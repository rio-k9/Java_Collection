// Use images with Radio Buttons.  
  
import javafx.beans.value.*; 
import javafx.application.*;  
import javafx.scene.*;  
import javafx.stage.*;  
import javafx.scene.layout.*;  
import javafx.scene.control.*;  
import javafx.event.*;  
import javafx.geometry.*;  
import javafx.scene.image.*; 
  
public class ImageRadioButtonExample extends Application {  
  
  Label response;  
  Label prompt;  
  
  RadioButton rbAnalog;  
  RadioButton rbHourglass;  
  RadioButton rbStopwatch;  
  
  ToggleGroup tg;  
  
  public static void main(String[] args) {  
  
    // Start the JavaFX application by calling launch().  
    launch(args);    
  }  
  
  // Override the start() method.  
  public void start(Stage myStage) {  
  
    // Give the stage a title.  
    myStage.setTitle("Use Images with Radio Buttons");  
  
    // Use a FlowPane for the root node. In this case,   
    // vertical gap of 10.   
    FlowPane rootNode = new FlowPane(Orientation.VERTICAL, 0, 10);   
  
    // Center the controls vertically, left-align them horizontally.   
    rootNode.setAlignment(Pos.CENTER_LEFT);   
   
    // Set a padding value of 10 on the left for the flow pane.   
    rootNode.setPadding(new Insets(0, 0, 0, 10));   
  
    // Create a scene.  
    Scene myScene = new Scene(rootNode, 220, 240);  
  
    // Set the scene on the stage.  
    myStage.setScene(myScene);  
  
    // Create the prompting label.  
    prompt = new Label("Select Timepiece");  
  
    // Create a label that will report the selection.  
    response = new Label("");  
  
    // Create the radio buttons.  
    rbAnalog = new RadioButton("Analog Clock");  
    rbHourglass = new RadioButton("Hourglass");  
    rbStopwatch = new RadioButton("Stopwatch");  
  
    // Add images to the buttons. 
    rbAnalog.setGraphic(new ImageView("analog.png")); 
    rbHourglass.setGraphic(new ImageView("hourglass.png")); 
    rbStopwatch.setGraphic(new ImageView("stopwatch.png")); 
 
    // Create a toggle group.  
    tg = new ToggleGroup();  
  
    // Add each radio button to a toggle group.  
    rbAnalog.setToggleGroup(tg);  
    rbHourglass.setToggleGroup(tg);  
    rbStopwatch.setToggleGroup(tg);  
  
    // Use a change listener to respond to a radio button selection.  
    tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {  
      public void changed(ObservableValue<? extends Toggle> changed,  
                          Toggle oldVal, Toggle newVal) {  
  
        // Cast newVal to RadioButton.  
        RadioButton rb = (RadioButton) newVal;   
  
        // Display the selected timepiece.  
        response.setText("You selected " + rb.getText());  
      }  
    });  
  
    // Select the first button.  
    rbAnalog.setSelected(true); 
 
    // Add controls to the scene graph.  
    rootNode.getChildren().addAll(prompt, rbAnalog, rbHourglass,  
                                  rbStopwatch, response);  
  
    // Show the stage and its scene.  
    myStage.show();  
  }  
}