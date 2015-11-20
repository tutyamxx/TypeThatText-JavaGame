package gamestuff;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;


public class Exit extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
					
					Exit frame = new Exit();
					
					frame.setVisible(true);
					
					// --| Disable maximize button and the frame can't be resized
					// --| Set frame default location to center of screen
					
					frame.setResizable(false);
					frame.setLocationRelativeTo(null);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * --| Create the frame.
	 */
	
	public Exit()
	{
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		setBounds(100, 100, 394, 185);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Are you sure you want to exit?");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Ravie", Font.BOLD, 14));
		
		// --| If user click Yes! button, exit the application
		JButton btnNewButton = new JButton("Yes!");
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Ravie", Font.BOLD, 12));
		
		// --| If user click No! button, close popup window and display welcome screen window again
		JButton btnNo = new JButton("No!");
		btnNo.setBackground(new Color(0, 0, 0));
		btnNo.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});
		
		// --| ===================================================================================================
		// --| DESIGN MADE WITH WINDOWBUILDER PLUGIN FOR ECLIPSE INDIGO !
		// --| ===================================================================================================
		
		btnNo.setForeground(new Color(50, 205, 50));
		btnNo.setFont(new Font("Ravie", Font.BOLD, 12));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
							.addComponent(btnNo, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(20)
							.addComponent(lblNewLabel)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(48, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNo))
					.addContainerGap())
		);
		
		contentPane.setLayout(gl_contentPane);
		
		// --| ===================================================================================================
		// --| DESIGN MADE WITH WINDOWBUILDER PLUGIN FOR ECLIPSE INDIGO !
		// --| ===================================================================================================
	}

}
