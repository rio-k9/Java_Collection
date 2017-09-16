import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;

public class DrawOvals extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 400, 300);
        
        // A red oval
        Ellipse oval1 = new Ellipse();
        oval1.setCenterX(200);
        oval1.setCenterY(150);
        oval1.setRadiusX(100);
        oval1.setRadiusY(50);
        oval1.setFill(Color.BLUE);
        root.getChildren().add(oval1);
        
        // With a white oval overlaid at the centre
        Ellipse oval2 = new Ellipse();
        oval2.setCenterX(200);
        oval2.setCenterY(150);
        oval2.setRadiusX(50);
        oval2.setRadiusY(25);
        oval2.setFill(Color.WHITE);
        root.getChildren().add(oval2);
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("Draw Ovals");
        primaryStage.show();
    }
}

