import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.util.Optional;


public class ConfirmationDialogExample
        extends Application {

	public static void main(String [] args) {

		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

	primaryStage.setTitle("Confirmation Dialog Example");

	Alert alert = new Alert(AlertType.CONFIRMATION);
	alert.setTitle("Confirmation Dialog");
	alert.setHeaderText("This is a Confirmation Dialog");
	alert.setContentText("Are you ok with this?");

	Optional<ButtonType> result = alert.showAndWait();
	if (result.get() == ButtonType.OK){
	    // ... user chose OK
		System.out.println("Ok Button Pressed");
	} else {
	    // ... user chose CANCEL or closed the dialog
		System.out.println("Dialog Cancelled");
	}
	

}
	
}