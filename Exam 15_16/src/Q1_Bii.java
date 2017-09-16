import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Q1_Bii {
	
	public static int genRandom(int MAX_VALUE, int MIN_VALUE) {
		
		Random gen = new Random();
		int Randomgen = gen.nextInt(MAX_VALUE - MIN_VALUE) + MIN_VALUE;
		return Randomgen;			
	}
	
	public static void main(String args[]){				
		int[] randomNums = new int[10];
		
		for (int i = 0; i <= 9; i++){
			randomNums[i] = genRandom(10000, 999);
			System.out.println(randomNums[i]);	
		}	
	}
}
