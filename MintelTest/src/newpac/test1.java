package newpac;

public class test1 {
	public static void main (String[] args) {
		
		String me = "Rio";
		System.out.println(me.length());
		System.out.println(me.equals("Charlotte"));
		System.out.println(me.equalsIgnoreCase("RIO"));
		System.out.println(me.charAt(0));
		System.out.println(me.toUpperCase());
		System.out.println(me.endsWith("o"));
		
		
		int num = 10;
		
		Double numTwo = Double.valueOf(num);
		System.out.println(numTwo);
		System.out.println(Double.parseDouble("120"));
		System.out.println(Integer.parseInt("10"));
		System.out.println("\n");
		
		int array[] = new int[3];
		int arra2[] = {11, 22, 33};
		for (int i = 0; i < array.length; i++){
			
			array[i] = i+1;
			System.out.println(array[i]);
			System.out.println(arra2[i]);
		}
	}

}
