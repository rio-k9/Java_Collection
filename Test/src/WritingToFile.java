import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WritingToFile {

		   public static void main(String args[])throws IOException {
			   
			  //For Specified Folder
			  //String basePath = new File("src").getAbsolutePath();
		      //File file = new File(basePath + "/" + "Hello1.txt");
			   File file = new File("Hello1.txt");
		      // creates the file
		      file.createNewFile();
		      // creates a FileWriter Object
		      FileWriter writer = new FileWriter(file); 		      
		      // Writes the content to the file
		      writer.write("This\n is\n an\n example"); 
		      writer.flush();
		      writer.close();
		      
		      // Creates a FileReader Object
		      Scanner fr = new Scanner(file); 
		        // reads the content to the array
		      
		      while(fr.hasNextLine()) {
		    	 String newLine = fr.nextLine();
		         System.out.println(newLine);
		      }// prints the characters one by one
		      fr.close();
		   }
		

	}


