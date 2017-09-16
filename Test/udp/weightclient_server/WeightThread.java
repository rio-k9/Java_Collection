package weightclient_server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import javafx.application.Platform;

public class WeightThread extends Thread 
{
	public WeightThread(WeightClient app, DatagramSocket s)
	{
		MainApp = app;
		socket = s;
	}
	
	public void run()
	{
        for (;;)
        {
            byte[] buffer = new byte[100];
            DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
            try
            {
                socket.receive(receivePacket);
                // get the value of grams
                String grams = new String(receivePacket.getData(), 0, receivePacket.getLength());
                Platform.runLater(()->
                {
                	MainApp.setStatus("Receive value from the server");
                    MainApp.setGram(grams);
                });
            }
            catch (IOException ioe)
            {
            	String errMsg = "Error receiving packet: " + ioe.toString();
                Platform.runLater(()->
                {
                	MainApp.setStatus(errMsg);
                });
            }
        }
	}
	private WeightClient MainApp;
	private DatagramSocket socket;
}
