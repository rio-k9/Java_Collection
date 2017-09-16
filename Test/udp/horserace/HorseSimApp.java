package horserace;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.*;

public class HorseSimApp extends Application {
	@Override
	public void start(Stage primaryStage) 
	{
		Group root = new Group();
		Scene scene = new Scene(root);
		
		GridPane gridpane = new GridPane();
		gridpane.setPadding(new Insets(5));
		gridpane.setHgap(5);
		gridpane.setVgap(5);
		ColumnConstraints column1 = new ColumnConstraints(100); 
		ColumnConstraints column2 = new ColumnConstraints(50, 150, 300); 
		column2.setHgrow(Priority.ALWAYS); 
		gridpane.getColumnConstraints().addAll(column1, column2);
		horsePos = new Label[HORSE_NUM];
		horseThreads = new HorseThread[HORSE_NUM];
		for (int i = 0; i < HORSE_NUM; i++)
		{
			Label lbl = new Label("Horse " + i + ": ");
			gridpane.add(lbl, 0, i);
			horseThreads[i] = new HorseThread(i);
			horsePos[i] = new Label();
			gridpane.add(horsePos[i], 1, i);
			horsePos[i].textProperty().bind(horseThreads[i].messageProperty());
			
			finishMessage = new TextArea();
			finishMessage.setPrefRowCount(10);
			gridpane.add(finishMessage, 0, HORSE_NUM, 2, 1);
			
			horseThreads[i].setOnSucceeded((event)->{
				HorseThread worker = (HorseThread)(event.getSource()); 
				finishMessage.appendText("Horse " + worker.getID() + " finished at time " + worker.getValue() + "\n");
				if (worker.getValue() < winner_time)
				{
					winner_time = worker.getValue();
					winner.setText("Winner: Horse " + worker.getID());
				}
			  }
			);
			
			winner = new Label("");
			gridpane.add(winner, 0, HORSE_NUM+1, 2, 1);
		}
		
		for (int i = 0; i < HORSE_NUM; i++)
			new Thread(horseThreads[i]).start();
		
		root.getChildren().add(gridpane);
		
		primaryStage.setTitle("Horse Race Simulator");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String [] args)
	{
		launch(args);
	}
	
	final int HORSE_NUM = 10;
	private Label horsePos[];
	private HorseThread horseThreads[];
	private Label winner;
	private TextArea finishMessage;
	private int winner_time = 100000;
}
