// ComboBox Example. 
 
import javafx.application.*; 
import javafx.scene.*; 
import javafx.stage.*; 
import javafx.scene.layout.*; 
import javafx.scene.control.*; 
import javafx.geometry.*; 
import javafx.collections.*; 
import javafx.event.*; 
 
 
public class ComboBoxExample extends Application { 
 
  ComboBox<String> cbApple; 
  Label response; 
 
  public static void main(String[] args) { 
 
    // Start the JavaFX application by calling launch(). 
    launch(args);   
  } 
 
  // Override the start() method. 
  public void start(Stage myStage) { 
 
    // Give the stage a title. 
    myStage.setTitle("ComboBox Demo"); 
 
    // Use a FlowPane for the root node. In this case, 
    // vertical and horizontal gaps of 10. 
    FlowPane rootNode = new FlowPane(10, 10); 
 
    // Pad top of window. 
    rootNode.setPadding(new Insets(10, 0, 0, 0)); 
 
    // Center the control at top of the scene.  
    rootNode.setAlignment(Pos.TOP_CENTER);  
 
    // Create a scene. 
    Scene myScene = new Scene(rootNode, 240, 120); 
 
    // Set the scene on the stage. 
    myStage.setScene(myScene); 
 
    // Create a label. 
    response = new Label(); 
 
    // Create an ObservableList of entries for the combo box. 
    ObservableList<String> appleTypes = 
      FXCollections.observableArrayList("Winesap", "Cortland", "Gala", 
                                        "Golden Delicious", "Fuji", 
                                        "Jonathan");  
 
    // Create a combo box. 
    cbApple = new ComboBox<String>(appleTypes); 
 
    // Set the default value. 
    cbApple.setValue("Winesap"); 
 
    // Set the response label to indicate the default selection. 
    response.setText("Selected apple is " + cbApple.getValue()); 
 
    // Listen for action events on the combo box. 
    cbApple.setOnAction(new EventHandler<ActionEvent>() { 
      public void handle(ActionEvent ae) { 
        response.setText("Selected apple is " + cbApple.getValue()); 
      } 
    }); 
 
    // Add the label and combo box to the scene graph. 
    rootNode.getChildren().addAll(cbApple, response); 
 
    // Show the stage and its scene. 
    myStage.show(); 
  } 
}