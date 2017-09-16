import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * VBoxExample demonstrates the VBox layout.
 */

public class VBoxExample extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Group root = new Group();
        Scene scene = new Scene(root, 80, 200);
        VBox vbox = new VBox(5);        // spacing between child nodes only.
        vbox.setPadding(new Insets(1)); // space between vbox border and child nodes column

        Rectangle r1 = new Rectangle(30, 30);
        Rectangle r2 = new Rectangle(60, 60);
        Rectangle r3 = new Rectangle(15, 60);
        Rectangle r4 = new Rectangle(60, 15);

        VBox.setMargin(r1, new Insets(2,2,2,2)); // margin around r1

        vbox.getChildren().addAll(r1, r2, r3, r4);
  
        root.getChildren().add(vbox);
        primaryStage.setOnShown((WindowEvent we) -> {
            System.out.println("vbox width  " + vbox.getBoundsInParent().getWidth());
            System.out.println("vbox height " + vbox.getBoundsInParent().getHeight());
        });
        primaryStage.setTitle("VBox Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
