import java.net.Socket;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class ReverseStringClient 
{
   public static void main( String[] args ) 
   {
      try 
      
      
      {
         // construct client socket for connection to server 
         // on port 1234
         Socket sock = new Socket( args[ 0 ], 1234 );
         
         
         // construct PrintWriter for sending string to server
         PrintWriter out =
                    new PrintWriter( sock.getOutputStream() );
         // send string to server
         
         out.println( s );
         out.flush();
         // construct BufferedReader for reading information
         // sent from server
         
         BufferedReader in = new BufferedReader( 
             new InputStreamReader( sock.getInputStream() ) );
         // read information from server
         
         String t = in.readLine();
         if ( t != null ) 
            System.out.println( "To server:   " + s +  
                                "\nFrom server: " + t );
         // close client socket
         sock.close();
      } 
      catch( IOException e ) 
      { 
         System.err.println( e ); 
      }
   }
}

/*             if (Character.isDigit(t.charAt(t.length()))== true){
            	
            	int Num1 = (int) t.charAt(0);
            	int Num2 = (int) t.charAt(3);
            	
            	recieve digits
            	
            }
            
            */
