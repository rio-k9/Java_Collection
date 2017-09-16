import java.util.Optional;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class InformationDialogExample
        extends Application {

	public static void main(String [] args) {

		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

		primaryStage.setTitle("InformationDialog Example");

Alert alert = new Alert(AlertType.INFORMATION);
alert.setTitle("Information Dialog");
alert.setHeaderText("This is an Information Dialog");
alert.setContentText("This is an Information Dialog");

Optional<ButtonType> result = alert.showAndWait();

if ((result.isPresent()) && (result.get() == ButtonType.OK)) {

	System.out.println("OK Button Pressed");
}


}
	
}