import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Items
{  
   public static void main( String[] args )
   {   
      BufferedReader reader = new BufferedReader( 
                   new InputStreamReader( System.in ) );
      String inputLine = "";
      try
      {
         System.out.print( "Enter a line of input> " );
         inputLine = reader.readLine();
      }
      catch( IOException ioe )
      {
         System.out.println( "I/O error" );
         System.exit( 1 );
      }
      // determine number of items in line
      StringTokenizer tokenizer
                     = new StringTokenizer( inputLine );
      int count = tokenizer.countTokens();
      System.out.println( "There are " + count 
                                           + " items" );
      // break up line into items
      while ( tokenizer.hasMoreTokens() )
      {
         String item = tokenizer.nextToken();
         System.out.println( item );
      }
      System.exit( 0 );
   }
}
