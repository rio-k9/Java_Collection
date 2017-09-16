/*
 * 
 * 
 * 
 *  OLD CLASS FOR TESTING CSV READER
 * 
 * 
 * 
 */





package application;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.String;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class CSVTest {

    private static CSVReader reader;
	public static void main(String args[]) throws IOException {

    			//will be changed to main(String company)     files\\" + company + ".csv
    		 	reader = new CSVReader(new FileReader("C:\\Users\\Rio\\Desktop\\java CW files\\ANTO.csv"));
    		 	String [] nextLine;
    		 	@SuppressWarnings("unchecked")
				LinkedHashMap<String, String>[] Days = new LinkedHashMap[65];
    		 	
    		 	
    		 	nextLine = reader.readNext();
    		 	List<String> Keys = new ArrayList<String>();
    		 	for (int x = 0; x <= 6; x++)
    		 	{
    		 		Keys.add(nextLine[x]);

    		 	}
    		 	int a = 0;
    		 	for (int i = 1; i <= Days.length; i++){
    		 		
    		 		nextLine = reader.readNext();
    		 		Days[a] = new LinkedHashMap<String, String>();
    		 		Days[a].put(Keys.get(0) + " ", " "+ nextLine[0]);
    		 		Days[a].put(Keys.get(1) + " ", " "+ nextLine[1]);
    		 		Days[a].put(Keys.get(2) + " ", " "+ nextLine[2]);
    		 		Days[a].put(Keys.get(3) + " ", " "+ nextLine[3]);
    		 		Days[a].put(Keys.get(4) + " ", " "+ nextLine[4]);
    		 		Days[a].put(Keys.get(5) + " ", " "+ nextLine[5]);
    		 		Days[a].put(Keys.get(6) + " ", " "+ nextLine[6]);
     		 		a++;
    		 	}
				


	}
}
    		 	
    		 	
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
        
        
        


