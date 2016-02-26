package ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
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
import javax.swing.JToolTip;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import objects.Post;

import org.jdesktop.swingx.JXDatePicker;

import applogic.Logic;
import applogic.PostCellRenderer;

public class Interface extends JFrame{
	
	private static applogic.Logic logic;
	private String userType;
	
	//login
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
	private JLabel logoImageLabel;
	private Image logoImageScaled;
	private ImageIcon logoIconScaled;
	private JLabel unbImageLabel;
	private Image unbImageScaled;
	private ImageIcon unbIconScaled;
	
	//view all posts
	private JPanel viewPostingsPanel;
	private ButtonGroup btnGroup;
	private JRadioButton rdoSenior;
	private JRadioButton rdoStudent;
	private JButton goToAddPostBtn;
	private JButton goToMyPostsBtn;
	private JList allPostsList;
	private JPanel allPostsListPane;
	private JButton logoutAllPostsBtn;
	private JButton helpAllPostsBtn;
	private JPanel allPostsRedPanel;
	private JPanel allPostsBlackPanel;
	private JLabel allPostsTitle;
	private GridBagConstraints viewPostsConstraints;
	private JPanel allPostsBottomPanel;
	private GridBagConstraints bottomPanelConstraints;
	private JPanel allPostsBottomPanelLeft;
	private JPanel leftTop;
	private JPanel leftBottom;
	private GridBagConstraints bottomPanelLeftConstraints;
	private JPanel allPostsBottomPanelRight;
	private GridBagConstraints bottomPanelRightConstraints;
	private JLabel noPostsAddedLbl;
	private JScrollPane scrollPaneForList;

	//view my posts/responses
	private JLabel responseLbl;
	private JList postResponseList;
	private JPanel postPane;
	private JPanel viewMyPostsPanel;
	private JTextField contact;
	private JTextField message;
	private JList responseList;
	private JPanel responsesPane;
	private JTextArea responsesText;
	private JScrollPane respScrollPane;
	private JButton logoutMyPostsBtn;
	private JButton helpMyPostsBtn;
	private JScrollPane myPostsScrollPane;
	private JButton deletePost;
	private GridBagConstraints myPostsConstraints;
	private JPanel myPostsBottomPanel;
	private GridBagConstraints myBottomPanelConstraints;
	private JPanel myPostsBottomPanelLeft;
	private GridBagConstraints myBottomPanelLeftConstraints;
	private JPanel myPostsBottomPanelRight;
	private GridBagConstraints myBottomPanelRightConstraints;
	private JPanel myPostsRedPanel;
	private JPanel myPostsBlackPanel;
	private JLabel myUnbImageLabel;
	private Image myUnbImageScaled;
	private ImageIcon myUnbIconScaled;
	private JLabel myPostsTitle;
	private JButton myBackToViewAllPostsBtn;
	
	//add new post
	private JPanel addPostsBottomPanel;
	private GridBagConstraints bottomPanelAddConstraints;
	private JPanel addPostsRedPanel;
	private JButton logoutAddPostsBtn;
	private JButton helpAddPostsBtn;
	private JPanel addPostsBlackPanel;
	private JLabel addPostsTitle;
	private JPanel addPostPanel;
	private JTextArea textFieldWanted;
	private JTextArea textFieldOffer;
	private JLabel lblWanted;
	private JLabel lblOffer;
	private JLabel lblAvailable;
	private JButton submitPost;
	private Image imgCheck;
	private Image imgCheckSmall;
	private Icon iconCheck;
	private JLabel lblCheck2;
	private JButton backToViewAllPostsBtn;
	private JXDatePicker datePicker;
	private JLabel unbImageLabelAdd;
	private Image unbImageScaledAdd;
	private ImageIcon unbIconScaledAdd;
	
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
		postPane = new JPanel();
		postPane.setBackground(new Color(255, 255, 255));
		postPane.setPreferredSize(new Dimension (600,300));
		postPane.setBorder(new LineBorder(Color.BLACK, 3));
		allPostsListPane = new JPanel();
		logoImageLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/image1.png")).getImage();
		logoImageScaled = img.getScaledInstance(600, 400, java.awt.Image.SCALE_SMOOTH);
		logoIconScaled = new ImageIcon(logoImageScaled);
		logoImageLabel.setIcon(logoIconScaled);
		cardPanel.setLayout(cardLayout);
		loginPanel.setLayout(new GridBagLayout());
		
		contact = new JTextField();
		message = new JTextField();
		
		noPostsAddedLbl = new JLabel("No posts have been added yet!");
		noPostsAddedLbl.setFont(new Font("Georgia", Font.PLAIN, 20));
		
		GridBagConstraints constraints = new GridBagConstraints();
		
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.weightx = 0.5;
		constraints.weighty = 0.5;
		
		constraints.gridwidth = 3;

		constraints.gridx = 0;
		constraints.gridy = 0;
		loginPanel.add(logoImageLabel, constraints);
		
		constraints.gridwidth = 1;
				
