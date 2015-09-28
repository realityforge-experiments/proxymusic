package com.audiveris.proxymusic.util;

import java.util.Iterator;
import javax.xml.namespace.NamespaceContext;

/**
 * Class to avoid any namespace binding during marshal operation.
 */
class MyNamespaceContext
  implements NamespaceContext
{
  private String defaultNS = "";

  public String getNamespaceURI( String prefix )
  {
    if ( "".equals( prefix ) )
    {
      return defaultNS;
    }

    return null;
  }

  public String getPrefix( String namespaceURI )
  {
    // Trick for xlink:...
    if ( Marshalling.XLINK_NAMESPACE_URI.equals( namespaceURI ) )
    {
      return "xlink";
    }

    return "";
  }

  public Iterator getPrefixes( String namespaceURI )
  {
    return null;
  }

  public void setDefaultNS( String ns )
  {
    defaultNS = ns;
  }
}
