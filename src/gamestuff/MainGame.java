/*
 * ========================================================================================================
 * 
 * Project name: Type That Text
 * 
 * ========================================================================================================
 */

package gamestuff;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.util.Random;


public class MainGame extends JFrame
{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txtDisplayCharacters;
	private JTextField txtWriteHere;
	private JTextField txtPoints;
	private JTextField textFieldTimeRem;
	
	// --| ===============================================================
	
	// --| Create some variables where will get/display player level and points
	
	public int PlayerPoints = 0;
	public int PlayerLevel = 0;
	
	// --| Some null string where will store something that will need
	
	public String LevelToStr = "";
	public String WhatPlayerWrote = "";
	
	// --| A boolean for getting if game was started or not
	public boolean bGameStarted = false;
	
	// --| Counter for timer
	public int CountDown = 0;

	// --| Maximum consecutive correct answers to win
	public int MaxCorrectAnswersToWin = 15;
	
	// --| Player consecutive answers count
	public int ConsecutiveAnswers = 0;
	
	// --| Player max score counter
	public int MaximumScore = 0;
	
	// --| ===============================================================
	
	
	// --| Level 1 of Difficulty Easy: Display Numbers from 1 to 10
	public int[] Numbers = 
	{
		0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
		11, 12, 13, 14, 15, 16, 17, 18, 19, 20
	};
		
	// --| Level 2 of Difficulty Normal: Display Alphabet Letters
	public String[ ] AlphabetLetters = 
	{
		"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", 
		"m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"
	};
	
	// --| Level 3 of Difficulty Advanced: Display Special Characters
	public String[ ] SpecialChars =
	{
			"!", "£", "$", "%", "^", "&", "*", "(", ")", "-", "=", "+",
			"£$%", "&&^%", "(($%£", "_+^$", 
			"£$%^", "***", "*&)*+", "+-=!", "$!!%^^",
			"&%$$$$", "£$%%^%$", "^^£££===", "_£!%£$"
	};
	
	// --| Level 4 of Difficulty Hard: Display Words
	// --| Words generated from http://listofrandomwords.com/ 
	// --| They may be wrong but it is just a game
	public String[ ] SpecialWords =
	{
			"choreal", "secam", "bashfully", "nipper", "acrophobia", "xanthoma", "rutty", "retrogradingly", 
			"titanous", "isosceles", "unvisualised", "nonequal", "metaphysical", "transnationally", "elicit", "expiration",
			"vastus", "snaring", "prelabeled", "helix", "overnervous", "autobahns", "unpassionate", "solfataric", "questionably",
			"autotroph", "unsweltering", "diversionary", "distally", "heliotaxis", "canthus", "objurgatorily", "spicey", "reallegation",
			"rufescence", "intellectualistic", "refired", "unsubrogated", "oppression", "archangelic", "birdbrain"
	};
	
	
	// --| Level 5 of Difficulty Expert: Display Whole Sentences
	// --| The sentences was generated from http://www.wordgenerator.net/random-sentence-generator.php
	// --| They may be wrong but it is just a game :D
	public String[ ] Sentences =
	{
			"The idea negotiates the servant#", "The statuesque porter enables the profit!", "The moaning burn translates the country.",
			"The advertisement inventorys the barbarous body!", "The chance proposes the known smile :)", "The music applys the vague side?!?!",
			"The enchanted story stimulates the cloth.", "The sugar organizes the trouble.", "The unhealthy play set goalss the summer! :(",
			"The even soup moderates the force.", "The smelly year rans the advertisement.", "The committee debates the acidic protest!!!",
			"The end unifys the free year...", "The peace verifys the fluffy comparison.", "The tax encourages the imminent advertisement.",
			"The pleasant committee reinforces the turn", "The overrated discovery observes the mine.", "The cotton methodizes the person."
			
	};
	
	private JTextField txtCurLevel;
	private JTextField textFieldRecord;
	
	/**
	 * --| Launch the application.
	 */
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					MainGame frame = new MainGame();
					
					frame.setVisible(true);
					
					// --| Disable maximize button and the frame can't be resized
					// --| Set frame default location to center of screen
					
