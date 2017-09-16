package tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TransServer {
    public static void main (String args[]){
    	double count = 0;
        ServerSocket sSock = null;
        try
        {
            sSock = new ServerSocket(1234); // Create server socket listening at port 1234
        }
        catch (IOException e)
        {
            System.err.println(e);
            return;
        }
        while (true){
			try {
				Socket connection = sSock.accept();
	
		        System.out.println("Server running...");
		         // wait for connections
		        // we assume one connection at a time1
		        // use multi-threading to handle multiple connections at the same time
		        Boolean flag = true;
		        while (flag){ 
		        	try {
		                    System.out.println("Mpikame");
		                    
		                    BufferedReader in = new BufferedReader(
		                            new InputStreamReader( connection.getInputStream() ));
		                    String t = in.readLine();
		      
		                    System.out.println(t);
		                    if (t.equals("1 1")){
		                    	flag = false;
		                    }
		                    double calculate;
		                    // generate random number for guessing
		                    String[] strList = t.split(" ");
		                    double num1 = Double.valueOf(strList[0]);
		                    double num2 = Double.valueOf(strList[1]);
		                    calculate = num1 * num2;
		                    count += calculate;
		                    String toSend = String.valueOf(count);
		                    System.out.println("Mpikame2");
		
		                    PrintWriter ps = new PrintWriter(connection.getOutputStream());
		                    ps.println(toSend);
		                    System.out.println("Mpikame3");
		                    ps.flush();
		                    System.out.println("Mpikame4");
		                    
		                    // close client socket
		                    break;
		                    }
		                    catch (IOException ioe)
		                    {
		                        System.err.println(ioe);
		                    } catch (Exception e){
		                        System.out.println("Please send numbers");
		
		                    }
		        }
		        connection.close();
			}
		    catch (Exception e){
		    	
		    }
        }
    }
   }

