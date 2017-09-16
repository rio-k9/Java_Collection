import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.text.*;

public class DisplayString extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 300, 200);
        Text t = new Text(100, 50, "Graphics");
        t.setFont(Font.font("Helvetica", FontWeight.BOLD, FontPosture.ITALIC, 24));
        root.getChildren().add(t);
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("Display String");
        primaryStage.show();
    }
}
