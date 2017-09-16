//
// Reverse the contents of a string
//
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class SplitAndJoin
{
   public static void main( String[] args )
   {
      BufferedReader reader = new BufferedReader( 
                    new InputStreamReader( System.in ) );
      String inputString = "";
      String reversedString = "";
      try
      {
         System.out.println( "Please enter a string" );
         inputString = reader.readLine();
      }
      catch ( IOException ioe )
      {
         System.out.println( ioe );
         System.exit( 1 );
      }
      for ( int i = inputString.length() - 1; i >= 0;
                                                    i-- )
      {
         char ch = inputString.charAt( i );
         reversedString += String.valueOf( ch );
      }
      System.out.println( "Reversed string is" );
      System.out.println( reversedString );
      System.exit( 0 );
   }
}
