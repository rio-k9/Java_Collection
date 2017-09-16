import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class GetValidNumber
{
   //
   // check keyboard input is a valid non-negative integer
   //
   public static boolean checkInt( String input )
   {
      boolean valid = true;
      int length = input.length();
      for ( int i = 0; i < length; i++ )
      {
         char ch = input.charAt( i );
         if ( ch < '0' || ch > '9' )
            valid = false;
      }
      return valid;
   }
   public static void main( String[] args )
   {
      BufferedReader reader;
      reader =
        new BufferedReader( new InputStreamReader( System.in ) );
      boolean valid = true;
      String inputLine = "";
      do
      {
         System.out.println( "Please enter a number" );
         try
         {
            inputLine = reader.readLine();
         }
         catch ( IOException ioe )
         {
            System.out.println( ioe );
            System.exit( 1 );
         }
         valid = checkInt( inputLine );
      } while ( ! valid );
      System.out.println( "Number entered was " + inputLine );
      System.exit( 0 );
   }
}
