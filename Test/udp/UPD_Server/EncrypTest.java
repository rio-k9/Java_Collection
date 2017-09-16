package UPD_Server;

public class EncrypTest {
	
	public static void main(String args[]) {
		
		String GoMan = "Encrypt Me Bitch, You Punk";
		System.out.println(Encrypt(GoMan));
		
		
	}
		
		public static String Encrypt(String encryptMe){
			
			String messageEncrypted = "";

	        for (int i=0; i<encryptMe.length(); i++){
	            char ch = encryptMe.charAt(i);
	            if ((ch>='a') && (ch<='z')){
	                if (ch=='z'){
	                    ch='a';
	                    messageEncrypted+=ch;
	                } else {
	                    ch+=1;
	                    messageEncrypted+=ch;
	                }
	            } else{
	            	 messageEncrypted +=ch;
	            }
	        }
	        System.out.println("Original Message: " + encryptMe);
			
			
			
			return messageEncrypted;
		}
	}

