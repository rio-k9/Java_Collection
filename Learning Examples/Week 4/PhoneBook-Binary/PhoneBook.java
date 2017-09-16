import java.io.*;

public class PhoneBook implements Serializable {

    private PhoneBookEntry[] entries;
    private int size;
    final private static int MAX_ENTRIES = 2;

    public PhoneBook( ) {
        entries = new PhoneBookEntry[MAX_ENTRIES];
    }

    public void add( String name, String number ) {
		if (size != MAX_ENTRIES) {
        	entries[size] = new PhoneBookEntry( name, number );
        	size++;
		}
    }

    public String numberFor( String name ) {
        for (int i = 0; i < size; ++i) {
            if ( entries[i].getName().equals(name) ) {
                return entries[i].getNumber();
            }
        }
        return "NOT FOUND";
    }

    public String toString( ) {
        StringBuffer temp = new StringBuffer();
        for (int i = 0; i < size; ++i) {
            temp.append( entries[i].toString() + "\n" );
        }
        return temp.toString();
    }

}

