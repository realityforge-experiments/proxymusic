//----------------------------------------------------------------------------//
//                                                                            //
//                                D u m p e r                                 //
//                                                                            //
//  Copyright © Hervé Bitteur and others 2000-20123. All rights reserved.     //
//  This software is released under the GNU Lesser General Public License.    //
//  Please see http://kenai.com/projects/proxymusic/ for bugs & suggestions.  //
//----------------------------------------------------------------------------//
//
package com.audiveris.proxymusic.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Map;

/**
 * Class <code>Dumper</code> is a debugging utility that reports,
 * in a brute force manner, any internal data of a class instance.
 *
 * <p> When used on a class instance, all class internal fields which are
 * considered as "relevant" are printed using their toString() method, then we
 * walk up the inheritance tree and repeat the same actions, until there is no
 * more superclass or until the superclass we have reached is considered as
 * non-relevant. </p>
 *
 * <p> A (super)class is considered "relevant" if the static method
 * <code>isClassRelevant(class)</code> returns true. This method can be
 * overridden in a subclass of Dumper to adapt to local needs. </p>
 *
 * <p> A field is considered "relevant" if the following condition if the method
 * <code>isFieldRelevant(field)</code> returns true. Similarly, the behavior of
 * this predicate can be customized by subclassing the Dumper class. </p>
 *
 * <p> There are several kinds of print outs available through subclassing. Each
 * of them export two public methods: <code>dump()</code> which prints the
 * result on default output stream, and <code>dumpOf()</code> which simply
 * returns the generated dump string.
 *
 * <ul> <li> <b>Column</b> a dump with one line per field </li>
 *
 * <li> <b>Row</b> a dump with all information on one row </li>
 *
 * <li> <b>Html</b> an Html stream with fields arranged in tables </li>
 *
 * </ul>
 *
 * Here are some examples of use:
 * <pre>
 * // Using the predefined static helper methods
 * Dumper.dump(myinstance);
 * Dumper.dump(myinstance, "My Title");
 * Dumper.dump(myinstance, "My Title", 2);
 * System.out.println(Dumper.dumpOf(myinstance));
 * System.out.println(Dumper.htmlDumpOf(myinstance));
 *
 *  // Using directly the Dumper subclasses
 * new Dumper.Column(myinstance).print();
 * System.out.println(new Dumper.Row(myinstance).toString());
 * display(new Dumper.Html(myinstance).toString());
 * </pre>
 *
 * @author Hervé Bitteur
 */
public abstract class Dumper
{
  /**
   * The object to be dumped
   */
  protected final Object obj;

  /**
   * The string buffer used as output
   */
  protected final StringBuffer sb;

  /**
   * Can we use HTML directives?
   */
  protected final boolean useHtml;

  /**
   * Class (beware, this variable is updated as we walk up the inheritance
   * tree)
   */
  protected Class cl;

  /**
   * Creates a new Dumper.
   *
   * @param obj the object instance to be dumped.
   */
  private Dumper( Object obj,
                  boolean useHtml )
  {
    // (re)Allocate the string buffer
    sb = new StringBuffer( 1024 );

    // Cache the object & the related class
    this.obj = obj;
    this.useHtml = useHtml;
    cl = obj.getClass();
  }

  /**
   * Predicate to determine if a given class is worth being printed. This
   * method could be overridden to reflect customized policy. Note that when
   * walking up the inheritance tree, the browsing is stopped as soon as a
   * non-relevant class is encountered.
   *
   * @param cl the class at stake
   * @return true if found relevant
   */
  public static boolean isClassRelevant( Class cl )
  {
    return ( cl != null ) && cl.getName().startsWith( "omr." );
  }

  //-----------------//
  // isFieldRelevant //
  //-----------------//

  /**
   * Predicate to determine if a given field is worth being printed. This
   * method could be overridden to reflect customized policy.
   *
   * @param field the field at stake
   * @return true if found relevant
   */
  public static boolean isFieldRelevant( Field field )
  {
    // We don't print static field since the Dumper is meant for instances
    if ( Modifier.isStatic( field.getModifiers() ) )
    {
      return false;
    }

    // We don't print non-user visible entities
    return field.getName().indexOf( '$' ) == -1;
  }

