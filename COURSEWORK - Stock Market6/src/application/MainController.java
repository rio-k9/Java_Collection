/*  CLASS #3
 * 
 * MAIN METHOD FOR CONTROLLING JAVAFX WINDOW VIA SCENEBUILDER
 * 
 */
package application;
//Imports
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
	
	//Declaring object variables private to the window and linking with FXML files to be used in scenebuilder
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
	//Constructor for model class
	private Model model = new Model();
	@FXML
	private Button parseTest;
	@FXML 
	private Label labelTest;
	//Sound that changes on window
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

	//Sound that plays on button hover
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
	//Action event for when Login button is clicked, associated via scenebuilder
	@FXML
	public void Login(ActionEvent event) throws Exception {	
		//Text from user field is made uppercase to make E-Mail feed non-sensitive to case typing
		//Asking for "ADMIN@CARDIFF.AC.UK
		//Many ways of doing this, SQL, Serializer and Token, but using if && is quick way
		if (txtUserName.getText().toUpperCase().equals("ADMIN@CARDIFF.AC.UK") && txtPassword.getText().equals("password")) {		
			//Set label to correct and green color
			lblStatus.setText("Correct");
			lblStatus.setStyle("-fx-text-fill: Green");		 
			//Getting system username into variable
			String userID = System.getProperty("user.name");
			String loginButton[] = {"Ok"};		
			//Showing option dialog, option dialog allows button to be changed
	        	int loginConfirm = JOptionPane.showOptionDialog(null,"Login successful, welcome " + userID + ".",
	        			"Login",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE,null,loginButton, null);
	        	//if OK is pressed
	        	if (loginConfirm == JOptionPane.OK_OPTION){
	        		//Launch main menu window
				Stage mainStage = new Stage();
				//Accessing FXML
				Parent root = FXMLLoader.load(getClass().getResource("/application/Main.fxml"));
				Scene scene = new Scene(root,600,400);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				//SETTING WINDOW AND SCENE
				mainStage.setScene(scene);
				mainStage.show();
				//Accessing Node tree structure
				//Close current window
				((Node)(event.getSource())).getScene().getWindow().hide();
				//Calling audio stream
				wooshSound();
	        }
		}		
		else {
			
			//Otherwise login failed label
			lblStatus.setText("Login Failed");
			lblStatus.setStyle("-fx-text-fill: red");
		}
	}
	
	//Accessible to scene builder
	@FXML
	//Calls stock information window
	public void StockData(ActionEvent event) throws Exception {
		System.out.println("Stock button pushed");
		Stage mainStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/StockList.fxml"));
		Scene scene = new Scene(root,750,600);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		mainStage.setScene(scene);
		mainStage.show();
		wooshSound();
		//Incase I want AnchorPane instead
		//AnchorPane pane = FXMLLoader.load(getClass().getResource("/application/StockList.FXML"));
	}
	@FXML
	//Window for notes
	public void Notes(ActionEvent event) throws Exception {
		System.out.println("Notes button pushed");
		System.out.println("Calculator button pushed");
		Stage mainStage = new Stage();	
		//Accessing FXML
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
		 //Save text file to root folder
		//Could also use FileChooser class
		try( PrintWriter out = new PrintWriter("newtxtfile.txt") ){
			out.println("text here");
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}

	@FXML
	//Call calculator page
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
	
	public void helpApp(ActionEvent event) {
		String loginButton[] = {"Ok"};		
		int loginConfirm = JOptionPane.showOptionDialog(null,"			See Report.PDF", "Help", JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE,null,loginButton, null);
    	//if OK is pressed
    	if (loginConfirm == JOptionPane.OK_OPTION){
	}
	}
	public void exitApp(ActionEvent event) {
		System.exit(0);
	}
	

	

	@FXML
	//Action event for when a number on the calculator is pressed
	public void processNumbers(ActionEvent event){
		if (start) {
			result.setText("");
			start = false;
		}
		String value = ((Button)event.getSource()).getText();
		result.setText(result.getText() + value);
		
	}
	
	@FXML
	//Action event for when an operator on the calculator is pressed
	public void processOperators(ActionEvent event) {
		String value = ((Button)event.getSource()).getText();
		//Making seperate if statement for = sign
		if (!value.equals("=")) {	
			//Complete with previous operator
			operator = value;
			number1 = Long.parseLong(result.getText());
			result.setText("");		
		//Otherwise it's either /, *, -, or +
		} else {		
			//Process numbers and pass through with operator to Calculator class 'model'
			long number2 = Long.parseLong(result.getText());
			float output = model.calculate(number1,  number2, operator);
			result.setText(String.valueOf(output));		
			 //Causes problem if 3rd integer is pressed, can be fixed with
			/*
			 * 
			 * 	int calculate = button counter at top of action event
			 * 
			 * if (number1 != null & number2 != null){
			 * 	 number1 = result.getText();
			 * }
			 */	 
			operator = "";
			start = true;
		}
	}
}
