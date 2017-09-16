package horserace;

import javafx.concurrent.*;
import java.util.Random;
public class HorseThread extends Task<Integer> 
{
	
	public int getTime()
	{
		return time;
	}
	
	public HorseThread(int id)
	{
		ID = id;
	}
	
	protected Integer call()
	{
		final int MAX_DISTANCE = 1000;
		int distance = 0;
		
		Random random = new Random();
		while (distance < MAX_DISTANCE)
		{
			distance += random.nextInt(6) + 1;
			time++;
			try
			{
				Thread.sleep(10);
			}
			catch (InterruptedException ie)
			{
				
			}
			
			updateMessage(String.valueOf(distance));
		}
		
		return time;
	}
	
	public int getID()
	{
		return ID;
	}
	
	private int ID;
	private int time = 0;
}
