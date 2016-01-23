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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import objects.Post;

import org.jdesktop.swingx.JXDatePicker;

import applogic.Logic;
import applogic.PostCellRenderer;
import applogic.ResponseCellRenderer;

public class Interface extends JFrame{
	
	private static applogic.Logic logic;
	private String userType;
	
	private JFrame frame;
	private JPanel cardPanel;
	private JPanel loginPanel;
	private JPanel adminPanel;
	private JTextField textFieldUsername;
	private JPasswordField textFieldPassword;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private CardLayout cardLayout;
	private JButton btnSubmit;
	private JLabel picLabel;
	private Image imgSmall;
	private ImageIcon iconSmall;
	
	private JPanel viewPostingsPanel;
	private ButtonGroup btnGroup;
	private JRadioButton rdoSenior;
	private JRadioButton rdoStudent;
	private JButton addPost;
	private JButton viewMyPosts;
	private JList postList;
	private JPanel pane;
	
	private JLabel responseLbl;
	private JList postResponseList;
	private JPanel postPane;
	private JPanel viewMyPostsPanel;
	private JTextField contact;
	private JTextField message;
	private JList responseList;
	private JPanel responsesPane;
	
	private JPanel addPostPanel;
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
	private JXDatePicker datePicker;
	
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
		postPane = new JPanel();
		
		Image img = new ImageIcon(this.getClass().getResource("/image1.png")).getImage();
		imgSmall = img.getScaledInstance(600, 400,
				java.awt.Image.SCALE_SMOOTH);
		iconSmall = new ImageIcon(imgSmall);
		picLabel.setIcon(iconSmall);
		
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
					if (textFieldUsername.getText().equals("senior")) {
						userType = "Senior";
					}
					if (textFieldUsername.getText().equals("student")) {
						userType = "Student";
					}
					
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
		loginPanel.setBackground(new Color(247, 247, 247));
		
		JScrollPane scrollWholePage = new JScrollPane();
		scrollWholePage.add(loginPanel);
		cardPanel.add(loginPanel, "1");
	//login end
		
	//view posting start
		viewMyPostsPanel = new JPanel();
		responseLbl = new JLabel();
		contact = new JTextField();
		message = new JTextField();
		responsesPane = new JPanel();
		
		colorPanel = new JPanel();
		colorPanel.setPreferredSize(new Dimension(300,200));
        colorPanel.setBackground(new Color(205, 0, 0));
		
		btnGroup = new ButtonGroup();
		rdoSenior = new JRadioButton();
		rdoStudent = new JRadioButton();
		addPost = new JButton("Add Post");
		addPost.setFont(new Font("Source Sans Pro", Font.PLAIN, 20));

		viewMyPosts = new JButton("View My Posts");
		viewMyPosts.setFont(new Font("Source Sans Pro", Font.PLAIN, 20));

		viewPostingsPanel.setLayout(new GridBagLayout());
		viewPostingsPanel.setBackground(new Color(247, 247, 247));
		
		GridBagConstraints viewPostsConstraints = new GridBagConstraints();
		
		viewPostsConstraints.weightx = 1;
		viewPostsConstraints.weighty = 1;
		
		viewPostsConstraints.anchor = GridBagConstraints.LINE_START;
		viewPostsConstraints.gridwidth = GridBagConstraints.REMAINDER;

		viewPostsConstraints.gridx = 0;
		viewPostsConstraints.gridy = 0;
		viewPostsConstraints.fill = GridBagConstraints.HORIZONTAL;
		viewPostingsPanel.add(colorPanel, viewPostsConstraints);
		
		viewPostsConstraints.fill = GridBagConstraints.NONE;
		
		viewPostsConstraints.gridx = 0;
		viewPostsConstraints.gridy = 1;
		viewPostingsPanel.add(addPost, viewPostsConstraints);
		
		viewPostsConstraints.gridx = 0;
		viewPostsConstraints.gridy = 2;
		viewPostingsPanel.add(viewMyPosts, viewPostsConstraints);
		
		cardPanel.add(addPostPanel, "4");
		cardPanel.add(viewMyPostsPanel, "5");
		
