//
// Comparison of two strings
//
public class Compare
{
   public static void main( String[] args )
   {
      if ( args.length == 2 )
      {
         if ( args[ 0 ].compareTo( args[ 1 ] )
                                          == 0 )
         {
            System.out.println( 
                    "Arguments are identical" );
         }
         else
         {
            System.out.println( 
                    "Arguments are different" );
         }
      }
      else
      {
         System.out.println( 
             "Two arguments must be supplied" );
         System.exit( 1 );
      }
      System.exit( 0 );
   }
}
