package tim;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;


/**
 * @author Tim
 *
 */
public class Main {

	/**
	 * @param args
	 */
	
	public static void initialise() {
		// Check for settings file
		// else create default settings
		try {
			if (!Serializer.checkFile()) {
				File f_new = new File("settings.sav");
				f_new.createNewFile();
				System.out.println("No settings found.");
				Serializer.write(Staff.defaultSettings());
			} else {
				System.out.println("Settings found.");
			}
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
	//DECLARE THE IMPORTED VARIABLE OUTSIDE THE OBJECT 
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		initialise();
		
		Token response = Staff.login(user1, pass1);  //START HERE WITH FEEDING A VARIABLE IN FROM A SEPERATE PACKAGE
		System.out.println(response.message);
		
		Student testStudent = new Student();
		System.out.println(testStudent.school);
		
		testStudent.newAnswer(2, 3);
		Integer a = testStudent.getAnswer(2);
		if (a!=0) { System.out.println(a); }
		
	}

}
