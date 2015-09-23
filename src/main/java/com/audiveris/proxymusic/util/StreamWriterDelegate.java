//------------------------------------------------------------------------------------------------//
//                                                                                                //
//                             S t r e a m W r i t e r D e l e g a t e                            //
//                                                                                                //
//------------------------------------------------------------------------------------------------//
// <editor-fold defaultstate="collapsed" desc="hdr">
//  Copyright © Herve Bitteur and others 2000-2014. All rights reserved.
//  This software is released under the GNU General Public License.
//  Goto http://kenai.com/projects/audiveris to report bugs or suggestions.
//------------------------------------------------------------------------------------------------//
// </editor-fold>
package com.audiveris.proxymusic.util;

import javax.xml.namespace.NamespaceContext;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/**
 * Class {@code StreamWriterDelegate} is meant to serve as a base class for
 * deriving an {@link XMLStreamWriter} filter.
 *
 * @author Hervé Bitteur
 */
public class StreamWriterDelegate
  implements XMLStreamWriter
{
  private XMLStreamWriter _writer;

  /**
   * Construct an empty filter with no parent.
   */
  public StreamWriterDelegate()
  {
  }

  /**
   * Construct a filter with the specified parent.
   *
   * @param writer the parent
   */
  public StreamWriterDelegate( final XMLStreamWriter writer )
  {
    this._writer = writer;
  }

  @Override
  public void close()
    throws XMLStreamException
  {
    _writer.close();
  }

  @Override
  public void flush()
    throws XMLStreamException
  {
    _writer.flush();
  }

  @Override
  public NamespaceContext getNamespaceContext()
  {
    return _writer.getNamespaceContext();
  }

  /**
   * Get the parent of this instance.
   *
   * @return the parent or null if none is set
   */
  public XMLStreamWriter getParent()
  {
    return _writer;
  }

  @Override
  public String getPrefix( final String uri )
    throws XMLStreamException
  {
    return _writer.getPrefix( uri );
  }

  @Override
  public Object getProperty( final String name )
    throws IllegalArgumentException
  {
    return _writer.getProperty( name );
  }

  @Override
  public void setDefaultNamespace( final String uri )
    throws XMLStreamException
  {
    _writer.setDefaultNamespace( uri );
  }

  @Override
  public void setNamespaceContext( final NamespaceContext context )
    throws XMLStreamException
  {
    _writer.setNamespaceContext( context );
  }

  /**
   * Set the parent of this instance.
   *
   * @param writer the new parent
   */
  public void setParent( final XMLStreamWriter writer )
  {
    this._writer = writer;
  }

  @Override
  public void setPrefix( final String prefix, final String uri )
    throws XMLStreamException
  {
    _writer.setPrefix( prefix, uri );
  }

  @Override
  public void writeAttribute( final String localName, final String value )
    throws XMLStreamException
  {
    _writer.writeAttribute( localName, value );
  }

  @Override
  public void writeAttribute( final String prefix,
                              final String namespaceURI,
                              final String localName,
                              final String value )
    throws XMLStreamException
  {
    _writer.writeAttribute( prefix, namespaceURI, localName, value );
  }

  @Override
  public void writeAttribute( final String namespaceURI, final String localName, final String value )
    throws XMLStreamException
  {
    _writer.writeAttribute( namespaceURI, localName, value );
  }

  @Override
  public void writeCData( String data )
    throws XMLStreamException
  {
    _writer.writeCData( data );
  }

  @Override
  public void writeCharacters( final String text )
    throws XMLStreamException
  {
    _writer.writeCharacters( text );
  }

  @Override
  public void writeCharacters( final char[] text, final int start, final int len )
    throws XMLStreamException
  {
    _writer.writeCharacters( text, start, len );
  }

  @Override
  public void writeComment( final String data )
    throws XMLStreamException
  {
    _writer.writeComment( data );
  }

  @Override
  public void writeDTD( final String dtd )
    throws XMLStreamException
  {
    _writer.writeDTD( dtd );
  }

  @Override
  public void writeDefaultNamespace( final String namespaceURI )
    throws XMLStreamException
  {
    _writer.writeDefaultNamespace( namespaceURI );
  }

  @Override
  public void writeEmptyElement( final String namespaceURI, final String localName )
    throws XMLStreamException
  {
    _writer.writeEmptyElement( namespaceURI, localName );
  }

  @Override
  public void writeEmptyElement( final String prefix, final String localName, final String namespaceURI )
    throws XMLStreamException
  {
    _writer.writeEmptyElement( prefix, localName, namespaceURI );
  }

  @Override
  public void writeEmptyElement( final String localName )
    throws XMLStreamException
  {
    _writer.writeEmptyElement( localName );
  }

  @Override
  public void writeEndDocument()
    throws XMLStreamException
  {
    _writer.writeEndDocument();
  }

  @Override
  public void writeEndElement()
    throws XMLStreamException
  {
    _writer.writeEndElement();
  }

  @Override
  public void writeEntityRef( final String name )
    throws XMLStreamException
  {
    _writer.writeEntityRef( name );
  }

  @Override
  public void writeNamespace( final String prefix, final String namespaceURI )
    throws XMLStreamException
  {
    _writer.writeNamespace( prefix, namespaceURI );
  }

  @Override
  public void writeProcessingInstruction( final String target )
    throws XMLStreamException
  {
    _writer.writeProcessingInstruction( target );
  }

  @Override
  public void writeProcessingInstruction( final String target, final String data )
    throws XMLStreamException
  {
    _writer.writeProcessingInstruction( target, data );
  }

  @Override
  public void writeStartDocument()
    throws XMLStreamException
  {
    _writer.writeStartDocument();
  }

  @Override
  public void writeStartDocument( final String version )
    throws XMLStreamException
  {
    _writer.writeStartDocument( version );
  }

  @Override
  public void writeStartDocument( final String encoding, final String version )
    throws XMLStreamException
  {
    _writer.writeStartDocument( encoding, version );
  }

  @Override
  public void writeStartElement( final String localName )
    throws XMLStreamException
  {
    _writer.writeStartElement( localName );
  }

  @Override
  public void writeStartElement( final String namespaceURI, final String localName )
    throws XMLStreamException
  {
    _writer.writeStartElement( namespaceURI, localName );
  }

  @Override
  public void writeStartElement( final String prefix, final String localName, final String namespaceURI )
    throws XMLStreamException
  {
    _writer.writeStartElement( prefix, localName, namespaceURI );
  }
}
