import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class Main extends Application {
	public static void main(String[] args) {
	launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Login");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		/*
		
		THIS CODE IS WITHOUT USING SCENE BUILDER, KEEP FOR LAMDBA SYNTAX
		Button buttonLogin = new Button("Login");
		buttonLogin.setOnAction(e -> {
			System.out.println("Login Button Clicked");
		});
		
		Button exitButton = new Button("Exit");
		exitButton.setOnAction(e -> {
			System.out.println("Exit Button Clicked");
			System.exit(0);
		});
		VBox root = new VBox();
		root.getChildren().addAll(buttonLogin, exitButton);
		*/
		
		
		
		
	/*	buttonLogin.setOnAction(new EventHandler<ActionEvent>(){  
	 * 		
	 * 		//OLD WAY OF DOING IT
			//USE LAMBDA EXPRESSION INSTEAD

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Button Click Logged");
			
			}
		}); */
		
		

		
	}

}
