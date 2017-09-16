package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Random;

public class MainController {

	@FXML
	private Label myLabel;
	public void generateRandom(ActionEvent event){
		Random rand = new Random();
		int myRand = rand.nextInt(100) + 1;
		System.out.println(Integer.toString(myRand));
		myLabel.setText(Integer.toString(myRand));
		
	}

}
