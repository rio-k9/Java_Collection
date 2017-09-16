/*  
 * CLASS #2
 * 
 * MAIN METHOD FOR CALLING JAVAFX WINDOW
 */

package application;

//Importing required libraries
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	//Overriding method in supertype
	@Override
	//Stage class, top level container
	public void start(Stage primaryStage) {	
		//Catch error declaration
		try {	
			//Parent (level 1)
			Parent root = FXMLLoader.load(getClass().getResource("/application/Login.fxml"));	
			//Scene (level 2)
			Scene scene = new Scene(root,700,300);	
			//Apply stylesheet
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());	
			//Set scene and display window
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	//Launch application
	public static void main(String[] args) {
		launch(args);
	}
}
