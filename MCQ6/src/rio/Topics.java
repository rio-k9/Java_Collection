package rio;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import Question.SQLiteQuestionDatabaseManager;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.sun.rowset.CachedRowSetImpl;
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
	Object[][] tableData;
	JTextField QuestionField;
	JTextField AnswerField_1;
	JTextField AnswerField_2;
	JTextField AnswerField_3;
	JTextField AnswerField_4;
	Integer topicID;

	SQLiteQuestionDatabaseManager DBSync;
	
	public HashMap<Integer, String[]> questionMap;
	public CachedRowSetImpl questionsCrs;

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
		
		/*---- Database Initialization ----*/
		
		//Instantiate database object
		DBSync = new SQLiteQuestionDatabaseManager("QuestionDB");
		
		//Retrieve the topics as a CachedRowSetImpl object
		CachedRowSetImpl topicsCrs = DBSync.getTopics();
		
		//Convert the CachedRowSetImpl to a HashMap
		HashMap<Integer, String[]> topicsMap = Question.ResultSetUtils.CachedRowSetImplToMap(topicsCrs);
		
		//Default retrieve questions of History of Computing as an initial, default topic
		topicID = 2;
		questionsCrs = DBSync.getQuestions(topicID);
		
		//Convert the CachedRowSetImpl to a HashMap
		//HashMap<Integer, String[]> questionMap = Question.ResultSetUtils.CachedRowSetImplToMap(questionsCrs);
		questionMap = Question.ResultSetUtils.CachedRowSetImplToMap(questionsCrs);
		
		/*---- Topics Buttons ----*/
		
		JPanel topicsButtonContainer = new JPanel();
		topicsButtonContainer.setBounds(372, 107, 203, 120);
		
		for (Integer key : topicsMap.keySet()) {
			
			String[] topicArray = topicsMap.get(key);
			
			JButton topicButton = new JButton(topicArray[1]);
			topicButton.addActionListener(e -> {
				
				topicID = Integer.parseInt(topicArray[0]);
				
				try {
					refreshData(Integer.parseInt(topicArray[0]));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});	
			
			topicsButtonContainer.add(topicButton);
		}
		
		contentPane.add(topicsButtonContainer);
		
		/*
		JButton button_1 = new JButton();
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		button_1.setBounds(372, 107, 203, 41);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton();
		button_2.setBounds(372, 159, 203, 43);
		contentPane.add(button_2);

		JButton button_3 = new JButton();
		button_3.setBounds(372, 213, 203, 40);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton();
		button_4.setBounds(372, 264, 203, 41);
		contentPane.add(button_4);
		*/
		
		
		/*---- Question Table ----*/
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(20, 85, 342, 220);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Q#       ||     Questions", null, panel, null);
		
		
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(table);
		table.setToolTipText("aaa");
		
		tableData = getTableData(questionMap);
		setTableData();
		
		
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
		
		//Fields for the question information
		
		QuestionField = new JTextField();
		QuestionField.setBounds(20, 367, 342, 20);
		contentPane.add(QuestionField);
		QuestionField.setColumns(10);
		QuestionField.setText("Please use the slider to select the question");
		
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
		
		/*-- Radio buttons for answer input --*/
		
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
		
		/*-- Slider --*/
		
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 1, 10, 1);
		slider.setMinorTickSpacing(0);
		slider.setMajorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setLabelTable(slider.createStandardLabels(1));
		slider.setMaximum(10);
		slider.setMinimum(1);
		slider.setBounds(20, 315, 342, 41);
		slider.setValue(1);
		contentPane.add(slider);
		
		/*-- Save Button --*/
		
		//Retrieve and transform the image for the button icon
		ImageIcon saveimageIcon = new ImageIcon(Topics.class.getResource("/img/save.png"));
		Image saveimage = saveimageIcon.getImage(); // transform it 
		Image savenewimg = saveimage.getScaledInstance(33, 33,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		saveimageIcon = new ImageIcon(savenewimg);  // transform it back
		
		//Create the save button and set the image
		JButton saveButton = new JButton("");
		saveButton.setIcon(saveimageIcon);
		saveButton.setBounds(372, 316, 57, 51);
		contentPane.add(saveButton);
		
		//Add the event handler for the save button
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Get the contents of the ID column of the table using the slider position as a row index
				String selectedQuestionID = (String) table.getModel().getValueAt(slider.getValue()-1, 0);
				
				//Update the database	
				
				try {
					DBSync.editQuestion("QuestionText", QuestionField.getText(), Integer.valueOf(selectedQuestionID));
					DBSync.editQuestion("Option1", AnswerField_1.getText(), Integer.valueOf(selectedQuestionID));
					DBSync.editQuestion("Option2", AnswerField_2.getText(), Integer.valueOf(selectedQuestionID));
					DBSync.editQuestion("Option3", AnswerField_3.getText(), Integer.valueOf(selectedQuestionID));
					DBSync.editQuestion("Option4", AnswerField_4.getText(), Integer.valueOf(selectedQuestionID));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//Refresh the table
				try {
					refreshData(topicID);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		});
				
		slider.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e) {
			
				//Get the slider position
				int sliderIndex = (((JSlider)e.getSource()).getValue());
				
				//Use the slider position to retrieve the question data
				Object[] sliderData = (Object[]) questionMap.get(sliderIndex-1);
				
				//Not sure what this does, I probably removed it by accident
				//questionID = Integer.parseInt(Q1_ID);
				
				QuestionField.setText((String) sliderData[1]);
				AnswerField_1.setText((String) sliderData[3]);
				AnswerField_2.setText((String) sliderData[4]);
				AnswerField_3.setText((String) sliderData[5]);
				AnswerField_4.setText((String) sliderData[6]);
			}
		});			
	}
	
	private void refreshData(Integer topicID) throws SQLException, ClassNotFoundException {
		
		//Close the previous questionCrs and generate a new one
		questionsCrs.close();
		questionsCrs = DBSync.getQuestions(topicID);
		questionMap = Question.ResultSetUtils.CachedRowSetImplToMap(questionsCrs);
		
		//Re-set the table data and refresh the table
		tableData = getTableData(questionMap);
		setTableData();
		table.validate();
		table.repaint();	
	}
	
	
	
	private static Object[][] getTableData(HashMap<Integer, String[]> questionMap) {
		//Get the number of questions in the retrieved topic
		int qCount = questionMap.size();
		
		//Create an array of objects to store the table data
		Object[][] tableData = new Object[qCount][2];
		
		//Run a loop for i in range of the number of questions in the topic
		for (int i=0; i < qCount; i++) {
			
			//Get the question from the topic
			Object[] question = (Object[]) questionMap.get(i);
			
			//Add the questionID
			tableData[i][0] = question[0];
			
			//Add the questionText
			tableData[i][1] = question[1];
		}
		
		return tableData;
	}
	
	private void setTableData() {
		//Create an Array for the column names
		table.setModel(new DefaultTableModel(
				
				//Use the tableData array to add data to the table
				tableData,
				
				//Create a new String array to add the headings to the table
				new String[] {
					"#", "Question"
				})
			 {
				Class[] columnTypes = new Class[] {
					String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
		
		table.getColumnModel().getColumn(0).setMinWidth(46);
		table.getColumnModel().getColumn(0).setMaxWidth(0);
		table.getColumnModel().getColumn(1).setPreferredWidth(281);
	}
	
}