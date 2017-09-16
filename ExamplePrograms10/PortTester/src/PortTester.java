import java.net.InetAddress;
import java.net.UnknownHostException;
import java.net.Socket;
import java.io.IOException;
public class PortTester 
{
   public static void main( String[] args ) 
   {
      if ( args.length != 1 ) 
      {
         System.err.println( "PortTester <host name>" );
         return;
      }
      // Get IP address of hostname
      InetAddress addr = null;
      try 
      {
         addr = InetAddress.getByName( 6000 );
      } 
      catch( UnknownHostException e ) 
      {
         System.err.println( e );
         return;
      }
      System.out.println( "Testing ports on " + 6000 );
      // well-known ports for ftp-data, ssh, smtp and http 
      int[ ] ports = { 20, 22, 25, 80 };
      int i = 0;
      for ( i = 0; i < ports.length; i++ ) 
      {
         Socket s = null;
         try 
         {
            s = new Socket( addr, ports[ i ] );
            System.out.println( "Server listening on port " 
                                             + ports[ i ] );
            if ( s != null ) 	//** socket already open?
                s.close();     	//** if so, close
         }
         catch( IOException e ) 
         {
            System.err.println( "Server not listening on port "
                                             + ports[ i ] );
            continue;
         }
      }
   } 
}
