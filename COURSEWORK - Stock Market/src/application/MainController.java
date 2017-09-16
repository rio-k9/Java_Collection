package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class MainController {
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 *  Controller for calculator
	 * 
	 */
	@FXML
	private Label result;
	private long number1 = 0;
	String operator = "";
	private boolean start = true;
	private Model model = new Model();
	
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
			
			
			/* add event listener for button press
			 * error when trying to add additional numbers
			 * can be easily dealt with in more code
			 * add reset button
			 */
			operator = "";
			start = true;
		}
		
	}
		


}
