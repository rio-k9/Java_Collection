import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
public class Validate
{
   public static boolean checkInt( String input )
   {
      boolean valid = true;
      int length = input.length();
      char ch;
      for ( int i = 0; i < length; i++ )
      {
         ch = input.charAt( i );
         if ( ! Character.isDigit( ch ) )
            valid = false;
      }
      return valid;
   }
   public static void main( String[] args )
   {  
      BufferedReader reader =
        new BufferedReader( new InputStreamReader ( System.in ) );
      String inputLine = "";
      try
      {
         System.out.println( "Please enter a number" );
         inputLine = reader.readLine();
      }
      catch ( IOException ioe )
      {
         System.out.println( ioe );
         System.exit( 1 );
      }
      if ( ! checkInt( inputLine ) )
      {
         System.out.println( inputLine 
                    + " is not a valid non-negative integer" );
         System.exit( 2 );
      }
      else
      {
         System.out.println( inputLine 
                        + " is a valid non-negative integer" );
         System.exit( 0 );
      }
   }
}
