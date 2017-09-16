/*START HERE
 * 
 * Class #1. CREATE CSV CLASS
 */

package application;
//declaring package name
//importing required libraries
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.String;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

//"public" - public across all classes, "class" declaring as class
public class CSV {
	//"private access" to CSV variable across classes, "static" making variable available across this class
    private static CSVReader reader; //Initiating reader variable
    /* 1, allowing return of any "LinkedHashMap" created within method
     * 2, naming method and declaring the String variable 'company' as an argument
     * 3, catching any 'IOException' errors that throw during the CSVParse script
     */
	public static LinkedHashMap<String, String>[] CSVParse(String company) throws IOException {
    	//assigning reader variable to the CSVReader class
		//by using the company variable in between the file path, allows all companies to be accessed by one 'reader' variable
    	reader = new CSVReader(new FileReader("C:\\Users\\Rio\\Desktop\\java CW files\\" + company + ".csv"));
    	//creating string array for every line, comma split built into CSVReader class
    	String [] nextLine;    		 	
    	//Suppressing Warning which sometimes calls when building array of multiple LinkedHashMap
    	@SuppressWarnings("unchecked")
		LinkedHashMap<String, String>[] Days = new LinkedHashMap[65];    		 	
    	//creating variable that reads a line in the CSV contained in 'reader' variable
    	nextLine = reader.readNext();    		 	
    	//creating list from first CSV line containing keys
    	List<String> Keys = new ArrayList<String>();    		 	
    	//for loop to add 7 keys to list
    	for (int x = 0; x <= 6; x++){
    		 Keys.add(nextLine[x]);
    		 }    		 	
    	//for loop to place every index for every key, and place in current hashmap per loop
    	int a = 0;
    	for (int i = 1; i <= Days.length; i++){  		
    		nextLine = reader.readNext();
    		Days[a] = new LinkedHashMap<String, String>();
    		Days[a].put(Keys.get(0), nextLine[0]);
    		Days[a].put(Keys.get(1), nextLine[1]);
    		Days[a].put(Keys.get(2), nextLine[2]);
    		Days[a].put(Keys.get(3), nextLine[3]);
    		Days[a].put(Keys.get(4), nextLine[4]);
    		Days[a].put(Keys.get(5), nextLine[5]);
    		Days[a].put(Keys.get(6), nextLine[6]);
     		a++;
    		}
		return Days; //making array of hashmaps accessible to other classes
	}
}	
	
	/*
	public static void genReport() throws IOException{
	
	
	HASHMAP
	("AHT", "ANTO", "BA", "BATS", "CCH", "CCL", "CNA", "CPG",
			"EXPN", "EZJ", "GKN", "MDC", "PFG", "PPB", "PRU", "PSN", "RB", "RDSA", "RR", "SDR", "SHP", "SKY", "SSE", "STJ", "TSCO", "TUI", "VOD", "WPG");

	VALUE HAS COMPANY NAME
	
	//loop to read hashmap and csv's
	
		
	//get array of linkedhashmaps
		
	String user = "ANTO";
	System.out.println(user);
	
	//for (int i = 0; i <= 28; i++){
	
	LinkedHashMap<String, String>[] MyData = CSVParse(user);//CSVParse(i)
	System.out.println(MyData);	
	
	//System.out.println(MyData[0]);	
	//getting keys as String Set
	Set<String> keys = MyData[0].keySet();
	//changing to array with length of set as size
	String[] KeyArray = keys.toArray(new String[keys.size()]);
	System.out.println(KeyArray);
	
	int Days = MyData.length;
	//loop assigns value of each key in each hashmap into strings
	for (int x = 0; x <= Days; x++){
		String v1 = MyData[x].get(KeyArray[0]);
		String v2 = MyData[x].get(KeyArray[1]);
		String v3 = MyData[x].get(KeyArray[2]);
		String v4 = MyData[x].get(KeyArray[3]);
		String v5 = MyData[x].get(KeyArray[4]);
		String v6 = MyData[x].get(KeyArray[5]);
		String v7 = MyData[x].get(KeyArray[6]);	
		System.out.println(v1 + ", " + v2 + ", " + v3 + ", " + v4 + ", " + v5);
		//stringbuffer
	}
	//System.out stringbuffer
	
	//return stringbuffer
	//or direct save?
	
	
	}
*/

	/*
	 * 
	 * Method
	 * Built incase i wanted a seperate method for accessing only Open, Close and Avg lists
	 * 
	 */
	
	/*
	
	public static List<Float> CSVOpenStock(String company) throws IOException {
		
		//will be changed to main(String company)     files\\" + company + ".csv
	 	reader = new CSVReader(new FileReader("C:\\Users\\Rio\\Desktop\\java CW files\\" + company + ".csv"));
	 	String[] nextLine;
	 	List<Float> Open = new ArrayList<Float>();
	 	nextLine = reader.readNext();

	 	for (int i = 1; i <= 65; i++){
	 		
	 		nextLine = reader.readNext();
	 		
	 		
	 		/*
	 		 * 
	 		 * Method if i wanted to trim float by removing '.00' via string

	 		 */
	 		
	 		/*
	 		if(nextLine[i].contains("."))
	 		{
	 			String	newStr = nextLine[i].substring(0, nextLine[i].length()-3);
	 			int testv = Integer.parseInt(newStr);
	 			Open.add(testv);
	 		}
	 		else {
	 			
	 			Open.add(Integer.parseInt(nextLine[i]));
	 			
	 		}
	 		
	 		Open.add(Float.parseFloat(nextLine[i]));
	 	
		return Open;
		*/

