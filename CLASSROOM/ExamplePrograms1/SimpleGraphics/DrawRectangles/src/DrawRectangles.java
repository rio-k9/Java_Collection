import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;

public class DrawRectangles extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 400, 300);
        
        // Rectangle (20, 50) - (120, 250)
        Rectangle rect1 = new Rectangle();
        rect1.setX(20);
        rect1.setY(50);
        rect1.setWidth(100);
        rect1.setHeight(200);
        rect1.setStroke(Color.BLUE);
        rect1.setFill(Color.AQUA);
        root.getChildren().add(rect1);
        
        // Rounded rectangle (140, 50) - (240, 250)
        Rectangle rect2 = new Rectangle();
        rect2.setX(140);
        rect2.setY(50);
        rect2.setWidth(100);
        rect2.setHeight(200);
        rect2.setArcWidth(20);
        rect2.setArcHeight(20);
        rect2.setStroke(Color.BLUE);
        rect2.setFill(Color.AQUA);
        root.getChildren().add(rect2);
        
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("Rectangles");
        primaryStage.show();
    }
}