		addPost.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "4");					
			}
		});
		
		viewMyPosts.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "5");
				Object[] postsTest = null;
				try {
					postsTest = logic.showMyPosts(userType);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				postResponseList = new JList(postsTest);
				postResponseList.setBackground(new Color(247, 247, 247));
				postResponseList.setCellRenderer(new PostCellRenderer());
				postResponseList.setVisibleRowCount(7);
				postPane.removeAll();
				postPane.add(postResponseList);
			    viewMyPostsPanel.add(postPane);
			    
			    postResponseList.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent evt) {
					    if (evt.getClickCount() == 2) {
					    	
			            	Post p = (Post)(postResponseList.getSelectedValue());
			            	Integer pId = p.getPostId();
			            	
							Object[] allResponses = null;
							try {
								allResponses = logic.showResponses(pId);
							} catch (Exception e) {
								e.printStackTrace();
							}
			            	
			            	responseList = new JList(allResponses);
			            	responseList.setBackground(new Color(247, 247, 247));
			            	responseList.setCellRenderer(new ResponseCellRenderer());
			            	responseList.setVisibleRowCount(7);
							responsesPane.removeAll();
							responsesPane.add(responseList);
						    viewMyPostsPanel.add(responsesPane);
					    }
					}
				});
			}
		});

	//view posting end
		
	//view my posts		
	
	//view my posts end	
		
	//Add post panel
		Border border = BorderFactory.createLineBorder(Color.GRAY);

		userQuestion = new JLabel("Are you a?");
		userQuestion.setFont(new Font("Source Sans Pro", Font.PLAIN, 20));
		btnGroupAdd = new ButtonGroup();
		rdoSeniorAdd = new JRadioButton("Senior");
		rdoStudentAdd = new JRadioButton("Student");
		textFieldWanted = new JTextArea(5, 30);
		JScrollPane scrollpane1 = new JScrollPane(textFieldWanted);
		scrollpane1.setBorder(null);
		textFieldWanted.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		textFieldWanted.setFont(new Font("Source Sans Pro", Font.PLAIN, 20));
		textFieldOffer = new JTextArea(5, 30);
		JScrollPane scrollpane2 = new JScrollPane(textFieldOffer);
		scrollpane2.setBorder(null);
		textFieldOffer.setFont(new Font("Source Sans Pro", Font.PLAIN, 20));
		textFieldOffer.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		textFieldContact = new JTextArea(2, 30);
		JScrollPane scrollpane3 = new JScrollPane(textFieldContact);
		scrollpane3.setBorder(null);
		textFieldContact.setFont(new Font("Source Sans Pro", Font.PLAIN, 20));
		textFieldContact.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
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
		pane.setBackground(new Color(247, 247, 247));
		
		datePicker = new JXDatePicker();
		datePicker.getEditor().setEditable(false);
		
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
					if (postsTest != null) {
						postList = new JList(postsTest);
						postList.setBackground(new Color(247, 247, 247));
						postList.setCellRenderer(new PostCellRenderer());
						postList.setVisibleRowCount(7);
						postList.setFont(new Font("Source Sans Pro", Font.PLAIN, 20));
						pane.removeAll();
						pane.add(postList);
					} else {
						pane.add(new JLabel("No posts have been added yet!"));
					}
					viewPostingsPanel.add(pane);

					postList.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent evt) {
						    if (evt.getClickCount() == 2) {
						    	
				            	Post p = (Post)(postList.getSelectedValue());
				            	Integer pId = p.getPostId();
				            	
				            	Object[] response = {
				            	    "Response:", message,
				            	    "Contact Info:", contact
				            	};
				            	
				            	Object[] options = {"RESPOND", "REPORT", "CANCEL"};
				            	int option = JOptionPane.showOptionDialog(null, "Click OK to continue", "Warning",
				                        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
				            	
				            	if (option == JOptionPane.YES_OPTION) {
							    	int opt = JOptionPane.showConfirmDialog(null, response, "Respond To Post", JOptionPane.OK_CANCEL_OPTION);
					            	if (opt == JOptionPane.OK_OPTION) {
					            		try {
											logic.addResponse(message.getText(), contact.getText(), pId);
										} catch (Exception e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
					            	}
				            	}
				            	
				            	if (option == JOptionPane.NO_OPTION) {
				            		JOptionPane.showMessageDialog(null, "This post has been reported", "Report", JOptionPane.OK_OPTION);
				            	}
				            	
						    }
						}
					});
			}
		});
		
