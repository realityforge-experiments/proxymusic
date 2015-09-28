//------------------------------------------------------------------------------------------------//
//                                                                                                //
//                                      M a r s h a l l i n g                                     //
//                                                                                                //
//------------------------------------------------------------------------------------------------//
// <editor-fold defaultstate="collapsed" desc="hdr">
//  Copyright © Herve Bitteur and others 2000-2014. All rights reserved.
//  This software is released under the GNU Lesser General Public License.
//  Go to http://kenai.com/projects/proxymusic/ to report bugs or suggestions.
//------------------------------------------------------------------------------------------------//
// </editor-fold>
package com.audiveris.proxymusic.util;

import com.audiveris.proxymusic.Encoding;
import com.audiveris.proxymusic.Identification;
import com.audiveris.proxymusic.ObjectFactory;
import com.audiveris.proxymusic.ScorePartwise;
import com.audiveris.proxymusic.opus.Opus;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import org.w3c.dom.Node;

/**
 * Class {@code Marshalling} gathers static methods to marshal and to un-marshal {@link
 * ScorePartwise} or {@link Opus} java objects to/from an output/input stream in UTF8
 * encoding and using MusicXML format.
 * <p>
 * Several tricks are used to work around namespaces during marshalling and un-marshalling since
 * MusicXML does not support them
 * (MusicXML uses prefixed attribute names such as <i>xlink:href</i>, although it never binds the
 * xlink prefix to its proper namespace URI).
 * <p>
 * No access to a DTD (local or remote) is made during the un-marshalling which ignores DTDs.
 * <p>
 * The method {@link #getContext(Class)} is publicly visible so as to allow an asynchronous
 * elaboration of the JAXB context, which can be an expensive operation because of the large number
 * of Java classes in the ScorePartwise hierarchy.
 *
 * @author Hervé Bitteur
 */
public abstract class Marshalling
{
  /**
   * JAXB contexts.
   */
  private static final Map<Class, JAXBContext> jaxbContextMap = new HashMap<Class, JAXBContext>();

  /**
   * The XML document statement.
   */
  private static final String XML_LINE = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";

  /**
   * The official URI for XLink namespace.
   */
  public static final String XLINK_NAMESPACE_URI = "http://www.w3.org/1999/xlink";

  /**
   * The DOCTYPE statement for PARTWISE.
   */
  private static final String PARTWISE_DOCTYPE_LINE = "<!DOCTYPE score-partwise PUBLIC \"-//Recordare//DTD MusicXML "
                                                      +
                                                      "3.0"
                                                      +
                                                      " Partwise//EN\" \"http://www.musicxml.org/dtds/partwise.dtd\">";

  /**
   * The DOCTYPE statement for OPUS.
   */
  private static final String OPUS_DOCTYPE_LINE = "<!DOCTYPE opus PUBLIC \"-//Recordare//DTD MusicXML "
                                                  + "3.0"
                                                  + " Opus//EN\" \"http://www.musicxml.org/dtds/opus.dtd\">";

  /**
   * This class is not meant to be instantiated.
   */
  private Marshalling()
  {
  }

  /**
   * Get access to (and elaborate if not yet done) the needed JAXB context.
   * This method can be called any time.
   *
   * @param classe the desired class
   * @return the ready to use JAXB context
   * @throws JAXBException if anything goes wrong
   */
  public static JAXBContext getContext( Class classe )
    throws JAXBException
  {
    // Lazy creation
    JAXBContext context = jaxbContextMap.get( classe );

    if ( context == null )
    {
      synchronized ( jaxbContextMap )
      {
        context = jaxbContextMap.get( classe ); // It may have just been created!

        if ( context == null )
        {
          context = JAXBContext.newInstance( classe );
          jaxbContextMap.put( classe, context );
        }
      }
    }

    return context;
  }

