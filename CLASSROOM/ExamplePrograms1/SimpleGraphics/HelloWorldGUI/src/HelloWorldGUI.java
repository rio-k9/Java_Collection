import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Text;

public class HelloWorldGUI extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 300, 200);
        Text t = new Text(10, 50, "Hello, World");
        root.getChildren().add(t);
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hello World GUI");
        primaryStage.show();
    }
}

