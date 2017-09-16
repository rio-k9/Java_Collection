package rio;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
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
	public JPanel Qpanel;
	static JScrollPane scrollPane;
	static JLabel labelQuestion;
	static String radioText;
	public static int counter = 0;
	public int selectedAnswer;
	private static int playerCorrectAnswers = 0;
	public static JLabel questionImage  = new JLabel();
	
	/**
	 * Launch the application window.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Play frame = new Play(null);
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
	public Play(HashMap<Integer, String[]> questionMap) {
		
		this.questionMap = questionMap;
		
		System.out.println(questionMap);
		style();
		String[] question = questionMap.get(0);
		labelQuestion.setText(question[1]);  //QUESTION TEXT
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
		questionImage.setBounds(51, 49, 175, 175);
		contentPane.add(questionImage);
		setQuestionImage();
		

		
		
		//NEXT BUTTON AND RADIO BUTTON LISTENERS
		JButton buttonNext = new JButton("Next Question");
		buttonNext.setMargin(new Insets(2, 5, 2, 5));
		buttonNext.setHorizontalTextPosition(SwingConstants.LEADING);
		buttonNext.setIconTextGap(10);
		buttonNext.setIcon(new ImageIcon("src/img/next.png")); //STYLING FOR NEXT BUTTON
		
		buttonNext.setFont(new Font("MV Boli", Font.PLAIN, 16));
		buttonNext.setBounds(605, 417, 168, 41);
		contentPane.add(buttonNext);
		
		buttonNext.addActionListener(new ActionListener() { //NEXT LISTENER
			
			public void actionPerformed(ActionEvent arg0) {
				
				radioText = "";
				if (radio_1.isSelected()){
					radioText = radio_1.getText();
					selectedAnswer = 1;
					System.out.println(selectedAnswer);
					

				}
				else if (radio_2.isSelected()){
					radioText = radio_2.getText();
					selectedAnswer = 2;
					System.out.println(selectedAnswer);

				}
				else if (radio_3.isSelected()){
					radioText = radio_3.getText();
					selectedAnswer = 3;
					System.out.println("selectedAnswer:" + selectedAnswer);

				}
				else if (radio_4.isSelected()){
					radioText = radio_4.getText();
					selectedAnswer = 4;
					System.out.println(selectedAnswer);

				}
	
				
				//IF RADIO TEXT IS EMPTY STRING, RETURN AS NO ANSWER SELECTED
				if ((radioText == "") || (radioText == null)) {
					int skipQuestion = JOptionPane.showConfirmDialog(null, "You have not selected an answer, if you skip to the next question you will lose a mark.", "Next Question", JOptionPane.OK_CANCEL_OPTION);
					if (skipQuestion == JOptionPane.OK_OPTION){
						cycleQuestion();
						MainConstructor.wooshSound();
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
						
						System.out.println("CorrectAnswewr:"+ questionMap.get(counter)[7]);
						
						if (selectedAnswer == Integer.parseInt(questionMap.get(counter)[7])) {
							System.out.println("treu");
							playerCorrectAnswers++;
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
	
	public void style(){
	setBounds(100, 100, 799, 501);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	contentPane.setBackground(Color.WHITE);
	setContentPane(contentPane);
	contentPane.setLayout(null);

	MainConstructor.Logo(); //CODE TO CALL METHOD FROM MAIN (Main.JAVA) CLASS
	getContentPane().add(Main.logoImageAbc); //CALLS LOGO IMAGE VARIABLE FROM PREVIOUS CLASS
	contentPane.setLayout(null);

	
	
	
	/*
	 * String[] question = questionMap.get(0);  (0 - 9) assigning each question array 1 - 10
	 * question[2]
	 */

	
	/*
	 * int QLabel = 1
	 * QLabel++
	 */
	logoPlay = new JLabel("QUESTION" + (counter+1) + "/" + questionMap.size());   //EASIER TO 
	logoPlay.setFont(new Font("MV Boli", Font.BOLD, 26));
	logoPlay.setHorizontalAlignment(SwingConstants.CENTER);
	logoPlay.setBounds(225, 11, 296, 50);
	getContentPane().add(logoPlay);
	
	
	/*
	 * String[] question = questionMap.get(0);  (0 - 9)
	 * question[1]
	 */
	Qpanel = new JPanel();
	Qpanel.setBounds(267, 89, 506, 130);
	contentPane.add(Qpanel);
	Qpanel.setLayout(null);
	
	scrollPane = new JScrollPane();
	scrollPane.setBounds(0, 0, 506, 130);
	Qpanel.add(scrollPane);

	labelQuestion = new JLabel(" ", JLabel.CENTER);
	scrollPane.setViewportView(labelQuestion);
	labelQuestion.setHorizontalAlignment(SwingConstants.CENTER);
	labelQuestion.setFont(new Font("Tahoma", Font.PLAIN, 20));
	labelQuestion.setBounds(238, 110, 315, 180);


	
	/*
	 * String[] question = questionMap.get(0);  (0 - 9)
	 * question[3]
	 */
	radio_1 = new JRadioButton("Barley");
	radio_1.setHorizontalAlignment(SwingConstants.CENTER);
	radio_1.setBackground(Color.WHITE);
	radio_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
	radio_1.setBounds(45, 226, 692, 41);
	contentPane.add(radio_1);
	
	/*
	 * String[] question = questionMap.get(0);  (0 - 9)
	 * question[4]
	 */
	radio_2 = new JRadioButton("Wheat");
	radio_2.setHorizontalAlignment(SwingConstants.CENTER);
	radio_2.setBackground(Color.WHITE);
	radio_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
	radio_2.setBounds(45, 270, 692, 41);
	contentPane.add(radio_2);
	
	/*
	 * String[] question = questionMap.get(0);  (0 - 9)
	 * question[5]
	 */
	radio_3 = new JRadioButton("Corn");
	radio_3.setHorizontalAlignment(SwingConstants.CENTER);
	radio_3.setBackground(Color.WHITE);
	radio_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
	radio_3.setBounds(45, 314, 692, 41);
	contentPane.add(radio_3);
	
	/*
	 * String[] question = questionMap.get(0);  (0 - 9)
	 * question[6]
	 */
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
	
	
	JButton buttonMenu = new JButton("Main Menu");
	buttonMenu.setBounds(10, 427, 101, 23);
	contentPane.add(buttonMenu);
	buttonMenu.setBackground(UIManager.getColor("activeCaption"));
	buttonMenu.setForeground(Color.BLACK);
	buttonMenu.setFont(new Font("Tahoma", Font.PLAIN, 12));
	buttonMenu.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			MainConstructor.chimeSound();
			int returnToMenu = JOptionPane.showConfirmDialog(null, "You are about to return to the main menu. \nThis will reset progress on your quiz.\n\nContinue?", "Return To Menu", JOptionPane.OK_CANCEL_OPTION);
			if (returnToMenu == JOptionPane.OK_OPTION) {
				MainConstructor.wooshSound();
				dispose();
				Main mainConstructor = new Main();
				mainConstructor.frame.setVisible(true);
			}
			else {
				MainConstructor.clickSound();
			}
		}
	});
}
	
	public static void cycleQuestion() {
		
		if (counter < questionMap.size() - 1) {
			counter++;
			MainConstructor.clickSound();
			String[] question = questionMap.get(counter);
			labelQuestion.setText(question[1]);
			radio_1.setText(question[3]);
			radio_2.setText(question[4]);
			radio_3.setText(question[5]);
			radio_4.setText(question[6]);
			setQuestionImage();
			System.out.println(playerCorrectAnswers);
		}
		else {
			counter = 0;
			
			cycleQuestion();
		}

	}
	
	public static void setQuestionImage() {

		if (questionMap.get(counter)[3] != null) {
			
			System.out.println(questionMap.get(counter)[2]);
			
			ImageIcon questionImageIcon = new ImageIcon(questionMap.get(counter)[2]);
			questionImage.setIcon(questionImageIcon);
			
			//questionImage.setIcon(preloadedImages.get(0));
			
			//ImageIcon imgSettings = new ImageIcon("file: " + questionMap.get(counter)[3]);
			//Image image = imgSettings.getImage();
			//Image newimg = image.getScaledInstance(180, 180,  java.awt.Image.SCALE_SMOOTH);
			//imgSettings = new ImageIcon(newimg);
			//questionImage.setIcon(imgSettings);
		}
		else {
			
		}
		
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
