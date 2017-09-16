import java.util.Scanner;

public class Main {
    
    /* 
    initialise global variables
    */
    
    static int myLength;
    static String myLine;
    static String st;
    static String firstHalf;
    static String secondHalf;
    static Scanner in;
    public static void main(String args[]){
        
    /* 
    check string input can be split into two, else ask again for input
    */
        while(true){
            in = new Scanner( System.in );
            st = in.nextLine();
            myLength = myLine.length();
            myLine = st.replaceAll("^[^a-zA-Z0-9\\s]+|[^a-zA-Z0-9\\s]+$", "");
            /* regular expression to have only alphanumeric remaining
                i did need help to find the exact regex to do this, or you can do a for loop replacing
            */
            if (myLength % 2 == 0){
                System.out.println(myLine + " can be split in half, thanks!");
                break;
            }
            else{
                System.out.println("Your input can't be split in half, please make sure it is divisible by two!");
                continue;
            }
        }
        
        /*
        split string
        */
        firstHalf = myLine.substring(0, myLength/2);
        secondHalf = myLine.substring(myLength/2, myLength);
        System.out.println(firstHalf);
        System.out.println(secondHalf);
        
        /*
        compare string
        */
        
        if (firstHalf.toLowerCase().equals(secondHalf.toLowerCase())){
            
            System.out.println(firstHalf + " -> true");
        }
        
        else{
            
            System.out.println(firstHalf + " -> false");
            
        }
        
        /*
        awesome, now to make sure its only 
        containing alphabetical or numerical characters
        */
    }
}
