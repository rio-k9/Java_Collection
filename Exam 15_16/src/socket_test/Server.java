package socket_test;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Server extends JFrame{
	
	private JTextField userText;
	private JTextArea chatWindow;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private ServerSocket server;
	private Socket Connection;
	
	//Setup Constructor
	public Server(){
		super("Rios Instant Messenger");
		userText = new JTextField();
		userText.setEditable(false);
		userText.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event) {
						sendMessage(event.getActionCommand());
						userText.setText("");
					}
				}
		);
		add(userText, BorderLayout.NORTH);
		chatWindow=new JTextArea();
		add(new JScrollPane(chatWindow));
		setSize(300,150);
		setVisible(true);
	}
	
	//Setup and run the server
	public void startRunning(){
		try{
			server = new ServerSocket(6789, 100);
			//int Port Number int 100 connections max (backlog / queue link)
			while(true){
				try{
					waitForConnection();
					setupStreams();
					whileChatting();
					//connect and have conversation
				}catch(EOFException eofe){
					showMessage("\n Punk Ass Bitch.");
				}finally{
					closeChat();
				}
			}
			
		}catch(IOException ioe){
			ioe.printStackTrace();
			
		}
	}
	
	//wait for connection, then display connection information
	private void waitForConnection() throws IOException{
		showMessage("\n Waiting for a Punk Ass Bitch to connection... \n ");
		Connection = server.accept();
		showMessage("Now connected to " + Connection.getInetAddress().getHostName() + ". Punk.");
		//this is your own IP address, the machine running the the code
		//
		
	}
	
	//get stream to send and recieve data
	private void setupStreams() throws IOException {
		output = new ObjectOutputStream(Connection.getOutputStream());
		output.flush();
		input = new ObjectInputStream(Connection.getInputStream()); 
		showMessage("\n Streams have successfully connected.");
	}
	
	//during the chat conversation
	private void whileChatting() throws IOException{
		String message = " You are now connected! Say hello :) ";
		sendMessage(message);
		ableToType(true);
		do{
			//have a conversation
			try{
				message = (String) input.readObject();
				showMessage("\n" + message);
			}catch(ClassNotFoundException cnf){
				showMessage("\n Server could not understand the message...");
			}
		}while(!message.equals("CLIENT - END"));
	}
	
	//send a message to the client / socket user
	private void sendMessage(String message){
		try{
			output.writeObject("Punk Ass Server: " + message);
			output.flush();
			showMessage("\nPunk Ass Server: " + message); 
		}catch(IOException ioe){
			chatWindow.append("\n Message not sent, try again or typing something else");
			
		}
		
	}
	
	//updates chatWindow 
	private void showMessage(final String text){
		SwingUtilities.invokeLater(
			new Runnable(){
				public void run(){
					chatWindow.append(text);
				}
			}
		);
	}
	
	//let the user type stuff into their box
	private void ableToType(final boolean ToF){
		SwingUtilities.invokeLater(
				new Runnable(){
					public void run(){
						userText.setEditable(ToF);
					}
				}
		);
		
	}
}
