import java.util.ArrayList;

public class ArrayTest
{
	// print 1D array
	private static void print_array(int[] arr)
	{
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
		System.out.println();
	}
	// print 2D array
	private static void print_array_2d(int[][] arr)
	{
		for (int i = 0; i < arr.length; i++)
		{
			for (int j = 0; j < arr[i].length; j++)
			{
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	// print 1D array list
	private static void print_array_list(ArrayList<Integer> arrlst)
	{
		for (int i = 0; i < arrlst.size(); i++)
		{
			System.out.print(arrlst.get(i) + " ");
		}
		System.out.println();
	}
	public static void main (String [] args)
	{
		int[] arr1 = new int[10];		// one dimensional array
		print_array(arr1);
		int[] arr2 = new int[] {1, 3, 5, 7, 9};	// initialised
		print_array(arr2);
		int[] arr3 = {1, 3, 5, 7, 9};		// another initialised
		print_array(arr3);
		
		int[][] arr4 = new int[3][2];		// two dimensional array
		print_array_2d(arr4);
		int[][] arr5 = new int[][] {{1, 3, 5}, {2, 4, 6}};	// initialised
		print_array_2d(arr5);
		int[][] arr6 = {{1, 3, 5}, {2, 4, 6}};		// another initialised
		print_array_2d(arr6);
		
		int[][] arr7 = {{1, 3, 5}, {2, 4, 6, 8}};	// non-rectangular array
		print_array_2d(arr7);
		
		// two dimensional is an array of array
		print_array(arr7[0]);
		print_array(arr7[1]);
		
		// manual creation of 2d array
		int[][] arr8 = new int[2][];
		arr8[0] = new int[] {1, 5, 7, 9};
		arr8[1] = new int[] {2, 4};
		print_array_2d(arr8);
		
		// size changeable array list: see java reference for details
		ArrayList<Integer> arrlst = new ArrayList<Integer>();
		arrlst.add(3);
		arrlst.add(5);
		arrlst.add(7);
		print_array_list(arrlst);
	}
}