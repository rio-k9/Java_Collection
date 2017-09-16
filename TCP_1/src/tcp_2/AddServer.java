package tcp_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class AddServer {
	public static void main(String args[]){
		ServerSocket sSock = null;
		try{
			sSock = new ServerSocket(6000);
		}
		catch(Exception e){
		}
		System.out.println("Server running...");
		while (true){
			try{
				Socket sock = sSock.accept();
				PrintWriter ps = new PrintWriter(sock.getOutputStream());
				Random rand = new Random();
				int r1 = rand.nextInt(10);
				int r2 = rand.nextInt(10);
				ps.println("Add " + r1 +"+" + r2 +" please!");
				ps.flush();
				int sum = r1 + r2;
				BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
				String t = in.readLine();
				int clientSum = Integer.valueOf(t);
				System.out.println(t);
				String answer = "Incorrect";
				if (sum == clientSum){
					answer = "Correct";
				}
				PrintWriter sendResult = new PrintWriter(sock.getOutputStream());
				sendResult.println(answer);
				sendResult.flush();
				sock.close();
				
			}
			catch(Exception e){
			}
		}
	}
}
