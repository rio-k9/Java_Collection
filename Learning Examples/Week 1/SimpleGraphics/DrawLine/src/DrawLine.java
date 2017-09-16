import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;

public class DrawLine extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 300, 200);
        Line line = new Line();
        line.setStartX(50);
        line.setStartY(50);
        line.setEndX(250);
        line.setEndY(150);
        line.setStroke(Color.BLUE);
        root.getChildren().add(line);
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("Draw Line");
        primaryStage.show();
    }
}

