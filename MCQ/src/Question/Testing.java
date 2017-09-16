package Question;

import java.sql.ResultSet;
import java.sql.SQLException;

/*
 *   @author adam
 * 
 */


public class Testing {

	/*
	 * This is just some examples of the methods being called.
	 * Make sure the database is not open with any database management programs while running.
	 * Comment out changes and inspect the database after running to see the changes.
	 */
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		SQLiteDB test = new SQLiteDB("QuestionDB");
		
		ResultSet res = null;
		
		System.out.println("----------- Printing All Topics as TopicID - TopicName -----------");
		
		res = test.getTopics();
		while (res.next()){
			System.out.println(res.getInt("TopicID") + " - " + res.getString("TopicName"));  
		}
		
		//THIS IS MY METHOD FOR GETTING A TOPIC NAME  ^^^
		//TO BE USED ON QUESTIONS SCREEN AND SELECTION SCREEN
		
		System.out.println("----------- Adding a new topic -----------");
		
		try {
			test.addTopic("Testing");
		} catch (SQLException e) {
			System.out.println("The Topic already exists");
		}
		res = test.getTopics();
		while (res.next()){
			System.out.println(res.getInt("TopicID") + " - " + res.getString("TopicName"));
		}
		
		//THIS IS MY METHOD TO INTEGRATE WITH A BUTTON THAT SAYS "ADD NEW TOPIC"  ^^^
		
		
		
		
		
		
		System.out.println("----------- Adding another new topic -----------");
		test.addTopic("TV");
		res = test.getTopics();
		while (res.next()){
			System.out.println(res.getInt("TopicID") + " - " + res.getString("TopicName"));
		}//OPTIONAL

		
		
		
		System.out.println("----------- Adding a new question -----------");
		test.addQuestion("What was the last partially decent series of the Simpsons before it became irredeemably bad?", null, "11", "15", "18", "25", 1);
		//THIS IS MY INPUT BOX FOR WHEN WE WANT TO ADD A NEW QUESTION ^^
		
		System.out.println("----------- Adding your question to the topic -----------");
		int ID = test.getTopicID("TV");  //THIS NEEDS TO BE CHANGED TO A VARIABLE THAT IS ASSIGNED WITH WHATEVER TOPIC SELECTED
		test.addQuestionToTopic(4, ID);
		//THIS IS THE BUTTON REQUIRED TO FINALISE THE QUESTION AND ADD IT TO TOPIC
		
		
		
		
		
		
		
		
		System.out.println("----------- Displaying all the questions in a topic -----------");
		
		ResultSet question = test.getQuestions("TV");  //THIS NEEDS TO BE FOR A BROWSE QUESTIONS BUTTON WHERE VARIABLE IS SELECTED TOPIC

		while (question.next()) {
			System.out.println(question.getString("QuestionText"));
			System.out.println(question.getString("Option1"));
			System.out.println(question.getString("Option2")); //ALL THIS PRINTED IN JPANEL 
			System.out.println(question.getString("Option3"));
			System.out.println(question.getString("Option4"));
			System.out.println("Correct Answer:" + question.getInt("correctAnswer"));
		}

		
		System.out.println("----------- Removing the topics that were added and clearling all questions from the Question_Topic table, and displaying remaining topics -----------");
		
		test.removeTopic("Testing");
		test.removeTopic("TV");
		res = test.getTopics();
		while (res.next()){
			System.out.println(res.getString("TopicName"));
		}
		
		System.out.println("----------- Deleting the question that was previously added -----------");
		test.removeQuestion(4);
		
		System.out.println("----------- Unless any of the above was changed, everything is now back the way it was at the start -----------");
	
		//Example of question edited
		//test.editQuestion("QuestionText", "This is some example text?", 1);
		
		//Example of Topic renamed
		//test.renameTopic("Security", "Example");
	}

}
