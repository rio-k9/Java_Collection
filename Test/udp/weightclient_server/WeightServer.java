package weightclient_server;

/**
 * Server that converts weight from imperial to metric
 * @author Yukun
 */
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class WeightServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        try
        {
            // construct a socket on port 5000
            DatagramSocket socket = new DatagramSocket(5000);   
            System.out.println("Weight server running...");
            // waiting for incoming packets
            while (true)
            {
                // set up a buffer packet
                byte data[] = new byte[100];
                DatagramPacket receivePacket = new DatagramPacket(data, data.length);
                // wait for packet
                socket.receive(receivePacket);
                // process the data, assuming the input is a String with two integer numbers
                String msg = new String(receivePacket.getData(), 0, receivePacket.getLength());
                Scanner scanner = new Scanner(msg);
                
                int lb = scanner.nextInt();     // pounds
                int oz = scanner.nextInt();     // ounces
                double grams = 453.6 * lb + 28.35 * oz; // convert to grams
                
                // prepare the packet to send back
                byte[] sendBuffer = String.valueOf(grams).getBytes();
                DatagramPacket sendPacket = new DatagramPacket
                        (sendBuffer, sendBuffer.length, receivePacket.getAddress(), receivePacket.getPort());
                socket.send(sendPacket);
                System.out.println(lb + " lb " + oz + " oz = " + grams + " g");
            }
        }
        catch (IOException e)
        {
            System.err.println(e);
        }
    }
}
