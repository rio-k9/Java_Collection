package UPD_Server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;

public class EncServer {
		
	public static void main(String args[]){
		DatagramSocket socket;
		
		
		//Run the server
		try{
			socket = new DatagramSocket(5000);
		}
		catch (IOException e){
	            System.err.println(e);
	            return;
	    }
		System.out.println("Server running...");
		
		
		//Receive data
	    while ( true )
	    {
	    	try 
	    	{
	           byte data[] = new byte[ 100 ];
	           DatagramPacket receivePacket = new DatagramPacket( data, data.length );
	           socket.receive( receivePacket );
	           String str = new String( receivePacket.getData(), 0, receivePacket.getLength() );

	           //Encrypt Message here

               String response =  Encrypt(str);
               byte resp[] = response.getBytes();
               DatagramPacket sendPacket = new DatagramPacket( resp, resp.length, 
   	                              receivePacket.getAddress(), receivePacket.getPort());
               socket.send(sendPacket);
	    	}
	    	catch (IOException ioe)
	    	{
	            System.err.println(ioe);
	            return;	    		
	    	}
	    }
		
		

	}
	
	//Encrypt message
public static String Encrypt(String encryptMe){
		
		String messageEncrypted = "";

        for (int i=0; i<encryptMe.length(); i++){
            char ch = encryptMe.charAt(i);
            if ((ch>='a') && (ch<='z')){
                if (ch=='z'){
                    ch='a';
                    messageEncrypted+=ch;
                } else {
                    ch+=1;
                    messageEncrypted+=ch;
                }
            } else{
            	 messageEncrypted +=ch;
            }
        }
        System.out.println("Original Message: " + encryptMe + "\n" +
        "Encrypted Message: "  +  messageEncrypted);
		
		
		
		return messageEncrypted;
	}
}
