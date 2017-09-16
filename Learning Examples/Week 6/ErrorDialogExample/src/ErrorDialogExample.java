import java.util.Optional;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class ErrorDialogExample
        extends Application {

	public static void main(String [] args) {

		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

	primaryStage.setTitle("Error Dialog Example");

	Alert alert = new Alert(AlertType.ERROR);
	alert.setTitle("Error Dialog");
	alert.setHeaderText("This is an Error Dialog");
	alert.setContentText("Some kind of mistake eh?");

	Optional<ButtonType> result = alert.showAndWait();

	if ((result.isPresent()) && (result.get() == ButtonType.OK)) {

		System.out.println("OK Button Pressed, Quitting Program");
		System.exit(-1);
	}




}
	
}