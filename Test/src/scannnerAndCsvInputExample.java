import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class scannnerAndCsvInputExample {
	

	public static void main(String args[]) {
        //String fileName = "filename";
        // reading the contect of the csv file
            //String basePath = new File("FolderInRoot").getAbsolutePath(); //create new file with info below
            try {
                Scanner in = new Scanner(new File ("hello1.txt")); //File input to split
                in.nextLine(); //skip header
                StringBuffer writeToFile = new StringBuffer();
                while (in.hasNextLine()) {
                    String Words = in.nextLine();
                    String[] WordArray = Words.split(" ");
                    
                    for (int i = 0; i < WordArray.length; i++){
	                    StringBuffer reversedLine = ( new StringBuffer(WordArray[i]).reverse());
	                    System.out.println(reversedLine);
	                    writeToFile.append(reversedLine + System.getProperty("line.separator"));
//	                    writeToFile.append("\n");
                    }
	                BufferedWriter bwr = new BufferedWriter(new FileWriter(new File("output1.txt")));
	                bwr.write(writeToFile.toString());
	                bwr.flush();
	                bwr.close();	                
                }

                in.close();
            } catch (FileNotFoundException fnf){
                System.out.println(fnf);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
}