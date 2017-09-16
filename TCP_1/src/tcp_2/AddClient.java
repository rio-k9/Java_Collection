package tcp_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class AddClient {
	public static void main(String[] args){
		try{
			Scanner scanner = new Scanner(System.in);
			Socket sock = new Socket("localhost", 6000);
			BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			String t = in.readLine();
			System.out.println(t);
			
			int num1 = scanner.nextInt();
			String toSend = String.valueOf(num1);
			PrintWriter ps = new PrintWriter(sock.getOutputStream());
			ps.println(toSend);
			ps.flush();
			
			BufferedReader in2 = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			String t2 = in.readLine();
			System.out.println(t2);
			
		}
		catch(Exception e){
			System.out.println("Error");
		}
	}
}
