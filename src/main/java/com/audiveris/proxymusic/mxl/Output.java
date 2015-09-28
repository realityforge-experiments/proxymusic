package com.audiveris.proxymusic.mxl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * Class {@code Output} allows to write a .mxl file.
 */
public class Output
{
  /**
   * The global container.
   */
  private final Container container = new Container();

  /**
   * The underlying zip output stream.
   */
  private final MxlOutputStream mos;

  /**
   * Flag to indicate if the stream has already been closed.
   */
  private boolean closed;

  /**
   * Create an {@code Output} object on a provided output stream.
   *
   * @param out the provided output stream
   */
  public Output( OutputStream out )
  {
    mos = new MxlOutputStream( this, new BufferedOutputStream( out ) );
  }

  /**
   * Create an {@code Output} object on a provided output file.
   *
   * @param file the file to write
   */
  public Output( File file )
    throws FileNotFoundException
  {
    this( new FileOutputStream( file ) );
  }

  /**
   * Insert a new RootFile entry into this file.
   * This populates the internal container and positions the stream output accordingly.
   *
   * @param rootFile the provided RootFile
   * @return the corresponding Zip entry
   */
  public ZipEntry addEntry( RootFile rootFile )
    throws MxlException
  {
    try
    {
      ZipEntry entry = new ZipEntry( rootFile._fullPath );
      mos.putNextEntry( entry );
      container.addRootFile( rootFile );

      return entry;
    }
    catch ( IOException ex )
    {
      throw new MxlException( ex );
    }
  }

  /**
   * Insert the provided RootFile as the FIRST entry.
   * This can be called at any time, to populate the internal container in first position, and
   * position the stream output accordingly.
   *
   * @param rootFile the provided RootFile
   * @return the corresponding Zip entry
   */
  public ZipEntry addFirstEntry( RootFile rootFile )
    throws MxlException
  {
    try
    {
      ZipEntry entry = new ZipEntry( rootFile._fullPath );
      mos.putNextEntry( entry );
      container.addFirstRootFile( rootFile );

      return entry;
    }
    catch ( IOException ex )
    {
      throw new MxlException( ex );
    }
  }

  /**
   * Write the container and close the underlying output stream.
   */
  public void close()
    throws IOException
  {
    if ( closed )
    {
      return;
    }

    try
    {
      // Marshal the container
      Marshaller m = Mxl.getContext().createMarshaller();
      mos.putNextEntry( new ZipEntry( Mxl.CONTAINER_ENTRY_NAME ) );
      m.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );
      m.marshal( container, mos );

      // Close everything
      closed = true;
      mos.close();
    }
    catch ( JAXBException ex )
    {
      throw new IOException( ex );
    }
  }

  /**
   * Report the underlying Zip output stream.
   *
   * @return the Zip output stream
   */
  public OutputStream getOutputStream()
  {
    return mos;
  }

}