/**
 * 
 * OLD NOTES FROM TESTS
 * 
 */
    		 	
    		 	/*
    	        LinkedHashMap<String, String> Day1 = new LinkedHashMap<String, String>();
    	        LinkedHashMap<String, String> Day2 = new LinkedHashMap<String, String>();
    	        
    	       nextLine = reader.readNext();
    	       nextLine = reader.readNext();
    			 
				Day1.put("Date ", " "+ nextLine[0]);
				Day1.put("Open ", " "+ nextLine[1]);
				Day1.put("High ", " "+ nextLine[2]);
				Day1.put("Low ", " "+ nextLine[3]);
				Day1.put("Close ", " "+ nextLine[4]);
				Day1.put("Volume ", " "+ nextLine[5]);
				Day1.put("Adj Close ", " "+ nextLine[6]);
    			 System.out.println(Day1);
    			 
    			 nextLine = reader.readNext();
    			 
    			 Day2.put("Date ", " "+ nextLine[0]);
 				Day2.put("Open ", " "+ nextLine[1]);
 				Day2.put("High ", " "+ nextLine[2]);
 				Day2.put("Low ", " "+ nextLine[3]);
 				Day2.put("Close ", " "+ nextLine[4]);
 				Day2.put("Volume ", " "+ nextLine[5]);
 				Day2.put("Adj Close ", " "+ nextLine[6]);
     			 System.out.println(Day1);
    	    		
     			 */
     			 
    			
    			 /* NEED HELP WITH OUTPUTTING THIS INTO A HASHMAP FOR EACH DAY 
    			  * ANTO_day1.put("Date ", " "+Stock[0]);
    			  * ANTO_day1.put("Open ", " "+Stock[1]);
    			  * etc
    			  * 
    			  * ANTO_day2.put("Date ", " "+Stock[0]);
    			  * ANTO_day2.put("Open ", " "+Stock[1]);
    			  * 
    			  */
  
    	/*
    	String csvFile = "C:\\Users\\Rio\\Desktop\\java CW files\\ANTO.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
        	

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] Stock = line.split(cvsSplitBy);
                
                System.out.println(line);
                //System.out.println("ANTO [Date: " + Stock[0] + " , Open: " + Stock[1] + " , High: " + Stock[2] + " , Low: " + Stock[3] + " , Close: " + Stock[4] + " , Volume: " + Stock[5] + " , Adj Close: " + Stock[6] + "]");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        */
