package shapes;
import javafx.application.Application;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;

	public class Shapes1 extends Application {
	    public static void main(String[] args) {
	        launch(args);
	    }
	    public void start(Stage primaryStage) {
	        Group root = new Group();
	        Scene scene = new Scene(root, 400, 300);

	        // A blue circle
	        Ellipse circle1 = new Ellipse();
	        circle1.setCenterX(60);
	        circle1.setCenterY(80);
	        circle1.setRadiusX(40);
	        circle1.setRadiusY(40);
	        circle1.setFill(Color.BLUE);
	        root.getChildren().add(circle1);


	        Rectangle rect1 = new Rectangle();
	        rect1.setX(110);
	        rect1.setY(140);
	        rect1.setWidth(50);
	        rect1.setHeight(40);
	        rect1.setStroke(Color.DARKGRAY);
	        rect1.setFill(Color.GRAY);
	        root.getChildren().add(rect1);

	        Line line2 = new Line();
	        line2.setStartX(100);
	        line2.setStartY(240);
	        line2.setEndX(300);
	        line2.setEndY(240);
	        line2.setStroke(Color.BLUE);
	        root.getChildren().add(line2);

	        Text t = new Text(140, 135, "SCHOOL BUS");
	        t.setFont(Font.font("Helvetica", FontWeight.NORMAL, 
	        		FontPosture.REGULAR, 12));
	        t.setFill(Color.RED);
	        root.getChildren().add(t);

	        primaryStage.setScene(scene);
	        primaryStage.setTitle("Draw Ovals");
	        primaryStage.show();
	    }
}

