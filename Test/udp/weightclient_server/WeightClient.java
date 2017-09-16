package weightclient_server;

/**
 * Weight Client
 * @author Yukun
 */
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.*;


public class WeightClient extends Application {

	@Override
	public void start(Stage primaryStage)
	{
		GridPane gridpane = new GridPane();
		Scene scene = new Scene(gridpane);
		
		gridpane.setPadding(new Insets(5));
		gridpane.setHgap(5);
		gridpane.setVgap(5);
		Label lblImperial = new Label("Imperial");
		lblImperial.setMaxWidth(Double.MAX_VALUE);
		lblImperial.setStyle("-fx-background-color: pink;");
		gridpane.add(lblImperial, 0, 0, 2, 1);
		
		txtPound = new TextField();
		txtPound.setPrefColumnCount(5);
		gridpane.add(txtPound, 2, 0);
		
		Label lblLb = new Label("lb");
		gridpane.add(lblLb, 3, 0);
		
		txtOunce = new TextField();
		txtOunce.setPrefColumnCount(5);
		gridpane.add(txtOunce, 4, 0);
		
		Label lblOz = new Label("oz");
		gridpane.add(lblOz, 5, 0);
		
		Label lblMetric = new Label("Metric");
		lblMetric.setStyle("-fx-background-color: pink;");
        gridpane.add(lblMetric, 0, 1, 2, 1);
        lblMetric.setMaxWidth(Double.MAX_VALUE);
		
        txtGram = new TextField();
        txtGram.setPrefColumnCount(10);
        txtGram.setStyle("-fx-background-color: yellow;");
        txtGram.setEditable(false);  // set read only
        gridpane.add(txtGram, 2, 1, 3, 1);
        
        Label lblGram = new Label("g");
        gridpane.add(lblGram, 5, 1);
        
        Button btnClear = new Button("Clear");
        btnClear.setStyle("-fx-background-color: orange;");
        gridpane.add(btnClear, 0, 2, 2, 1);
        btnClear.setMaxWidth(Double.MAX_VALUE);
        btnClear.setOnAction((e)->
        {
            txtGram.setText("");
            txtPound.setText("");
            txtOunce.setText("");
            txtStatus.setText("");        	
        });
        
        Button btnConvert = new Button("Convert");
        btnConvert.setStyle("-fx-background-color: orange;");
        gridpane.add(btnConvert, 2, 2, 2, 1);
        btnConvert.setMaxWidth(Double.MAX_VALUE);
        btnConvert.setOnAction((e)->
        {
            int pound, ounce;
            // check if the input is correct
            String strPound = txtPound.getText();
            String strOunce = txtOunce.getText();
            if (strPound.equals(""))    // empty means 0
            {
                strPound = "0";
            }
            if (strOunce.equals(""))
            {
                strOunce = "0";
            }
            try
            {
                pound = Integer.parseInt(strPound);
                ounce = Integer.parseInt(strOunce);
            }
            catch (NumberFormatException nfe)
            {
                txtStatus.setText("Input values are not proper integers!");
                return;
            }
            
            String msg = pound + " " + ounce;
            byte[] sendBuffer = msg.getBytes();
            try
            {
                DatagramPacket sendPacket = new DatagramPacket(
                    sendBuffer, sendBuffer.length,
                    InetAddress.getLocalHost(), 5000
                    );
                
                socket.send(sendPacket);
                txtStatus.setText("Message sent to the server...");
            }
            catch (IOException ioe)
            {
                txtStatus.setText("Error sending message");
            }
        	
        });
        
        Button btnDone = new Button("Done");
        btnDone.setStyle("-fx-background-color: orange;");
        gridpane.add(btnDone, 4, 2, 2, 1);
        btnDone.setMaxWidth(Double.MAX_VALUE);
        btnDone.setOnAction((e)->
        {
        	System.exit(0);
        });
        
        
        Label lblStatus = new Label("Status");
        lblStatus.setStyle("-fx-background-color: pink;");       
        gridpane.add(lblStatus, 0, 3, 2, 1);
        lblStatus.setMaxWidth(Double.MAX_VALUE);
        
        txtStatus = new TextField();
        txtStatus.setPrefColumnCount(15);
        txtStatus.setEditable(false);       // set to read only
        txtStatus.setStyle("-fx-background-color: yellow;");
        txtStatus.setMaxWidth(Double.MAX_VALUE);
        gridpane.add(txtStatus, 2, 3, 4, 1);
        
		primaryStage.setTitle("Weight Client");
		primaryStage.setScene(scene);
		primaryStage.show();
		
        // create datagram socket
        try
        {
            socket = new DatagramSocket();  // we don't care about the local port
        }
        catch (SocketException se)
        {
            txtStatus.setText("Socket exception: " + se.toString());
        }
        
        new WeightThread(this, socket).start();
	}
	
	public void setGram(String txt)
	{
		txtGram.setText(txt);
	}
	
	public void setStatus(String txt)
	{
		txtStatus.setText(txt);
	}
	
	public static void main(String [] args)
	{
		launch(args);
	}
	
    // private variables
    private TextField txtPound, txtOunce, txtGram, txtStatus;
    private DatagramSocket socket;
}
