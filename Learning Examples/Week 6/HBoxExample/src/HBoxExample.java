import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * HBoxExample demonstrates the HBox layout.
 * 
 */

public class HBoxExample extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Group root = new Group();
        Scene scene = new Scene(root, 200, 80);
        HBox hbox = new HBox(5);         // pixels space between child nodes
        hbox.setPadding(new Insets(1));  // padding between child nodes only
        Rectangle r1 = new Rectangle(30, 30);
        Rectangle r2 = new Rectangle(60, 60);
        Rectangle r3 = new Rectangle(15, 60);
        Rectangle r4 = new Rectangle(60, 15);

        HBox.setMargin(r1, new Insets(2,2,2,2));

        hbox.getChildren().addAll(r1, r2, r3, r4);
        
        root.getChildren().add(hbox);
        
        
        primaryStage.setOnShown((WindowEvent we) -> {
            System.out.println("hbox width  " + hbox.getBoundsInParent().getWidth());
            System.out.println("hbox height " + hbox.getBoundsInParent().getHeight());
        });
        primaryStage.setTitle("HBox Example");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
