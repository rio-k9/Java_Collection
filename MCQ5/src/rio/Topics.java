package rio;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import Question.ResultSetManager;
import Question.SQLiteDB;
import Question.SQLiteQuestionDatabaseManager;

import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.ButtonGroup;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;

public class Topics extends JFrame {

	
	/*
	 *  @author Rio Karim
	 * 
	 */
	
	JPanel contentPane;
	JTable table;
	JTextField QuestionField;
	JTextField AnswerField_1;
	JTextField AnswerField_2;
	JTextField AnswerField_3;
	JTextField AnswerField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Topics contentPane = new Topics();
					contentPane.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	Main MainConstructor = new Main();
	@SuppressWarnings("serial")
	public Topics() throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent we)
		    { 
		        String exitButtons[] = {"Exit","Return"};
		        MainConstructor.chimeSound();
		        int exitAttempt = JOptionPane.showOptionDialog(null,"Are you sure you wish to exit?","Exit Warning",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,exitButtons,exitButtons[1]);
		        if(exitAttempt == JOptionPane.YES_OPTION)
		        {	
			        MainConstructor.clickSound();
		            System.exit(0);
		        }
		    }
		});
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		MainConstructor.Logo();
		getContentPane().add(Main.logoImageAbc); //CALLS LOGO IMAGE VARIABLE FROM PREVIOUS CLASS

		
		
		
		
		JButton buttonBack = new JButton("Back");
		buttonBack.setBounds(486, 427, 89, 23);
		contentPane.add(buttonBack);
		buttonBack.setBackground(UIManager.getColor("activeCaption"));
		buttonBack.setForeground(Color.BLACK);
		buttonBack.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buttonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

					
				
					MainConstructor.wooshSound();
					dispose();
					Main mainConstructor = new Main();
					mainConstructor.frame.setVisible(true);

				
				
			}
		});
		
		
		JLabel logoMainMenu = new JLabel("TOPICS");   //EASIER TO 
		logoMainMenu.setFont(new Font("MV Boli", Font.BOLD, 26));
		logoMainMenu.setHorizontalAlignment(SwingConstants.CENTER);
		logoMainMenu.setBounds(200, 30, 200, 50);
		contentPane.add(logoMainMenu);
		

		
		
		SQLiteQuestionDatabaseManager DBSync = new SQLiteQuestionDatabaseManager("QuestionDB");
		
		ResultSet resTop = DBSync.getTopics();
		
		resTop.next();
		String first = resTop.getString("TopicName");
		resTop.next();
		String second = resTop.getString("TopicName");
		
		//sqlConstructor.addTopic("User Input");
		//sqlConstructor.addTopic("Another Input");
		
		//resTop.next();
		String third = "Placeholder";
		//resTop.next();
		String fourth = "Placeholder";
		//resSet.first();
		
		
		
		ResultSet Q1_res = DBSync.getQuestions(2);
		HashMap<Integer,Object> Q1_output = new HashMap<Integer,Object>();
		Q1_output = ResultSetManager.resultSetToMap(Q1_res);
		Object[] Q1_Array = (Object[]) Q1_output.get(0);
		
		//QuestionID
		//System.out.println(Q1_Array[0]);
		String Q1_ID = Q1_Array[0].toString();
		System.out.println(Q1_ID);
		
		//Question text
		System.out.println(Q1_Array[1]);
		String Q1_AT = Q1_Array[1].toString();
		System.out.println(Q1_AT);
		
		//Question Image
		System.out.println(Q1_Array[2]);
		//BufferedImage Q1_IMG = Q1_Array[2];
		//System.out.println(Q1_IMG);
		//AS IMAGE IS NULL THIS IS COMMENTED OUT
		
		
		//Option1
		//System.out.println(Q1_Array[3]);
		String Q1_A1 = Q1_Array[3].toString();
		System.out.println(Q1_A1);
		
		//Option2
		//System.out.println(Q1_Array[4]);
		String Q1_A2 = Q1_Array[4].toString();
		System.out.println(Q1_A2);
		
		//Option3
		//System.out.println(Q1_Array[5]);
		String Q1_A3 = Q1_Array[5].toString();
		System.out.println(Q1_A3);
		
		//Option4
		//System.out.println(Q1_Array[6]);
		String Q1_A4 = Q1_Array[6].toString();
		System.out.println(Q1_A4);
		
		//Correct Answer
		//System.out.println(Q1_Array[7]);
		String Q1_AA = Q1_Array[7].toString();
		System.out.println(Q1_AA);
		
		
		
		
		ResultSet Q2_res = DBSync.getQuestions(2);
		HashMap<Integer,Object> Q2_output = new HashMap<Integer,Object>();
		Q2_output = ResultSetManager.resultSetToMap(Q2_res);
		Object[] Q2_Array = (Object[]) Q2_output.get(1);
		
		//QuestionID
		//System.out.println(Q1_Array[0]);
		String Q2_ID = Q2_Array[0].toString();
		System.out.println(Q1_ID);
		
		//Question text
		System.out.println(Q2_Array[1]);
		String Q2_AT = Q2_Array[1].toString();
		System.out.println(Q2_AT);
		
		//Question Image
		System.out.println(Q2_Array[2]);
		//BufferedImage Q1_IMG = Q1_Array[2];
		//System.out.println(Q1_IMG);
		//AS IMAGE IS NULL THIS IS COMMENTED OUT
		
		
		//Option1
		//System.out.println(Q1_Array[3]);
		String Q2_A1 = Q2_Array[3].toString();
		System.out.println(Q2_A1);
		
		//Option2
		//System.out.println(Q1_Array[4]);
		String Q2_A2 = Q2_Array[4].toString();
		System.out.println(Q2_A2);
		
		//Option3
		//System.out.println(Q1_Array[5]);
		String Q2_A3 = Q2_Array[5].toString();
		System.out.println(Q2_A3);
		
		//Option4
		//System.out.println(Q1_Array[6]);
		String Q2_A4 = Q2_Array[6].toString();
		System.out.println(Q2_A4);
		
		//Correct Answer
		//System.out.println(Q1_Array[7]);
		String Q2_AA = Q2_Array[7].toString();
		System.out.println(Q2_AA);
		
		
		ResultSet Q3_res = DBSync.getQuestions(2);
		HashMap<Integer,Object> Q3_output = new HashMap<Integer,Object>();
		Q3_output = ResultSetManager.resultSetToMap(Q3_res);
		Object[] Q3_Array = (Object[]) Q3_output.get(1);   //NEED MORE QUESTIONS ADDED HERE
		
		//QuestionID
		//System.out.println(Q1_Array[0]);
		String Q3_ID = Q3_Array[0].toString();
		System.out.println(Q1_ID);
		
		//Question text
		System.out.println(Q3_Array[1]);
		String Q3_AT = Q3_Array[1].toString();
		System.out.println(Q3_AT);
		
		//Question Image
		System.out.println(Q3_Array[2]);
		//BufferedImage Q1_IMG = Q1_Array[2];
		//System.out.println(Q1_IMG);
		//AS IMAGE IS NULL THIS IS COMMENTED OUT
		
		
		//Option1
		//System.out.println(Q1_Array[3]);
		String Q3_A1 = Q3_Array[3].toString();
		System.out.println(Q3_A1);
		
		//Option2
		//System.out.println(Q1_Array[4]);
		String Q3_A2 = Q3_Array[4].toString();
		System.out.println(Q3_A2);
		
		//Option3
		//System.out.println(Q1_Array[5]);
		String Q3_A3 = Q3_Array[5].toString();
		System.out.println(Q3_A3);
		
		//Option4
		//System.out.println(Q1_Array[6]);
		String Q3_A4 = Q3_Array[6].toString();
		System.out.println(Q3_A4);
		
		//Correct Answer
		//System.out.println(Q1_Array[7]);
		String Q3_AA = Q3_Array[7].toString();
		System.out.println(Q3_AA);
		
		//BEFORE I CAN DO THIS I NEED TO RE - ADD MY RESULT SET TYPE DECLARATIONS 
		/* Statement stmt = conn.createStatement (ResultSet.CONCUR_UPDATABLE
		 * 										ResultSet.TYPE_SCROLL_SENSITIVE);
		 * }
		 * 
		 * 
		 * 
		 */
		
		
		
		JButton button_1 = new JButton(first);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		button_1.setBounds(372, 107, 203, 41);
		contentPane.add(button_1);
		
		
		JButton button_2 = new JButton(second);
		button_2.setBounds(372, 159, 203, 43);
		contentPane.add(button_2);
		

		JButton button_3 = new JButton(third);
		button_3.setBounds(372, 213, 203, 40);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton(fourth);
		button_4.setBounds(372, 264, 203, 41);
		contentPane.add(button_4);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(20, 85, 342, 220);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Q#       ||     Questions", null, panel, null);
		
		
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(table);
		table.setToolTipText("aaa");
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{Q1_ID, Q1_AT},
				{Q2_ID, Q2_AT},
				{Q3_ID, Q3_AT},
				{4, "q4"},
				{5, "q5"},
				{6, "q6"},
				{7, null},
				{8, null},
				{9, null},
				{10, null},
			},
			new String[] {
				"#", "Question"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		/*
		JButton save = wadawdadaaa
				action event {
			
		}
		String newQuestionText = QuestionField.getText();
	}
	AdamsMethod(String newQuestionText);
	
	String 
	*/
		
		//Qtextfield
		
		/*
		upon button click
		adamQ = Qtextfield.getText()
				sqllitedb.editQuestion("QuestionText", adamQ, "SLIDE OR DROP BOX INTEGER VARIABLE FOR !!QUESTION ID!!")
		*/
		
		/*
		 * upon button click
		String adamA1 = A1textfield.getText()
		
				if ( adams text != my text) {
				sqllitedb.editQuestion("Option1", adamA1, "SLIDE OR DROP BOX INTEGER VARIABLE FOR !!!QUESTION ID!!!")
				}
				else nothing
				
				FOR CORRECT CHANGE
				
				int radio_1 = 1
				int radio_2 = 2
				int radio_3 = 3
				int radio_4 = 4
				sqllitedb.editQuestion("CorrectAnswer", radio_3, "SLIDE OR DROP BOX INTEGER VARIABLE FOR !!!QUESTION ID!!!")
		 */
		QuestionField = new JTextField();
		
		QuestionField.setBounds(20, 367, 342, 20);
		contentPane.add(QuestionField);
		QuestionField.setColumns(10);
		
		AnswerField_1 = new JTextField();
		AnswerField_1.setColumns(10);
		AnswerField_1.setBounds(20, 398, 160, 20);
		contentPane.add(AnswerField_1);
		
		AnswerField_2 = new JTextField();
		AnswerField_2.setColumns(10);
		AnswerField_2.setBounds(213, 398, 149, 20);
		contentPane.add(AnswerField_2);
		
		AnswerField_3 = new JTextField();
		AnswerField_3.setColumns(10);
		AnswerField_3.setBounds(20, 429, 160, 20);
		contentPane.add(AnswerField_3);
		
		AnswerField_4 = new JTextField();
		AnswerField_4.setColumns(10);
		AnswerField_4.setBounds(213, 429, 149, 20);
		contentPane.add(AnswerField_4); 
		
		JRadioButton correct_1 = new JRadioButton("");
		correct_1.setBounds(186, 394, 21, 23);
		contentPane.add(correct_1 );
		
		JRadioButton correct_2 = new JRadioButton("");
		correct_2.setBounds(186, 428, 21, 23);
		contentPane.add(correct_2);
		
		JRadioButton correct_3 = new JRadioButton("");
		correct_3.setBounds(368, 427, 21, 23);
		contentPane.add(correct_3);
		
		JRadioButton correct_4 = new JRadioButton("");
		correct_4.setBounds(368, 395, 21, 23);
		contentPane.add(correct_4);
		
		ButtonGroup correctAnswer = new ButtonGroup();
		correctAnswer.add(correct_1);
		correctAnswer.add(correct_2);
		correctAnswer.add(correct_3);
		correctAnswer.add(correct_4);
		
		
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 1, 10, 1);
		slider.setMinorTickSpacing(0);
		slider.setMajorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setLabelTable(slider.createStandardLabels(1));
		slider.setMaximum(10);
		slider.setMinimum(1);
		slider.setBounds(20, 315, 342, 41);
		contentPane.add(slider);
		
		
		ImageIcon saveimageIcon = new ImageIcon(Topics.class.getResource("/img/save.png"));
		//CODE FOR RESIZE
		Image saveimage = saveimageIcon.getImage(); // transform it 
		Image savenewimg = saveimage.getScaledInstance(33, 33,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		saveimageIcon = new ImageIcon(savenewimg);  // transform it back
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(saveimageIcon);
		btnNewButton.setBounds(372, 316, 57, 51);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				System.out.println(QuestionField.getText());
				System.out.println(AnswerField_1.getText());
				System.out.println(AnswerField_2.getText());
				System.out.println(AnswerField_3.getText());
				System.out.println(AnswerField_4.getText());
				
				if (correct_1.isSelected()){
					System.out.println("Saving correct answer: " + AnswerField_1.getText());
				}
				else if (correct_2.isSelected()){
					System.out.println("Saving correct answer: " + AnswerField_2.getText());
				}
				else if (correct_3.isSelected()){
					System.out.println("Saving correct answer: " + AnswerField_3.getText());
				}
				else if (correct_4.isSelected()){
					System.out.println("Saving correct answer: " + AnswerField_4.getText());
				}
			}
		});
		
		
		
		
		
		
		
		table.getColumnModel().getColumn(0).setMinWidth(46);
		table.getColumnModel().getColumn(0).setMaxWidth(0);
		table.getColumnModel().getColumn(1).setPreferredWidth(281);
		
		slider.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e) {
				
			
				switch (((JSlider)e.getSource()).getValue()) {
				
				case 1: QuestionField.setText(Q1_AT);
						AnswerField_1.setText(Q1_A1);
						AnswerField_2.setText(Q1_A2);
						AnswerField_3.setText(Q1_A3);
						AnswerField_4.setText(Q1_A4);
						break;
						
				case 2: QuestionField.setText(Q2_AT);
						AnswerField_1.setText(Q2_A1);
						AnswerField_2.setText(Q2_A2);
						AnswerField_3.setText(Q2_A3);
						AnswerField_4.setText(Q2_A4);
						break;
						
				default: QuestionField.setText("Please use the slider");
						break;	
				
				
				}
				
			}
				//QuestionField.setText("Question Text : " + ((JSlider)e.getSource()).getValue() );
		});
		
		
		
}
}
