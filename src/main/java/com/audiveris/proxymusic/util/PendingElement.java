package com.audiveris.proxymusic.util;

import javax.xml.stream.XMLStreamException;

/**
 * Class meant to save a starting element with its parameters.
 */
class PendingElement
{
  private MyStreamWriter _streamWriter;
  final String _localName;

  public PendingElement( final MyStreamWriter streamWriter, final String localName )
  {
    _streamWriter = streamWriter;
    _localName = localName;
  }

  /**
   * Write an empty element.
   */
  public void writeEmpty()
    throws XMLStreamException
  {
    _streamWriter.getParent().writeEmptyElement( _localName );
  }

  /**
   * Write just the element start.
   */
  public void writeStart()
    throws XMLStreamException
  {
    _streamWriter.getParent().writeStartElement( _localName );
  }

  protected final MyStreamWriter getStreamWriter()
  {
    return _streamWriter;
  }
}
