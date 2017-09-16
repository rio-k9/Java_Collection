package Question;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;


public class SQLiteDB {
	
	//Connection object for establishing connection with the database
	private static Connection connection;
	
	//Initialize String objects for the database name and path.
	private String databaseName;
	private String databasePath;
	
	//Class constructor
	public SQLiteDB(String databaseName) {
		this.databaseName = databaseName;
		
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.databasePath = "jdbc:sqlite:" + databaseName + ".db";
	}

	//--------------------------------------------------------------------------------//
	//Public Methods//
	
	//Return all TopicName and TopicID entries from the Topic table
	public ResultSet getTopics() throws ClassNotFoundException, SQLException {
		
		ResultSet res = _getTopics();
		return res;
	}
	
	//Get the questions relating to a topic. As noted below, the function can be called either using the topicName or topicID due to method overloading.
	public ResultSet getQuestions(int TopicID) throws ClassNotFoundException, SQLException {
		
		//Look up the Questions relating to the TopicID by performing a table join query on the Question_Topic and Question tables
		ResultSet res = _getQuestions(TopicID);
		return res;
	}
	//Method overloading to allow getQuestions to be called either using the TopicName or the TopicID
	//This is possible as the TopicName is a unique identified in the Topic database, i.e. no two Topic entries are allowed to have the same name
	public ResultSet getQuestions(String topicName) throws ClassNotFoundException, SQLException {
		
		//Look up the TopicID from the Topic table and store the integer value as TopicID
		ResultSet res = _getTopicID(topicName);
		int TopicID = res.getInt("TopicID");
		
		//Look up the Questions relating to the TopicID by performing a table join query on the Question_Topic and Question tables
		res = _getQuestions(TopicID);
		return res;
	}
	
	//Adds a new Topic to the Topic table in the databsae
	public void addTopic(String topicName) throws SQLException, ClassNotFoundException {
		
		//Check if the topic already exists
		ResultSet topicExists = _getTopicID(topicName);
		
		//If not, add the new topic
		if (!topicExists.next()) {
			_addTopic(topicName);
		}
	}
	
	//Remove a topic from the Topic table and clear all questions from the topic in the Question_Topic table
	//This will not remove the questions from the database, as they may be linked to another Topic, or indeed, may exist with no assigned topic
	public void removeTopic(String topicName) throws SQLException, ClassNotFoundException {
		
		//Look up the topicID from the Topic table
		ResultSet res = _getTopicID(topicName);
		
		//If the topic is found, look up the id and remove the Topic from the Topic table
		if (res.next()) {
			int topicID = res.getInt("topicID");
			
			//Remove the Topic from the Topic table
			_removeTopic(topicName);
			
			//Clear all questions from the Topic in the Topic_Question table
			_removeAllQuestionFromTopic(topicID);
		}
	}
	//Method overloading. As above, but using the TopicID rather than the TopicName
	public void removeTopic(int topicID) throws SQLException, ClassNotFoundException {
		
		//Remove the Topic from the Topic table
		_removeTopic(topicID);
		
		//Clear all questions from the Topic in the Topic_Question table
		_removeAllQuestionFromTopic(topicID);
	}
	
	//Add a new question
	public void addQuestion(String QuestionText, String QuestionImage, String Option1, String Option2, String Option3, String Option4, int CorrectAnswer) throws SQLException {	
		//Add the question to the Question table
		_addQuestion(QuestionText, QuestionImage, Option1, Option2, Option3, Option4, CorrectAnswer);
	}
	
	//Remove a question
	public void removeQuestion(int questionID) throws SQLException {
		_removeQuestion(questionID);
	}
	
	//Link a question to a specified topic
	public void addQuestionToTopic(int questionID, int topicID) throws SQLException {
		_addQuestionToTopic(questionID, topicID);
	}
	
	//Remove a question from a specified topic
	public void removeQuestionFromTopic(int questionID, int topicID) throws SQLException {
		_removeQuestionFromTopic(questionID, topicID);
	}
	
	//Retrieve the topicID as integer value when given the topicName
	public int getTopicID(String topicName) throws ClassNotFoundException, SQLException {
		
		//Look up the topicID from the Topic table and assign the value to ID
		ResultSet res = _getTopicID(topicName);
		int ID = res.getInt("topicID");
		return ID;
	}
	
