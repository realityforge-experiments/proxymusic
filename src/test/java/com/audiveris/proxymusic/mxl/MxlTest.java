//------------------------------------------------------------------------------------------------//
//                                                                                                //
//                                          M x l T e s t                                         //
//                                                                                                //
//------------------------------------------------------------------------------------------------//
// <editor-fold defaultstate="collapsed" desc="hdr">
//  Copyright © Herve Bitteur and others 2000-2014. All rights reserved.
//  This software is released under the GNU General Public License.
//  Goto http://kenai.com/projects/audiveris to report bugs or suggestions.
//------------------------------------------------------------------------------------------------//
// </editor-fold>
package com.audiveris.proxymusic.mxl;

import com.audiveris.proxymusic.ScorePartwise;
import com.audiveris.proxymusic.opus.Opus;
import com.audiveris.proxymusic.util.DummyGenerator;
import com.audiveris.proxymusic.util.Dumper;
import com.audiveris.proxymusic.util.Marshalling;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.zip.ZipEntry;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Class {@code MxlTest} is meant to test features related to mxl (compressed)
 * MusicXML files.
 *
 * @author Hervé Bitteur
 */
public class MxlTest
  extends TestCase
{
  public static void main( final String... args )
    throws Throwable
  {
    new MxlTest().play( args[ 0 ] );
  }

  public void play( String fileName )
    throws Throwable
  {
    System.out.println( "Building contexts ..." );
    Marshalling.getContext( ScorePartwise.class );
    Marshalling.getContext( Opus.class );

    System.out.println( "Marshalling ..." );

    Output mof = new Output( new File( fileName ) );
    OutputStream zos = mof.getOutputStream();
    ScorePartwise scorePartwise = DummyGenerator.buildScorePartwise( "First score", 4 );
    System.out.println( new Dumper.Column( scorePartwise ).toString() );
    mof.addEntry( new RootFile( "myscore.xml", RootFile.MUSICXML_MEDIA_TYPE ) );
    Marshalling.marshal( scorePartwise, zos, true, 2 );

    scorePartwise = DummyGenerator.buildScorePartwise( "Second score", 2 );
    mof.addEntry( new RootFile( "myscore2.mxl", RootFile.MUSICXML_MEDIA_TYPE ) );
    Marshalling.marshal( scorePartwise, zos, true, 2 );
    mof.close();
    System.out.println( "Marshalled." );

    System.out.println( "Unmarshalling ..." );

    Input mif = new Input( new File( fileName ) );

    for ( RootFile rootFile : mif.getRootFiles() )
    {
      System.out.println( "   " + rootFile );

      ZipEntry zipEntry = mif.getEntry( rootFile._fullPath );
      System.out.println( "   entryTime: " + new Date( zipEntry.getTime() ) );
    }

    RootFile first = mif.getRootFiles().get( 0 );
    ZipEntry zipEntry = mif.getEntry( first._fullPath );
    InputStream is = mif.getInputStream( zipEntry );
    ScorePartwise newScorePartwise = (ScorePartwise) Marshalling.unmarshal( is );
    System.out.println( new Dumper.Column( newScorePartwise ).toString() );
    System.out.println( new Dumper.Column( newScorePartwise.getIdentification() ).toString() );
    System.out.println( "Unmarshalled." );
  }

  @Test
  public void test()
    throws Throwable
  {
    File dir = new File( "target/temp" );
    dir.mkdirs();
    play( new File( dir, "myfile.mxl" ).toString() );
  }
}
