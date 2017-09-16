import java.util.Scanner;
import java.io.*;

public class AddEntry {

    public static PhoneBook loadPhoneBook( String filename ) throws Exception {
        File fileIn = new File( filename );
        
        Scanner in = new Scanner( fileIn );
        PhoneBook book = new PhoneBook();
        
        while( in.hasNextLine() ) {
            // Get a line of the text file
            String line = in.nextLine();
            
            // Separate the line into name and number
            String[] parts = line.split(",");
            String name = parts[0];
            String number = parts[1];
            
            // Create an entry and add it to the phone book
            book.add( name, number );
        }
        in.close();
        
        return book;
    }
    
    public static void savePhoneBook( String filename, PhoneBook pb ) throws Exception {
        FileWriter writer = new FileWriter( filename );  // no need for File!
        PrintWriter out = new PrintWriter( writer );
        
        for( PhoneBookEntry pbe : pb.getEntries() ) {
            String name = pbe.getName();
            String number = pbe.getNumber();
            String line = name + "," + number;
            out.println( line );
        }
        
        out.close();
    }
    
    public static void main( String[] args ) {
        try {
            // Load an existing phone book...
            String filename = args[0];
            String name = args[1];
            String number = args[2];
        
            PhoneBook pb = loadPhoneBook( filename );
        
            // Print the current phone book
            System.out.println( "Phone book from file..." );
            System.out.println( pb );
        
            // Add the entry
            pb.add( name, number );
        
            // Print updated phone book
            System.out.println( "Updated phone book..." );
            System.out.println( pb );
        
            savePhoneBook( filename, pb );
        }
        catch( Exception e ) {
            System.out.println( e );
        }
    }
}





