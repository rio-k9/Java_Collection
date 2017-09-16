package tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TransClient {
	public static void main(String[] args){
		try {
			
			Scanner scanner = new Scanner(System.in);
			boolean done = false;
			while (! done){
				Socket sock = new Socket("localhost", 1234);
				double num1 = scanner.nextDouble();

				double num2 = scanner.nextDouble();
				String toSend = num1 + " " + num2;
				if (toSend.equals("1.0 1.0")){
					done = true;
				}
				PrintWriter out = new PrintWriter (sock.getOutputStream());
				out.println(toSend);
				out.flush();
				
				BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
				String t = in.readLine();
				System.out.println(t);
				sock.close();
				
				
			}
			
			scanner.close();
		}
		catch (Exception e){
			System.out.println("Error");
		}
	}
}