//		postList.addListSelectionListener(new ListSelectionListener() {
//			@Override
//            public void valueChanged(ListSelectionEvent arg0) {
//                if (!arg0.getValueIsAdjusting()) {
//                	Post p = (Post)(postResponseList.getSelectedValue());
//                	Integer pId = p.getPostId();
//                	
//                	Object[] response = {
//                	    "Response:", message,
//                	    "Contact Info:", contact
//                	};
//
//                	int option = JOptionPane.showConfirmDialog(null, response, "Respond", JOptionPane.OK_CANCEL_OPTION);
//                	if (option == JOptionPane.OK_OPTION) {
//                		try {
//							logic.addResponse(message.getText(), contact.getText(), pId);
//						} catch (Exception e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//                	} else {
//                	}
//                }
//            }
//        });
		

		
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

		addPostConstraints.anchor = GridBagConstraints.LINE_START;
		addPostConstraints.gridwidth = GridBagConstraints.REMAINDER;
		
		addPostConstraints.gridx = 0;
		addPostConstraints.gridy = 1;
		addPostPanel.add(userQuestion, addPostConstraints);
		
		addPostConstraints.gridx = 1;
		addPostConstraints.gridy = 1;
		addPostPanel.add(rdoSeniorAdd, addPostConstraints);
		
		addPostConstraints.gridx = 2;
		addPostConstraints.gridy = 1;	
		addPostPanel.add(rdoStudentAdd, addPostConstraints);

		addPostConstraints.gridx = 1;
		addPostConstraints.gridy = 2;
		addPostPanel.add(scrollpane1, addPostConstraints);
		
		addPostConstraints.gridx = 1;
		addPostConstraints.gridy = 3;
		addPostPanel.add(scrollpane2, addPostConstraints);
		
		addPostConstraints.gridx = 1;
		addPostConstraints.gridy = 4;
		addPostPanel.add(scrollpane3, addPostConstraints);	

		addPostConstraints.gridwidth = GridBagConstraints.RELATIVE;

		addPostConstraints.gridx = 0;
		addPostConstraints.gridy = 2;
		addPostPanel.add(lblWanted, addPostConstraints);
		
		constraints.anchor = GridBagConstraints.LINE_END;
		addPostConstraints.gridx = 0;
		addPostConstraints.gridy = 3;
		addPostPanel.add(lblOffer, addPostConstraints);
		
		addPostConstraints.gridx = 0;
		addPostConstraints.gridy = 4;
		addPostPanel.add(lblContact, addPostConstraints);
		
		//add datepicker
		datePicker.getEditor().setEditable(false);
		datePicker.getEditor().setBorder(new LineBorder(new Color(192, 192, 192)));
		addPostConstraints.gridx = 2;
		addPostConstraints.gridy = 2;
		addPostConstraints.insets = new Insets(10,10,10,10);  
		addPostPanel.add(datePicker, addPostConstraints);
		
		addPostConstraints.gridx = 1;
		addPostConstraints.gridy = 5;
		addPostPanel.add(submitPost, addPostConstraints);
		
		constraints.anchor = GridBagConstraints.CENTER;
		addPostConstraints.gridx = 2;
		addPostConstraints.gridy = 5;
		addPostPanel.add(lblCheck2, addPostConstraints);
		
		addPostPanel.setBackground(new Color(247, 247, 247));
		
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
			
				Date dateSelected = datePicker.getDate();
				
				try {
					logic.addPost(wanted, offer, contact, user, dateSelected);
					lblCheck2.setIcon(iconCheck);
					textFieldWanted.setText("");
					textFieldOffer.setText("");
					textFieldContact.setText("");
					datePicker.setDate(null);
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
	//end Add Post

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
		
		logic = new Logic("posts.xml", "responses.xml");
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

