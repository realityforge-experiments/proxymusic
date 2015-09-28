package com.audiveris.proxymusic.mxl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * Class {@code Input} allows to read a .mxl file.
 */
public class Input
{
  /**
   * The underlying zip file.
   */
  private final ZipFile zipFile;

  /**
   * MXL container.
   */
  private final Container container;

  /**
   * Create an {@code Input} object on a provided file.
   *
   * @param file the provided file
   */
  public Input( final File file )
    throws IOException, MxlException, JAXBException
  {
    zipFile = new ZipFile( file );

    // Retrieve container
    ZipEntry containerEntry = zipFile.getEntry( Mxl.CONTAINER_ENTRY_NAME );

    if ( containerEntry == null )
    {
      throw new MxlException( "No container found in " + file );
    }

    InputStream cis = zipFile.getInputStream( containerEntry );
    Unmarshaller um = Mxl.getContext().createUnmarshaller();
    container = (Container) um.unmarshal( cis );
  }

  /**
   * Report the zip entry related to the provided name.
   *
   * @param entryName the provided entry name
   * @return the entry in the .mxl file
   */
  public ZipEntry getEntry( String entryName )
    throws IOException
  {
    return zipFile.getEntry( entryName );
  }

  /**
   * Report the input stream related to the provided zip entry.
   *
   * @param zipEntry the provided zip entry
   * @return the corresponding input stream
   */
  public InputStream getInputStream( ZipEntry zipEntry )
    throws IOException
  {
    return zipFile.getInputStream( zipEntry );
  }

  /**
   * Report the sequence of root files in the container.
   *
   * @return the (un-mutable) list of RootFile instances
   */
  public List<RootFile> getRootFiles()
  {
    return Collections.unmodifiableList( container.rootFiles );
  }
}
