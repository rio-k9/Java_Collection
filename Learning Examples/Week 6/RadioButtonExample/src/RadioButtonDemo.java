// A simple demonstration of Radio Buttons. 
// 
// This program responds to the action events generated 
// by a radio button selection. It also uses fire() to set 
// the initial selection. 
 
import javafx.application.*; 
import javafx.scene.*; 
import javafx.stage.*; 
import javafx.scene.layout.*; 
import javafx.scene.control.*; 
import javafx.event.*; 
import javafx.geometry.*; 
 
public class RadioButtonDemo extends Application { 
 
  Label response; 
  Label prompt; 
 
  RadioButton rbKeyboard; 
  RadioButton rbMouse; 
  RadioButton rbTouchScreen; 
 
  ToggleGroup tg; 
 
  public static void main(String[] args) { 
 
    // Start the JavaFX application by calling launch(). 
    launch(args);   
  } 
 
  // Override the start() method. 
  @Override
public void start(Stage myStage) { 
 
    // Give the stage a title. 
    myStage.setTitle("RadioButton Example"); 
 
    // Use a FlowPane for the root node. In this case,  
    // vertical gap of 10.  
    FlowPane rootNode = new FlowPane(Orientation.VERTICAL, 0, 10);  
 
    // Center the controls vertically, left-align them horizontally.  
    rootNode.setAlignment(Pos.CENTER_LEFT);  
  
    // Set a padding value of 10 on the left for the flow pane.  
    rootNode.setPadding(new Insets(0, 0, 0, 10));  
 
    // Create a scene. 
    Scene myScene = new Scene(rootNode, 220, 140); 
 
    // Set the scene on the stage. 
    myStage.setScene(myScene); 
 
    // Create the prompting label. 
    prompt = new Label("Select Primary Input Device"); 
 
    // Create a label that will report the selection. 
    response = new Label(""); 
 
    // Create the radio buttons. 
    rbKeyboard = new RadioButton("Keyboard"); 
    rbMouse = new RadioButton("Mouse"); 
    rbTouchScreen = new RadioButton("Touch Screen"); 
 
    // Create a toggle group. 
    tg = new ToggleGroup(); 
 
    // Add each button to a toggle group. 
    rbKeyboard.setToggleGroup(tg); 
    rbMouse.setToggleGroup(tg); 
    rbTouchScreen.setToggleGroup(tg); 
 
    // Handle action events for the radio buttons. 
    rbKeyboard.setOnAction(new EventHandler<ActionEvent>() { 
      @Override
	public void handle(ActionEvent ae) { 
        response.setText("Primary input device is keyboard."); 
      } 
    }); 
 
    rbMouse.setOnAction(new EventHandler<ActionEvent>() { 
      @Override
	public void handle(ActionEvent ae) { 
        response.setText("Primary input device is mouse."); 
      } 
    }); 
 
    rbTouchScreen.setOnAction(new EventHandler<ActionEvent>() { 
      @Override
	public void handle(ActionEvent ae) { 
        response.setText("Primary input device is touch screen."); 
      } 
    }); 
 
    // Fire the event for the first selection. This causes 
    // that radio button to be selected and an action event 
    // for that button to occur. 
    rbKeyboard.fire(); 
 
    // Add the label and buttons to the scene graph. 
    rootNode.getChildren().addAll(prompt, rbKeyboard, rbMouse, 
                                  rbTouchScreen, response); 
 
    // Show the stage and its scene. 
    myStage.show(); 
  } 
}