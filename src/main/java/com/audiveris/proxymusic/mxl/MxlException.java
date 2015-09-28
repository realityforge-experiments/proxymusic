package com.audiveris.proxymusic.mxl;

/**
 * Global exception.
 */
public class MxlException
  extends Exception
{
  public MxlException( Throwable cause )
  {
    super( cause );
  }

  public MxlException( String msg )
  {
    super( msg );
  }
}
