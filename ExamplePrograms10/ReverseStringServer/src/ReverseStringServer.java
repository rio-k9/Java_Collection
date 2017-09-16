import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
public class ReverseStringServer 
{ 
   public static void main( String args[] ) 
   Socket sock;

   {
	  String CorrectAnswer;
	  int Num1;
	  int Num2;
      ServerSocket sSock = null;
      String sendMe;
      try 
      {
         sSock = new ServerSocket( 6000 );
   	  sock = sSock.accept();  
      } 
      catch( IOException e ) 
      { 
         System.err.println( e ); 
         return;
      }
      
      
      System.out.println( "Server running..." );
      while ( true ) 
      	  if (sendMe == "Request Numbers"){
      		try {

          	  PrintWriter ps = 
                        new PrintWriter( sock.getOutputStream() ); 
                  ps.println( new String(GenNums() ) );
                  ps.flush();
               } catch( IOException e ){  
            			
                   System.err.println( e ); 
                }
      
      {
         try 
         {
            
            BufferedReader in = new BufferedReader( 
              new InputStreamReader( sock.getInputStream() ) );
            // read a string and return a reversed string
            String t = in.readLine();
            
            
            
            if (Character.isDigit(t.charAt(t.length()))== true){            	
            	int clientResult = (int) t.charAt(t.length());           	
            	//CALCULATE THE ORIGINAL TWO DIGITS HERE            	
            }                   
            else {
            	CorrectAnswer = "Not a digit!";
            }
            
            
            
  
            if ( t != null ) 
            {
               PrintWriter ps = 
                     new PrintWriter( sock.getOutputStream() ); 
               ps.println( new String("RETURN CORRECT OR INCORRECT HERE" ) );
               ps.flush();
            }
            // close client socket
            sock.close();
         } 
         catch( IOException e ) 
         { 
            System.err.println( e ); 
         }
      }
   }
}
   
   
   public static String GenNums(){
	   
	   Random ran = new Random();
	   
	   int num1 =  ran.nextInt(-1) +10;
	   int num2 =  ran.nextInt(-1) +10;
	   
	   String twoDigAdd = (num1 + "+" + num2).toString();
	   return twoDigAdd;	   	   
   }
}