  /**
   * Marshal the provided <b>ScorePartwise</b> instance to an OutputStream.
   *
   * @param scorePartwise   the root scorePartwise element
   * @param os              the output stream (not closed by this method)
   * @param injectSignature false if ProxyMusic encoder must not be referenced
   * @param indentation     formatting indentation value, null for no formatting.
   *                        When formatting, a comment line is inserted before parts and measures
   * @throws MarshallingException global exception (use getCause() for original exception)
   */
  public static void marshal( final ScorePartwise scorePartwise,
                              final OutputStream os,
                              final boolean injectSignature,
                              final Integer indentation )
    throws MarshallingException
  {
    try
    {
      // Inject version & signature
      annotate( scorePartwise, injectSignature );

      Marshaller marshaller = getContext( ScorePartwise.class ).createMarshaller();
      marshaller.setProperty( Marshaller.JAXB_FRAGMENT, true );
      marshaller.setProperty( Marshaller.JAXB_ENCODING, "UTF-8" );

      Writer out = new BufferedWriter( new OutputStreamWriter( os, "UTF-8" ) );
      out.write( XML_LINE );
      out.write( "\n" );
      out.write( PARTWISE_DOCTYPE_LINE );

      XMLOutputFactory outputFactory = XMLOutputFactory.newFactory();
      XMLStreamWriter writer = outputFactory.createXMLStreamWriter( out );
      // Use our custom XmlStreamWriter for name-space, formatting and comment line
      writer = new MyStreamWriter( writer, indentation );

      // Marshalling
      marshaller.marshal( scorePartwise, writer );
      writer.flush();
    }
    catch ( Exception ex )
    {
      throw new MarshallingException( ex );
    }
  }