		constraints.anchor = GridBagConstraints.LINE_END;
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.insets = new Insets(8,8,8,8);  
		lblUsername.setFont(new Font("Georgia", Font.PLAIN, 20));
		loginPanel.add(lblUsername, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 2;
		lblPassword.setFont(new Font("Georgia", Font.PLAIN, 20));
		loginPanel.add(lblPassword, constraints);
		
		constraints.anchor = GridBagConstraints.LINE_START;
		constraints.gridx = 2;
		constraints.gridy = 1;
		textFieldUsername.setPreferredSize(new Dimension(190, 40));
		textFieldUsername.setFont(new Font("Georgia", Font.PLAIN, 20));
		loginPanel.add(textFieldUsername, constraints);
		
		constraints.gridx = 2;
		constraints.gridy = 2;
		loginPanel.add(textFieldPassword, constraints);
		textFieldPassword.setEchoChar('*');
		textFieldPassword.setPreferredSize(new Dimension(190, 40));
		textFieldPassword.setFont(new Font("Georgia", Font.PLAIN, 20));
		btnSubmit.setSize(10, 20);
		
		constraints.anchor = GridBagConstraints.FIRST_LINE_START;
		constraints.weighty = 10;
		constraints.gridx = 2;
		constraints.gridy = 3;
		
		btnSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if ((textFieldUsername.getText().equals("senior") && textFieldPassword.getText().equals("senior")) || (textFieldUsername.getText().equals("student") && textFieldPassword.getText().equals("student"))) {
					if (textFieldUsername.getText().equals("senior")) {
						userType = "senior";
					}
					if (textFieldUsername.getText().equals("student")) {
						userType = "student";
					}
					
					textFieldUsername.setText(null);
					textFieldPassword.setText(null);

					cardLayout.show(cardPanel, "2");	
					Object[] postsTest = null;
					try {
						postsTest = logic.showAll();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					if (postsTest != null) {
						allPostsList = new JList(postsTest) {
							@Override
				            public JToolTip createToolTip() {
				                JToolTip toolTip = super.createToolTip();
				                toolTip.setFont(new Font("Georgia", Font.PLAIN, 17));
				                toolTip.setBackground(Color.BLACK);
				                toolTip.setForeground(Color.WHITE);
	
				                return toolTip;
				            }
						};
						
						allPostsList.setBackground(new Color(255, 255, 255));
						allPostsList.setCellRenderer(new PostCellRenderer());
						allPostsList.setVisibleRowCount(4);
						allPostsList.setToolTipText("Click the post to view options to RESPOND or REPORT");
						
						scrollPaneForList = new JScrollPane(allPostsList);
						scrollPaneForList.setPreferredSize(new Dimension (650,295));
						scrollPaneForList.setBorder(null);
						
						allPostsListPane.removeAll();
						allPostsListPane.add(scrollPaneForList);
						
					} else {
						allPostsList = new JList();
						allPostsListPane.removeAll();
						allPostsListPane.add(noPostsAddedLbl);
					}
					bottomPanelRightConstraints.gridheight = GridBagConstraints.REMAINDER;
					bottomPanelRightConstraints.gridwidth = GridBagConstraints.REMAINDER;
					bottomPanelRightConstraints.anchor = GridBagConstraints.CENTER;
					bottomPanelRightConstraints.insets = new Insets(30,30,30,30); 
					bottomPanelRightConstraints.fill = GridBagConstraints.BOTH;
					bottomPanelRightConstraints.weighty = 1;
					bottomPanelRightConstraints.weightx = 1;
					bottomPanelRightConstraints.gridx = 0;
					bottomPanelRightConstraints.gridy = 1;
					allPostsBottomPanelRight.add(allPostsListPane, bottomPanelRightConstraints);
	
					allPostsList.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent evt) {
						    if (evt.getClickCount() == 1) {
						    	
				            	Post p = (Post)(allPostsList.getSelectedValue());
				            	Integer pId = p.getPostId();
				            	
				            	if (!p.getUser().equalsIgnoreCase(userType)) {
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
												message.setText(null);
												contact.setText(null);
											} catch (Exception e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
						            	}
					            	}
					            	if (option == JOptionPane.NO_OPTION) {
					            		JOptionPane.showMessageDialog(null, "This post has been reported", "Report", JOptionPane.OK_OPTION);
					            	}
				            	} else {
				            		String s = "Sorry, you cannot respond to fellow " + userType + " posts.";
				            		JOptionPane.showMessageDialog(null, s, "Report", JOptionPane.OK_OPTION);
				            	}
						    }
						}
					});
				} else if (!textFieldUsername.getText().isEmpty() && textFieldPassword.getPassword().length == 0){
					JOptionPane.showMessageDialog(frame,
						"You have entered an invalid login. Please try again.",
						"Inane error",
						JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		 
		btnSubmit.setFont(new Font("Georgia", Font.PLAIN, 24));
		btnSubmit.setPreferredSize(new Dimension(120, 40));
		loginPanel.add(btnSubmit, constraints);
		loginPanel.setBackground(new Color(215, 215, 215));
		
		JScrollPane scrollWholePage = new JScrollPane();
		scrollWholePage.add(loginPanel);
		cardPanel.add(loginPanel, "1");
	//login end
		

	//view posting start
		//--------nav bar-------
		logoutAllPostsBtn = new JButton("<html><u>Logout</u></html>") {
			@Override
            public JToolTip createToolTip() {
                JToolTip toolTip = super.createToolTip();
                toolTip.setFont(new Font("Georgia", Font.PLAIN, 17));
                toolTip.setBackground(Color.BLACK);
                toolTip.setForeground(Color.WHITE);

                return toolTip;
            }
		};
		logoutAllPostsBtn.setFont(new Font("Georgia", Font.PLAIN, 24));
		logoutAllPostsBtn.setPreferredSize(new Dimension(120, 40));
		logoutAllPostsBtn.setBorder(null);
		logoutAllPostsBtn.setBackground(new Color(205, 0, 0));
		logoutAllPostsBtn.setForeground(Color.WHITE);
		logoutAllPostsBtn.setToolTipText("Click to logout of the website");
		
		helpAllPostsBtn = new JButton("<html><u>Help</u></html>") {
			@Override
            public JToolTip createToolTip() {
                JToolTip toolTip = super.createToolTip();
                toolTip.setFont(new Font("Georgia", Font.PLAIN, 17));
                toolTip.setBackground(Color.BLACK);
                toolTip.setForeground(Color.WHITE);

                return toolTip;
            }
		};
		helpAllPostsBtn.setFont(new Font("Georgia", Font.PLAIN, 24));
		helpAllPostsBtn.setPreferredSize(new Dimension(120, 40));
		helpAllPostsBtn.setBorder(null);
		helpAllPostsBtn.setBackground(new Color(205, 0, 0));
		helpAllPostsBtn.setForeground(Color.WHITE);
		helpAllPostsBtn.setToolTipText("Click to learn how to find the instructions on this webpage");
		
		allPostsRedPanel = new JPanel();
		allPostsRedPanel.setPreferredSize(new Dimension(300,80));
        allPostsRedPanel.setBackground(new Color(205, 0, 0));
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(helpAllPostsBtn);
        buttonPanel.add(logoutAllPostsBtn);
        buttonPanel.setOpaque(false);
        
        viewPostingsPanel.setLayout(new GridBagLayout());
        viewPostingsPanel.setBackground(new Color(215, 215, 215));

        allPostsRedPanel.setLayout(new GridBagLayout());
		GridBagConstraints redPanelConstraints = new GridBagConstraints();
		redPanelConstraints.weightx = 0.5;
		redPanelConstraints.weighty = 0.5;
		redPanelConstraints.fill = GridBagConstraints.HORIZONTAL;
		
		redPanelConstraints.gridx = 0;
		redPanelConstraints.gridy = 0;
		allPostsRedPanel.add(buttonPanel, redPanelConstraints);
		
		//--------title bar-------
		
		allPostsTitle = new JLabel("View All Posts");
		allPostsTitle.setFont(new Font("Georgia", Font.PLAIN, 60));
		allPostsTitle.setForeground(Color.WHITE);
		
		allPostsBlackPanel = new JPanel(new BorderLayout());
		allPostsBlackPanel.setPreferredSize(new Dimension(300,80));
		allPostsBlackPanel.setBackground(new Color(0, 0, 0));
		allPostsBlackPanel.add(allPostsTitle, BorderLayout.WEST);
		
		//--------right-------

		allPostsBottomPanelRight = new JPanel(new GridBagLayout());
		allPostsBottomPanelRight.setPreferredSize(new Dimension(300,600));
		allPostsBottomPanelRight.setBackground(new Color(215, 215, 215));

		btnGroup = new ButtonGroup();
		rdoSenior = new JRadioButton("Senior Posts");
		rdoSenior.setFont(new Font("Georgia", Font.PLAIN, 20));
		
		rdoStudent = new JRadioButton("Student Posts");
		rdoStudent.setFont(new Font("Georgia", Font.PLAIN, 20));

		btnGroup.add(rdoSenior);
		btnGroup.add(rdoStudent);
		
		rdoSenior.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object[] postsTest = null;
				try {
					postsTest = logic.filterBySeniorUser(userType);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				if (postsTest != null) {
					allPostsList = new JList(postsTest) {
						@Override
			            public JToolTip createToolTip() {
			                JToolTip toolTip = super.createToolTip();
			                toolTip.setFont(new Font("Georgia", Font.PLAIN, 17));
			                toolTip.setBackground(Color.BLACK);
			                toolTip.setForeground(Color.WHITE);

			                return toolTip;
			            }
					};
					
					allPostsList.setBackground(new Color(255, 255, 255));
					allPostsList.setCellRenderer(new PostCellRenderer());
					allPostsList.setVisibleRowCount(4);
					allPostsList.setToolTipText("Click the post to view options to RESPOND or REPORT");
					
					scrollPaneForList = new JScrollPane(allPostsList);
					scrollPaneForList.setPreferredSize(new Dimension (650,295));
					scrollPaneForList.setBorder(null);
					
					allPostsListPane.removeAll();
					allPostsListPane.add(scrollPaneForList);
					allPostsListPane.validate();
					allPostsListPane.repaint();
					repaint();
					frame.repaint();
					scrollPaneForList.repaint();
					
				} else {
					allPostsList = new JList();
					allPostsListPane.removeAll();
					allPostsListPane.add(noPostsAddedLbl);
					allPostsListPane.repaint();
					repaint();
					frame.repaint();
					scrollPaneForList.repaint();
				}
				bottomPanelRightConstraints.gridheight = GridBagConstraints.REMAINDER;
				bottomPanelRightConstraints.gridwidth = GridBagConstraints.REMAINDER;
				bottomPanelRightConstraints.anchor = GridBagConstraints.CENTER;
				bottomPanelRightConstraints.insets = new Insets(30,30,30,30); 
				bottomPanelRightConstraints.fill = GridBagConstraints.BOTH;
				bottomPanelRightConstraints.weighty = 1;
				bottomPanelRightConstraints.weightx = 1;
				bottomPanelRightConstraints.gridx = 0;
				bottomPanelRightConstraints.gridy = 1;
				allPostsBottomPanelRight.add(allPostsListPane, bottomPanelRightConstraints);

				allPostsList.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent evt) {
					    if (evt.getClickCount() == 1) {
					    	
			            	Post p = (Post)(allPostsList.getSelectedValue());
			            	Integer pId = p.getPostId();
			            	
			            	if (!p.getUser().equalsIgnoreCase(userType)) {
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
											message.setText(null);
											contact.setText(null);
										} catch (Exception e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
					            	}
				            	}
				            	if (option == JOptionPane.NO_OPTION) {
				            		JOptionPane.showMessageDialog(null, "This post has been reported", "Report", JOptionPane.OK_OPTION);
				            	}
			            	} else {
			            		String s = "Sorry, you cannot respond to fellow " + userType + " posts.";
			            		JOptionPane.showMessageDialog(null, s, "Report", JOptionPane.OK_OPTION);
			            	}
					    }
					}
				});				
			}
		});
		
		rdoStudent.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object[] postsTest = null;
				try {
					postsTest = logic.filterByStudentUser(userType);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				if (postsTest != null) {
					allPostsList = new JList(postsTest) {
						@Override
			            public JToolTip createToolTip() {
			                JToolTip toolTip = super.createToolTip();
			                toolTip.setFont(new Font("Georgia", Font.PLAIN, 17));
			                toolTip.setBackground(Color.BLACK);
			                toolTip.setForeground(Color.WHITE);

			                return toolTip;
			            }
					};
					
					allPostsList.setBackground(new Color(255, 255, 255));
					allPostsList.setCellRenderer(new PostCellRenderer());
					allPostsList.setVisibleRowCount(4);
					allPostsList.setToolTipText("Click the post to view options to RESPOND or REPORT");
					
					scrollPaneForList = new JScrollPane(allPostsList);
					scrollPaneForList.setPreferredSize(new Dimension (650,295));
					scrollPaneForList.setBorder(null);
					
					allPostsListPane.removeAll();
					allPostsListPane.add(scrollPaneForList);
					allPostsListPane.validate();
					allPostsListPane.repaint();
					repaint();
					frame.repaint();
					scrollPaneForList.repaint();
					
				} else {
					allPostsList = new JList();
					allPostsListPane.removeAll();
					allPostsListPane.add(noPostsAddedLbl);
					allPostsListPane.repaint();
					repaint();
					frame.repaint();
					scrollPaneForList.repaint();
				}
				bottomPanelRightConstraints.gridheight = GridBagConstraints.REMAINDER;
				bottomPanelRightConstraints.gridwidth = GridBagConstraints.REMAINDER;
				bottomPanelRightConstraints.anchor = GridBagConstraints.CENTER;
				bottomPanelRightConstraints.insets = new Insets(30,30,30,30); 
				bottomPanelRightConstraints.fill = GridBagConstraints.BOTH;
				bottomPanelRightConstraints.weighty = 1;
				bottomPanelRightConstraints.weightx = 1;
				bottomPanelRightConstraints.gridx = 0;
				bottomPanelRightConstraints.gridy = 1;
				allPostsBottomPanelRight.add(allPostsListPane, bottomPanelRightConstraints);

				allPostsList.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent evt) {
					    if (evt.getClickCount() == 1) {
					    	
			            	Post p = (Post)(allPostsList.getSelectedValue());
			            	Integer pId = p.getPostId();
			            	
			            	if (!p.getUser().equalsIgnoreCase(userType)) {
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
											message.setText(null);
											contact.setText(null);
										} catch (Exception e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
					            	}
				            	}
				            	if (option == JOptionPane.NO_OPTION) {
				            		JOptionPane.showMessageDialog(null, "This post has been reported", "Report", JOptionPane.OK_OPTION);
				            	}
			            	} else {
			            		String s = "Sorry, you cannot respond to fellow " + userType + " posts.";
			            		JOptionPane.showMessageDialog(null, s, "Report", JOptionPane.OK_OPTION);
			            	}
					    }
					}
				});				
			}
		});
		
		bottomPanelRightConstraints = new GridBagConstraints();
		
		JLabel filterBy = new JLabel("View Only:") {
			@Override
            public JToolTip createToolTip() {
                JToolTip toolTip = super.createToolTip();
                toolTip.setFont(new Font("Georgia", Font.PLAIN, 17));
                toolTip.setBackground(Color.BLACK);
                toolTip.setForeground(Color.WHITE);

                return toolTip;
            }
		};
		filterBy.setToolTipText("Select to only see posts by that type of user.");
		filterBy.setFont(new Font("Georgia", Font.PLAIN, 20));
		bottomPanelRightConstraints.insets = new Insets(30,30,30,30); 
		bottomPanelRightConstraints.weightx = 0;
		bottomPanelRightConstraints.anchor = GridBagConstraints.LINE_START;
		bottomPanelRightConstraints.gridx = 0;
		bottomPanelRightConstraints.gridy = 0;
		allPostsBottomPanelRight.add(filterBy, bottomPanelRightConstraints);
		bottomPanelRightConstraints.gridx = 1;
		bottomPanelRightConstraints.gridy = 0;
		allPostsBottomPanelRight.add(rdoSenior, bottomPanelRightConstraints);
		bottomPanelRightConstraints.gridx = 2;
		bottomPanelRightConstraints.gridy = 0;
		allPostsBottomPanelRight.add(rdoStudent, bottomPanelRightConstraints);
		
