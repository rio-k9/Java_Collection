package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import javafx.scene.control.ComboBox;

public class StockListController implements Initializable {
	@FXML
	private ComboBox<String> ComboBoxStock;
	@FXML
	private TextField stockLabel;
	@FXML
	private TextField lateShare;
	@FXML
	private Label labelTest;
	@FXML
	private Button parseTest;

	@FXML
	private TableView<Stocks> StockTable;
	//Counter for when table is generated
	private int tableCounter = 0;

	

	// Event Listener on Button[#parseTest].onAction
	/*
	@FXML
	public void csvTest() throws Exception{
		
		
		String user = "ANTO";
		LinkedHashMap<String, String>[] MyData = CSV.CSVParse(user);
		System.out.println(MyData);
		System.out.println(MyData[0]);
		Set<String> keys = MyData[0].keySet();
		String[] KeyArray = keys.toArray(new String[keys.size()]);
		System.out.println(KeyArray);
		System.out.println(KeyArray[0]);

		
		
	}*/
	
	
	ObservableList<String> stockList = FXCollections.observableArrayList("AHT", "ANTO", "BA", "BATS", "CCH", "CCL", "CNA", "CPG",
			"EXPN", "EZJ", "GKN", "MDC", "PFG", "PPB", "PRU", "PSN", "RB", "RDSA", "RR", "SDR", "SHP", "SKY", "SSE", "STJ", "TSCO", "TUI", "VOD", "WPG");
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ComboBoxStock.setItems(stockList);
		
		
		
	}
	
	public void helpApp(ActionEvent event) {
		String loginButton[] = {"Ok"};		
		int loginConfirm = JOptionPane.showOptionDialog(null,"			See Report.PDF", "Help", JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE,null,loginButton, null);
    	//if OK is pressed
    	if (loginConfirm == JOptionPane.OK_OPTION){
	}
	}
	public void exitApp(ActionEvent event) {
		System.exit(0);
	}
	
	public void mainMenu(ActionEvent event) throws IOException{
		Stage mainStage = new Stage();
		//Accessing FXML
		Parent root = FXMLLoader.load(getClass().getResource("/application/Main.fxml"));
		Scene scene = new Scene(root,600,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		//SETTING WINDOW AND SCENE
		mainStage.setScene(scene);
		mainStage.show();
		//Accessing Node tree structure
		//Close current window
		((Node)(event.getSource())).getScene().getWindow().hide();
		//Calling audio stream

		}
	public void reportButton(ActionEvent event) throws Exception{
		//if table counter is 2 or more
		String userID = System.getProperty("user.name");
		String loginButton[] = {"Ok"};		
		//Showing option dialog, option dialog allows button to be changed
        	int loginConfirm = JOptionPane.showOptionDialog(null,"Report saved to application folder in root folder for " + userID + ".",
        			"Saving report...",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE,null,loginButton, null);
        	//if OK is pressed
        	if (loginConfirm == JOptionPane.OK_OPTION){
					//clear observable list before running action script

				//get combobox value
				String user = ComboBoxStock.getValue();
				
				/*
				 * Could also do this with loop and string array used for ValuePropertyFactor
				 * But ORACLE website preferred this way
				 * 
				 */

				BufferedWriter bwr = new BufferedWriter(new FileWriter(new File("demo.txt")));
				List<String> stock_list = ComboBoxStock.getItems();
				String[] nameArray =stock_list.toArray(new String[stock_list.size()]);
				for (int x = 0; x <= nameArray.length; x++){
				
				
				System.out.println(nameArray[x]);	
				//get array of linkedhashmaps
				LinkedHashMap<String, String>[] MyData = CSV.CSVParse(nameArray[x]);
				System.out.println(MyData);	
				//System.out.println(MyData[0]);	
				//getting keys as String Set
				Set<String> keys = MyData[0].keySet();
				//changing to array with length of set as size
				String[] KeyArray = keys.toArray(new String[keys.size()]);
				System.out.println(KeyArray);
				StringBuilder tryme = new StringBuilder();
				tryme.append(System.getProperty("line.separator"));
				tryme.append("    (  ____ \\\\__   __/(  ___  )(  ____ \\| \\    /\\  (  ___  )(  ____ )(  ____ )");
				tryme.append(System.getProperty("line.separator"));
				tryme.append("    | (    \\/   ) (   | (   ) || (    \\/|  \\  / /  | (   ) || (    )|| (    )|");
				tryme.append(System.getProperty("line.separator"));
				tryme.append("    | (_____    | |   | |   | || |      |  (_/ /   | (___) || (____)|| (____)|");
				tryme.append(System.getProperty("line.separator"));
				tryme.append("    (_____  )   | |   | |   | || |      |   _ (    |  ___  ||  _____)|  _____)");
				tryme.append(System.getProperty("line.separator"));
				tryme.append("          ) |   | |   | |   | || |      |  ( \\ \\   | (   ) || (      | (   ");  
				tryme.append(System.getProperty("line.separator"));
				tryme.append("    /\\____) |   | |   | (___) || (____/\\|  /  \\ \\  | )   ( || )      | )   ");  
				tryme.append(System.getProperty("line.separator"));
				tryme.append("    \\_______)   )_(   (_______)(_______/|_/    \\/  |/     \\||/       |/    ");   
				tryme.append(System.getProperty("line.separator"));
				tryme.append(System.getProperty("line.separator"));
				tryme.append(System.getProperty("line.separator"));
				tryme.append("Sequence: ");
				tryme.append((x+1));
				//for loop with MyData.length as break
				int Days = MyData.length;
				//loop assigns value of each key in each hashmap into strings
				int average = 0;
				
				for (int i = 0; i <= (Days-1); i++){
					String v7 = MyData[i].get(KeyArray[6]);	
					average += Float.parseFloat(v7);
				}
				
				int newaverage = average / Days;
				tryme.append(System.getProperty("line.separator"));
				tryme.append(System.getProperty("line.separator"));
				tryme.append("Company Name / Symbol :  ");
				tryme.append(nameArray[x]);
				tryme.append(System.getProperty("line.separator"));
				tryme.append(System.getProperty("line.separator"));
				tryme.append("Company Average");
				tryme.append(" : ");
				tryme.append(newaverage);
				tryme.append(System.getProperty("line.separator"));
				tryme.append("Latest Share :  ");
				tryme.append(MyData[0].get(KeyArray[6]));
				tryme.append(System.getProperty("line.separator"));
				tryme.append(System.getProperty("line.separator"));
				
				for (int i = 0; i <= (Days-1); i++){

					String v1 = MyData[i].get(KeyArray[0]);
					String v2 = MyData[i].get(KeyArray[1]);
					String v3 = MyData[i].get(KeyArray[2]);
					String v4 = MyData[i].get(KeyArray[3]);
					String v5 = MyData[i].get(KeyArray[4]);
					String v6 = MyData[i].get(KeyArray[5]);
					String v7 = MyData[i].get(KeyArray[6]);	
					//setting all observable lists created when length is reached

					tryme.append(KeyArray[0]);
					tryme.append(" : ");
					tryme.append(v1);
					tryme.append(System.getProperty("line.separator"));
					

					tryme.append(KeyArray[1]);
					tryme.append(" : ");
					tryme.append(v2);
					tryme.append(System.getProperty("line.separator"));

					tryme.append(KeyArray[2]);
					tryme.append(" : ");
					tryme.append(v3);
					tryme.append(System.getProperty("line.separator"));
					tryme.append(KeyArray[3]);
					tryme.append(" : ");
					tryme.append(v4);
					tryme.append(System.getProperty("line.separator"));

					tryme.append(KeyArray[4]);
					tryme.append(" : ");
					tryme.append(v5);
					tryme.append(System.getProperty("line.separator"));

					tryme.append(KeyArray[5]);
					tryme.append(" : ");
					tryme.append(v6);
					tryme.append(System.getProperty("line.separator"));

					tryme.append(KeyArray[6]);
					tryme.append(" : ");
					tryme.append(v7);
					tryme.append(System.getProperty("line.separator"));
					tryme.append(System.getProperty("line.separator"));
					tryme.append(System.getProperty("line.separator"));

					if (i <= Days-2){
					System.out.println("building...");
		            bwr.write(tryme.toString());
		            tryme = new StringBuilder();
					}				
				}
				if (x == (nameArray.length)-1){
				 //write contents of StringBuffer to a file        
               //flush the stream
               bwr.flush();              
               //close the stream
               bwr.close();             
               System.out.println("Content of StringBuffer written to File.");
			}					
		}
       }		//otherwise send to observable list method, which then uses getter and setter						
	}	

	@FXML
	public void graphButton(ActionEvent event) throws Exception, RuntimeException{
		//Getting combobox selection string
		String user = ComboBoxStock.getValue();
		System.out.println(user);
		//Retrieving array of linked hashmaps from CSV class, and calling CSVParse with selected combobox as argument
		LinkedHashMap<String, String>[] MyData = CSV.CSVParse(user);
		//Creating new list for only open stock information per day
		List<Float> Open = new ArrayList<Float>();
		//Creating access
		NumberAxis xAxis = new NumberAxis();
		NumberAxis yAxis = new NumberAxis();	
		//Setting display XAxis as day
		xAxis.setLabel("Day");
		/*
		 * Creating a new linechart, with Number, Number per axis. 
		 * Creates compilation error if attempt to change to Integer, Integer
		 */
		LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis);
		//Set title of linechart
		lineChart.setTitle(user);
		//Creating series variable, which creates a new X by Y series when called
		Series<Number, Number>series = new XYChart.Series<Number, Number>();	
		//Setting name of data set
	    series.setName("Open");
		//Allows linechart to autosize
		lineChart.getXAxis().setAutoRanging(true);
	    lineChart.getYAxis().setAutoRanging(true);
	}
	
	@FXML
	public void testbutton(ActionEvent event) throws Exception{
		//if table counter is 2 or more
				if (tableCounter >= 2){
					//clear observable list before running action script
				stocks.removeAll(stocks);
				}
				//get combobox value
				String user = ComboBoxStock.getValue();
				System.out.println(user);	
				//get array of linkedhashmaps
				LinkedHashMap<String, String>[] MyData = CSV.CSVParse(user);
				System.out.println(MyData);	
				//System.out.println(MyData[0]);	
				//getting keys as String Set
				Set<String> keys = MyData[0].keySet();
				//changing to array with length of set as size
				String[] KeyArray = keys.toArray(new String[keys.size()]);
				System.out.println(KeyArray);
				/*
				 * Could also do this with loop and string array used for ValuePropertyFactor
				 * But ORACLE website preferred this way
				 * 
				 */
				TableColumn<Stocks, String> dateColumn = new TableColumn<>(KeyArray[0]);
				dateColumn.setMinWidth(100);
				dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
				TableColumn<Stocks, String> openColumn = new TableColumn<>(KeyArray[1]);
				openColumn.setMinWidth(100);
				openColumn.setCellValueFactory(new PropertyValueFactory<>("open"));
				TableColumn<Stocks, String> highColumn = new TableColumn<>(KeyArray[2]);
				highColumn.setMinWidth(100);
				highColumn.setCellValueFactory(new PropertyValueFactory<>("high"));
				TableColumn<Stocks, String> lowColumn = new TableColumn<>(KeyArray[3]);
				lowColumn.setMinWidth(100);
				lowColumn.setCellValueFactory(new PropertyValueFactory<>("low"));		
				TableColumn<Stocks, String> closeColumn = new TableColumn<>(KeyArray[4]);
				closeColumn.setMinWidth(100);
				closeColumn.setCellValueFactory(new PropertyValueFactory<>("close"));	
				TableColumn<Stocks, String> volumeColumn = new TableColumn<>(KeyArray[5]);
				volumeColumn.setMinWidth(100);
				volumeColumn.setCellValueFactory(new PropertyValueFactory<>("volume"));	
				TableColumn<Stocks, String> adjcloseColumn = new TableColumn<>(KeyArray[6]);
				adjcloseColumn.setMinWidth(100);
				adjcloseColumn.setCellValueFactory(new PropertyValueFactory<>("adjclose"));
				
				//Setting keys as columns
				StockTable.getColumns().add(dateColumn);
				StockTable.getColumns().add(openColumn);
				StockTable.getColumns().add(highColumn);
				StockTable.getColumns().add(lowColumn);
				StockTable.getColumns().add(closeColumn);
				StockTable.getColumns().add(volumeColumn);
				StockTable.getColumns().add(adjcloseColumn);
				//for loop with MyData.length as break
				int Days = MyData.length;
				//loop assigns value of each key in each hashmap into strings
				for (int i = 0; i <= Days; i++){
					String v1 = MyData[i].get(KeyArray[0]);
					String v2 = MyData[i].get(KeyArray[1]);
					String v3 = MyData[i].get(KeyArray[2]);
					String v4 = MyData[i].get(KeyArray[3]);
					String v5 = MyData[i].get(KeyArray[4]);
					String v6 = MyData[i].get(KeyArray[5]);
					String v7 = MyData[i].get(KeyArray[6]);		
					//setting all observable lists created when length is reached
					if (i<=Days){
					StockTable.setItems(getStocks(v1, v2, v3, v4, v5, v6, v7));
					}
					//otherwise send to observable list method, which then uses getter and setter
					else {
						getStocks(v1, v2, v3, v4, v5, v6, v7);
					}
				}

			}
		
	
	/*
	 * Combo Box button
	 */
	@FXML
	public void comboChanged(ActionEvent event) throws Exception{


		String user = "";
		user = ComboBoxStock.getValue();
		stockLabel.setText(ComboBoxStock.getValue());
		System.out.println(user);
		LinkedHashMap<String, String>[] MyData = CSV.CSVParse(user);
		System.out.println(MyData);
		//System.out.println(MyData[0]);
		Set<String> keys = MyData[0].keySet();
		lateShare.setText(MyData[0].get("Adj Close "));
		String[] KeyArray = keys.toArray(new String[keys.size()]);
		System.out.println(KeyArray);
		//System.out.println(MyData[0].get("Adj Close "));
		//ObservableList<String> testList = FXCollections.observableArrayList(KeyArray);


		
	}
	

	/*
	 * accessing getter and setter
	 * 
	 */

	ObservableList<Stocks> stocks = FXCollections.observableArrayList();
	//Get table data
	public ObservableList<Stocks> getStocks(String date, String open, String high, String low,
			String close, String volume, String adjclose) {
		//retrieving getter and setter data and adding as observable list
		//and adding to list
		stocks.add(new Stocks(date, open, high, low, close, volume, adjclose));
		System.out.println(stocks);
		//use of table counter goes up
		tableCounter++;
		return stocks;
	}	
}

	

