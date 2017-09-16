import tim.Main;
import tim.Staff;
import tim.Token;



public class timtest {
	
	
	private static String user1 = "fuck"; //INPUT
	private static String pass1 = "fuck"; //INPUT
	
	private static tim.Main timAuth = new Main();
	timAuth.initialise();
	
	Token response = Staff.login("admin", "admin");
	System.out.println(response.message);
	
	/*

	private static tim.Token timToken = new Token();
	private static tim.Settings timAuth = tim.Serializer.restore(); {
	
	


	if (user1.equals(timAuth.user) && pass1.equals(timAuth.pass)) { //USER INPUT VARIABLE HERE and USER INPUT PASS
		timToken.message = "Log in successful.";
		timToken.granted = true;
	} else {
		timToken.message = "Log in failed.";
		timToken.granted = false;
	}
	

	}*/
}