//		bottomPanelRightConstraints.gridheight = GridBagConstraints.REMAINDER;
		bottomPanelRightConstraints.insets = new Insets(30,30,30,30); 
//		bottomPanelRightConstraints.fill = GridBagConstraints.BOTH;
		bottomPanelRightConstraints.gridx = 0;
		bottomPanelRightConstraints.gridy = 1;
		allPostsBottomPanelRight.add(allPostsListPane, bottomPanelRightConstraints);
		
		//--------left-------
		
		allPostsBottomPanelLeft = new JPanel(new GridBagLayout());
		allPostsBottomPanelLeft.setPreferredSize(new Dimension(300,600));
		allPostsBottomPanelLeft.setBackground(new Color(215, 215, 215));

		goToAddPostBtn = new JButton("Add Post") {
			@Override
            public JToolTip createToolTip() {
                JToolTip toolTip = super.createToolTip();
                toolTip.setFont(new Font("Georgia", Font.PLAIN, 17));
                toolTip.setBackground(Color.BLACK);
                toolTip.setForeground(Color.WHITE);
                return toolTip;
            }
		};
		goToAddPostBtn.setToolTipText("Click to go to the page to publish a new post to the website.");
		goToAddPostBtn.setFont(new Font("Georgia", Font.PLAIN, 25));
		goToAddPostBtn.setPreferredSize(new Dimension(180, 50));
		goToMyPostsBtn = new JButton("View My Posts") {
			@Override
            public JToolTip createToolTip() {
                JToolTip toolTip = super.createToolTip();
                toolTip.setFont(new Font("Georgia", Font.PLAIN, 17));
                toolTip.setBackground(Color.BLACK);
                toolTip.setForeground(Color.WHITE);
                return toolTip;
            }
		};
		goToMyPostsBtn.setToolTipText("Click to go to the page to view your own published posts. Here you can also check to view responses to your posts");
		goToMyPostsBtn.setFont(new Font("Georgia", Font.PLAIN, 25));
		goToMyPostsBtn.setPreferredSize(new Dimension(240, 50));
		
		unbImageLabel = new JLabel("");
		Image imgUNB = new ImageIcon(this.getClass().getResource("/unb_logo_white.png")).getImage();
		unbImageScaled = imgUNB.getScaledInstance(300, 150, java.awt.Image.SCALE_SMOOTH);
		unbIconScaled = new ImageIcon(unbImageScaled);
		unbImageLabel.setIcon(unbIconScaled);

		bottomPanelLeftConstraints = new GridBagConstraints();
		bottomPanelLeftConstraints.weightx = 0.4;
		bottomPanelLeftConstraints.weighty = 0.2;
		
		bottomPanelLeftConstraints.insets = new Insets(20,20,20,20); 
		bottomPanelLeftConstraints.anchor = GridBagConstraints.LINE_START;
		bottomPanelLeftConstraints.gridx = 0;
		bottomPanelLeftConstraints.gridy = 0;
		allPostsBottomPanelLeft.add(goToAddPostBtn, bottomPanelLeftConstraints);
		
		bottomPanelLeftConstraints.weighty = 0.6;
		bottomPanelLeftConstraints.gridx = 0;
		bottomPanelLeftConstraints.gridy = 1;
		allPostsBottomPanelLeft.add(goToMyPostsBtn, bottomPanelLeftConstraints);
		
		bottomPanelLeftConstraints.gridx = 0;
		bottomPanelLeftConstraints.gridy = 2;
		allPostsBottomPanelLeft.add(unbImageLabel, bottomPanelLeftConstraints);
		
		
		//--------bottom-------
		
		allPostsBottomPanel = new JPanel(new GridBagLayout());
		allPostsBottomPanel.setPreferredSize(new Dimension(300,600));
		allPostsBottomPanel.setBackground(new Color(215, 215, 215));
		
		bottomPanelConstraints = new GridBagConstraints();
		
		bottomPanelConstraints.fill = GridBagConstraints.BOTH;
		bottomPanelConstraints.gridheight = GridBagConstraints.REMAINDER;
		
		bottomPanelConstraints.weightx = 0.3;
		bottomPanelConstraints.weighty = 0.5;
		bottomPanelConstraints.gridx = 0;
		bottomPanelConstraints.gridy = 0;
		allPostsBottomPanel.add(allPostsBottomPanelLeft, bottomPanelConstraints);

		bottomPanelConstraints.weightx = 0.7;
		bottomPanelConstraints.weighty = 0.5;
		
		bottomPanelConstraints.gridx = 1;
		bottomPanelConstraints.gridy = 0;
		allPostsBottomPanel.add(allPostsBottomPanelRight, bottomPanelConstraints);

		viewPostsConstraints = new GridBagConstraints();
		
		viewPostsConstraints.weightx = 0.2;
		viewPostsConstraints.weighty = 0.2;
		viewPostsConstraints.anchor = GridBagConstraints.NORTH;
		viewPostsConstraints.gridwidth = GridBagConstraints.REMAINDER;
		viewPostsConstraints.fill = GridBagConstraints.BOTH;
		
		viewPostsConstraints.gridx = 0;
		viewPostsConstraints.gridy = 0;
		viewPostingsPanel.add(allPostsRedPanel, viewPostsConstraints);
		
		viewPostsConstraints.gridx = 0;
		viewPostsConstraints.gridy = 1;
		viewPostingsPanel.add(allPostsBlackPanel, viewPostsConstraints);

		viewPostsConstraints.weightx = 0.8;
		viewPostsConstraints.weighty = 0.8;
		
		viewPostsConstraints.gridx = 0;
		viewPostsConstraints.gridy = 2;
		viewPostingsPanel.add(allPostsBottomPanel, viewPostsConstraints);
		
		cardPanel.add(addPostPanel, "4");
		
		goToAddPostBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "4");					
			}
		});
		
		leftTop = new JPanel();
		leftTop.setPreferredSize(new Dimension(500,500));
		leftTop.setBackground(new Color(215, 215, 215));
		
