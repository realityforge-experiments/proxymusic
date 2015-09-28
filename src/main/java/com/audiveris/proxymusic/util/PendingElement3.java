package com.audiveris.proxymusic.util;

import javax.xml.stream.XMLStreamException;

class PendingElement3
  extends PendingElement2
{
  final String _prefix;

  public PendingElement3( final MyStreamWriter streamWriter,
                          final String prefix,
                          final String localName,
                          final String namespaceURI )
  {
    super( streamWriter, namespaceURI, localName );
    _prefix = prefix;
  }

  @Override
  public void writeEmpty()
    throws XMLStreamException
  {
    getStreamWriter().getParent().writeEmptyElement( _prefix, _localName, _namespaceURI );
  }

  @Override
  public void writeStart()
    throws XMLStreamException
  {
    getStreamWriter().getParent().writeStartElement( _prefix, _localName, _namespaceURI );
  }
}
