package Notes;

import java.io.File;
import java.util.Scanner;

public class readFile {

    public static void main(String[] args) {
        int counterChars = 0;
        int countWords =0;
        try {
            String asd = "Hello1.txt";
            File theFile = new File(asd);
            Scanner in = new Scanner(theFile);

            while (in.hasNextLine()) {
                String checkMe = in.nextLine();
                //or Character.isWhiteSpace(ch);
                
                for (int i = 0; i < checkMe.length(); i++) {
                    char ch = checkMe.charAt(i);

                    if (Character.isAlphabetic(ch)) {
                        counterChars += 1;
                    }
                    if (!Character.isDigit(ch) && !Character.isAlphabetic(ch)) {
                        countWords += 1;

                    } else if ((Character.isAlphabetic(ch)) && (i == checkMe.length() - 1)) {
                        countWords+=1;
                    }

                }
                System.out.println(checkMe);
                System.out.println("Letters so far: " + counterChars);
                System.out.println("Words so far: " + countWords + "\n");
 

            }
            in.close();
        }catch(Exception e){
            System.out.println("No file found.");
            

        }
        System.out.println("\nAmount of Words: " + countWords);
        System.out.println("Amount of Chars: " + counterChars);

    }
}