//		leftTop.setLayout(new BorderLayout());
//		JLabel postLabel = new JLabel("My Posts");
//	    leftTop.add(postLabel, BorderLayout.NORTH);

		
		goToMyPostsBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "5");
				Object[] postsTest = null;
				try {
					postsTest = logic.showMyPosts(userType);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				if (postsTest != null) {
					postResponseList = new JList(postsTest);
					postResponseList.setBackground(new Color(255, 255, 255));
					postResponseList.setCellRenderer(new PostCellRenderer());
					
					myPostsScrollPane = new JScrollPane(postResponseList);
					myPostsScrollPane.setPreferredSize(new Dimension (590,270));
					myPostsScrollPane.setBorder(null);
					
					postPane.removeAll();
					
					postPane.add(myPostsScrollPane);
					postPane.repaint();
					
				} else {
					postPane.removeAll();
					postPane.add(new JLabel());
					postResponseList = new JList();
				}
				respScrollPane.setPreferredSize(new Dimension(450,350));
				respScrollPane.setViewportView(responsesText);
				responsesPane.removeAll();
				responsesPane.add(respScrollPane);
				
				postResponseList.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent evt) {
					    if (evt.getClickCount() == 1) {
			            	Post p = (Post)(postResponseList.getSelectedValue());
			            	Integer pId = p.getPostId();
			            	int opt = -1;
			            	try {
			            		responsesText.setText(logic.showResponses(pId));
				            	if (logic.countResponses(pId) > 2) {
				    				opt = JOptionPane.showConfirmDialog(postPane, "Have you completed this task yet? Click Yes to delete the post.", "Have you completed this task yet?", JOptionPane.YES_NO_OPTION);
				            	}
								if (opt == 0) {
									logic.delete(pId);
									responsesText.setText(null);
									postResponseList.repaint();
									postPane.repaint();
									repaint();
									frame.repaint();
									scrollPaneForList.repaint();
								}
							}catch(Exception e) {
//								JOptionPane.showMessageDialog(compareWorkoutsPanel,
//										e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
							}
					    }
					}
				});
			
				
			    leftTop.add(postPane);
			   
			    myBottomPanelRightConstraints.gridx = 0;
			    myBottomPanelRightConstraints.gridy = 0;
			    myPostsBottomPanelRight.add(responsesPane, myBottomPanelRightConstraints);
			}
		});
		
		logoutAllPostsBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "1");
			}
		});
		
		helpAllPostsBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Hover your cursor over elements on the page to show specific instructions for each element.");
			}
		});

	//view posting end
		
	//view my posts	
		
		viewMyPostsPanel = new JPanel();
		responseLbl = new JLabel();
		responsesPane = new JPanel();
		responsesPane.setBackground(new Color(215,215,215));
		responsesText = new JTextArea();
		respScrollPane = new JScrollPane();
		
		responsesText = new JTextArea(5, 30);
		responsesText.setEditable(false);
		responsesText.setWrapStyleWord(true);
		responsesText.setLineWrap(true);
		responsesText.setForeground(Color.BLACK);
		responsesText.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 14));
		responsesText.setBackground(Color.WHITE);
		
		deletePost = new JButton("Delete Post");
		deletePost.setPreferredSize(new Dimension(100,20));
		
		
		logoutMyPostsBtn = new JButton("<html><u>Logout</u></html>") {
			@Override
            public JToolTip createToolTip() {
                JToolTip toolTip = super.createToolTip();
                toolTip.setFont(new Font("Georgia", Font.PLAIN, 17));
                toolTip.setBackground(Color.BLACK);
                toolTip.setForeground(Color.WHITE);

                return toolTip;
            }
		};
		logoutMyPostsBtn.setFont(new Font("Georgia", Font.PLAIN, 24));
		logoutMyPostsBtn.setPreferredSize(new Dimension(120, 40));
		logoutMyPostsBtn.setBorder(null);
		logoutMyPostsBtn.setBackground(new Color(205, 0, 0));
		logoutMyPostsBtn.setForeground(Color.WHITE);
		logoutMyPostsBtn.setToolTipText("Click to logout of the website");
		
		helpMyPostsBtn = new JButton("<html><u>Help</u></html>") {
			@Override
            public JToolTip createToolTip() {
                JToolTip toolTip = super.createToolTip();
                toolTip.setFont(new Font("Georgia", Font.PLAIN, 17));
                toolTip.setBackground(Color.BLACK);
                toolTip.setForeground(Color.WHITE);

                return toolTip;
            }
		};
		helpMyPostsBtn.setFont(new Font("Georgia", Font.PLAIN, 24));
		helpMyPostsBtn.setPreferredSize(new Dimension(120, 40));
		helpMyPostsBtn.setBorder(null);
		helpMyPostsBtn.setBackground(new Color(205, 0, 0));
		helpMyPostsBtn.setForeground(Color.WHITE);
		helpMyPostsBtn.setToolTipText("Click to learn how to find the instructions on this webpage");

		myBackToViewAllPostsBtn = new JButton("<html><u>Back to View All Posts</u></html>") {
			@Override
            public JToolTip createToolTip() {
                JToolTip toolTip = super.createToolTip();
                toolTip.setFont(new Font("Georgia", Font.PLAIN, 17));
                toolTip.setBackground(Color.BLACK);
                toolTip.setForeground(Color.WHITE);

                return toolTip;
            }
		};
		myBackToViewAllPostsBtn.setFont(new Font("Georgia", Font.PLAIN, 24));
		myBackToViewAllPostsBtn.setPreferredSize(new Dimension(260, 40));
		myBackToViewAllPostsBtn.setBorder(null);
		myBackToViewAllPostsBtn.setBackground(new Color(205, 0, 0));
		myBackToViewAllPostsBtn.setForeground(Color.WHITE);
		myBackToViewAllPostsBtn.setToolTipText("Click to return to the page to view all posts.");
		
		myBackToViewAllPostsBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				rdoSenior.setSelected(false);
				rdoStudent.setSelected(false);
				cardLayout.show(cardPanel, "2");	
				Object[] postsTest = null;
				try {
					postsTest = logic.showAll();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				if (postsTest != null) {
					allPostsList = new JList(postsTest) {
						@Override
			            public JToolTip createToolTip() {
			                JToolTip toolTip = super.createToolTip();
			                toolTip.setFont(new Font("Georgia", Font.PLAIN, 17));
			                toolTip.setBackground(Color.BLACK);
			                toolTip.setForeground(Color.WHITE);

			                return toolTip;
			            }
					};
					allPostsList.setBackground(new Color(255, 255, 255));
					allPostsList.setCellRenderer(new PostCellRenderer());
					allPostsList.setVisibleRowCount(4);
					allPostsList.setToolTipText("Click the post to view options to RESPOND or REPORT");
					
					scrollPaneForList = new JScrollPane(allPostsList);
					scrollPaneForList.setPreferredSize(new Dimension (650,295));
					scrollPaneForList.setBorder(null);
					
					allPostsListPane.removeAll();
					allPostsListPane.add(scrollPaneForList);
					
				} else {
					allPostsListPane.removeAll();
					allPostsListPane.add(noPostsAddedLbl);
					allPostsList = new JList();
				}

				allPostsList.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent evt) {
					    if (evt.getClickCount() == 1) {
					    	
			            	Post p = (Post)(allPostsList.getSelectedValue());
			            	Integer pId = p.getPostId();
			            	
			            	if (!p.getUser().equalsIgnoreCase(userType)) {
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
											message.setText(null);
											contact.setText(null);
										} catch (Exception e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
					            	}
				            	}
				            	
				            	if (option == JOptionPane.NO_OPTION) {
				            		JOptionPane.showMessageDialog(null, "This post has been reported", "Report", JOptionPane.OK_OPTION);
				            	}
			            	} else {
			            		String s = "Sorry, you cannot respond to fellow " + userType + " posts.";
			            		JOptionPane.showMessageDialog(null, s, "Report", JOptionPane.OK_OPTION);
			            	}
					    }
					}
				});
			}
		});
		
		JPanel myButtonPanel = new JPanel();
		myButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		myButtonPanel.add(helpMyPostsBtn);
		myButtonPanel.add(logoutMyPostsBtn);
		myButtonPanel.setOpaque(false);
		
		JPanel myBackButtonPanelAdd = new JPanel();
		myBackButtonPanelAdd.setLayout(new FlowLayout(FlowLayout.LEFT));
		myBackButtonPanelAdd.add(myBackToViewAllPostsBtn);
		myBackButtonPanelAdd.setOpaque(false);
		
		myPostsRedPanel = new JPanel();
		myPostsRedPanel.setPreferredSize(new Dimension(300,80));
		myPostsRedPanel.setBackground(new Color(205, 0, 0));
		myPostsRedPanel.setLayout(new GridBagLayout());
		
		GridBagConstraints myRedPanelConstraints = new GridBagConstraints();
		myRedPanelConstraints.weightx = 0.5;
		myRedPanelConstraints.weighty = 0.5;
		myRedPanelConstraints.fill = GridBagConstraints.HORIZONTAL;

		myRedPanelConstraints.gridx = 0;
		myRedPanelConstraints.gridy = 0;
		myPostsRedPanel.add(myBackButtonPanelAdd, myRedPanelConstraints);
		
		redPanelConstraints.gridx = 1;
		redPanelConstraints.gridy = 0;
		myPostsRedPanel.add(myButtonPanel, myRedPanelConstraints);

        
        viewMyPostsPanel.setLayout(new GridBagLayout());
        viewMyPostsPanel.setBackground(new Color(215, 215, 215));
		
		//--------title bar-------
		
		myPostsTitle = new JLabel("View My Posts & Responses");
		myPostsTitle.setFont(new Font("Georgia", Font.PLAIN, 60));
		myPostsTitle.setForeground(Color.WHITE);
		
		myPostsBlackPanel = new JPanel(new BorderLayout());
		myPostsBlackPanel.setPreferredSize(new Dimension(300,60));
		myPostsBlackPanel.setBackground(new Color(0, 0, 0));
		myPostsBlackPanel.add(myPostsTitle, BorderLayout.WEST);
		
		//--------right-------

		myPostsBottomPanelRight = new JPanel(new GridBagLayout());
		myPostsBottomPanelRight.setPreferredSize(new Dimension(600,600));
		myPostsBottomPanelRight.setBackground(new Color(215, 215, 215));
		
		myBottomPanelRightConstraints = new GridBagConstraints();
		myBottomPanelRightConstraints.weightx = 0.2;
		myBottomPanelRightConstraints.weighty = 0.2;

		myBottomPanelRightConstraints.gridheight = GridBagConstraints.REMAINDER;
		myBottomPanelRightConstraints.insets = new Insets(30,30,30,30); 
		myBottomPanelRightConstraints.fill = GridBagConstraints.BOTH;

		//--------left-------
		
		myPostsBottomPanelLeft = new JPanel(new GridBagLayout());
		myPostsBottomPanelLeft.setPreferredSize(new Dimension(600,600));
		myPostsBottomPanelLeft.setBackground(new Color(215, 215, 215));
		
		myUnbImageLabel = new JLabel("");
		Image myImgUNB = new ImageIcon(this.getClass().getResource("/unb_logo_white.png")).getImage();
		myUnbImageScaled = myImgUNB.getScaledInstance(210, 130, java.awt.Image.SCALE_SMOOTH);
		myUnbIconScaled = new ImageIcon(myUnbImageScaled);
		myUnbImageLabel.setIcon(myUnbIconScaled);

		myBottomPanelLeftConstraints = new GridBagConstraints();
		myBottomPanelLeftConstraints.fill = GridBagConstraints.BOTH;
