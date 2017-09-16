import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.TextInputDialog;
import java.util.Optional;

public class TextInputDialogExample
        extends Application {

	public static void main(String [] args) {

		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

	primaryStage.setTitle("Text Input Dialog Example");

	TextInputDialog dialog = new TextInputDialog("David");
	dialog.setTitle("Text Input Dialog");
	dialog.setHeaderText("This is a Text Input Dialog");
	dialog.setContentText("Please enter your name:");

	Optional<String> result = dialog.showAndWait();
	
	// Traditional way to get the response value.
	//if (result.isPresent()){
	//    System.out.println("Your name: " + result.get());
	//}

	// The Java 8 way to get the response value (with lambda expression).
	result.ifPresent(name -> System.out.println("Your name: " + name));




}
	
}