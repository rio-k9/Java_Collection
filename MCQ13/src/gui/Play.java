package gui;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.sun.rowset.CachedRowSetImpl;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Insets;


/*
 *  @author Rio Karim
 * 
 */

@SuppressWarnings("serial")
public class Play extends JFrame {

	private JPanel contentPane;
	static JRadioButton radio_1;
	static JRadioButton radio_2;
	static JRadioButton radio_3;
	static JRadioButton radio_4;
	static JLabel logoPlay;
	static JPanel Qpanel;
	static JScrollPane scrollPane;
	static JTextArea labelQuestionTextArea;
	static String radioText;
	public static int counter = 0;
	public static Integer selectedAnswer;
	private static int topicID;
	private static int playerCorrectAnswers = 0;
	public static JLabel questionImage  = new JLabel();
	public static statistics.Feedback feedback;
	public static JLabel feedbackText;
	
	
	/**
	 * Launch the application window.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Play frame = new Play(questionMap, topicID);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	static Main MainConstructor = new Main();
	public static HashMap<Integer, String[]> questionMap;  
		
	public Play(HashMap<Integer, String[]> questionMap, int topicID) throws ClassNotFoundException, IOException, SQLException {
		
		this.questionMap = questionMap;
		this.topicID = topicID;
		
		style();
		
		String[] question = questionMap.get(0);
		labelQuestionTextArea.setText(question[1]);
		radio_1.setText(question[3]);
		radio_2.setText(question[4]);
		radio_3.setText(question[5]);
		radio_4.setText(question[6]);
		
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);  //DISABLES 'X' BUTTON ON WINDOW
		addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent we)
		    { 
		    	MainConstructor.chimeSound();
		        String exitButtons[] = {"Exit","Return"}; //DIALOG BOX TO CONFIRM QUIZ EXIT
		        int exitAttempt = JOptionPane.showOptionDialog(null,"Are you sure you wish to exit?\nData from your current session may be lost or incomplete.","Exit Warning",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,exitButtons,exitButtons[1]);
		        if(exitAttempt == JOptionPane.YES_OPTION)
		        {
		        	MainConstructor.clickSound(); //IF YES SYSTEM EXIT
		            System.exit(0);
		        }
		        else {
		        	MainConstructor.clickSound(); //ELSE DO NOTHING
		        }
		    }
		});

		//Create the Image Frame
		questionImage.setBounds(20, 50, 250, 250);
		contentPane.add(questionImage);
		setQuestionImage();
		
		
		//--------------------------------------------------------------------------------//
		// Feedback
		
		HashMap<Integer, Integer> correctAnswerMap = getCorrectAnswerMap();
		feedback = new statistics.Feedback(correctAnswerMap);
		
		feedbackText = new JLabel(); 
		feedbackText.setBounds(700, 10, 296, 50);
		getContentPane().add(feedbackText);
		
		//--------------------------------------------------------------------------------//
		// Navigation Buttons
		
		//Next Button
		JButton nextButton = new JButton("Next Question");
		nextButton.setMargin(new Insets(2, 5, 2, 5));
		nextButton.setHorizontalTextPosition(SwingConstants.LEADING);
		nextButton.setIconTextGap(10);
		nextButton.setIcon(new ImageIcon("src/img/next.png")); //STYLING FOR NEXT BUTTON
		
		nextButton.setFont(new Font("MV Boli", Font.PLAIN, 16));
		nextButton.setBounds(605, 417, 168, 41);
		contentPane.add(nextButton);
		
		
		//--------------------------------------------------------------------------------//
		// Button Listeners
		
		nextButton.addActionListener(new ActionListener() { //NEXT LISTENER
			
			public void actionPerformed(ActionEvent arg0) {
				
				radioText = "";
				if (radio_1.isSelected()){
					radioText = radio_1.getText();
					selectedAnswer = 1;
				}
				else if (radio_2.isSelected()){
					radioText = radio_2.getText();
					selectedAnswer = 2;
				}
				else if (radio_3.isSelected()){
					radioText = radio_3.getText();
					selectedAnswer = 3;
				}
				else if (radio_4.isSelected()){
					radioText = radio_4.getText();
					selectedAnswer = 4;
				}
	
				
				//IF RADIO TEXT IS EMPTY STRING, RETURN AS NO ANSWER SELECTED
				if ((radioText == "") || (radioText == null)) {
					int skipQuestion = JOptionPane.showConfirmDialog(null, "You have not selected an answer, if you skip to the next question you will lose a mark.", "Next Question", JOptionPane.OK_CANCEL_OPTION);
					if (skipQuestion == JOptionPane.OK_OPTION){
						MainConstructor.wooshSound();
						cycleQuestion();
					}
					else {
						MainConstructor.clickSound();
					}
				}
				
				//PROCEED HERE IF STRING IS NOT EMPTY
				else {
					/*
					 * return dialog to confirm your answer
					 */
					
					
					int nextQuestion = JOptionPane.showConfirmDialog(null, "You are about to select \"" + radioText + "\" as your answer.\nContinue to the next question?", "Next Question", JOptionPane.OK_CANCEL_OPTION);
					if (nextQuestion == JOptionPane.OK_OPTION){
						
						/*
						if (selectedAnswer == Integer.parseInt(questionMap.get(counter)[7])) {
							
							
							
							playerCorrectAnswers++;
						}
						*/
						
						feedback.newAnswer(Integer.parseInt(questionMap.get(counter)[0]), selectedAnswer);
						
						///////AMMK
						System.out.println(feedback.getFeedback(Integer.parseInt(questionMap.get(counter)[0]), selectedAnswer));
						
						Boolean feedbackCheck = (Boolean) feedback.getFeedback(Integer.parseInt(questionMap.get(counter)[0]), selectedAnswer).get(0);
						
						if (feedbackCheck == true) {
							playerCorrectAnswers++;
							feedbackText.setText("" + playerCorrectAnswers + "/" + (counter+1));
						}
						
						
						
						MainConstructor.wooshSound();
						cycleQuestion();
					}
					else {
						MainConstructor.clickSound();
					}
				}
				
			}
		});
		

	}
	
	public void style() {
		
		setBounds(100, 100, 799, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		MainConstructor.Logo(); //CODE TO CALL METHOD FROM MAIN (Main.JAVA) CLASS
		getContentPane().add(Main.logoImageAbc); //CALLS LOGO IMAGE VARIABLE FROM PREVIOUS CLASS
		contentPane.setLayout(null);
	
		logoPlay = new JLabel("QUESTION" + (counter+1) + "/" + questionMap.size());   //EASIER TO 
		logoPlay.setFont(new Font("MV Boli", Font.BOLD, 26));
		logoPlay.setHorizontalAlignment(SwingConstants.CENTER);
		logoPlay.setBounds(225, 11, 296, 50);
		getContentPane().add(logoPlay);
				
		labelQuestionTextArea = new JTextArea();
		labelQuestionTextArea.setBounds(280, 90, 500, 130);
		labelQuestionTextArea.setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelQuestionTextArea.setEditable(false);
		labelQuestionTextArea.setWrapStyleWord(true);
		labelQuestionTextArea.setLineWrap(true);
		contentPane.add(labelQuestionTextArea);
		
		//--------------------------------------------------------------------------------//
		// Radio Buttons //
		
		radio_1 = new JRadioButton("Barley");
		radio_1.setHorizontalAlignment(SwingConstants.CENTER);
		radio_1.setBackground(Color.WHITE);
		radio_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		radio_1.setBounds(45, 226, 692, 41);
		contentPane.add(radio_1);
		
		radio_2 = new JRadioButton("Wheat");
		radio_2.setHorizontalAlignment(SwingConstants.CENTER);
		radio_2.setBackground(Color.WHITE);
		radio_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		radio_2.setBounds(45, 270, 692, 41);
		contentPane.add(radio_2);
		
		radio_3 = new JRadioButton("Corn");
		radio_3.setHorizontalAlignment(SwingConstants.CENTER);
		radio_3.setBackground(Color.WHITE);
		radio_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		radio_3.setBounds(45, 314, 692, 41);
		contentPane.add(radio_3);
		
		radio_4 = new JRadioButton("Glitter");
		radio_4.setHorizontalAlignment(SwingConstants.CENTER);
		radio_4.setBackground(Color.WHITE);
		radio_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		radio_4.setBounds(45, 358, 692, 41);
		contentPane.add(radio_4);
		
		ButtonGroup radioAnswer = new ButtonGroup();
		radioAnswer.add(radio_1);
		radioAnswer.add(radio_2);
		radioAnswer.add(radio_3);
		radioAnswer.add(radio_4);
	
		/* STILL NEED TO ADD SOUNDS TO NEXT QUESTION BUTTON
		 * AND TO ADD WARNING DIALOG INCASE NO ANSWER HAS BEEN SELECTED "SKIP QUESTION"
		 */
		
		
		JButton menuButton = new JButton("Leave Quiz");
		menuButton.setBounds(10, 427, 101, 23);
		contentPane.add(menuButton);
		menuButton.setBackground(UIManager.getColor("activeCaption"));
		menuButton.setForeground(Color.BLACK);
		menuButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		menuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainConstructor.chimeSound();
				int leaveQuiz = JOptionPane.showConfirmDialog(null, "You are about to return to the main menu. \nThis will reset progress on your quiz.\n\nContinue?", "Return To Menu", JOptionPane.OK_CANCEL_OPTION);
				if (leaveQuiz == JOptionPane.OK_OPTION) {
					MainConstructor.wooshSound();
					dispose();
					StatisticsFrame statisticsConstructor = new StatisticsFrame(questionMap);
					statisticsConstructor.setVisible(true);
				}
				else {
					MainConstructor.clickSound();
				}
			}
		});
	}
	
	//--------------------------------------------------------------------------------//
	// Class Methods
	
	//Goes to the next question in the question set and updates the on screen text
	private static void cycleQuestion() {
		
		if (counter < questionMap.size() - 1) {
									
			//Retrieve the next question
			counter++;
			String[] question = questionMap.get(counter);

			logoPlay.setText("QUESTION" + (counter+1) + "/" + questionMap.size());
			MainConstructor.clickSound();
			labelQuestionTextArea.setText(question[1]);
			radio_1.setText(question[3]);
			radio_2.setText(question[4]);
			radio_3.setText(question[5]);
			radio_4.setText(question[6]);
			setQuestionImage();
			
		}
		else {
			
			//Reset the quiz
			playerCorrectAnswers = 0;
			counter = -1;
			cycleQuestion();
		}
	}
		
	private static void setQuestionImage() {

		if (questionMap.get(counter)[3] != null) {
			
			ImageIcon questionImageIcon = new ImageIcon(questionMap.get(counter)[2]);
			questionImage.setIcon(questionImageIcon);
		}	
	}
	
	private static HashMap<Integer, Integer> getCorrectAnswerMap() throws ClassNotFoundException, SQLException {
		
		//Generate a HashMap of Question ID to Correct Answer
		CachedRowSetImpl questionSet = question.SQLiteQuestionDatabaseManager.getQuestions(topicID);
		HashMap<Integer, Integer> correctAnswerMap = question.SQLiteQuestionDatabaseManager.generateCorrectAnswerMap(questionSet);
		questionSet.close();		
		return correctAnswerMap;
	}
	
}


/*
//INACTIVITY TIMER
Action logout = new AbstractAction()
{
	public void actionPerformed(ActionEvent e)
	{
		JPanel contentPane = (JPanel)e.getSource();
		int returnToMenu = JOptionPane.showConfirmDialog(null, "The system has detected prolonged inactivity. \nWould you like to return to the main menu?", "Return To Menu", JOptionPane.OK_CANCEL_OPTION);
		if (returnToMenu == JOptionPane.OK_OPTION) {
			dispose();
			Main mainConstructor = new Main();
			mainConstructor.frame.setVisible(true);
		}
	}
	
};


InactivityListener listener = new InactivityListener(frame, logout, 5);
listener.start();
		*/
