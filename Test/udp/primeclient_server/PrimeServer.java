package primeclient_server;

import java.io.*;
import java.net.*;
public class PrimeServer 
{
	public static void main(String [] args)
	{
		DatagramSocket socket;
		try
		{
			 socket = new DatagramSocket(5000);
		}
        catch (IOException e)
        {
            System.err.println(e);
            return;
        }
		
		System.out.println("Server running...");
		
	    while ( true )
	    {
	    	try 
	    	{
	           byte data[] = new byte[ 100 ];
	           DatagramPacket receivePacket = new DatagramPacket( data, data.length );
	           socket.receive( receivePacket );
	           String str = new String( receivePacket.getData(), 0, receivePacket.getLength() );
	           int num = 0;
               try
               {
                   num = Integer.parseInt(str);
               }
               catch (NumberFormatException e)
               {
                   System.err.println(e);
               }

               String response = String.valueOf(isPrime(num));
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
	
    // check if num is a prime number
    // we use similar approach as previous exercise
    private static boolean isPrime(int num)
    {
        if (num < 2)
        {
            return false;
        }
        else
        {
            for (int i = 2; i < num; i++)
            {
                if (num % i == 0)
                {
                    return false;
                }
            }
            
            return true;
        }
    }
	
}
