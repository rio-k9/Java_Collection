import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;

public class Q_1Bi extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 400, 300);
        
        // A blue circle
        Ellipse circle1 = new Ellipse();
        circle1.setCenterX(60);
        circle1.setCenterY(80);
        circle1.setRadiusX(40);
        circle1.setRadiusY(40);
        circle1.setFill(Color.BLUE);
        root.getChildren().add(circle1);
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("Draw Ovals");
        primaryStage.show();
    }
}