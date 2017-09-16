import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class ReverseLines {

	public static void main(String args[]) {
            try {
            	Scanner in = new Scanner(new File ("hello1.txt")); //File input to split
                StringBuffer writeToFile = new StringBuffer();
                BufferedWriter bwr = new BufferedWriter(new FileWriter(new File("output1.txt")));
                
                while (in.hasNextLine()) {
                    String Words = in.nextLine();
                    StringBuffer reversedLine = ( new StringBuffer(Words).reverse());
                    System.out.println("\nReversed line:\n" + Words + "\n" + reversedLine);
                    writeToFile.append(reversedLine + System.getProperty("line.separator"));                  	               
                }               
               
                bwr.write(writeToFile.toString());
                bwr.flush();
                bwr.close();	 
                in.close();
            } catch (FileNotFoundException fnf){
                System.out.println(fnf);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
}