					frame.setResizable( false );
					frame.setLocationRelativeTo( null );
					
				} 
				
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * --| Create the frame.
	 */
	public MainGame()
	{
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 471, 694);
		
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 160, 122));
		contentPane.setToolTipText("");
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBackground(UIManager.getColor("activeCaption"));
		
		JLabel lblNewLabel_2 = new JLabel("Type this:");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBackground(new Color(255, 69, 0));
		lblNewLabel_2.setFont(new Font("Ravie", Font.BOLD, 20));
		
		txtDisplayCharacters = new JTextField();
		txtDisplayCharacters.setEditable(false);
		txtDisplayCharacters.setForeground(new Color(0, 0, 0));
		txtDisplayCharacters.setBackground(new Color(192, 192, 192));
		txtDisplayCharacters.setHorizontalAlignment(SwingConstants.CENTER);
		txtDisplayCharacters.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txtDisplayCharacters.setColumns(10);
		
		// --| If player press exit button, let's show him our second frame named Exit, wich will not redirect user
		// --| to the select difficulty frame
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Exit.main( null );
			}
		});
		
		btnExit.setForeground(new Color(255, 0, 0));
		btnExit.setFont(new Font("Ravie", Font.BOLD, 11));
		btnExit.setBackground(new Color(0, 0, 0));

		// --| When the user choose a different difficulty, let's show him a popup and reset the stats
		final JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItemListener(new ItemListener()
		{
				// --| If game is started, and player click on combobox, let's force him to stop the game first,
				// --| then select the difficulty level
				public void itemStateChanged(ItemEvent arg0)
				{
					int ComboBoxState = comboBox.getSelectedIndex();
						
					if( ComboBoxState == 0 )
					{
						PlayerLevel = 0;
						PlayerPoints = 0;
							
						LevelToStr = "";
						txtCurLevel.setText(LevelToStr);
						txtPoints.setText("0");
					}
						
					// --| Level 1 = Easy selected
					else if( ComboBoxState == 1 )
					{
						PlayerLevel = 1;
						PlayerPoints = 0;
							
						LevelToStr = "Easy";
						txtCurLevel.setText(LevelToStr);
						txtPoints.setText("0");
					}

					// --| Level 2 = Normal selected
					else if( ComboBoxState == 2 )
					{
						PlayerLevel = 2;
						PlayerPoints = 0;
							
						LevelToStr = "Normal";
						txtCurLevel.setText(LevelToStr);
						txtPoints.setText("0");
					}
						
					// --| Level 3 = Advanced selected
					else if( ComboBoxState == 3 )
					{
						PlayerLevel = 3;
						PlayerPoints = 0;
							
						LevelToStr = "Advanced";
						txtCurLevel.setText(LevelToStr);
						txtPoints.setText("0");
					}
						
					// --| Level 4 = Hard selected
					else if( ComboBoxState == 4 )
					{
						PlayerLevel = 4;
						PlayerPoints = 0;
							
						LevelToStr = "Hard";
						txtCurLevel.setText(LevelToStr);
						txtPoints.setText("0");
					}
						
					// --| Level 5 = Expert selected
					else if( ComboBoxState == 5 )
					{
						PlayerLevel = 5;
						PlayerPoints = 0;
							
						LevelToStr = "Expert";
						txtCurLevel.setText(LevelToStr);
						txtPoints.setText("0");
					}
				}
		});
				
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Difficulty?", "Easy", "Normal", "Advanced", "Hard", "Expert"}));
		comboBox.setSelectedIndex(0);
		comboBox.setForeground(Color.BLUE);
		comboBox.setFont(new Font("Ravie", Font.BOLD, 11));
				
		// --| When clicked on textbox/textbox gain focus, let's select all the text inside and provide user a simple write and press enter thing
		txtWriteHere = new JTextField();
		txtWriteHere.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyPressed(KeyEvent arg0)
			{
				// --| Check if ENTER KEY was HIT, and check if user wrote the correct values
				int key = arg0.getKeyCode();  
				
	            if( key == KeyEvent.VK_ENTER )
	            {
	            	// --| Level 1 Easy
	            	if( PlayerLevel == 1 )
					{
	            		// --| Check if answer is correct
	            		String TextUp = txtDisplayCharacters.getText();
	            		String TextBoxAnswer = txtWriteHere.getText();
	            		
	            		// --| Add player points according to level 
	            		if( TextBoxAnswer.equals( TextUp ) )
	            		{
	            			PlayerPoints += 1;
	            			
	            			// =============================================================================================
	            			// --| Player won the game!!!!
	            			// =============================================================================================
	            			
	            			if( ++ConsecutiveAnswers >= MaxCorrectAnswersToWin )
	            			{
	            				MaximumScore = PlayerPoints;
	            				
	            				// --| Generate int points to string 
	            				StringBuilder stringMaxPoints = new StringBuilder( );
	            				stringMaxPoints.append( MaximumScore );
								
		            			// --| Display max points on frame
								String stringMaxPointsDisplay = stringMaxPoints.toString( );
	            				textFieldRecord.setText( stringMaxPointsDisplay );
	            				
	            				// --| Game has stopped, reset consecutive answers
	            				bGameStarted = false;
	            				ConsecutiveAnswers = 0;
	            				
	            				// --| Clear the textbox where we display characters
		        				txtDisplayCharacters.setText("");
		        				
	            				// --| Generate int points to string 
		            			StringBuilder stringPoints = new StringBuilder( );
		            			stringPoints.append( PlayerPoints );
								
		            			// --| Display points on frame
								String stringPointsDisplay = stringPoints.toString( );
		            			txtPoints.setText( stringPointsDisplay );
		            			
		            			// --| Enable the combobox
		        				comboBox.setEnabled(true);
		        				
		        				// --| Rewrite the textbox and add default text Write here AND autoselect all strings
		        				txtWriteHere.setText("Write here");
		        				txtWriteHere.selectAll();
		
		        				// --| Reset combobox 
		        				comboBox.setSelectedIndex(0);
		            			
		            			// --| Add a window where it shows that player won the game with amount of points
	            				JOptionPane.showMessageDialog( null, "Congratulations you won the game!\nTotal points: " + MaximumScore + "\nMaybe try another difficulty? :)", "Hooooooray!", JOptionPane.WARNING_MESSAGE );     
	            			}
	            			
	            			// =============================================================================================
	            			// --| Player won the game!!!!
	            			// =============================================================================================
	            			
	            			// --| Generate int points to string 
	            			StringBuilder stringPoints = new StringBuilder( );
	            			stringPoints.append( PlayerPoints );
							
	            			// --| Display points on frame
							String stringPointsDisplay = stringPoints.toString( );
	            			txtPoints.setText( stringPointsDisplay );
	            			
	            			// --| Select all the strings from textbox to let user type faster the answer without doing a selection, then write, then enter
	            			// --| Fast and furious
	            			txtWriteHere.selectAll( );
	            			
	            		}
	            		
	            		// --| Answer is wrong, he lost points according to level
	            		else
						{
	            			// --| Since user had a mistake, reset the consecutive answers
	            			ConsecutiveAnswers = 0;
	            			
	            			PlayerPoints -= 1;
	            			
	            			// --| Generate int points to string 
	            			StringBuilder stringPoints = new StringBuilder( );
	            			stringPoints.append( PlayerPoints );
							
	            			// --| Display points on frame
							String stringPointsDisplay = stringPoints.toString( );
	            			txtPoints.setText( stringPointsDisplay );
	            			
	            			// --| Select all the strings from textbox to let user type faster the answer without doing a selection, then write, then enter
	            			// --| Fast and furious
	            			txtWriteHere.selectAll( );
							JOptionPane.showMessageDialog( null, "Wrong answer! \nYou lost 1 point!", "Whoops...", JOptionPane.ERROR_MESSAGE );
						}
	            		
	            		
	            		// --| Generate a random item from array and display it
						int RandomNumberChoose = new Random( ).nextInt( Numbers.length );
						
						// --| Convert int to string using stringbuilder
						StringBuilder stringRandom = new StringBuilder( );
						stringRandom.append( RandomNumberChoose );
						
						String stringRandom1 = stringRandom.toString( );
						
						// --| Display on textbox the current string
						txtDisplayCharacters.setText( stringRandom1 );
					}
	            	
	            	// --| Level 2 Normal
	            	else if( PlayerLevel == 2 )
	            	{
	            		// --| Check if answer is correct
	            		String TextUp = txtDisplayCharacters.getText();
	            		String TextBoxAnswer = txtWriteHere.getText();
	            		
	            		// --| Add player points according to level 
	            		if( TextBoxAnswer.equals( TextUp ) )
	            		{
	            			PlayerPoints += 1;
	            			
	            			// =============================================================================================
	            			// --| Player won the game!!!!
	            			// =============================================================================================
	            			
	            			if( ++ConsecutiveAnswers >= MaxCorrectAnswersToWin )
	            			{
	            				MaximumScore = PlayerPoints;
	            				
	            				// --| Generate int points to string 
	            				StringBuilder stringMaxPoints = new StringBuilder( );
	            				stringMaxPoints.append( MaximumScore );
								
		            			// --| Display max points on frame
								String stringMaxPointsDisplay = stringMaxPoints.toString( );
	            				textFieldRecord.setText( stringMaxPointsDisplay );
	            				
	            				// --| Game has stopped, reset consecutive answers
	            				bGameStarted = false;
	            				ConsecutiveAnswers = 0;
	            				
	            				// --| Clear the textbox where we display characters
		        				txtDisplayCharacters.setText("");
		        				
	            				// --| Generate int points to string 
		            			StringBuilder stringPoints = new StringBuilder( );
		            			stringPoints.append( PlayerPoints );
								
		            			// --| Display points on frame
								String stringPointsDisplay = stringPoints.toString( );
		            			txtPoints.setText( stringPointsDisplay );
		            			
		            			// --| Enable the combobox
		        				comboBox.setEnabled(true);
		        				
		        				// --| Rewrite the textbox and add default text Write here AND autoselect all strings
		        				txtWriteHere.setText("Write here");
		        				txtWriteHere.selectAll();
		
		        				// --| Reset combobox 
		        				comboBox.setSelectedIndex(0);
		            			
		            			// --| Add a window where it shows that player won the game with amount of points
	            				JOptionPane.showMessageDialog( null, "Congratulations you won the game!\nTotal points: " + MaximumScore + "\nMaybe try another difficulty? :)", "Hooooooray!", JOptionPane.WARNING_MESSAGE );     
	            			}
	            			
	            			// =============================================================================================
	            			// --| Player won the game!!!!
	            			// =============================================================================================
	            			
	            			
	            			// --| Generate int points to string 
	            			StringBuilder stringPoints = new StringBuilder( );
	            			stringPoints.append( PlayerPoints );
							
	            			// --| Display points on frame
							String stringPointsDisplay = stringPoints.toString( );
	            			txtPoints.setText( stringPointsDisplay );
	            			
	            			// --| Select all the strings from textbox to let user type faster the answer without doing a selection, then write, then enter
	            			// --| Fast and furious
	            			txtWriteHere.selectAll( );
	            			
	            		}
	            		
	            		// --| Answer is wrong, he lost points according to level
	            		else
						{
	            			// --| Since user had a mistake, reset the consecutive answers
	            			ConsecutiveAnswers = 0;
	            			
	            			PlayerPoints -= 1;
	            			
	            			// --| Generate int points to string 
	            			StringBuilder stringPoints = new StringBuilder( );
	            			stringPoints.append( PlayerPoints );
							
	            			// --| Display points on frame
							String stringPointsDisplay = stringPoints.toString( );
	            			txtPoints.setText( stringPointsDisplay );
	            			
	            			// --| Select all the strings from textbox to let user type faster the answer without doing a selection, then write, then enter
	            			// --| Fast and furious
	            			txtWriteHere.selectAll( );
							JOptionPane.showMessageDialog( null, "Wrong answer! \nYou lost 1 point!", "Whoops...", JOptionPane.ERROR_MESSAGE );
						}
	            		
	            		// --| Generate a random letter from array and display it
	            		Random random = new Random();
						int RandomLetter = random.nextInt( AlphabetLetters.length );
						
						// --| Display on textbox the current string
						txtDisplayCharacters.setText( AlphabetLetters[ RandomLetter ] );
	            	}
	            	
	            	// --| Level 3 Advanced
	            	else if( PlayerLevel == 3 )
	            	{
	            		// --| Check if answer is correct
	            		String TextUp = txtDisplayCharacters.getText();
	            		String TextBoxAnswer = txtWriteHere.getText();
	            		
	            		// --| Add player points according to level 
	            		if( TextBoxAnswer.equals( TextUp ) )
	            		{
	            			PlayerPoints += 2;
	            			
	            			// =============================================================================================
	            			// --| Player won the game!!!!
	            			// =============================================================================================
	            			
	            			if( ++ConsecutiveAnswers >= MaxCorrectAnswersToWin )
	            			{
	            				MaximumScore = PlayerPoints;
	            				
	            				// --| Generate int points to string 
	            				StringBuilder stringMaxPoints = new StringBuilder( );
	            				stringMaxPoints.append( MaximumScore );
								
		            			// --| Display max points on frame
								String stringMaxPointsDisplay = stringMaxPoints.toString( );
	            				textFieldRecord.setText( stringMaxPointsDisplay );
	            				
	            				// --| Game has stopped, reset consecutive answers
	            				bGameStarted = false;
	            				ConsecutiveAnswers = 0;
	            				
	            				// --| Clear the textbox where we display characters
		        				txtDisplayCharacters.setText("");
		        				
	            				// --| Generate int points to string 
		            			StringBuilder stringPoints = new StringBuilder( );
		            			stringPoints.append( PlayerPoints );
								
		            			// --| Display points on frame
								String stringPointsDisplay = stringPoints.toString( );
		            			txtPoints.setText( stringPointsDisplay );
		            			
		            			// --| Enable the combobox
		        				comboBox.setEnabled(true);
		        				
		        				// --| Rewrite the textbox and add default text Write here AND autoselect all strings
		        				txtWriteHere.setText("Write here");
		        				txtWriteHere.selectAll();
		
		        				// --| Reset combobox 
		        				comboBox.setSelectedIndex(0);
		            			
		            			// --| Add a window where it shows that player won the game with amount of points
	            				JOptionPane.showMessageDialog( null, "Congratulations you won the game!\nTotal points: " + MaximumScore + "\nMaybe try another difficulty? :)", "Hooooooray!", JOptionPane.WARNING_MESSAGE );     
	            			}
	            			
	            			// =============================================================================================
	            			// --| Player won the game!!!!
	            			// =============================================================================================
	            			
	            			// --| Generate int points to string 
	            			StringBuilder stringPoints = new StringBuilder( );
	            			stringPoints.append( PlayerPoints );
							
	            			// --| Display points on frame
							String stringPointsDisplay = stringPoints.toString( );
	            			txtPoints.setText( stringPointsDisplay );
	            			
	            			// --| Select all the strings from textbox to let user type faster the answer without doing a selection, then write, then enter
	            			// --| Fast and furious
	            			txtWriteHere.selectAll( );
	            			
	            		}
	            		
	            		// --| Answer is wrong, he lost points according to level
	            		else
						{
	            			// --| Since user had a mistake, reset the consecutive answers
	            			ConsecutiveAnswers = 0;
	            			
	            			PlayerPoints -= 2;
	            			
	            			// --| Generate int points to string 
	            			StringBuilder stringPoints = new StringBuilder( );
	            			stringPoints.append( PlayerPoints );
							
	            			// --| Display points on frame
							String stringPointsDisplay = stringPoints.toString( );
	            			txtPoints.setText( stringPointsDisplay );
	            			
	            			// --| Select all the strings from textbox to let user type faster the answer without doing a selection, then write, then enter
	            			// --| Fast and furious
	            			txtWriteHere.selectAll( );
							JOptionPane.showMessageDialog( null, "Wrong answer! \nYou lost 2 points!", "Whoops...", JOptionPane.ERROR_MESSAGE );
						}
	            		
	            		// --| Generate a special char/s from array and display it
	            		Random random = new Random();
						int RandomChar = random.nextInt( SpecialChars.length );
						
						// --| Display on textbox the current string
						txtDisplayCharacters.setText( SpecialChars[ RandomChar ] );
	            	}
	
	            	// --| Level 4 Hard
	            	else if( PlayerLevel == 4 )
	            	{
	            		// --| Check if answer is correct
	            		String TextUp = txtDisplayCharacters.getText();
	            		String TextBoxAnswer = txtWriteHere.getText();
	            		
	            		// --| Add player points according to level 
	            		if( TextBoxAnswer.equals( TextUp ) )
	            		{
	            			PlayerPoints += 3;
	            			
	            			// =============================================================================================
	            			// --| Player won the game!!!!
	            			// =============================================================================================
	            			
	            			if( ++ConsecutiveAnswers >= MaxCorrectAnswersToWin )
	            			{
	            				MaximumScore = PlayerPoints;
	            				
	            				// --| Generate int points to string 
	            				StringBuilder stringMaxPoints = new StringBuilder( );
	            				stringMaxPoints.append( MaximumScore );
								
		            			// --| Display max points on frame
								String stringMaxPointsDisplay = stringMaxPoints.toString( );
	            				textFieldRecord.setText( stringMaxPointsDisplay );
	            				
	            				// --| Game has stopped, reset consecutive answers
	            				bGameStarted = false;
	            				ConsecutiveAnswers = 0;
	            				
	            				// --| Clear the textbox where we display characters
		        				txtDisplayCharacters.setText("");
		        				
	            				// --| Generate int points to string 
		            			StringBuilder stringPoints = new StringBuilder( );
		            			stringPoints.append( PlayerPoints );
								
		            			// --| Display points on frame
								String stringPointsDisplay = stringPoints.toString( );
		            			txtPoints.setText( stringPointsDisplay );
		            			
		            			// --| Enable the combobox
		        				comboBox.setEnabled(true);
		        				
		        				// --| Rewrite the textbox and add default text Write here AND autoselect all strings
		        				txtWriteHere.setText("Write here");
		        				txtWriteHere.selectAll();
		
		        				// --| Reset combobox 
		        				comboBox.setSelectedIndex(0);
		            			
		            			// --| Add a window where it shows that player won the game with amount of points
	            				JOptionPane.showMessageDialog( null, "Congratulations you won the game!\nTotal points: " + MaximumScore + "\nMaybe try another difficulty? :)", "Hooooooray!", JOptionPane.WARNING_MESSAGE );     
	            			}
	            			
	            			// =============================================================================================
	            			// --| Player won the game!!!!
	            			// =============================================================================================
	            			
	            			
	            			// --| Generate int points to string 
	            			StringBuilder stringPoints = new StringBuilder( );
	            			stringPoints.append( PlayerPoints );
							
	            			// --| Display points on frame
							String stringPointsDisplay = stringPoints.toString( );
	            			txtPoints.setText( stringPointsDisplay );
	            			
	            			// --| Select all the strings from textbox to let user type faster the answer without doing a selection, then write, then enter
	            			// --| Fast and furious
	            			txtWriteHere.selectAll( );
	            			
	            		}
	            		
	            		// --| Answer is wrong, he lost points according to level
	            		else
						{
	            			// --| Since user had a mistake, reset the consecutive answers
	            			ConsecutiveAnswers = 0;
	            			
	            			PlayerPoints -= 3;
	            			
	            			// --| Generate int points to string 
	            			StringBuilder stringPoints = new StringBuilder( );
	            			stringPoints.append( PlayerPoints );
							
	            			// --| Display points on frame
							String stringPointsDisplay = stringPoints.toString( );
	            			txtPoints.setText( stringPointsDisplay );
	            			
	            			// --| Select all the strings from textbox to let user type faster the answer without doing a selection, then write, then enter
	            			// --| Fast and furious
	            			txtWriteHere.selectAll( );
							JOptionPane.showMessageDialog( null, "Wrong answer! \nYou lost 3 points!", "Whoops...", JOptionPane.ERROR_MESSAGE );
						}
	         
	            		
	            		// --| Generate a special word from array and display it
	            		Random random = new Random();
						int RandomWord = random.nextInt( SpecialWords.length );
						
						// --| Display on textbox the current string
						txtDisplayCharacters.setText( SpecialWords[ RandomWord ] );
	            	}
	            	
	            	
	            	// --| Level 5 Expert
	            	else if( PlayerLevel == 5 )
	            	{
	            		// --| Check if answer is correct
	            		String TextUp = txtDisplayCharacters.getText();
	            		String TextBoxAnswer = txtWriteHere.getText();
	            		
	            		// --| Add player points according to level 
	            		if( TextBoxAnswer.equals( TextUp ) )
	            		{
	            			PlayerPoints += 4;
	            			
	            			// =============================================================================================
	            			// --| Player won the game!!!!
	            			// =============================================================================================
	            			
	            			if( ++ConsecutiveAnswers >= MaxCorrectAnswersToWin )
	            			{
	            				MaximumScore = PlayerPoints;
	            				
	            				// --| Generate int points to string 
	            				StringBuilder stringMaxPoints = new StringBuilder( );
	            				stringMaxPoints.append( MaximumScore );
								
		            			// --| Display max points on frame
								String stringMaxPointsDisplay = stringMaxPoints.toString( );
	            				textFieldRecord.setText( stringMaxPointsDisplay );
	            				
	            				// --| Game has stopped, reset consecutive answers
	            				bGameStarted = false;
	            				ConsecutiveAnswers = 0;
	            				
	            				// --| Clear the textbox where we display characters
		        				txtDisplayCharacters.setText("");
		        				
	            				// --| Generate int points to string 
		            			StringBuilder stringPoints = new StringBuilder( );
		            			stringPoints.append( PlayerPoints );
								
		            			// --| Display points on frame
								String stringPointsDisplay = stringPoints.toString( );
		            			txtPoints.setText( stringPointsDisplay );
		            			
		            			// --| Enable the combobox
		        				comboBox.setEnabled(true);
		        				
		        				// --| Rewrite the textbox and add default text Write here AND autoselect all strings
		        				txtWriteHere.setText("Write here");
		        				txtWriteHere.selectAll();
		
		        				// --| Reset combobox 
		        				comboBox.setSelectedIndex(0);
		            			
		            			// --| Add a window where it shows that player won the game with amount of points
	            				JOptionPane.showMessageDialog( null, "Congratulations you won the game!\nTotal points: " + MaximumScore + "\nMaybe try another difficulty? :)", "Hooooooray!", JOptionPane.WARNING_MESSAGE );     
	            			}
	            			
	            			// =============================================================================================
	            			// --| Player won the game!!!!
	            			// =============================================================================================
	            			
	            			// --| Generate int points to string 
	            			StringBuilder stringPoints = new StringBuilder( );
	            			stringPoints.append( PlayerPoints );
							
	            			// --| Display points on frame
							String stringPointsDisplay = stringPoints.toString( );
	            			txtPoints.setText( stringPointsDisplay );
	            			
	            			// --| Select all the strings from textbox to let user type faster the answer without doing a selection, then write, then enter
	            			// --| Fast and furious
	            			txtWriteHere.selectAll( );
	            			
	            		}
	            		
	            		// --| Answer is wrong, he lost points according to level
	            		else
						{
	            			// --| Since user had a mistake, reset the consecutive answers
	            			ConsecutiveAnswers = 0;
	            			
	            			PlayerPoints -= 4;
	            			
	            			// --| Generate int points to string 
	            			StringBuilder stringPoints = new StringBuilder( );
	            			stringPoints.append( PlayerPoints );
							
	            			// --| Display points on frame
							String stringPointsDisplay = stringPoints.toString( );
	            			txtPoints.setText( stringPointsDisplay );
	            			
	            			// --| Select all the strings from textbox to let user type faster the answer without doing a selection, then write, then enter
	            			// --| Fast and furious
	            			txtWriteHere.selectAll( );
							JOptionPane.showMessageDialog( null, "Wrong answer! \nYou lost 4 points!", "Whoops...", JOptionPane.ERROR_MESSAGE );
						}
	         
	            		// --| Generate a sentence from array and display it
	            		Random random = new Random();
						int RandomSentence = random.nextInt( Sentences.length );
						
						// --| Display on textbox the current string
						txtDisplayCharacters.setText( Sentences[ RandomSentence ] );
	            	}
	            }
			}
		});
		
		// --| When player click on the write here text box, we automatically select the text for him
		txtWriteHere.addFocusListener(new FocusAdapter()
		{
			@Override
			public void focusGained(FocusEvent arg0)
			{
				txtWriteHere.selectAll();
			}
		});
		
		txtWriteHere.setFont(new Font("Ravie", Font.BOLD, 11));
		txtWriteHere.setText("Write here");
		txtWriteHere.setHorizontalAlignment(SwingConstants.CENTER);
		txtWriteHere.setBackground(Color.LIGHT_GRAY);
		txtWriteHere.setForeground(new Color(0, 0, 0));
		txtWriteHere.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(0, 0, 0));
		panel_1.setBackground(new Color(255, 160, 122));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 215, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setForeground(Color.BLACK);
		panel_3.setBackground(new Color(173, 216, 230));
	
		
		// --| When player press Start button let's start the timer and display random items..
		JButton btnNewButton_1 = new JButton("Start");
		btnNewButton_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				// --| Create timer and display random item from array
				// --| If is easy level
			
				if( comboBox.getSelectedIndex() == 0 )
				{
					bGameStarted = false;
					// --| If no difficulty level selected, deny the process to start game!
					JOptionPane.showMessageDialog( null,  "Please select a difficulty level,\nbefore your Start the game!", "Error!", JOptionPane.ERROR_MESSAGE );
					
					return;
				}
				
				// --| If game already started, display an info message !
				if( bGameStarted == true )
				{
					JOptionPane.showMessageDialog( null,  "Game already started!\nPress Stop button if you want to start another session!" );
					
					return;
				}
				
				if( PlayerLevel == 1 )
				{
					// --| Disable the combobox
					comboBox.setEnabled(false);
					
					bGameStarted = true;
					PlayerPoints = 0;
					
					int RandomNumberChoose = new Random().nextInt( Numbers.length );
					
					StringBuilder StringB = new StringBuilder();
					StringB.append(RandomNumberChoose);
					
					String StringB2 = StringB.toString();
					
					txtDisplayCharacters.setText(StringB2);
					txtPoints.setText("0");
					
				}
				
				else if( PlayerLevel == 2 )
				{
					// --| Disable the combobox
					comboBox.setEnabled(false);
					
					bGameStarted = true;
					PlayerPoints = 0;
					
					Random random = new Random();
					
					int RandomLetter = random.nextInt( AlphabetLetters.length );
					
					txtDisplayCharacters.setText( AlphabetLetters[ RandomLetter ] );
					txtPoints.setText("0");
				}
				
				
				else if( PlayerLevel == 3 )
				{
					// --| Disable the combobox
					comboBox.setEnabled(false);
					
					bGameStarted = true;
					PlayerPoints = 0;
					
					Random random = new Random();
					
					int RandomChar = random.nextInt( SpecialChars.length );
					
					txtDisplayCharacters.setText( SpecialChars[ RandomChar ] );
					txtPoints.setText("0");
				}
				
				else if( PlayerLevel == 4 )
				{
					// --| Disable the combobox
					comboBox.setEnabled(false);
					
					bGameStarted = true;
					PlayerPoints = 0;
					
					Random random = new Random();
					
					int RandomWord = random.nextInt( SpecialWords.length );
					
					txtDisplayCharacters.setText( SpecialWords[ RandomWord ] );
					txtPoints.setText("0");
				}
				
				else if( PlayerLevel == 5 )
				{
					// --| Disable the combobox
					comboBox.setEnabled(false);
					
					bGameStarted = true;
					PlayerPoints = 0;
					
					Random random = new Random();
					
					int RandomSentence = random.nextInt( Sentences.length );
					
					txtDisplayCharacters.setText( Sentences[ RandomSentence ] );
					txtPoints.setText("0");
				}
			}
		});
		
		btnNewButton_1.setForeground(new Color(50, 205, 50));
		btnNewButton_1.setFont(new Font("Ravie", Font.BOLD, 17));
		btnNewButton_1.setBackground(Color.BLACK);
		
		// --| If player press the stop button, lets stop the game! and reset all stats
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				// --| If game was not started, display an error!
				if( bGameStarted == false )
				{
					JOptionPane.showMessageDialog( null,  "The game was not started!", "Error!", JOptionPane.ERROR_MESSAGE );
					
					return;
				}
				
				// --| Enable the combobox
				comboBox.setEnabled(true);
				
				// --| Rewrite the textbox and add default text Write here AND autoselect all strings
				txtWriteHere.setText("Write here");
				txtWriteHere.selectAll();
				
				// --| Reset player points, level, and clear the textbox where the words/numbers are displayed
				PlayerLevel = 0;
				PlayerPoints = 0;
				
				txtDisplayCharacters.setText("");
				txtPoints.setText("0");
				
				comboBox.setSelectedIndex(0);
				
				bGameStarted = false;
				
				JOptionPane.showMessageDialog( null,  "Okay, the game was stopped..." );
			}
		});
				
		btnStop.setForeground(new Color(255, 0, 0));
		btnStop.setFont(new Font("Ravie", Font.BOLD, 17));
		btnStop.setBackground(new Color(0, 0, 0));
		
		// --| Generate a new item from array after player pressed this button
		JButton btnNewButton = new JButton("Try another?");
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
				if( bGameStarted == false )
				{
					JOptionPane.showMessageDialog( null,  "You need to start the game first!",  "Error!", JOptionPane.ERROR_MESSAGE );
					
					return;
				}
				
				if( PlayerLevel == 1 )
				{
					bGameStarted = true;
					
					int RandomNumberChoose = new Random().nextInt( Numbers.length );
					
					StringBuilder StringB = new StringBuilder();
					StringB.append(RandomNumberChoose);
					
					String StringB2 = StringB.toString();
					txtDisplayCharacters.setText(StringB2);
					
					// --| Decrease one point!
					PlayerPoints = PlayerPoints - 1;
					
					// --| Convert int to string and display on textbox
					StringBuilder Str = new StringBuilder();
					Str.append(PlayerPoints);
					
					String PointsToString = Str.toString();
					txtPoints.setText(PointsToString);
				}
				
				else if( PlayerLevel == 2 )
				{
					bGameStarted = true;
					
					Random random = new Random();
					
					int RandomLetter = random.nextInt( AlphabetLetters.length );
					txtDisplayCharacters.setText( AlphabetLetters[ RandomLetter ] );
					
					// --| Decrease one point!
					PlayerPoints -= 1;
					
					// --| Convert int to string and display on textbox
					StringBuilder Str = new StringBuilder();
					Str.append(PlayerPoints);
					
					String PointsToString = Str.toString();
					txtPoints.setText(PointsToString);
				}
				
				
				else if( PlayerLevel == 3 )
				{
					bGameStarted = true;
					
					Random random = new Random();
					
					int RandomChar = random.nextInt( SpecialChars.length );
					txtDisplayCharacters.setText( SpecialChars[ RandomChar ] );
					
					// --| Decrease one point!
					PlayerPoints -= 1;
					
					// --| Convert int to string and display on textbox
					StringBuilder Str = new StringBuilder();
					Str.append(PlayerPoints);
					
					String PointsToString = Str.toString();
					txtPoints.setText(PointsToString);
				}
				
				else if( PlayerLevel == 4 )
				{
					bGameStarted = true;
					
					Random random = new Random();
					
					int RandomWord = random.nextInt( SpecialWords.length );
					txtDisplayCharacters.setText( SpecialWords[ RandomWord ] );
					
					// --| Decrease one point!
					PlayerPoints -= 1;
					
					// --| Convert int to string and display on textbox
					StringBuilder Str = new StringBuilder();
					Str.append(PlayerPoints);
					
					String PointsToString = Str.toString();
					txtPoints.setText(PointsToString);
				}
				
				else if( PlayerLevel == 5 )
				{
					bGameStarted = true;
					
					Random random = new Random();
					
					int RandomSentence = random.nextInt( Sentences.length );
					txtDisplayCharacters.setText( Sentences[ RandomSentence ] );
					
					// --| Decrease one point!
					PlayerPoints -= 1;
					
					// --| Convert int to string and display on textbox
					StringBuilder Str = new StringBuilder();
					Str.append(PlayerPoints);
					
					String PointsToString = Str.toString();
					txtPoints.setText(PointsToString);
				}
			}
		});
		
		
		// --| ===================================================================================================
		// --| DESIGN MADE WITH WINDOWBUILDER PLUGIN FOR ECLIPSE INDIGO !
		// --| ===================================================================================================
		
		btnNewButton.setFont(new Font("Ravie", Font.BOLD, 16));
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setForeground(new Color(0, 0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("You will lose one point!");
		lblNewLabel_4.setBackground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_4.setForeground(Color.RED);
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtDisplayCharacters, GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(152, Short.MAX_VALUE)
					.addComponent(lblNewLabel_2)
					.addGap(146))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(89)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(99, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
					.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(73, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(182)
							.addComponent(btnStop, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
					.addGap(72))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtWriteHere, GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(126)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(121, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(167)
					.addComponent(lblNewLabel_4)
					.addContainerGap(169, Short.MAX_VALUE))
		);
		
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
					.addGap(43)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtDisplayCharacters, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtWriteHere, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(lblNewLabel_4)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnStop, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExit))
					.addContainerGap())
		);
		
		JLabel lblNewLabel_3 = new JLabel("Level:");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Ravie", Font.BOLD, 13));
		
		txtCurLevel = new JTextField();
		txtCurLevel.setEditable(false);
		txtCurLevel.setHorizontalAlignment(SwingConstants.CENTER);
		txtCurLevel.setForeground(Color.WHITE);
		txtCurLevel.setFont(new Font("Ravie", Font.BOLD, 11));
		txtCurLevel.setBackground(new Color(176, 224, 230));
		txtCurLevel.setColumns(10);
		
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
					.addGap(34)
					.addComponent(txtCurLevel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(txtCurLevel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		panel_3.setLayout(gl_panel_3);
		
		JLabel lblTimeRemaining = new JLabel("Time Remaining:");
		lblTimeRemaining.setHorizontalAlignment(SwingConstants.LEFT);
		lblTimeRemaining.setForeground(Color.WHITE);
		lblTimeRemaining.setFont(new Font("Ravie", Font.BOLD, 12));
		
		textFieldTimeRem = new JTextField();
		textFieldTimeRem.setForeground(Color.WHITE);
		textFieldTimeRem.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldTimeRem.setText("0:00");
		textFieldTimeRem.setFont(new Font("Ravie", Font.BOLD, 13));
		textFieldTimeRem.setEditable(false);
		textFieldTimeRem.setBackground(new Color(205, 133, 63));
		textFieldTimeRem.setColumns(10);
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(textFieldTimeRem, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(lblTimeRemaining, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(5)
					.addComponent(lblTimeRemaining)
					.addGap(5)
					.addComponent(textFieldTimeRem, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Current Points:");
		lblNewLabel_1.setFont(new Font("Ravie", Font.BOLD, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setForeground(UIManager.getColor("Viewport.foreground"));
		
		txtPoints = new JTextField();
		txtPoints.setText("0");
		txtPoints.setFont(new Font("Ravie", Font.BOLD, 13));
		txtPoints.setForeground(new Color(0, 0, 0));
		txtPoints.setBackground(new Color(255, 255, 0));
		txtPoints.setEditable(false);
		txtPoints.setHorizontalAlignment(SwingConstants.CENTER);
		txtPoints.setColumns(10);
		
		JLabel lblRecord = new JLabel("Previous Score:");
		lblRecord.setHorizontalAlignment(SwingConstants.LEFT);
		lblRecord.setForeground(Color.BLACK);
		lblRecord.setFont(new Font("Ravie", Font.BOLD, 12));
		
		textFieldRecord = new JTextField();
		textFieldRecord.setFont(new Font("Ravie", Font.BOLD, 13));
		textFieldRecord.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldRecord.setText("0");
		textFieldRecord.setEditable(false);
		textFieldRecord.setBackground(Color.YELLOW);
		textFieldRecord.setColumns(10);
		
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_2.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblRecord)
							.addContainerGap())
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
								.addComponent(textFieldRecord, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
								.addComponent(txtPoints, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(31))))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(5)
					.addComponent(lblNewLabel_1)
					.addGap(5)
					.addComponent(txtPoints, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblRecord, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(textFieldRecord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		panel_2.setLayout(gl_panel_2);
		
		JLabel lblNewLabel = new JLabel("Type That Text");
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Ravie", Font.BOLD, 25));
		
		contentPane.setLayout(gl_contentPane);
		
		// --| ===================================================================================================
		// --| DESIGN MADE WITH WINDOWBUILDER PLUGIN FOR ECLIPSE INDIGO !
		// --| ===================================================================================================
	}
}
