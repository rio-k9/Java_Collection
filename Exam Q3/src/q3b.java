import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class q3b {
	
	public static void main (String[] args) throws FileNotFoundException {
		
		int countLetters = 0;
		int countWords = 0;
		
		//String FileIn = args[0];
		Scanner in = new Scanner(new File(args[0]));
		
		if (args.length != 1)
		{
			System.out.println("One command line arguement needed!");
			System.exit(-1);
			
		} 
		while (in.hasNextLine()) {
			
			String Words = in.nextLine ();
			
			String[] wordArray = Words.split(" ");
		}
	
	System.out.println("Total letters = " + countLetters);
	System.out.println("Total letters = " + countWords);
	}

}
