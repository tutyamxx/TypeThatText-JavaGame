package gamestuff;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;


public class WelcomeScreen extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * --| Launch the application.
	 */
	
	public static void main( String[ ] args )
	{
		EventQueue.invokeLater( new Runnable( )
		{
			public void run( )
			{
				try
				{
					
					WelcomeScreen frame = new WelcomeScreen( );
					
					frame.setVisible( true );
					
					// --| Disable maximize button and the frame can't be resized
					// --| Set frame default location to center of screen
					
					frame.setResizable( false );
					frame.setLocationRelativeTo( null );
					
				} 
				
				catch ( Exception e )
				{
					e.printStackTrace( );
				}
			}
		});
	}

	/**
	 * --| Create the frame.
	 */
	
	public WelcomeScreen( )
	{
		setDefaultCloseOperation( JFrame.DO_NOTHING_ON_CLOSE );
		setBounds( 100, 100, 469, 269 );
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Welcome to Type That Text!");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Ravie", Font.BOLD, 18));
		
		JButton btnNewButton = new JButton("Start Game");
		btnNewButton.setBackground(new Color(0, 0, 0));
		
		
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
					JOptionPane.showMessageDialog( null, "Press OK to start the game.");
					
					dispose();
					MainGame.main( null );
					
					return;
			}
		});
		
		
		btnNewButton.setForeground(new Color(50, 205, 50));
		btnNewButton.setFont(new Font("Ravie", Font.BOLD, 16));
		
		// --| Add a warning popup if user really want to close the game
		JButton btnExit = new JButton("Exit");
		btnExit.setBackground(new Color(0, 0, 0));
		btnExit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				
				// --| Destroy the welcome screen and display the exit screen popup
				dispose();
				
				ExitScreen.main(null);
			}
		});
		
		// --| ===================================================================================================
		// --| DESIGN MADE WITH WINDOWBUILDER PLUGIN FOR ECLIPSE INDIGO !
		// --| ===================================================================================================
		
		btnExit.setForeground(Color.RED);
		btnExit.setFont(new Font("Ravie", Font.BOLD, 17));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
							.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(31)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 378, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExit, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		contentPane.setLayout(gl_contentPane);
		
		// --| ===================================================================================================
		// --| DESIGN MADE WITH WINDOWBUILDER PLUGIN FOR ECLIPSE INDIGO !
		// --| ===================================================================================================
	}
}

