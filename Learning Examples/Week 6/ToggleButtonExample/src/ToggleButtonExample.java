import javafx.application.*; 
import javafx.scene.*; 
import javafx.stage.*; 
import javafx.scene.layout.*; 
import javafx.scene.control.*; 
import javafx.event.*; 
import javafx.geometry.*; 
 
public class ToggleButtonExample extends Application { 
 
  ToggleButton tbToggle; 
  Label response; 
 
  public static void main(String[] args) { 
 
    // Start the JavaFX application by calling launch(). 
    launch(args);   
  } 
 
  // Override the start() method. 
  public void start(Stage myStage) { 
 
    // Give the stage a title. 
    myStage.setTitle("Toggle Button Example"); 
 
    // Use a FlowPane for the root node. In this case, 
    // vertical and horizontal gaps of 10. 
    FlowPane rootNode = new FlowPane(10, 10); 
 
    // Center the controls in the scene. 
    rootNode.setAlignment(Pos.CENTER); 
 
    // Create a scene. 
    Scene myScene = new Scene(rootNode, 200, 100); 
 
    // Set the scene on the stage. 
    myStage.setScene(myScene); 
 
    // Create a label. 
    response = new Label("Push the Button."); 
 
    // Create the toggle button. 
    tbToggle = new ToggleButton("Toggle"); 
 
    // Handle action events for the toggle button. 
    tbToggle.setOnAction(new EventHandler<ActionEvent>() { 
      public void handle(ActionEvent ae) { 
        if(tbToggle.isSelected()) response.setText("Button is down."); 
        else response.setText("Button is up."); 
      } 
    }); 
 
    // Add the label and buttons to the scene graph. 
    rootNode.getChildren().addAll(tbToggle, response); 
 
    // Show the stage and its scene. 
    myStage.show(); 
  } 
}