import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
public class Reader
{
   public static void main(String[] args)
                                      throws IOException
   {
      BufferedReader reader = new BufferedReader(
                   new InputStreamReader( System.in ) );
      String name = "";
      System.out.print( "Name: " );
      name = reader.readLine();
      System.out.println( "Name entered was '" 
                                         + name + "'" );
      System.exit( 0 );
   }
}
