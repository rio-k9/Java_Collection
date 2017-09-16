//
// Command Line Arguments
//
public class Arguments
{
   public static void main( String[] args )
   {
      if ( args.length > 0 )
      {
         for ( int i = 0; i < args.length; i++ )
         {
            System.out.println( "args[ " + i
                 + " ] contains " + args[ i ] );
         }
      }
      else
      {
         System.out.println( 
                      "No arguments supplied" );
         System.exit( 1 );
      }
      System.exit( 0 );
   }
}
