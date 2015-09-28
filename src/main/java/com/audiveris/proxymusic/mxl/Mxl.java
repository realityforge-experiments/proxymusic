//------------------------------------------------------------------------------------------------//
//                                                                                                //
//                                              M x l                                             //
//                                                                                                //
//------------------------------------------------------------------------------------------------//
// <editor-fold defaultstate="collapsed" desc="hdr">
//  Copyright © Herve Bitteur and others 2000-2014. All rights reserved.
//  This software is released under the GNU Lesser General Public License.
//  Goto http://kenai.com/projects/proxymusic to report bugs or suggestions.
//------------------------------------------------------------------------------------------------//
// </editor-fold>
package com.audiveris.proxymusic.mxl;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

/**
 * Class {@code Mxl} handles the compressed MXL format, through its provided
 * {@link Input} and {@link Output} classes.
 *
 * @author Hervé Bitteur
 */
public abstract class Mxl
{
  /**
   * Name of the specific entry for container.
   */
  static final String CONTAINER_ENTRY_NAME = "META-INF/container.xml";

  /**
   * Container [un]marshalling context.
   */
  private static JAXBContext containerContext;

  /**
   * Get access to (and elaborate if not yet done) the Container JAXB context.
   *
   * @return the ready to use JAXB context
   * @throws JAXBException if anything goes wrong
   */
  static JAXBContext getContext()
    throws JAXBException
  {
    // Lazy creation
    if ( containerContext == null )
    {
      synchronized ( Mxl.class )
      {
        containerContext = JAXBContext.newInstance( Container.class );
      }
    }

    return containerContext;
  }
}