//		myBottomPanelLeftConstraints.gridheight = GridBagConstraints.REMAINDER;
//		myBottomPanelLeftConstraints.gridwidth = GridBagConstraints.REMAINDER;
		myBottomPanelLeftConstraints.weightx = 0.5;
		myBottomPanelLeftConstraints.weighty = 1;
		
		myBottomPanelLeftConstraints.gridx = 0;
		myBottomPanelLeftConstraints.gridy = 0;
		myPostsBottomPanelLeft.add(leftTop, myBottomPanelLeftConstraints);
		
		leftBottom = new JPanel(new GridBagLayout());
		GridBagConstraints leftBottomConstraints = new GridBagConstraints();

		leftBottom.setPreferredSize(new Dimension(200,200));
		leftBottom.setBackground(new Color(215, 215, 215));
		
//		leftBottomConstraints.insets = new Insets(0,0,0,50);
		leftBottomConstraints.gridx = 0;
		leftBottomConstraints.gridy = 0;
		leftBottomConstraints.anchor = GridBagConstraints.LINE_END;
		
		leftBottom.add(myUnbImageLabel, leftBottomConstraints);
		
//		leftBottomConstraints.insets = new Insets(0,50,0,0);
		leftBottomConstraints.gridx = 1;
		leftBottomConstraints.gridy = 0;
