package read_multiple_files;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class findMultiFile{
    public static ArrayList<String> folderFiles = new ArrayList();

    public static void main (String[] args){

	    String path = new File("readingFiles/").getAbsolutePath();
	    final File folder = new File(path);
	    listFilesForFolder(folder);
	
	    for (String fileName : folderFiles){
	        int countlines = 0;
	        if (fileName.endsWith(".txt")){
	
	            try {
	            	// System.out.println(path+"/"+fileName + ".txt");
	                Scanner in = new Scanner(new File(path+"/"+fileName));
	                while (in.hasNext()){
	                    in.nextLine();
	                    countlines+=1;
	                    }
	                System.out.println(fileName + " lines " + countlines);
	            }catch (Exception e){
	                System.out.println("Error Dude.");
	            }
	        }
	    }
    }
    public static void listFilesForFolder(final File folder) {
        for (final File fileEntry : folder.listFiles()) {
                folderFiles.add(fileEntry.getName());
            }
        }
    }