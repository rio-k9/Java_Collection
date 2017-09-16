package priority;

public class PriorityTest {
	
    public static void main( String[ ] args ) {
        // start many low priority threads
        for ( int i = 0; i <= NOOFTHREADS; i++ )
        {
            PriorityThread t = new PriorityThread(
                    Thread.MIN_PRIORITY, "Low Priority Thread " + i);
            t.start();
        }
        // start a thread with maximum priority
        PriorityThread t2 = new PriorityThread(
                Thread.MAX_PRIORITY, "High Priority Thread **" );
        t2.start();
        
    }
    // main thread exits
    private static final int NOOFTHREADS = 10;
}