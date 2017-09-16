
public class Q1_Bi {

	public static void main(String args[]) {

		
		String str = "aawd1dawd2awda3awd4ad5awda6ad7awd8awd9";
		String numOnly = "";

		        for (int i=0; i<str.length();i++){
//		            System.out.println("is " + (first.charAt(i)>=0 ));
		            if((str.charAt(i)>='0') &  (str.charAt(i)<='9')){
		                numOnly += str.charAt(i);
		            }
		        }
		        System.out.println(numOnly);
	}		
}
		
		
	

