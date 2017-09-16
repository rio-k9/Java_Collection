import java.io.*;

public class PhoneBookApp {

    public static void main( String[] args ) {
		// Note how the main method creates an
		// object representing the application.
		// This avoids the need to pass a lot of arguments
		// between methods.
		PhoneBookApp pba = new PhoneBookApp(args);

	}

	// Data fields.
	private PhoneBook pb;

	private PhoneBookApp( String[] args ) {

		switch (args[1].charAt(1)) {
			case 'n':
				createNewBook(args[0]);
				break;
			case 'p':
				readPhoneBook(args[0]);
				System.out.println(pb);
				break;
			case 'a':
				// Add entry
				readPhoneBook( args[0] );
				pb.add( args[2], args[3] );
				writePhoneBook( args[0] );
				break;
			case 'f':
				// Find entry
				readPhoneBook( args[0] );
				System.out.println( pb.numberFor(args[2]) );
				break;
			default:
				// Handle invalid switch
				break;
		}

    }

	private void createNewBook(String filename) {
		pb = new PhoneBook();
		writePhoneBook(filename);
	}

    private void readPhoneBook( String filename ) {
		try {
			ObjectInputStream in = new ObjectInputStream
				( new FileInputStream( filename ) );
			pb = (PhoneBook)in.readObject();
			in.close();
		}
		catch (Exception e) {
			System.out.println(e);
			System.out.println("Phone book could not be opened");
			System.exit(0);
		}
    }

    private void writePhoneBook( String filename ) {
        try {
			ObjectOutputStream out = new ObjectOutputStream
            	( new FileOutputStream( filename ) );
        	out.writeObject(pb);
        	out.close();
		}
		catch (IOException e) {
			System.out.println(e);
			System.out.println("Phone book not saved");
			System.exit(0);
		}
    }

}
