
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.util.Optional;


public class ConfirmationCustomDialogExample 
	extends Application {

	public static void main(String [] args) {

		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

	primaryStage.setTitle("Custom Confirmation Dialog Example");

	Alert alert = new Alert(AlertType.CONFIRMATION);
	alert.setTitle("Confirmation Dialog with Custom Actions");
	alert.setHeaderText("This a Confirmation Dialog with Custom Actions");
	alert.setContentText("Choose your option.");

	ButtonType buttonTypeOne = new ButtonType("You");
	ButtonType buttonTypeTwo = new ButtonType("Me");
	ButtonType buttonTypeThree = new ButtonType("Other");
	ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

	alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeThree, buttonTypeCancel);

	Optional<ButtonType> result = alert.showAndWait();
	if (result.get() == buttonTypeOne){
	    // ... user chose "You"
		System.out.println("Hello You");
	} else if (result.get() == buttonTypeTwo) {
	    // ... user chose "Me"
		System.out.println("Hello Me");
	} else if (result.get() == buttonTypeThree) {
	    // ... user chose "Other"
		System.out.println("Hello Other");
	} else {
	    // ... user chose CANCEL or closed the dialog
		System.out.println("Dialog Cancelled");
	}

}
	
}