package basic;

import java.util.Date;
public class GreetingThread implements Runnable {
    // instance variable
    private String greeting;
    // constants
    private static final int REPETITIONS = 5;
    private static final int DELAY = 1000;

    // GreetingThread constructor
    public GreetingThread( String aGreeting ) {
        greeting = aGreeting;
    }
    // this method is executed when the Thread is started
    public void run() {
        try {
            for ( int i = 0; i <= REPETITIONS; i++ )
            {
                // get current date and time
                Date now = new Date();
                // Output date and time and greeting
                System.out.println( now + " " + greeting );
                // sleep for 1 second
                Thread.sleep( DELAY );
            }
        }
        // exception generated if sleeping thread is
        // interrupted
        catch ( InterruptedException ie ) {
            System.err.println( ie.toString() );
        }
    }
}