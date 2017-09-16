import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * MenusSimpleExample simulates an security alarm application. This
 * demonstrates various menu and menu item selections.
 * 
 * @author cdea
 */
public class MenusSimpleExample extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Menus Example");
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 300, 250, Color.WHITE);

       
        MenuBar menuBar = new MenuBar();
		Menu fileMenu = new Menu("File");
		fileMenu.getItems().add(new MenuItem("Save"));
		menuBar.getMenus().add(fileMenu);
        
        
		root.setTop(menuBar); 
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
