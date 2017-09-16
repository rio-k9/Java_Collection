import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

class CallListener 
{ 
   public static void main( String args[] )
   {
      try 
      {
         // Construct a server socket on port 1234
         ServerSocket sSock = new ServerSocket( 1234 );
         while ( true ) 
         {
            // The server socket's accept method blocks until
            // a client connection occurs.  The server socket's
            // accept method then returns a reference to a client
            // socket that represents the client connection.
            Socket sock = sSock.accept();  
            // display information about client connection.
            printInfo( sock );
            sock.close();
         }
      } 
      catch( IOException e ) 
      { 
         System.err.println( e ); 
      }
   }
   // method to print information about client connection.
   private static void printInfo( Socket s ) 
   {
      System.out.println( "Remote port:    " 
                                      + s.getPort() );
      System.out.println( "Local port:     " 
                                 + s.getLocalPort() );
      System.out.println( "Remote IP addr: " 
                               + s.getInetAddress() );
      System.out.println( "Local IP addr:  " 
                              + s.getLocalAddress() );
   }
}
