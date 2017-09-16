package application;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;
import com.opencsv.CSVReader;
import java.lang.String;
import java.net.URL;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainController {
	
	@FXML
	private Label lblStatus;
	@FXML
	private Label menuLabel;
	@FXML
	private Button stockButton;
	@FXML
	private Button calcButton;
	@FXML
	private Button noteButton;
	@FXML
	private TextArea noteText;
	@FXML
	private Button noteSave;
	@FXML
	private TextField txtUserName;
	@FXML
	private TextField txtPassword;

	
	@FXML
	private Label result;
	private long number1 = 0;
	String operator = "";
	private boolean start = true;
	private Model model = new Model();
	
	@FXML
	private Button parseTest;
	@FXML 
	private Label labelTest;
	
	@FXML
	public void wooshSound(){
		try {
			System.out.println("Woosh!");
			String soundName = "src/img/woosh.wav";    
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	@FXML
	public void clickSound(){
		try {
			System.out.println("Click!");
			String soundName = "src/img/click.wav";     //Wav file
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile()); //makes it into audio output
			Clip clip = AudioSystem.getClip(); //turns audio output into java clip
			clip.open(audioInputStream); //plays clip
			clip.start();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	

	
	

	
	
	@FXML
	public void Login(ActionEvent event) throws Exception {
		if (txtUserName.getText().toUpperCase().equals("ADMIN@CARDIFF.AC.UK") && txtPassword.getText().equals("password")) {
			lblStatus.setText("Correct");
			lblStatus.setStyle("-fx-text-fill: Green");
			 
			String userID = System.getProperty("user.name");
			String loginButton[] = {"Ok"};
	        	int loginConfirm = JOptionPane.showOptionDialog(null,"Login successful, welcome " + userID + ".","Login",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE,null,loginButton, null);
	        	if (loginConfirm == JOptionPane.OK_OPTION){
				Stage mainStage = new Stage();
				Parent root = FXMLLoader.load(getClass().getResource("/application/Main.fxml"));
				Scene scene = new Scene(root,600,400);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				mainStage.setScene(scene);
				mainStage.show();
				//CLOSE CODE
				((Node)(event.getSource())).getScene().getWindow().hide();
				wooshSound();
	        	
	        }
		}		
		else {
			lblStatus.setText("Login Failed");
			lblStatus.setStyle("-fx-text-fill: red");
		}
	}
	
	@FXML
	public void StockData(ActionEvent event) throws Exception {
		System.out.println("Stock button pushed");
		Stage mainStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/StockList.fxml"));
		Scene scene = new Scene(root,750,562.50);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		mainStage.setScene(scene);
		mainStage.show();
		wooshSound();
		
		//AnchorPane pane = FXMLLoader.load(getClass().getResource("/application/StockList.FXML"));
		
	}
	
	
	@FXML
	public void Notes(ActionEvent event) throws Exception {
		
		System.out.println("Notes button pushed");
		System.out.println("Calculator button pushed");
		Stage mainStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/Notes.fxml"));
		Scene scene = new Scene(root,435,485);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		mainStage.setScene(scene);
		mainStage.show();
		wooshSound();
		
	}
	
	@FXML
	public void saveNotes(ActionEvent event) {
		System.out.println("Saving notes");
		/*
		 *throws java.io.FileNotFoundException
		try( PrintWriter out = new PrintWriter("newtxtfile.txt") ){
			out.println("text here");
		}catch(Exception e) {
			e.printStackTrace();
		}
		*/
	}
	

	@FXML
	public void Calculator(ActionEvent event) throws Exception {
		
		System.out.println("Calculator button pushed");
		Stage mainStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/Calculator.fxml"));
		Scene scene = new Scene(root,300,300);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		mainStage.setScene(scene);
		mainStage.show();
		wooshSound();
	}
	

	@FXML
	public void processNumbers(ActionEvent event){
		if (start) {
			result.setText("");
			start = false;
		}
		String value = ((Button)event.getSource()).getText();
		result.setText(result.getText() + value);
		
	}
	
	@FXML
	public void processOperators(ActionEvent event) {
		String value = ((Button)event.getSource()).getText();
		
		if (!value.equals("=")) {
			
			operator = value;
			number1 = Long.parseLong(result.getText());
			result.setText("");
			
		} else {
			long number2 = Long.parseLong(result.getText());
			float output = model.calculate(number1,  number2, operator);
			result.setText(String.valueOf(output));
			
			
			 // add event listener for button press
			 // error when trying to add additional numbers
			 // can be easily dealt with in more code
			 // add reset button
			 
			operator = "";
			start = true;
		}
		
	}

}
