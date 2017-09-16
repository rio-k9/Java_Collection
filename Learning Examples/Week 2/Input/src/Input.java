import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
public class Input
{
   public static void main(String[] args) 
   {
      BufferedReader reader = new BufferedReader( 
                   new InputStreamReader( System.in ) );
      String name = "";
      try
      {
         System.out.print( "Name: " );
         name = reader.readLine();
      }
      catch ( IOException ioe )
      {
         System.out.println( ioe );
         System.exit( 1 );
      }
      System.out.println( "Name entered was '" 
                                         + name + "'" );
      System.exit( 0 );
   }
}
