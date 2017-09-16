import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Q_3B {


    public static void main (String[] args) throws FileNotFoundException {
        {
            int countLetters = 0;
            int countWords = 0;


            String basePath = new File("words.txt").getAbsolutePath();
            System.out.println(basePath);
            System.out.println(basePath);

            Scanner in = new Scanner(new File(basePath));

            while (in.hasNextLine()) {
                String Words = in.nextLine();

                String[] wordArray = Words.split(" ");

                for (int i = 0; i <= wordArray.length; i++) {
                    countWords += 1;
                }
                for (int i = 0; i < Words.length(); i++) {
                    if ((Words.charAt(i) > 'a' || Words.charAt(i) < 'z') || (Words.charAt(i) > 'A' || Words.charAt(i) < 'Z')) {
                        countLetters += 1;
                    }
                }


            }
            System.out.println("Words = " + countWords);
            System.out.println("Letters = " + countLetters);
        }

    }
}