package basic;

public class GreetingThreadTest
{
    // main method
    public static void main( String[] args ) throws InterruptedException {
        // create first thread

        Thread thread1 = new Thread(new GreetingThread("Hello World!" ));
        Thread thread2 = new Thread(new GreetingThread("Goodbye World!" ));

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println( "Main thread wakes up" );
    }
}
