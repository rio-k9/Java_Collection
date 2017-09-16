package priority;

public class PriorityThread extends Thread {
    public PriorityThread( int priority, String name )
    {
        setPriority( priority );
        setName( name );
    }
    // this method is executed when the athread is started
    public void run()
    {
        System.out.println(
                Thread.currentThread().getName() + " Starting");
        // do something which takes a long tiume
        int j = 100;
        for(long i=0;i<1000000000;i++)
        {
            j = j * 2;
            j = j + 2;
            j = j / 2;
            j = j - 1;
        }
        System.out.println(
                Thread.currentThread().getName() + " Finished");

    }
}