//		leftBottomConstraints.anchor = GridBagConstraints.LINE_END;
		
		leftBottom.add(deletePost, leftBottomConstraints);
		
		myBottomPanelLeftConstraints.weightx = 0.5;
		myBottomPanelLeftConstraints.weighty = 0;
		myBottomPanelLeftConstraints.gridx = 0;
		myBottomPanelLeftConstraints.gridy = 1;
		myPostsBottomPanelLeft.add(leftBottom, myBottomPanelLeftConstraints);
		
		deletePost.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Post p = (Post)(postResponseList.getSelectedValue());
				if (p != null) {
					try {
						Integer pId = p.getPostId();
						logic.delete(pId);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(frame, "Please select a post to delete.");
				}
			}
			
		});
		
		//--------bottom-------
		
		myPostsBottomPanel = new JPanel(new GridBagLayout());
		myPostsBottomPanel.setPreferredSize(new Dimension(300,600));
		myPostsBottomPanel.setBackground(new Color(215, 215, 215));
		
		myBottomPanelConstraints = new GridBagConstraints();
		
		myBottomPanelConstraints.fill = GridBagConstraints.BOTH;
		myBottomPanelConstraints.gridheight = GridBagConstraints.REMAINDER;
		
		myBottomPanelConstraints.weightx = 0.5;
		myBottomPanelConstraints.weighty = 0.5;
		myBottomPanelConstraints.gridx = 0;
		myBottomPanelConstraints.gridy = 0;
		myPostsBottomPanel.add(myPostsBottomPanelLeft, myBottomPanelConstraints);

		myBottomPanelConstraints.weightx = 0.5;
		myBottomPanelConstraints.weighty = 0.5;
		
		myBottomPanelConstraints.gridx = 1;
		myBottomPanelConstraints.gridy = 0;
		myPostsBottomPanel.add(myPostsBottomPanelRight,  myBottomPanelConstraints);

		myPostsConstraints = new GridBagConstraints();
		
		myPostsConstraints.weightx = 0.2;
		myPostsConstraints.weighty = 0.2;
		myPostsConstraints.anchor = GridBagConstraints.NORTH;
		myPostsConstraints.gridwidth = GridBagConstraints.REMAINDER;
		myPostsConstraints.fill = GridBagConstraints.BOTH;
		
		myPostsConstraints.gridx = 0;
		myPostsConstraints.gridy = 0;
		viewMyPostsPanel.add(myPostsRedPanel, myPostsConstraints);
		
		myPostsConstraints.gridx = 0;
		myPostsConstraints.gridy = 1;
		viewMyPostsPanel.add(myPostsBlackPanel, myPostsConstraints);

		myPostsConstraints.weightx = 0.8;
		myPostsConstraints.weighty = 0.8;
		
		myPostsConstraints.gridx = 0;
		myPostsConstraints.gridy = 2;
		viewMyPostsPanel.add(myPostsBottomPanel, myPostsConstraints);
		
		logoutMyPostsBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "1");
			}
		});
		
		helpMyPostsBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Hover your cursor over elements on the page to show specific instructions for each element.");
			}
		});

		cardPanel.add(viewMyPostsPanel, "5");

	
	//view my posts end	
		
	//Add post panel
		Border border = BorderFactory.createLineBorder(Color.GRAY);

		textFieldWanted = new JTextArea(3, 30);
		JScrollPane scrollpane1 = new JScrollPane(textFieldWanted);
		scrollpane1.setBorder(null);
		textFieldWanted.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		textFieldWanted.setFont(new Font("Georgia", Font.PLAIN, 20));
		textFieldOffer = new JTextArea(3, 30);
		JScrollPane scrollpane2 = new JScrollPane(textFieldOffer);
		scrollpane2.setBorder(null);
		textFieldOffer.setFont(new Font("Georgia", Font.PLAIN, 20));
		textFieldOffer.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		lblWanted = new JLabel("<html>What do you need assistance with?<html/>");
		lblWanted.setFont(new Font("Georgia", Font.PLAIN, 20));
		lblOffer = new JLabel("<html>What can you offer in return?<html/>");
		lblOffer.setFont(new Font("Georgia", Font.PLAIN, 20));
		lblAvailable = new JLabel("<html>Choose a date for the meeting:<html/>");
		lblAvailable.setFont(new Font("Georgia", Font.PLAIN, 20));
		submitPost = new JButton("Submit Post") {
			@Override
	        public JToolTip createToolTip() {
		        JToolTip toolTip = super.createToolTip();
		        toolTip.setFont(new Font("Georgia", Font.PLAIN, 17));
		        toolTip.setBackground(Color.BLACK);
		        toolTip.setForeground(Color.WHITE);
		
		        return toolTip;
			}
        };
        submitPost.setToolTipText("Click to publish this information to the website in a post.");
		submitPost.setFont(new Font("Georgia", Font.PLAIN, 20));
		submitPost.setPreferredSize(new Dimension(130, 40));
		imgCheck = new ImageIcon(
				Interface.class.getResource("/check-mark.png"))
				.getImage();
		imgCheckSmall = imgCheck.getScaledInstance(50, 50,
			java.awt.Image.SCALE_SMOOTH);
		iconCheck = new ImageIcon(imgCheckSmall);
		lblCheck2 = new JLabel("");
		allPostsListPane.setBackground(new Color(255, 255, 255));
		allPostsListPane.setPreferredSize(new Dimension(900,500));
		allPostsListPane.setBorder(new LineBorder(Color.BLACK, 3));
		
		datePicker = new JXDatePicker();
		datePicker.getEditor().setEditable(false);
		
		//---red---
		
		addPostPanel.setLayout(new GridBagLayout());
		GridBagConstraints addPostConstraints = new GridBagConstraints();
		
		logoutAddPostsBtn = new JButton("<html><u>Logout</u></html>") {
			@Override
            public JToolTip createToolTip() {
                JToolTip toolTip = super.createToolTip();
                toolTip.setFont(new Font("Georgia", Font.PLAIN, 17));
                toolTip.setBackground(Color.BLACK);
                toolTip.setForeground(Color.WHITE);

                return toolTip;
            }
		};
		
		logoutAddPostsBtn.setFont(new Font("Georgia", Font.PLAIN, 24));
		logoutAddPostsBtn.setPreferredSize(new Dimension(120, 40));
		logoutAddPostsBtn.setBorder(null);
		logoutAddPostsBtn.setBackground(new Color(205, 0, 0));
		logoutAddPostsBtn.setForeground(Color.WHITE);
		logoutAddPostsBtn.setToolTipText("Click to logout of the website");
		
		helpAddPostsBtn = new JButton("<html><u>Help</u></html>") {
			@Override
            public JToolTip createToolTip() {
                JToolTip toolTip = super.createToolTip();
                toolTip.setFont(new Font("Georgia", Font.PLAIN, 17));
                toolTip.setBackground(Color.BLACK);
                toolTip.setForeground(Color.WHITE);

                return toolTip;
            }
		};
		helpAddPostsBtn.setFont(new Font("Georgia", Font.PLAIN, 24));
		helpAddPostsBtn.setPreferredSize(new Dimension(120, 40));
		helpAddPostsBtn.setBorder(null);
		helpAddPostsBtn.setBackground(new Color(205, 0, 0));
		helpAddPostsBtn.setForeground(Color.WHITE);
		helpAddPostsBtn.setToolTipText("Click to learn how to find the instructions on this webpage");
        
		backToViewAllPostsBtn = new JButton("<html><u>Back to View All Posts</u></html>") {
			@Override
            public JToolTip createToolTip() {
                JToolTip toolTip = super.createToolTip();
                toolTip.setFont(new Font("Georgia", Font.PLAIN, 17));
                toolTip.setBackground(Color.BLACK);
                toolTip.setForeground(Color.WHITE);

                return toolTip;
            }
		};
		backToViewAllPostsBtn.setFont(new Font("Georgia", Font.PLAIN, 24));
		backToViewAllPostsBtn.setPreferredSize(new Dimension(260, 40));
		backToViewAllPostsBtn.setBorder(null);
		backToViewAllPostsBtn.setBackground(new Color(205, 0, 0));
		backToViewAllPostsBtn.setForeground(Color.WHITE);
		backToViewAllPostsBtn.setToolTipText("Click to return to the page to view all posts.");
		
		backToViewAllPostsBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					rdoSenior.setSelected(false);
					rdoStudent.setSelected(false);
					cardLayout.show(cardPanel, "2");	
					Object[] postsTest = null;
					try {
						postsTest = logic.showAll();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					if (postsTest != null) {
						allPostsList = new JList(postsTest) {
							@Override
				            public JToolTip createToolTip() {
				                JToolTip toolTip = super.createToolTip();
				                toolTip.setFont(new Font("Georgia", Font.PLAIN, 17));
				                toolTip.setBackground(Color.BLACK);
				                toolTip.setForeground(Color.WHITE);

				                return toolTip;
				            }
						};
						allPostsList.setBackground(new Color(255, 255, 255));
						allPostsList.setCellRenderer(new PostCellRenderer());
						allPostsList.setVisibleRowCount(4);
						allPostsList.setToolTipText("Click the post to view options to RESPOND or REPORT");
						
						scrollPaneForList = new JScrollPane(allPostsList);
						scrollPaneForList.setPreferredSize(new Dimension (650,295));
						scrollPaneForList.setBorder(null);
						
						allPostsListPane.removeAll();
						allPostsListPane.add(scrollPaneForList);
						
					} else {
						allPostsListPane.removeAll();
						allPostsListPane.add(noPostsAddedLbl);
						allPostsList = new JList();
					}

					allPostsList.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent evt) {
						    if (evt.getClickCount() == 1) {
						    	
				            	Post p = (Post)(allPostsList.getSelectedValue());
				            	Integer pId = p.getPostId();
				            	
				            	if (!p.getUser().equalsIgnoreCase(userType)) {
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
												message.setText(null);
												contact.setText(null);
											} catch (Exception e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
						            	}
					            	}
					            	
					            	if (option == JOptionPane.NO_OPTION) {
					            		JOptionPane.showMessageDialog(null, "This post has been reported", "Report", JOptionPane.OK_OPTION);
					            	}
				            	} else {
				            		String s = "Sorry, you cannot respond to fellow " + userType + " posts.";
				            		JOptionPane.showMessageDialog(null, s, "Report", JOptionPane.OK_OPTION);
				            	}
						    }
						}
					});
			}
		});
		
		JPanel buttonPanelAdd = new JPanel();
		buttonPanelAdd.setLayout(new FlowLayout(FlowLayout.RIGHT));
		buttonPanelAdd.add(helpAddPostsBtn);
		buttonPanelAdd.add(logoutAddPostsBtn);
		buttonPanelAdd.setOpaque(false);
		
		JPanel backButtonPanelAdd = new JPanel();
		backButtonPanelAdd.setLayout(new FlowLayout(FlowLayout.LEFT));
		backButtonPanelAdd.add(backToViewAllPostsBtn);
		backButtonPanelAdd.setOpaque(false);
		
		addPostsRedPanel = new JPanel();
		addPostsRedPanel.setPreferredSize(new Dimension(300,80));
		addPostsRedPanel.setBackground(new Color(205, 0, 0));
		addPostsRedPanel.setLayout(new GridBagLayout());
		
		GridBagConstraints redPanelAddConstraints = new GridBagConstraints();
		redPanelAddConstraints.weightx = 0.5;
		redPanelAddConstraints.weighty = 0.5;
		redPanelAddConstraints.fill = GridBagConstraints.HORIZONTAL;

		redPanelAddConstraints.gridx = 0;
		redPanelAddConstraints.gridy = 0;
		addPostsRedPanel.add(backButtonPanelAdd, redPanelAddConstraints);
		
		redPanelAddConstraints.gridx = 1;
		redPanelAddConstraints.gridy = 0;
		addPostsRedPanel.add(buttonPanelAdd, redPanelAddConstraints);
		
		addPostConstraints.weightx = 0.2;
		addPostConstraints.weighty = 0.2;
		addPostConstraints.anchor = GridBagConstraints.NORTH;
		addPostConstraints.gridwidth = GridBagConstraints.REMAINDER;
		addPostConstraints.fill = GridBagConstraints.BOTH;
		
		addPostConstraints.gridx = 0;
		addPostConstraints.gridy = 0;
		addPostPanel.add(addPostsRedPanel, addPostConstraints);
		
		logoutAddPostsBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "1");
			}
		});
		
		helpAddPostsBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Hover your cursor over elements on the page to show specific instructions for each element.");
			}
		});
		
		//----black
		addPostsTitle = new JLabel("Add New Post");
		addPostsTitle.setFont(new Font("Georgia", Font.PLAIN, 60));
		addPostsTitle.setForeground(Color.WHITE);
		
		addPostsBlackPanel = new JPanel(new BorderLayout());
		addPostsBlackPanel.setPreferredSize(new Dimension(300,80));
		addPostsBlackPanel.setBackground(new Color(0, 0, 0));
		addPostsBlackPanel.add(addPostsTitle, BorderLayout.WEST);
		
		addPostConstraints.gridx = 0;
		addPostConstraints.gridy = 1;
		addPostPanel.add(addPostsBlackPanel, addPostConstraints);
		
		//----bottom
		addPostsBottomPanel = new JPanel(new GridBagLayout());
		addPostsBottomPanel.setPreferredSize(new Dimension(300,600));
		addPostsBottomPanel.setBackground(new Color(215, 215, 215));
		
		bottomPanelAddConstraints = new GridBagConstraints();
		bottomPanelAddConstraints.weightx = 0.5;
		bottomPanelAddConstraints.weighty = 0.5;
		bottomPanelAddConstraints.insets = new Insets(15,15,15,15);
		
		bottomPanelAddConstraints.gridx = 0;
		bottomPanelAddConstraints.gridy = 0;
		addPostsBottomPanel.add(lblWanted, bottomPanelAddConstraints);
		
		bottomPanelAddConstraints.gridx = 0;
		bottomPanelAddConstraints.gridy = 1;
		addPostsBottomPanel.add(lblOffer, bottomPanelAddConstraints);
		
		bottomPanelAddConstraints.gridx = 0;
		bottomPanelAddConstraints.gridy = 2;
		addPostsBottomPanel.add(lblAvailable, bottomPanelAddConstraints);

		bottomPanelAddConstraints.anchor = GridBagConstraints.LINE_START;
		
		//add datepicker
		datePicker.getEditor().setEditable(false);
		datePicker.getEditor().setBorder(new LineBorder(new Color(192, 192, 192)));
		datePicker.setPreferredSize(new Dimension(200, 40));
		datePicker.setFont(new Font("Georgia", Font.PLAIN, 20));
		datePicker.getEditor().setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		bottomPanelAddConstraints.gridx = 1;
		bottomPanelAddConstraints.gridy = 2;
		addPostsBottomPanel.add(datePicker, bottomPanelAddConstraints);
		
		unbImageLabelAdd = new JLabel("");
		Image imgUNBAdd = new ImageIcon(this.getClass().getResource("/unb_logo_white.png")).getImage();
		unbImageScaledAdd = imgUNBAdd.getScaledInstance(250, 100, java.awt.Image.SCALE_SMOOTH);
		unbIconScaledAdd = new ImageIcon(unbImageScaledAdd);
		unbImageLabelAdd.setIcon(unbIconScaledAdd);
		
		bottomPanelAddConstraints.gridx = 0;
		bottomPanelAddConstraints.gridy = 3;
		addPostsBottomPanel.add(unbImageLabelAdd, bottomPanelAddConstraints);
		
		bottomPanelAddConstraints.gridx = 1;
		bottomPanelAddConstraints.gridy = 3;
		addPostsBottomPanel.add(submitPost, bottomPanelAddConstraints);
		
		bottomPanelAddConstraints.gridx = 2;
		bottomPanelAddConstraints.gridy = 3;
		addPostsBottomPanel.add(lblCheck2, bottomPanelAddConstraints);
		
		bottomPanelAddConstraints.gridx = 1;
		bottomPanelAddConstraints.gridy = 0;
		addPostsBottomPanel.add(scrollpane1, bottomPanelAddConstraints);
		
		bottomPanelAddConstraints.gridx = 1;
		bottomPanelAddConstraints.gridy = 1;
		addPostsBottomPanel.add(scrollpane2, bottomPanelAddConstraints);

		addPostConstraints.fill = GridBagConstraints.BOTH;
		addPostConstraints.gridheight = GridBagConstraints.REMAINDER;
		
		addPostConstraints.weightx = 0.8;
		addPostConstraints.weighty = 0.8;
		addPostConstraints.gridx = 0;
		addPostConstraints.gridy = 2;
		addPostPanel.add(addPostsBottomPanel, addPostConstraints);
		
		submitPost.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String wanted = textFieldWanted.getText();
				String offer = textFieldOffer.getText();
				String user = userType;
			
				Date dateSelected = datePicker.getDate();
				
				try {
					logic.addPost(wanted, offer, user, dateSelected);
					lblCheck2.setIcon(iconCheck);
					textFieldWanted.setText("");
					textFieldOffer.setText("");
					datePicker.setDate(null);
				} catch (Exception er) {
					lblCheck2.setIcon(null);
					JOptionPane.showMessageDialog(addPostPanel,
							er.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

//Natalie Suggestions
// web design guidelines
// resources about designing for seniors
// connect with some seniors - 
//
//

