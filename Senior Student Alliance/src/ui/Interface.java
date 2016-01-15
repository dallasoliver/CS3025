package ui;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.BoxLayout;

public class Interface extends JFrame{
	
	private JFrame frame;
	private JPanel cardPanel;
	private JPanel loginPanel;
	private JPanel viewPostingsPanel;
	private JTextField textFieldUsername;
	private JTextField textFieldPassword;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private CardLayout cardLayout;
	private JButton btnSubmit;
	private JLabel picLabel;
	private BufferedImage wPic;
	
	/**
	 * Create the panel.
	 * @throws IOException 
	 */
	public Interface() throws IOException {
		frame = new JFrame();
		cardPanel = new JPanel();
		loginPanel = new JPanel();
		viewPostingsPanel = new JPanel();
		textFieldUsername = new JTextField(10);
		textFieldPassword = new JTextField(10);
		lblUsername = new JLabel("Username");
		lblPassword = new JLabel("Password");
		cardLayout = new CardLayout();
		btnSubmit = new JButton("Submit");
		
		BufferedImage wPic = ImageIO.read(this.getClass().getResource("pic1.png"));
		picLabel = new JLabel(new ImageIcon(wPic));
		
		cardPanel.setLayout(cardLayout);
		viewPostingsPanel.setLayout(null);
		loginPanel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		
		constraints.anchor = GridBagConstraints.LINE_END;
		constraints.weightx = 0.5;
		constraints.weighty = 0.5;
		
		constraints.gridx = 0;
		constraints.gridy = 0;
		loginPanel.add(picLabel, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 1;
		loginPanel.add(lblUsername, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 2;
		loginPanel.add(lblPassword, constraints);
		
		constraints.anchor = GridBagConstraints.LINE_START;
		constraints.gridx = 1;
		constraints.gridy = 1;
		loginPanel.add(textFieldUsername, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 2;
		loginPanel.add(textFieldPassword, constraints);
		
		constraints.anchor = GridBagConstraints.FIRST_LINE_START;
		constraints.weighty = 10;
		constraints.gridx = 1;
		constraints.gridy = 3;
		loginPanel.add(btnSubmit, constraints);
		
		cardPanel.add(loginPanel, "1");
		
		cardPanel.add(viewPostingsPanel, "2");
		
		cardLayout.show(cardPanel, "1");

		btnSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "2");
			}
		});
		
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