/* 
 * CLASS #5
 * 
 * Seperate scenebuilder controller for Stock page
 * Reason: initialisation variables don't exist in Main controller for when others are calle
 * 
 */
package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.ComboBox;


//Class implements Initializable, available since Java 2.0
public class StockListController implements Initializable {
	
	//Combo dropdown box for stock information
	@FXML
	private ComboBox<String> ComboBoxStock;
	//Label
	@FXML
	private Label stockLabel;
	//Label
	@FXML
	private Label labelTest;
	//Generate date buttons
	@FXML
	private Button parseTest;
	@FXML
	private Button parseTest2;
	
	//latest share label
	@FXML
	private TextField lateShare;
	//Stock TableView
	@FXML
	private TableView<Stocks> StockTable;	
	//Counter for when table is generated
	private int tableCounter = 0;
	
	//Observable list for drop box to use
	ObservableList<String> stockList = FXCollections.observableArrayList("AHT", "ANTO", "BA", "BATS", "CCH", "CCL", "CNA", "CPG",
			"EXPN", "EZJ", "GKN", "MDC", "PFG", "PPB", "PRU", "PSN", "RB", "RDSA", "RR", "SDR", "SHP", "SKY", "SSE", "STJ", "TSCO", "TUI", "VOD", "WPG");
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		//Set combo box on initialisation
		ComboBoxStock.setItems(stockList);	
	}	
	/*
	 * 
	 *Issues with generate graph button, see below 
	 *
	 */
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
	
	//Button to generate data table
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
	
	
	//Code for combo box selection
	//Could set as auto selection so data displays, but wanted to display text being set first
	@FXML
	public void comboChanged(ActionEvent event) throws Exception{
		String user = "";
		//getting selection value
		user = ComboBoxStock.getValue();
		System.out.println(user);
		//passes through to CSV class as argument, which then dictates filepath
		//which then returns required array of hashmaps
		LinkedHashMap<String, String>[] MyData = CSV.CSVParse(user);
		System.out.println(MyData);
		//System.out.println(MyData[0]);
		//calling keyset into Set of Strings
		Set<String> keys = MyData[0].keySet();
		//changing set into array and size of array
		String[] KeyArray = keys.toArray(new String[keys.size()]);
		System.out.println(KeyArray);
		
		//Setting latest share box as the latest date hashmap
		lateShare.setText(MyData[0].get("Adj Close"));
		//ObservableList<String> testList = FXCollections.observableArrayList(KeyArray);		
	}
	
	//observable list variable, which is particular to JavaFX objects
	ObservableList<Stocks> stocks = FXCollections.observableArrayList();
	
	/*
	 * 	//Sending table data to getter and setter when method is called, as arguments, 
		//and making any observable list to be viewable via return
	 * 
	 */

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
