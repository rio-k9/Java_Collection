import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceDialog;

import java.util.ArrayList;
import java.util.Optional;

public class ChoiceDialogExample
        extends Application {

	public static void main(String [] args) {

		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

	primaryStage.setTitle("Choice Dialog Example");

	ArrayList<String> choices = new ArrayList<String>();
	choices.add("You");
	choices.add("Me");
	choices.add("Other");

	ChoiceDialog<String> dialog = new ChoiceDialog<>("Me", choices);
	dialog.setTitle("Choice Dialog");
	dialog.setHeaderText("This a Choice Dialog");
	dialog.setContentText("Make your choide:");

	
	Optional<String> result = dialog.showAndWait();
	
	// Traditional way to get the response value.
	//if (result.isPresent()){
	//    System.out.println("Your choice: " + result.get());
	// }

	// The Java 8 way to get the response value (with lambda expression).
	result.ifPresent(letter -> System.out.println("Your choice: " + letter));





}
	
}