	//Rename a topic
	public void renameTopic(String oldName, String newName) throws SQLException, ClassNotFoundException {
		
		//Check if the new name for the topic already exists
		ResultSet topicExists = _getTopicID(newName);
		
		//If the new name doesn't exist, rename the topic
		if (!topicExists.next()) {
			_renameTopic(oldName, newName);
		}
	}
	
	//Edit a question
	public void editQuestion(String field, String newValue, int questionID) throws SQLException {
		_editQuestion(field, newValue, questionID);
	}
	// Method overloading to allow for integer values for correctAnswer to be updated
	public void editQuestion(String field, int newValue, int questionID) throws SQLException {
		_editQuestion(field, newValue, questionID);
	}
	
	//--------------------------------------------------------------------------------//
	//Private Methods//
	
	//Connect to database
	private void getConnection() throws SQLException {
		
		try {
			connection = DriverManager.getConnection(databasePath);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Connection to " + databasePath + " established");
	}
	
	//Returns a result set with the topic names
	private ResultSet _getTopics() throws SQLException, ClassNotFoundException {

		if (connection == null) {
			getConnection();
		}

		//Create a new SQL statement object
		Statement statement = connection.createStatement();

		//Create a ResultSet object to store the SQL query results
		ResultSet res; 
		
		try {
			res = statement.executeQuery("SELECT * FROM Topic");
		}
		catch (SQLException e) {
			res = null;
		}
		
		//Return the data, or null if data not found
		return res;
	}
	
	//Returns a resultSet with the TopicID of a given TopicName
	private ResultSet _getTopicID(String topicName) throws SQLException, ClassNotFoundException {
		
		
		
	//STATEMENT NOT WORKING ? ?
		Statement statement = connection.createStatement();
		
		if (connection == null) {
			getConnection();
		}

		//Create a new SQL statement object
		

		//Create a ResultSet object to store the SQL query results
		ResultSet res; 
		
		try {
			res = statement.executeQuery("SELECT TopicID FROM Topic WHERE TopicName='" + topicName +"'");
		}
		catch (SQLException e) {

			res = null;
			e.printStackTrace();
		}
		
		//Return the data, or null if data not found
		return res;
	}
	
	//Returns questions relating to a specified TopicID
	private ResultSet _getQuestions(int TopicID) throws SQLException {
		if (connection == null) {
			getConnection();
		}
		
		//Create a new SQL statement object
		Statement statement = connection.createStatement();
		
		//Create a ResultSet object to store the executed SQL query
		ResultSet res = null; 
		
		//Perform a table join query to retrieve all questions for the TopicID
		res = statement.executeQuery(""
		+ "SELECT Question.QuestionID, QuestionText, QuestionImage, Option1, Option2, Option3, Option4, CorrectAnswer "
		+ "FROM Question "
		+ "INNER JOIN Question_Topic "
		+ "ON Question.QuestionID=Question_Topic.QuestionID "
		+ "WHERE TopicID =" + TopicID
		);
			
		//Return the data as a resultSet object, or null if data not found
		return res;
	}
	
	//Add a new topic to the database
	private void _addTopic(String topicName) throws SQLException {
		if (connection == null) {
			getConnection();
		}
		
		//Create a new SQL statement object. The TopicID is the primary key, and should be generated automatically
		PreparedStatement prep = connection.prepareStatement("INSERT into Topic (TopicID, TopicName) values(?, ?);");
		prep.setString(2, topicName);
		prep.execute();
	}

	//Add a new question to the database
	private void _addQuestion(String QuestionText, String QuestionImage, String Option1, String Option2, String Option3, String Option4, int CorrectAnswer) throws SQLException {
		if (connection == null) {
			getConnection();
		}
	
		//Create a new SQL statement object
		PreparedStatement prep = connection.prepareStatement("INSERT into Question values(?, ?, ?, ?, ?, ?, ?, ?);");
		prep.setString(2, QuestionText);
		prep.setString(3, QuestionImage);
		prep.setString(4, Option1);
		prep.setString(5, Option2);
		prep.setString(6, Option3);
		prep.setString(7, Option4);
		prep.setInt(8, CorrectAnswer);
		prep.execute();
	}
	
	//Remove a question from the Question table of the database using the question's QuestionID
	//NOTE: this will not remove the question from the Question_Topic table
	private void _removeQuestion(int QuestionID) throws SQLException {
		if (connection == null) {
			getConnection();
		}
		
		PreparedStatement prep = connection.prepareStatement("DELETE FROM Question WHERE QuestionID = ?;");
		prep.setInt(1, QuestionID);
		prep.executeUpdate();
	}
	
	//Remove a particular question from a Topic as mapped in the Question_Topic table.
	//NOTE: this will not remove the question from the Question table	
	private void _removeQuestionFromTopic(int questionID, int topicID) throws SQLException {
		if (connection == null) {
			getConnection();
		}
		
		PreparedStatement prep = connection.prepareStatement("DELETE FROM Question_Topic WHERE QuestionID = ? AND TopicID = ?;");
		prep.setInt(1, questionID);
		prep.setInt(2, topicID);
		prep.executeUpdate();	
	}
	
	//Remove all questions from a Topic as mapped in the Question_Topic table.
	//Note: this will not remove the question from the Question table
	private void _removeAllQuestionFromTopic(int topicID) throws SQLException {
		if (connection == null) {
			getConnection();
		}
		
		PreparedStatement prep = connection.prepareStatement("DELETE FROM Question_Topic WHERE TopicID = ?;");
		prep.setInt(1, topicID);
		prep.executeUpdate();	
	}
	
	//Remove a topic from the database given the topicName
	//NOTE: This will not remove any questions assigned to this Topic from the Question_Topic table
	private void _removeTopic(String topicName) throws SQLException {
		if (connection == null) {
			getConnection();
		}
		
		//Create a new SQL statement object
		PreparedStatement prep = connection.prepareStatement("DELETE FROM Topic WHERE topicName = ?;");
		prep.setString(1, topicName);
		prep.executeUpdate();
	}
	
	//Remove a topic from the database given the topicID
	//NOTE: This will not remove any questions assigned to this Topic from the Question_Topic table
	private void _removeTopic(int topicID) throws SQLException {
		if (connection == null) {
			getConnection();
		}
		
		//Create a new SQL statement object
		PreparedStatement prep = connection.prepareStatement("DELETE FROM Topic WHERE topicID = " + topicID + ";");
		//prep.setString(1, topicID);
		prep.executeUpdate();
	}
	
	private void _addQuestionToTopic(int questionID, int topicID) throws SQLException {
		if (connection == null) {
			getConnection();
		}
		
		//Create and execute new SQL prepared statement object
		PreparedStatement prep = connection.prepareStatement("INSERT into Question_Topic values(?, ?);");
		prep.setInt(1, questionID);
		prep.setInt(2, topicID);
		prep.execute();	
	}
	
	private void _renameTopic(String oldName, String newName) throws SQLException {
		if (connection == null) {
			getConnection();
		}
		
		//Create and execute new SQL prepared statement object
		PreparedStatement prep = connection.prepareStatement("UPDATE Topic SET TopicName=? WHERE TopicName=?;");
		prep.setString(1, newName);
		prep.setString(2, oldName);
		prep.execute();
	}
	
	private void _editQuestion(String field, String newValue, int questionID) throws SQLException {
		if (connection == null) {
			getConnection();
		}
		
		//Check that the field is one which will accept the data type, noting that only the correctAnswer field accept integer data
		if (field != "correctAnswer" && field != "CorrectAnswer") {
			
			//Check that questionID is not overwritten
			if (field != "topicID" && field != "TopicID") {
			
				//Cannot pass column name to prepared statement directly, so add field as String
				PreparedStatement prep = connection.prepareStatement("UPDATE Question SET " + field + "=? WHERE QuestionID=?;");
				prep.setString(1, newValue);
				prep.setInt(2, questionID);
				prep.execute();
			}
		}
	}
	//Method overloading to allow integer input of new value in the case that the correctAnswer field needs to be updated
	private void _editQuestion(String field, int newValue, int questionID) throws SQLException {
		if (connection == null) {
			getConnection();
		}
		
		//Check that the field is one which will accept the data type, noting that only the correctAnswer field accept integer data
		if (field == "correctAnswer" || field == "CorrectAnswer") {	
			
			//Check that the new value is in correct range
			if (newValue > 0 && newValue < 5) {
			
				//Check that questionID is not overwritten
				if (field != "topicID" && field != "TopicID") {
					
					//Cannot pass column name to prepared statement directly, so add field as String
					PreparedStatement prep = connection.prepareStatement("UPDATE Question SET " + field + "= ? WHERE questionID = ?;");
					prep.setInt(1, newValue);
					prep.setInt(2, questionID);
					prep.execute();
				}
			}
		}
	}
}