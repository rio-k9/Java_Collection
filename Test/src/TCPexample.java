import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPexample {
	
	public static void main() {
		
		Socket sSock = null;
		try{
			
			sSock = new Socket( 6000 );
		}
		catch( IOException e ){
			System.err.println(e);
		}
		try{
			PrintWriter out = new PrintWriter( sSock.getOutputStream() );
		out.println( "Yes" );
		out.flush
		();
		BufferedReader
		in = new 
		BufferedReader
		( new 
				InputStreamReader
				( 
				sock.getInputStream
				() ) )String t = 
				in.readLine
				();
				if ( t != null ) 
				System.out.println
				( "To server:   " + s +  
				"
				\
				nFrom
				server: " + t );
				// close client socket
				sock.close
				();
				} 
				catch( 
				IOException
				e ) 
				{ 
				System.err.println
				( e ); 
		}
	}

}
