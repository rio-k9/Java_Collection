import java.io.*;

public class PhoneBookEntry implements Serializable {

    private String name;
    private String number;

    public PhoneBookEntry( String inName, String inNumber ) {
        name = inName;
        number = inNumber;
    }

    public String getName( ) {
        return name;
    }

    public String getNumber( ) {
        return number;
    }

    public String toString( ) {
        return name + "\t(" + number + ") ";
    }

    public boolean equals( PhoneBookEntry pbe ) {
        return name.equals( pbe.name ) && number.equals( pbe.number );
    }
}
