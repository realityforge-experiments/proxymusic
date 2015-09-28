package com.audiveris.proxymusic.util;

import javax.xml.stream.XMLStreamException;

class PendingElement2
  extends PendingElement
{
  final String _namespaceURI;

  public PendingElement2( final MyStreamWriter _streamWriter,
                          final String namespaceURI,
                          final String localName )
  {
    super( _streamWriter, localName );
    _namespaceURI = namespaceURI;
  }

  @Override
  public void writeEmpty()
    throws XMLStreamException
  {
    getStreamWriter().getParent().writeEmptyElement( _namespaceURI, _localName );
  }

  @Override
  public void writeStart()
    throws XMLStreamException
  {
    getStreamWriter().getParent().writeStartElement( _namespaceURI, _localName );
  }
}