  /**
   * Marshal the provided <b>Opus</b> instance to an OutputStream.
   *
   * @param opus the root opus element
   * @param os   the output stream (not closed by this method)
   * @throws MarshallingException global exception (use getCause() for original exception)
   */
  public static void marshal( final Opus opus,
                              final OutputStream os )
    throws MarshallingException
  {
    try
    {
      Marshaller marshaller = getContext( Opus.class ).createMarshaller();
      marshaller.setProperty( Marshaller.JAXB_FRAGMENT, true );
      marshaller.setProperty( Marshaller.JAXB_ENCODING, "UTF-8" );
      marshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );

      Writer out = new BufferedWriter( new OutputStreamWriter( os, "UTF-8" ) );
      out.write( XML_LINE );
      out.write( "\n" );
      out.write( OPUS_DOCTYPE_LINE );

      XMLOutputFactory outputFactory = XMLOutputFactory.newFactory();
      XMLStreamWriter writer = outputFactory.createXMLStreamWriter( out );

      // Our custom XmlStreamWriter for name-space, formatting and comment line
      writer = new MyStreamWriter( writer, 2 );

      // Marshalling
      com.audiveris.proxymusic.opus.ObjectFactory opusFactory = new com.audiveris.proxymusic.opus.ObjectFactory();
      JAXBElement<Opus> elem = opusFactory.createOpus( opus );
      marshaller.marshal( elem, writer );
      writer.flush();
    }
    catch ( Exception ex )
    {
      throw new MarshallingException( ex );
    }
  }

  /**
   * Marshal the provided <b>ScorePartwise</b> instance directly to a <b>DOM node</b>.
   *
   * @param scorePartwise   the root element
   * @param node            the DOM node where elements must be added
   * @param injectSignature false if ProxyMusic encoder must not be referenced
   * @throws MarshallingException global exception (use getCause() for original exception)
   */
  public static void marshal( final ScorePartwise scorePartwise,
                              final Node node,
                              final boolean injectSignature )
    throws MarshallingException
  {
    try
    {
      annotate( scorePartwise, injectSignature );

      Marshaller marshaller = getContext( ScorePartwise.class ).createMarshaller();
      marshaller.setProperty( Marshaller.JAXB_FRAGMENT, true );
      marshaller.marshal( scorePartwise, node );
    }
    catch ( Exception ex )
    {
      throw new MarshallingException( ex );
    }
  }

  /**
   * Un-marshal a <b>ScorePartwise</b> instance or an <b>Opus</b> instance from an InputStream.
   * <p>
   * Nota: The URLs of MusicXML DTD are specifically ignored by this method.
   *
   * @param is the input stream
   * @return the root element (either Opus or ScorePartwise object)
   * @throws UnmarshallingException global exception (use getCause() for original exception)
   */
  public static Object unmarshal( final InputStream is )
    throws UnmarshallingException
  {
    try
    {
      XMLInputFactory inputFactory = XMLInputFactory.newInstance();

      // Do not try to resolve DTDs (especially on the network!)
      inputFactory.setProperty( XMLInputFactory.SUPPORT_DTD, false );

      // Make the input reader non namespace aware
      // (attributes xlink:href and the like will be manually handled on the fly)
      inputFactory.setProperty( XMLInputFactory.IS_NAMESPACE_AWARE, false ); // OK

      XMLStreamReader xsr = inputFactory.createXMLStreamReader( is );
      // Use our specific stream reader
      xsr = new MyStreamReader( xsr );

      XMLEventReader reader = inputFactory.createXMLEventReader( xsr );

      while ( reader.hasNext() )
      {
        // Peek root element, to decide between ScorePartwise or Opus un-marshalling
        XMLEvent event = reader.peek();

        if ( event.isStartElement() )
        {
          StartElement rootStart = event.asStartElement();
          QName qName = rootStart.getName();
          String name = qName.getLocalPart();

          if ( name.equals( "opus" ) )
          {
            Unmarshaller um = getContext( Opus.class ).createUnmarshaller();

            return um.unmarshal( reader, Opus.class ).getValue();
          }
          else if ( name.equals( "score-partwise" ) )
          {
            Unmarshaller um = getContext( ScorePartwise.class ).createUnmarshaller();

            return um.unmarshal( reader, ScorePartwise.class ).getValue();
          }
          else
          {
            reader.next();
          }
        }
        else
        {
          reader.next();
        }
      }

      return null;
    }
    catch ( Exception ex )
    {
      throw new UnmarshallingException( ex );
    }
  }

  //----------//
  // annotate //
  //----------//

  /**
   * Annotate the scorePartwise tree with information about MusicXML version and, if
   * so desired, with signature composed of ProxyMusic version and date of marshalling.
   *
   * @param scorePartwise   the tree to annotate
   * @param injectSignature if true, ProxyMusic information is added
   */
  private static void annotate( final ScorePartwise scorePartwise,
                                final boolean injectSignature )
    throws DatatypeConfigurationException
  {
    // Predefined factory for all proxymusic elements
    ObjectFactory factory = new ObjectFactory();

    // Inject version
    scorePartwise.setVersion( "3.0" );

    // Inject signature if so desired
    if ( injectSignature )
    {
      // Identification
      Identification identification = scorePartwise.getIdentification();

      if ( identification == null )
      {
        identification = factory.createIdentification();
        scorePartwise.setIdentification( identification );
      }

      // Encoding
      Encoding encoding = identification.getEncoding();

      if ( null == encoding )
      {
        encoding = factory.createEncoding();
        identification.setEncoding( encoding );
      }

      // [Encoding]/Software (only if ProxyMusic is not already listed there)
      final List<JAXBElement<?>> list = encoding.getEncodingDateOrEncoderOrSoftware();
      final String programName = "ProxyMusic";

      for ( final Iterator<JAXBElement<?>> it = list.iterator(); it.hasNext(); )
      {
        final JAXBElement<?> element = it.next();
        if ( element.getName().getLocalPart().equals( "software" ) )
        {
          final Object obj = element.getValue();
          if ( obj instanceof String && obj.equals( programName ) )
          {
            // Remove it
            it.remove();

            break;
          }
        }
      }

      list.add(
        factory.createEncodingSoftware( "ProxyMusic" ) );

      // [Encoding]/EncodingDate (overwrite any existing date)
      for ( Iterator<JAXBElement<?>> it = list.iterator(); it.hasNext(); )
      {
        if ( it.next().getName().getLocalPart().equals( "encoding-date" ) )
        {
          it.remove();

          break;
        }
      }

      // Use date without time information (patch by lasconic)
      // Output:     2012-05-03
      // instead of: 2012-05-03T16:17:51.250+02:00
      XMLGregorianCalendar gc = DatatypeFactory.newInstance().newXMLGregorianCalendar( new GregorianCalendar() );
      gc.setTimezone( DatatypeConstants.FIELD_UNDEFINED );
      gc.setTime( DatatypeConstants.FIELD_UNDEFINED,
                  DatatypeConstants.FIELD_UNDEFINED,
                  DatatypeConstants.FIELD_UNDEFINED );
      list.add( factory.createEncodingEncodingDate( gc ) );
    }
  }
}
