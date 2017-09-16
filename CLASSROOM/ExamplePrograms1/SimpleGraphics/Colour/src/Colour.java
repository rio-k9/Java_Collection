import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class Colour extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 300, 200);
        Text t = new Text(100, 70, "Hello");
        t.setFont(Font.font("Times", FontWeight.BOLD, FontPosture.ITALIC, 30));
        t.setStroke(Color.color(1.0, 0.25, 0.25));
        t.setFill(Color.AQUA);
        root.getChildren().add(t);
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("Display String");
        primaryStage.show();
    }
}
