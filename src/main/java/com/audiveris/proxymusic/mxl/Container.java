package com.audiveris.proxymusic.mxl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The mandatory container structure.
 */
@XmlAccessorType( XmlAccessType.NONE )
@XmlRootElement( name = "container" )
class Container
{
  /**
   * The collection of root files.
   */
  @XmlElementWrapper( name = "rootfiles" )
  @XmlElement( name = "rootfile" )
  final List<RootFile> rootFiles = new ArrayList<RootFile>();

  /**
   * No-arg constructor, needed by JAXB.
   */
  public Container()
  {
  }

  /**
   * Add the rootFile entry to the container, in first position.
   *
   * @param rootFile the entry to add
   */
  public void addFirstRootFile( RootFile rootFile )
  {
    rootFiles.add( 0, rootFile );
  }

  /**
   * Add one rootFile entry to the container.
   *
   * @param rootFile the entry to add
   */
  public void addRootFile( RootFile rootFile )
  {
    rootFiles.add( rootFile );
  }
}
