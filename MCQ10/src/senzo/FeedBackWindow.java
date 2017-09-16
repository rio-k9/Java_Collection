import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.image.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;


public class FeedBackWindow extends Application {
  private ImageView imageview;
  private Font serif;
  private Text text2;
  private Text text3;
  private Button contButton;


  public static void main(String[] args) {
      launch(args);
  }

  
  /*
   * 
   * TO BE REVIEWED
   * 
   * 
   * 
   */
  public void GiveFeedBack(){
    HashMap<Integer, Integer> testAnswers = new HashMap<Integer, Integer>();
    //preloading questions and correct answers
    //these are the quiz questions and their correct answers
		testAnswers.put(1, 3);
		testAnswers.put(2, 2);
		testAnswers.put(3, 4);
		testAnswers.put(4, 1);
    testAnswers.put(5, 3);    
    testAnswers.put(6, 1);    
    testAnswers.put(7, 4);
    testAnswers.put(8, 3);
    testAnswers.put(9, 2);
    testAnswers.put(10, 1);
    
		// create new feedback object at beginning of each quiz attempt, feeding in
		//all questions and correct answers
		Feedback feedback = new Feedback(testAnswers);
		//for each question when the student answers do this
		feedback.newAnswer(1, 3); // student submits answer
    feedback.newAnswer(2, 3); // student submits answer
    feedback.newAnswer(3, 4); // student submits answer
    feedback.newAnswer(4, 4); // student submits answer


		// get immediate feedback for answer
		ArrayList<Object> thisFeedback = feedback.getFeedback(1, 3);
		boolean correct = (boolean) thisFeedback.get(0);
		Integer score = (Integer) thisFeedback.get(1);
		Integer answered = (Integer) thisFeedback.get(2);
    // get immediate feedback for answer
    ArrayList<Object> thisFeedback1 = feedback.getFeedback(2, 3);
    correct = (boolean) thisFeedback1.get(0);
    score = (Integer) thisFeedback1.get(1);
    answered = (Integer) thisFeedback1.get(2);
    // get immediate feedback for answer
    ArrayList<Object> thisFeedback2 = feedback.getFeedback(3, 4);
    correct = (boolean) thisFeedback2.get(0);
    score = (Integer) thisFeedback2.get(1);
    answered = (Integer) thisFeedback2.get(2);
    // get immediate feedback for answer
    ArrayList<Object> thisFeedback3 = feedback.getFeedback(4, 4);
    correct = (boolean) thisFeedback3.get(0);
    score = (Integer) thisFeedback3.get(1);
    answered = (Integer) thisFeedback3.get(2);

		//System.out.println(correct);
		System.out.println(score);
		System.out.println(answered);
    String img;
    String txt;

    if (correct == true){
      img = "src/img/congrats.gif";
      txt = "CONGRATULATIONS, YOU'VE GOT IT!!";
    } else {
      img = "src/img/sorry.jpg";
      txt = "OH NO!, WRONG ANSWER SORRY!";
    }
    Image image = new Image(img);

    imageview = new ImageView();
    imageview.setImage(image);
    imageview.setFitWidth(450);
    imageview.setPreserveRatio(true);
    imageview.setSmooth(true);
    imageview.setCache(true);

    text2 = new Text(txt);
    serif = Font.font("Serif", 30);
    text2.setFont(serif);
    text2.setFill(Color.ORANGE);

    text3 = new Text("Your Score is  " + score + "/" + answered);
    text3.setFont(serif);
    text3.setFill(Color.GREEN);

    contButton = new Button("CONTINUE");

  }

  // Override the start() method.
  public void start(Stage myStage) {
    myStage.setTitle("Feedback Window");
    BorderPane rootNode = new BorderPane( );
    Scene myScene = new Scene(rootNode, 800, 600);
    myStage.setScene(myScene);
    // Create controls and put them into the five BorderPane locations.

    // Center
    //header text
    Text text1 = new Text("FEED BACK");
    serif = Font.font("Serif", 30);
    text1.setFont(serif);
    text1.setFill(Color.BLUE);

    this.GiveFeedBack();
    VBox fbkBox = new VBox(10);
    fbkBox.getChildren().addAll(text1, imageview, text2, text3, contButton);
    fbkBox.setAlignment(Pos.TOP_CENTER);
    rootNode.setCenter(fbkBox);
    BorderPane.setAlignment(fbkBox, Pos.TOP_CENTER);
    BorderPane.setMargin(fbkBox, new Insets(10, 10, 10, 10));

    // Show the stage and its scene.
    myStage.show();
 }
}
