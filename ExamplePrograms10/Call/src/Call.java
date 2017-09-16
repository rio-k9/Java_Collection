import java.net.Socket;
import java.io.IOException;

public class Call 
{
   public static void main( String[] args ) 
   {
      // check one command line argument has been supplied
      if ( args.length != 1 ) 
      {
         System.err.println( "Call <IP address of server>" );
         return;
      }
      try 
      {
         // Create client socket for connection to server 
         // on port 1234
         Socket sock = new Socket( args[ 0 ], 1234 );
         sock.close();
      } 
      catch( IOException e ) 
      { 
         System.err.println( e ); 
      }
   }
}
