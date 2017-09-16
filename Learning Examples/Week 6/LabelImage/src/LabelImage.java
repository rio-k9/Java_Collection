	// How to embed an image in a label.  
  
import javafx.application.*;  
import javafx.scene.*;  
import javafx.stage.*;  
import javafx.scene.layout.*;  
import javafx.scene.control.*;  
import javafx.geometry.*; 
import javafx.scene.image.*; 
  
public class LabelImage extends Application {  
  
  public static void main(String[] args) {  
  
    // Start the JavaFX application by calling launch().  
    launch(args);    
  }  
  
  // Override the start() method.  
  public void start(Stage myStage) {  
  
    // Give the stage a title.  
    myStage.setTitle("Use an Image in a Label");  
  
    // Use a FlowPane for the root node.  
    FlowPane rootNode = new FlowPane();  
 
    // Use center alignment. 
    rootNode.setAlignment(Pos.CENTER); 
  
    // Create a scene.  
    Scene myScene = new Scene(rootNode, 300, 200);  
  
    // Set the scene on the stage.  
    myStage.setScene(myScene);  
 
    // Create a scaled image.  
    Image imgWoodland = new Image("woodland.png", 100, 100, true, true);  
 
    // Create an image view that uses the image.  
    ImageView ivWoodland = new ImageView(imgWoodland); 
  
    // Create a label that contains both an image and text. 
    Label imageLabel = new Label("Woodland", ivWoodland);  
 
    // Add the label to the scene graph.  
    rootNode.getChildren().add(imageLabel);  
 
    // Show the stage and its scene.  
    myStage.show();  
  }  
}