  /**
   * Return the string buffer content
   *
   * @return the dump of the object as a string
   */
  @Override
  public String toString()
  {
    // Do the processing
    processObject();

    // Return the final content of string buffer
    return sb.toString();
  }

  /**
   * To be overridden so as to print the epilog of class data
   */
  protected void printClassEpilog()
  {
  }

  /**
   * To be overridden so as to print the prolog of class data
   */
  protected void printClassProlog()
  {
  }

  protected void printCollectionValue( Collection col )
  {
    sb.append( "[" );

    int i = 0;

    for ( Object obj : col )
    {
      if ( i++ > 0 )
      {
        sb.append( useHtml ? ",<br/>" : "," );
      }

      // Safeguard action when the object is a big collection
      final int maxCOllectionIndex = 9;
      if ( i > maxCOllectionIndex )
      {
        sb.append( " ... " ).append( col.size() ).append( " items" );

        break;
      }
      else
      {
        sb.append( obj );
      }
    }

    sb.append( "]" );
  }

  /**
   * Basic printing of field name and value. The method can of course be
   * overridden.
   *
   * @param name  the field name
   * @param value the field value, which may be null
   */
  protected void printField( String name,
                             Object value )
  {
    if ( value == null )
    {
      sb.append( "null" );
    }
    else
    {
      if ( value instanceof Collection )
      {
        printCollectionValue( (Collection) value );
      }
      else if ( value instanceof Map )
      {
        printCollectionValue( ( (Map) value ).entrySet() );
      }
      else
      {
        sb.append( value.toString() );
      }
    }
  }

  private void processClass()
  {
    // Class Prolog
    printClassProlog();

    // Process the class Fields
    for ( Field field : cl.getDeclaredFields() )
    {
      processField( field );
    }

    // Class Epilog
    printClassEpilog();
  }

  private void processField( Field field )
  {
    // Check that we are really interested in printing this field out
    if ( isFieldRelevant( field ) )
    {
      // Override any access limitation
      field.setAccessible( true );

      try
      {
        // Retrieve field value in the object instance
        Object value = field.get( obj );

        // Print the field value as requested
        printField( field.getName(), value );
      }
      catch ( IllegalAccessException ex )
      {
        // Cannot occur in fact, thanks to setAccessible
      }
    }
  }

  private void processObject()
  {
    do
    {
      // Process the class at hand
      processClass();

      // Walk up the inheritance tree
      cl = cl.getSuperclass();
    } while ( isClassRelevant( cl ) );
  }

  /**
   * Class <code>Column</code> implements a Dumper where all fields are
   * presented in one column, each field on a separate line. The column can be
   * left indented, according to the specified indentation level.
   */
  public static class Column
    extends Dumper
  {
    private static final String MEMBER_GAP = "   ";
    private static final String INDENT_GAP = ".  ";

    private final String title;
    private final StringBuffer prefix;

    public Column( Object obj )
    {
      this( obj, null, 0 );
    }

    public Column( Object obj,
                   String title )
    {
      this( obj, title, 0 );
    }

    public Column( Object obj,
                   int level )
    {
      this( obj, null, level );
    }

    public Column( Object obj,
                   String title,
                   int level )
    {
      super( obj, false );

      // Cache the title
      if ( title != null )
      {
        this.title = title;
      }
      else
      {
        this.title = "";
      }

      // Prepare indent prefix
      prefix = new StringBuffer( level * INDENT_GAP.length() );

      for ( int i = level; i > 0; i-- )
      {
        prefix.append( INDENT_GAP );
      }
    }

    @Override
    protected void printClassProlog()
    {
      // We print the class name only for the lowest class in
      // heritance hierarchy
      if ( obj.getClass() == cl )
      {
        sb.append( "\n" );
        sb.append( prefix )
          .append( cl.getName() );
        sb.append( " " )
          .append( title )
          .append( ":" );
      }
    }

    @Override
    protected void printField( String name,
                               Object value )
    {
      sb.append( "\n" );
      sb.append( prefix )
        .append( MEMBER_GAP );
      sb.append( name )
        .append( "=" );
      super.printField( name, value );
    }
  }
}
