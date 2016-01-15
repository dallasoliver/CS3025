package ui;

import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Interface extends JFrame{
	
	private JFrame frame;
	private JPanel cardPanel;
	private JPanel loginPanel;
	private JPanel viewPostingsPanel;
	private JPanel adminPanel;
	private JTextField textFieldUsername;
	private JTextField textFieldPassword;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private CardLayout cardLayout;
	private JButton btnSubmit;
	private JLabel picLabel;
	
	/**
	 * Create the panel.
	 * @throws IOException 
	 */
	public Interface() throws IOException {
		frame = new JFrame();
		cardPanel = new JPanel();
		loginPanel = new JPanel();
		viewPostingsPanel = new JPanel();
		adminPanel = new JPanel();
		textFieldUsername = new JTextField(10);
		textFieldPassword = new JTextField(10);
		lblUsername = new JLabel("Username");
		lblPassword = new JLabel("Password");
		cardLayout = new CardLayout();
		btnSubmit = new JButton("Submit");
		picLabel = new JLabel("");
		
		//login start	
		Image img = new ImageIcon(this.getClass().getResource("/image1.png")).getImage();
		picLabel.setIcon(new ImageIcon(img));
		picLabel.setBounds(10, 53, 166, 266);
		
		cardPanel.setLayout(cardLayout);
		loginPanel.setLayout(new GridBagLayout());
		
		GridBagConstraints constraints = new GridBagConstraints();
		
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.weightx = 0.5;
		constraints.weighty = 0.5;
		
		constraints.gridwidth = 3;

		constraints.gridx = 0;
		constraints.gridy = 0;
		loginPanel.add(picLabel, constraints);
		
		constraints.gridwidth = 1;
				
		constraints.anchor = GridBagConstraints.LINE_END;
		constraints.gridx = 1;
		constraints.gridy = 1;
		loginPanel.add(lblUsername, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 2;
		loginPanel.add(lblPassword, constraints);
		
		constraints.anchor = GridBagConstraints.LINE_START;
		constraints.gridx = 2;
		constraints.gridy = 1;
		loginPanel.add(textFieldUsername, constraints);
		
		constraints.gridx = 2;
		constraints.gridy = 2;
		loginPanel.add(textFieldPassword, constraints);
		
		btnSubmit.setSize(10, 20);
		
		constraints.anchor = GridBagConstraints.FIRST_LINE_START;
		constraints.weighty = 10;
		constraints.gridx = 2;
		constraints.gridy = 3;
		loginPanel.add(btnSubmit, constraints);

//		loginPanel.setBackground(Color.lightGray);
		
		cardPanel.add(loginPanel, "1");
		//login end

		viewPostingsPanel.setLayout(new GridBagLayout());
		adminPanel.setLayout(new GridBagLayout());
		
		cardPanel.add(viewPostingsPanel, "2");

		cardPanel.add(adminPanel, "3");

		cardLayout.show(cardPanel, "1");

		btnSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (textFieldUsername.getText().equals("admin") && textFieldPassword.getText().equals("admin")) {
					cardLayout.show(cardPanel, "3");					
				} else if ((textFieldUsername.getText().equals("senior") && textFieldPassword.getText().equals("senior")) || (textFieldUsername.getText().equals("student") && textFieldPassword.getText().equals("student"))) {
					cardLayout.show(cardPanel, "2");					
				} else if (!textFieldUsername.getText().isEmpty() && !textFieldPassword.getText().isEmpty()){
					JOptionPane.showMessageDialog(frame,
						    "You have entered an invalid login. Please try again.",
						    "Inane error",
						    JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		try {
		    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		}
		
		frame.getContentPane().add(cardPanel);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					new Interface();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
}