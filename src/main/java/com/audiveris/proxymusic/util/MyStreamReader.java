package com.audiveris.proxymusic.util;

import java.util.Arrays;
import java.util.List;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.util.StreamReaderDelegate;

/**
 * Class to resolve any xlink:xxx attribute on the fly during unmarshal operation.
 */
class MyStreamReader
  extends StreamReaderDelegate
{
  /**
   * The collection of all supported attributes with xlink: prefix.
   */
  private static final List<String> XLINK_ATTRIBUTES = Arrays.asList(
    "href",
    "type",
    "role",
    "title",
    "show",
    "actuate" );

  public MyStreamReader( XMLStreamReader reader )
  {
    super( reader );
  }

  @Override
  public QName getAttributeName( int index )
  {
    String prefix = getAttributePrefix( index );

    if ( "xlink".equals( prefix ) )
    {
      QName qName = super.getAttributeName( index );
      String local = qName.getLocalPart();

      if ( XLINK_ATTRIBUTES.contains( local ) )
      {
        return new QName( Marshalling.XLINK_NAMESPACE_URI, local, "xlink" );
      }
    }

    return super.getAttributeName( index );
  }
}
