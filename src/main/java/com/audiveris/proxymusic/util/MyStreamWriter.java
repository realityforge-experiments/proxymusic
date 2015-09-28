package com.audiveris.proxymusic.util;

import javax.xml.namespace.NamespaceContext;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/**
 * Class {@code MyStreamWriter} removes the namespaces from the marshal operation.
 * <p>
 * It is a wrapper for an XMLStreamWriter that intercepts and removes the relevant namespace
 * info. It does so by treating all namespace declarations as default namespaces.
 * <p>
 * The "xlink:" prefix is preserved for relevant attributes (opus).
 * <p>
 * It also performs formatting on the fly, if a non-null indentation value was provided.
 * <p>
 * Detected empty elements are written as one (empty) element rather than start + end tags.
 * <p>
 * It also inserts a comment line just before a part or measure element begins.
 *
 * @author Blaise Doughan (namespace handling)
 * @author Hervé Bitteur (other features)
 * @see <a href="http://stackoverflow.com/a/5722013">Blaise article</a>
 */
class MyStreamWriter
  extends StreamWriterDelegate
{
  /**
   * Special name context.
   */
  private final MyNamespaceContext nc = new MyNamespaceContext();

  /**
   * Indentation string, if any.
   */
  private final String INDENT;

  /**
   * Current level of indentation.
   */
  private int level;

  /**
   * Are we closing element(s)?.
   */
  private boolean closing;

  /**
   * Pending element if any. (meant to handle empty elements)
   */
  private PendingElement pending;

  /**
   * Creates a new {@code MyXMLStreamWriter} object.
   *
   * @param writer      the real XML stream writer
   * @param indentValue desired indentation value, if any (null, 0 or n)
   * @throws XMLStreamException for any processing error
   */
  public MyStreamWriter( XMLStreamWriter writer,
                         Integer indentValue )
    throws XMLStreamException
  {
    super( writer );

    writer.setNamespaceContext( nc );
    INDENT = getIndentString( indentValue );
  }

  @Override
  public void setNamespaceContext( NamespaceContext context )
    throws XMLStreamException
  {
    // void (we keep using our own NamespaceContext)
  }

  @Override
  public void writeAttribute( String localName,
                              String value )
    throws XMLStreamException
  {
    checkPending();
    super.writeAttribute( localName, value );
  }

  @Override
  public void writeAttribute( String namespaceURI,
                              String localName,
                              String value )
    throws XMLStreamException
  {
    checkPending();
    super.writeAttribute( namespaceURI, localName, value );
  }

  @Override
  public void writeAttribute( String prefix,
                              String namespaceURI,
                              String localName,
                              String value )
    throws XMLStreamException
  {
    checkPending();
    super.writeAttribute( prefix, namespaceURI, localName, value );
  }

  @Override
  public void writeCData( String data )
    throws XMLStreamException
  {
    checkPending();
    super.writeCData( data );
  }

  @Override
  public void writeCharacters( String text )
    throws XMLStreamException
  {
    checkPending();
    super.writeCharacters( text );
  }

  @Override
  public void writeCharacters( char[] text,
                               int start,
                               int len )
    throws XMLStreamException
  {
    checkPending();
    super.writeCharacters( text, start, len );
  }

  @Override
  public void writeComment( String data )
    throws XMLStreamException
  {
    checkPending();
    indentComment();

    super.writeComment( data );
  }

  @Override
  public void writeDTD( String dtd )
    throws XMLStreamException
  {
    checkPending();
    super.writeDTD( dtd );
  }

  @Override
  public void writeDefaultNamespace( String namespaceURI )
    throws XMLStreamException
  {
    checkPending();
    super.writeDefaultNamespace( namespaceURI );
  }

  @Override
  public void writeEmptyElement( String localName )
    throws XMLStreamException
  {
    checkPending();
    super.writeEmptyElement( localName );
  }

  @Override
  public void writeEmptyElement( String namespaceURI,
                                 String localName )
    throws XMLStreamException
  {
    checkPending();
    super.writeEmptyElement( namespaceURI, localName );
  }

  @Override
  public void writeEmptyElement( String prefix,
                                 String localName,
                                 String namespaceURI )
    throws XMLStreamException
  {
    checkPending();
    super.writeEmptyElement( prefix, localName, namespaceURI );
  }

  @Override
  public void writeEndElement()
    throws XMLStreamException
  {
    if ( pending != null )
    {
      // The end is immediately following the start, with nothing in between:
      // So, write an empty element, instead of start + end
      pending.writeEmpty();
      indentEnd();
      pending = null;
    }
    else
    {
      indentEnd();
      super.writeEndElement();
    }
  }

  @Override
  public void writeEntityRef( String name )
    throws XMLStreamException
  {
    checkPending();
    super.writeEntityRef( name );
  }

  @Override
  public void writeNamespace( String prefix,
                              String namespaceURI )
    throws XMLStreamException
  {
    // void (we don't output this information)
  }

  @Override
  public void writeProcessingInstruction( String target )
    throws XMLStreamException
  {
    checkPending();
    super.writeProcessingInstruction( target );
  }

  @Override
  public void writeProcessingInstruction( String target,
                                          String data )
    throws XMLStreamException
  {
    checkPending();
    super.writeProcessingInstruction( target, data );
  }

  @Override
  public void writeStartElement( String localName )
    throws XMLStreamException
  {
    checkPending();
    indentStart( localName );

    // We don't write the element start now, but save it as pending
    pending = new PendingElement( this, localName );
  }

  @Override
  public void writeStartElement( String namespaceURI,
                                 String localName )
    throws XMLStreamException
  {
    checkPending();
    indentStart( localName );

    // We don't write the element start now, but save it as pending
    pending = new PendingElement2( this, namespaceURI, localName );
  }

  @Override
  public void writeStartElement( String prefix,
                                 String localName,
                                 String namespaceURI )
    throws XMLStreamException
  {
    checkPending();
    indentStart( localName );

    // We don't write the element start now, but save it as pending
    pending = new PendingElement3( this, prefix, localName, namespaceURI );
  }

  private void checkPending()
    throws XMLStreamException
  {
    if ( pending != null )
    {
      pending.writeStart();
      pending = null;
    }
  }

  /**
   * Insert a new line, followed by proper level of indentation.
   */
  private void doIndent()
    throws XMLStreamException
  {
    super.writeCharacters( "\n" );

    for ( int i = 0; i < level; i++ )
    {
      super.writeCharacters( INDENT );
    }
  }

  /**
   * Build proper indentation string.
   *
   * @param value desired indentation value
   * @return the indentation string to use: null for no indentation at all, empty string for
   * LF only, non-empty string for LF and concrete indentation
   */
  private String getIndentString( Integer value )
  {
    if ( value == null )
    {
      return null;
    }

    StringBuilder sb = new StringBuilder();

    for ( int i = 0; i < value; i++ )
    {
      sb.append( " " );
    }

    return sb.toString();
  }
  /**
   * Indentation before comment. Always indent.
   */
  private void indentComment()
    throws XMLStreamException
  {
    if ( INDENT != null )
    {
      doIndent();
    }
  }

  /**
   * Indentation before end tag. Indent except on first close.
   */
  private void indentEnd()
    throws XMLStreamException
  {
    if ( INDENT != null )
    {
      level--;

      if ( closing )
      {
        doIndent();
      }

      closing = true;
    }
  }

  /**
   * Indentation before start tag. Always indent.
   *
   * @param localName the local tag name
   */
  private void indentStart( String localName )
    throws XMLStreamException
  {
    if ( INDENT != null )
    {
      // Insert visible comment lines only for measures and parts
      if ( localName.equals( "measure" ) )
      {
        doIndent();
        super.writeComment( "=======================================================" );
      }
      else if ( localName.equals( "part" ) )
      {
        doIndent();
        super.writeComment( "= = = = = = = = = = = = = = = = = = = = = = = = = = = = =" );
      }

      doIndent();
      level++;
      closing = false;
    }
  }

}
