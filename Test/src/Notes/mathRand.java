package Notes;

import java.util.Random;

	public class mathRand {
	
		public static void main(String args[]){
		
		Random ran = new Random();
	    int[] $numArray = new int[10];
	
	    for (int i=0; i<10; i++) {
	    	
	        int $randNum =  ran.nextInt(8999) +1001;
	      //change to and from range here
	        //inclusive numbering
	        $numArray[i]= $randNum;
	        System.out.println($numArray[i]);
	
	    }
	}
}
