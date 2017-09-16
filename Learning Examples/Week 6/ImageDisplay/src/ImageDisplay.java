// Load and display an image. 
  
import javafx.application.*;  
import javafx.scene.*;  
import javafx.stage.*;  
import javafx.scene.layout.*;  
import javafx.geometry.*; 
import javafx.scene.image.*; 
 
  
public class ImageDisplay extends Application {  
  
  public static void main(String[] args) {  
  
    // Start the JavaFX application by calling launch().  
    launch(args);    
  }  
  
  // Override the start() method.  
  public void start(Stage myStage) {  
  
    // Give the stage a title.  
    myStage.setTitle("Image Display Example");  
  
    // Use a FlowPane for the root node.  
    FlowPane rootNode = new FlowPane();  
 
    // Use center alignment. 
    rootNode.setAlignment(Pos.CENTER); 
  
    // Create a scene.  
    Scene myScene = new Scene(rootNode, 300, 200);  
  
    // Set the scene on the stage.  
    myStage.setScene(myScene);  
 
    // Create an image. 
    Image imgWoodland = new Image("woodland.png"); 
 
    // Create an image view that uses the image. 
    ImageView ivWoodland = new ImageView(imgWoodland); 
  
    // Add the image to the scene graph.  
    rootNode.getChildren().add(ivWoodland);  
 
    // Show the stage and its scene.  
    myStage.show();  
  }  
}
