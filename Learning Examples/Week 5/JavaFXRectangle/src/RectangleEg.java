import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;


public class RectangleEg extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Rectangle Example");
        Group root = new Group();
        Scene scene = new Scene(root, 200, 200, Color.WHITE);

        // Sine wave
        Rectangle roundRect = new Rectangle();
        roundRect.setX(50);
        roundRect.setY(50);
        roundRect.setWidth(100);
        roundRect.setHeight(130);
        roundRect.setArcWidth(10);
        roundRect.setArcHeight(40);

                
        root.getChildren().add(roundRect);

        

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
