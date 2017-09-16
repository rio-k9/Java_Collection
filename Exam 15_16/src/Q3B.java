import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Scanner;

public class Q3B {
	
	public static void main(String[] args) throws IOException{
		
		File dir = new File("C:\\Users\\Rio\\Desktop\\ComSci\\Java\\Test\\");
		File[] files = dir.listFiles(new FilenameFilter() {
		    public boolean accept(File dir, String name) {
		        return name.toLowerCase().endsWith(".txt");
		    }
		});
		System.out.println(files[0]);
		String FILENAME;
		File[] txtFiles = new File[files.length];
		int a = 0;
		int LENGTH;
		for (int i = 0; i <= 1; i++){
		FILENAME = 	files[i].toString();
		LENGTH = FILENAME.length();
		
			if (FILENAME.contains(".txt") == true){
				
				txtFiles[a] = files[i];
				a++;
				System.out.println("Text File Found.");
				System.out.println(txtFiles[a].toString());
	
			}
			else{
			System.out.println("Skipping Over Other File.");
			}
		}

		
		
		 //BufferedReader reader = new BufferedReader(new FileReader("Hello1.txt"));
		 //int lines = 0;
		 //while (reader.readLine() != null) lines++;
		 //reader.close();
		 //System.out.println(lines);
		
	}

}
