

package application;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.String;
import java.util.LinkedHashMap;

public class CSV {

    private static CSVReader reader;
    				//USING CSVReader.Jar appears to be the industry standard rather than using a BufferReader, but I have placed an example of how I would do that instead below
	public static void main(String[] args) throws IOException {

    			
    		 	reader = new CSVReader(new FileReader("C:\\Users\\Rio\\Desktop\\java CW files\\ANTO.csv")); //I NEED TO FEED THE NAME OF THE CSV FILE AS AN ARGUMENT ON BUTTON CLICK
    	        String line = "";
    	        String[] Stock = line.split(",");
    	        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
  
    	        System.out.println(Stock);  //THIS IS MY RESULT SET
    	        
    		 while ((Stock = reader.readNext()) != null) {
    			 
    			 //map.put("Stock ", " ANTO");
    			 
    			 map.put("Date ", " "+Stock[0]);
    			 map.put("Open ", " "+Stock[1]);
    			 map.put("High ", " "+Stock[2]);
    			 map.put("Low ", " "+Stock[3]);
    			 map.put("Close ", " "+Stock[4]);
    			 map.put("Volume ", " "+Stock[5]);
    			 map.put("Adj Close ", " "+Stock[6]);
    			 System.out.println(map);
    	    		
    			
    			 /* NEED HELP WITH OUTPUTTING THIS INTO A HASHMAP FOR EACH DAY 
    			  * ANTO_day1.put("Date ", " "+Stock[0]);
    			  * ANTO_day1.put("Open ", " "+Stock[1]);
    			  * etc
    			  * 
    			  * ANTO_day2.put("Date ", " "+Stock[0]);
    			  * ANTO_day2.put("Open ", " "+Stock[1]);
    			  * 
    			  */
    			
    			 		
    			 	
    		       
    		     }
    		 

    	}
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
        
        
        
}

