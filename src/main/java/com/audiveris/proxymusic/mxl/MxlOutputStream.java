package com.audiveris.proxymusic.mxl;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.zip.ZipOutputStream;

/**
 * An OutputStream sub-classed in order to intercept closing.
 */
public class MxlOutputStream
  extends ZipOutputStream
{
  private Output _output;

  public MxlOutputStream( final Output output, OutputStream out )
  {
    super( out, StandardCharsets.UTF_8 );
    _output = output;
  }

  @Override
  public void close()
    throws IOException
  {
    // Write the container data
    _output.close();

    // Close the stream
    super.close();
  }
}
