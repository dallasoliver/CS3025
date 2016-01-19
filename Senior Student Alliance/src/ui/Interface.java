package ui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import applogic.Logic;
import applogic.PostCellRenderer;

public class Interface extends JFrame{
	
	private static applogic.Logic logic;
	
	private JFrame frame;
	private JPanel cardPanel;
	private JPanel loginPanel;
	private JPanel viewPostingsPanel;
	private JPanel addPostPanel;
	private JPanel adminPanel;
	private JTextField textFieldUsername;
	private JPasswordField textFieldPassword;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private CardLayout cardLayout;
	private JButton btnSubmit;
	private JLabel picLabel;
	
	private ButtonGroup btnGroup;
	private JRadioButton rdoSenior;
	private JRadioButton rdoStudent;
	private JButton addPost;
	private JList postList;
	private JPanel pane;
	
	private ButtonGroup btnGroupAdd;
	private JRadioButton rdoSeniorAdd;
	private JRadioButton rdoStudentAdd;
	private JTextArea textFieldWanted;
	private JTextArea textFieldOffer;
	private JTextArea textFieldContact;
	private JLabel lblWanted;
	private JLabel lblOffer;
	private JLabel lblContact;
	private JButton submitPost;
	private Image imgCheck;
	private Image imgCheckSmall;
	private Icon iconCheck;
	private JLabel lblCheck2;
	private JButton btnBack;
	private JPanel colorPanel;
	private JLabel userQuestion;
	
	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public Interface() throws Exception {
	//login start	
		frame = new JFrame();
		cardPanel = new JPanel();
		loginPanel = new JPanel();
		viewPostingsPanel = new JPanel();
		addPostPanel = new JPanel();
		adminPanel = new JPanel();
		textFieldUsername = new JTextField(15);
		textFieldPassword = new JPasswordField(15);
		lblUsername = new JLabel("Username");
		lblPassword = new JLabel("Password");
		cardLayout = new CardLayout();
		btnSubmit = new JButton("Submit");
		picLabel = new JLabel("");
		
		pane = new JPanel();
		
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
		constraints.insets = new Insets(8,8,8,8);  
		lblUsername.setFont(new Font("Source Sans Pro", Font.PLAIN, 20));
		loginPanel.add(lblUsername, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 2;
		lblPassword.setFont(new Font("Source Sans Pro", Font.PLAIN, 20));
		loginPanel.add(lblPassword, constraints);
		
		constraints.anchor = GridBagConstraints.LINE_START;
		constraints.gridx = 2;
		constraints.gridy = 1;
		textFieldUsername.setPreferredSize(new Dimension(190, 40));
		textFieldUsername.setFont(new Font("Source Sans Pro", Font.PLAIN, 20));
		loginPanel.add(textFieldUsername, constraints);
		
		constraints.gridx = 2;
		constraints.gridy = 2;
		loginPanel.add(textFieldPassword, constraints);
		textFieldPassword.setEchoChar('*');
		textFieldPassword.setPreferredSize(new Dimension(190, 40));
		textFieldPassword.setFont(new Font("Source Sans Pro", Font.PLAIN, 20));
		btnSubmit.setSize(10, 20);
		
		constraints.anchor = GridBagConstraints.FIRST_LINE_START;
		constraints.weighty = 10;
		constraints.gridx = 2;
		constraints.gridy = 3;
		
		btnSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (textFieldUsername.getText().equals("admin") && textFieldPassword.getPassword().equals("admin")) {
					cardLayout.show(cardPanel, "3");					
				} else if ((textFieldUsername.getText().equals("senior") && textFieldPassword.getPassword().equals("senior")) || (textFieldUsername.getText().equals("student") && textFieldPassword.getText().equals("student"))) {
					cardLayout.show(cardPanel, "2");	
					Object[] postsTest = null;
					try {
						postsTest = logic.showAll();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					postList = new JList(postsTest);
					postList.setCellRenderer(new PostCellRenderer());
					postList.setVisibleRowCount(4);
//				    pane = new JScrollPane(postList);
//				    viewPostingsPanel.add(pane);
				} else if (!textFieldUsername.getText().isEmpty() && textFieldPassword.getPassword().length == 0){
					JOptionPane.showMessageDialog(frame,
							"You have entered an invalid login. Please try again.",
							"Inane error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		 
		btnSubmit.setFont(new Font("Source Sans Pro", Font.PLAIN, 24));
		btnSubmit.setPreferredSize(new Dimension(120, 40));
		loginPanel.add(btnSubmit, constraints);
		loginPanel.setBackground(new Color(240,248,255));
		cardPanel.add(loginPanel, "1");
	//login end
		
	//view posting start
		viewPostingsPanel.setLayout(new GridBagLayout());
		viewPostingsPanel.setBackground(new Color(240,248,255));
		
		btnGroup = new ButtonGroup();
		rdoSenior = new JRadioButton();
		rdoStudent = new JRadioButton();
		addPost = new JButton();
		addPost.setFont(new Font("Source Sans Pro", Font.PLAIN, 20));
		
		viewPostingsPanel.add(addPost);
		
		
		cardPanel.add(addPostPanel, "4");
		
		addPost.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "4");					
			}
		});
	//view posting end
		
	//Add post panel
		colorPanel = new JPanel();
		colorPanel.setBackground(new Color(125,38,205));
		userQuestion = new JLabel("Are you a?");
		userQuestion.setFont(new Font("Source Sans Pro", Font.PLAIN, 20));
		btnGroupAdd = new ButtonGroup();
		rdoSeniorAdd = new JRadioButton("Senior");
		rdoStudentAdd = new JRadioButton("Student");
		textFieldWanted = new JTextArea(5, 30);
		textFieldWanted.setFont(new Font("Source Sans Pro", Font.PLAIN, 20));
		textFieldOffer = new JTextArea(5, 30);
		textFieldOffer.setFont(new Font("Source Sans Pro", Font.PLAIN, 20));
		textFieldContact = new JTextArea(2, 30);
		textFieldContact.setFont(new Font("Source Sans Pro", Font.PLAIN, 20));
		lblWanted = new JLabel("<html>What do you need <br>assistance with?<html/>");
		lblWanted.setFont(new Font("Source Sans Pro", Font.PLAIN, 20));
		lblOffer = new JLabel("<html>What can you offer <br>in return?<html/>");
		lblOffer.setFont(new Font("Source Sans Pro", Font.PLAIN, 20));
		lblContact = new JLabel("Contact Information");
		lblContact.setFont(new Font("Source Sans Pro", Font.PLAIN, 20));
		submitPost = new JButton("Submit Post");
		submitPost.setFont(new Font("Source Sans Pro", Font.PLAIN, 20));
		imgCheck = new ImageIcon(
				Interface.class.getResource("/check-mark.png"))
				.getImage();
		imgCheckSmall = imgCheck.getScaledInstance(50, 50,
			java.awt.Image.SCALE_SMOOTH);
		iconCheck = new ImageIcon(imgCheckSmall);
		lblCheck2 = new JLabel("");
		btnBack = new JButton("Back to View Postings");
		btnBack.setFont(new Font("Source Sans Pro", Font.PLAIN, 20));
		pane.setBackground(new Color(240,248,255));
		
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					cardLayout.show(cardPanel, "2");	
					Object[] postsTest = null;
					try {
						postsTest = logic.showAll();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					postList = new JList(postsTest);
					postList.setBackground(new Color(240,248,255));
					postList.setCellRenderer(new PostCellRenderer());
					postList.setVisibleRowCount(7);
					pane.removeAll();
				    pane.add(postList);
				    viewPostingsPanel.add(pane);
			}
		});
		
		btnGroupAdd.add(rdoSeniorAdd);
		btnGroupAdd.add(rdoStudentAdd);
		
		addPostPanel.setLayout(new GridBagLayout());
		
		GridBagConstraints addPostConstraints = new GridBagConstraints();
		
		addPostConstraints.weightx = 0.5;
		addPostConstraints.weighty = 0.5;
		addPostConstraints.insets = new Insets(10,10,10,10);  

		addPostConstraints.gridx = 0;
		addPostConstraints.gridy = 0;
		addPostPanel.add(btnBack);
		
		colorPanel.setPreferredSize(new Dimension(100, 70));
		addPostConstraints.gridx = 0;
		addPostConstraints.gridy = 1;
		addPostConstraints.gridwidth = GridBagConstraints.REMAINDER;
		addPostPanel.add(colorPanel);

		addPostConstraints.anchor = GridBagConstraints.LINE_START;
		addPostConstraints.gridwidth = GridBagConstraints.REMAINDER;
		
		addPostConstraints.gridx = 0;
		addPostConstraints.gridy = 2;
		addPostPanel.add(userQuestion, addPostConstraints);
		
		addPostConstraints.gridx = 1;
		addPostConstraints.gridy = 2;
		addPostPanel.add(rdoSeniorAdd, addPostConstraints);
		
		addPostConstraints.gridx = 2;
		addPostConstraints.gridy = 2;	
		addPostPanel.add(rdoStudentAdd, addPostConstraints);

		addPostConstraints.gridx = 1;
		addPostConstraints.gridy = 3;
		addPostPanel.add(textFieldWanted, addPostConstraints);
		
		addPostConstraints.gridx = 1;
		addPostConstraints.gridy = 4;
		addPostPanel.add(textFieldOffer, addPostConstraints);
		
		addPostConstraints.gridx = 1;
		addPostConstraints.gridy = 5;
		addPostPanel.add(textFieldContact, addPostConstraints);	

		addPostConstraints.gridwidth = GridBagConstraints.RELATIVE;

		addPostConstraints.gridx = 0;
		addPostConstraints.gridy = 3;
		addPostPanel.add(lblWanted, addPostConstraints);
		
		constraints.anchor = GridBagConstraints.LINE_END;
		addPostConstraints.gridx = 0;
		addPostConstraints.gridy = 4;
		addPostPanel.add(lblOffer, addPostConstraints);
		
		constraints.anchor = GridBagConstraints.LINE_END;
		addPostConstraints.gridx = 0;
		addPostConstraints.gridy = 5;
		addPostPanel.add(lblContact, addPostConstraints);
		
		constraints.anchor = GridBagConstraints.LINE_END;
		addPostConstraints.gridx = 1;
		addPostConstraints.gridy = 6;
		addPostPanel.add(submitPost, addPostConstraints);
		
		constraints.anchor = GridBagConstraints.CENTER;
		addPostConstraints.gridx = 2;
		addPostConstraints.gridy = 6;
		addPostPanel.add(lblCheck2, addPostConstraints);
		
		addPostPanel.setBackground(new Color(240,248,255));
		
		submitPost.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String wanted = textFieldWanted.getText();
				String offer = textFieldOffer.getText();
				String contact = textFieldContact.getText();
				String user = "";
				
				for (Enumeration<AbstractButton> buttons = btnGroupAdd.getElements(); buttons.hasMoreElements();) {
					AbstractButton button = buttons.nextElement();
					if (button.isSelected()) {
						if(button.getText().equals("Senior")) {
							user = "Senior";
						} else if(button.getText().equals("Student")) {
							user = "Student";
						}
					}
				}
				
				try {
					logic.addPost(wanted, offer, contact, user);
					lblCheck2.setIcon(iconCheck);
					textFieldWanted.setText("");
					textFieldOffer.setText("");
					textFieldContact.setText("");
				} catch (Exception er) {
					lblCheck2.setIcon(null);
//					JOptionPane.showMessageDialog(cardioMainPanel,
//							er.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
				
		adminPanel.setLayout(new GridBagLayout());
		cardPanel.add(viewPostingsPanel, "2");
		cardPanel.add(adminPanel, "3");
		cardLayout.show(cardPanel, "1");

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
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		logic = new Logic("posts.xml");
	}
}

//TODO: add logout button
//TODO: (maybe) add "please confirm that you are over 18 years of age"


//Natalie Suggestions
// web design guidelines
// resources about designing for seniors
// connect with some seniors - 
//
//

