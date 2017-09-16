import java.util.Arrays;

public class BubbleSort {
	public static void main(String args[]){
		
		int[] $numArray = {3, 11, 1212, 45545, 120912, 2, 8, 3, 5, 4, 9, 6, 1, 7, 10};
		int[] $autoSortArray = {20, 80, 30, 50, 40, 90, 60, 10, 70, 100};
		Arrays.sort($autoSortArray);
	    int $arrayLength = $numArray.length;
	    int $numberMove = 0;

	    for (int i = 0; i < $arrayLength; i++) {
	    	//Initiate array loop    	
	        for (int x = 1; x < ($arrayLength  - i); x++) {
	        	//Initiate bubble sort loop for every number in loop
	            if ($numArray[x - 1] > $numArray[x]) {
	            	//if [the number before] > [current number]
	            	//swap them around using a temporary variable $numberMove
	            	$numberMove = $numArray[x - 1];
	            	$numArray[x - 1] = $numArray[x];
	            	$numArray[x] = $numberMove;	                	               
	            }	            		        
	        }	        
	    }
	    for (int i = 0; i < $numArray.length; i++){
	    System.out.println($numArray[i]);
	    }
	    for (int i = 0; i < $autoSortArray.length; i++){
	    	System.out.println($autoSortArray[i]);
		}	    
	}
}
