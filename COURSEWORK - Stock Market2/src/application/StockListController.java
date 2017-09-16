package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.LinkedHashMap;
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
import javafx.scene.layout.VBox;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import javafx.scene.control.ComboBox;

public class StockListController implements Initializable {
	@FXML
	private ComboBox<String> ComboBoxStock;
	@FXML
	private Label stockLabel;
	@FXML
	private Label labelTest;
	@FXML
	private Button parseTest;
	@FXML
	private TextField lateShare;
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
		
	
	
	@FXML
	public void comboChanged(ActionEvent event) throws Exception{
		String user = "";
		user = ComboBoxStock.getValue();
		System.out.println(user);
		
		LinkedHashMap<String, String>[] MyData = CSV.CSVParse(user);
		System.out.println(MyData);
		//System.out.println(MyData[0]);
		Set<String> keys = MyData[0].keySet();
		String[] KeyArray = keys.toArray(new String[keys.size()]);
		System.out.println(KeyArray);
		//System.out.println(MyData[0].get("Adj Close "));
		lateShare.setText(MyData[0].get("Adj Close "));
		//ObservableList<String> testList = FXCollections.observableArrayList(KeyArray);


		
	}
	


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

	

