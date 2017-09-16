import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
public class SimpleReader
{
   public static void main(String[] args) 
                                      throws IOException
   {
      InputStreamReader input = 
                     new InputStreamReader( System.in );
      BufferedReader reader = 
                     new BufferedReader( input );
      String name = "";
      System.out.print( "Name: " );
      name = reader.readLine();
      System.out.println( "Name entered was '" 
                                         + name + "'" );
      System.exit( 0 );
   }
}
