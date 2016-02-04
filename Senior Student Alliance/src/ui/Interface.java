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
	private GridBagConstraints bottomPanelLeftConstraints;
	private JPanel allPostsBottomPanelRight;
	private GridBagConstraints bottomPanelRightConstraints;
	private JLabel noPostsAddedLbl;

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
	private JButton logoutMyPosts;
	private JScrollPane scrollPaneForList;
	
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
		allPostsListPane = new JPanel();
		postPane = new JPanel();
		logoImageLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/image1.png")).getImage();
		logoImageScaled = img.getScaledInstance(600, 400, java.awt.Image.SCALE_SMOOTH);
		logoIconScaled = new ImageIcon(logoImageScaled);
		logoImageLabel.setIcon(logoIconScaled);
		cardPanel.setLayout(cardLayout);
		loginPanel.setLayout(new GridBagLayout());
		
		noPostsAddedLbl = new JLabel("No posts have been added yet!");
		noPostsAddedLbl.setFont(new Font("Source Sans Pro", Font.PLAIN, 20));
		
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
		
		//--------nav bar-------
		logoutAllPostsBtn = new JButton("<html><u>Logout</u></html>") {
			@Override
            public JToolTip createToolTip() {
                JToolTip toolTip = super.createToolTip();
                toolTip.setBackground(Color.BLACK);
                toolTip.setForeground(Color.WHITE);

                    return toolTip;
            }
		};
		logoutAllPostsBtn.setFont(new Font("Source Sans Pro", Font.PLAIN, 24));
		logoutAllPostsBtn.setPreferredSize(new Dimension(120, 40));
		logoutAllPostsBtn.setBorder(null);
		logoutAllPostsBtn.setBackground(new Color(205, 0, 0));
		logoutAllPostsBtn.setForeground(Color.WHITE);
		logoutAllPostsBtn.setToolTipText("Click to logout of the website");
		
		helpAllPostsBtn = new JButton("<html><u>Help</u></html>") {
			@Override
            public JToolTip createToolTip() {
                JToolTip toolTip = super.createToolTip();
                toolTip.setBackground(Color.BLACK);
                toolTip.setForeground(Color.WHITE);

                    return toolTip;
            }
		};
		helpAllPostsBtn.setFont(new Font("Source Sans Pro", Font.PLAIN, 24));
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
        viewPostingsPanel.setBackground(new Color(232, 232, 232));
        
//        JButton newJ = new JButton("hi");
//        JPanel backButtonPanel = new JPanel();
//        backButtonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
//        backButtonPanel.add(newJ);
//        backButtonPanel.setOpaque(false);

        allPostsRedPanel.setLayout(new GridBagLayout());
		GridBagConstraints redPanelConstraints = new GridBagConstraints();
		redPanelConstraints.weightx = 0.5;
		redPanelConstraints.weighty = 0.5;
		redPanelConstraints.fill = GridBagConstraints.HORIZONTAL;

//		colorPanelConstraints.gridx = 0;
//		colorPanelConstraints.gridy = 0;
//		colorPanel.add(backButtonPanel, colorPanelConstraints);
		
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
		allPostsBottomPanelRight.setBackground(new Color(234, 55, 228));

		btnGroup = new ButtonGroup();
		rdoSenior = new JRadioButton("Senior");
		rdoSenior.setFont(new Font("Georgia", Font.PLAIN, 20));
		
		rdoStudent = new JRadioButton("Student");
		rdoStudent.setFont(new Font("Georgia", Font.PLAIN, 20));

		btnGroup.add(rdoSenior);
		btnGroup.add(rdoStudent);
		
		bottomPanelRightConstraints = new GridBagConstraints();
		
		JLabel filterBy = new JLabel("Filter By:");
		filterBy.setFont(new Font("Source Sans Pro", Font.PLAIN, 20));
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
		allPostsBottomPanelLeft.setBackground(new Color(3, 228, 228));

		goToAddPostBtn = new JButton("Add Post");
		goToAddPostBtn.setFont(new Font("Source Sans Pro", Font.PLAIN, 25));
		goToAddPostBtn.setPreferredSize(new Dimension(180, 50));
		goToMyPostsBtn = new JButton("View My Posts");
		goToMyPostsBtn.setFont(new Font("Source Sans Pro", Font.PLAIN, 25));
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
		allPostsBottomPanel.setBackground(new Color(228, 228, 228));
		
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
					postResponseList.setBackground(new Color(247, 247, 247));
					postResponseList.setCellRenderer(new PostCellRenderer());
					postResponseList.setVisibleRowCount(7);
					postPane.removeAll();
					postPane.add(postResponseList);
					
					postResponseList.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent evt) {
						    if (evt.getClickCount() == 1) {
				            	Post p = (Post)(postResponseList.getSelectedValue());
				            	Integer pId = p.getPostId();
				            	
								try {
									responsesText.setText(logic.showResponses(pId));
								}catch(Exception e) {
//									JOptionPane.showMessageDialog(compareWorkoutsPanel,
//											e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
								}
//								responsesPane.removeAll();
						    }
						}
					});
					
					respScrollPane.setViewportView(responsesText);
					responsesPane.add(respScrollPane);
				    viewMyPostsPanel.add(responsesPane);
				    
				} else {
					postPane.add(new JLabel("You have not posted anything yet!"));
				}
			    viewMyPostsPanel.add(postPane);
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
		contact = new JTextField();
		message = new JTextField();
		responsesPane = new JPanel();
		responsesText = new JTextArea();
		respScrollPane = new JScrollPane();
		
		responsesText = new JTextArea(5, 30);
		responsesText.setEditable(false);
		responsesText.setWrapStyleWord(true);
		responsesText.setLineWrap(true);
		responsesText.setForeground(Color.DARK_GRAY);
		responsesText.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 14));
		responsesText.setBackground(Color.WHITE);
		
		cardPanel.add(viewMyPostsPanel, "5");
	
	//view my posts end	
		
	//Add post panel
		Border border = BorderFactory.createLineBorder(Color.GRAY);

		textFieldWanted = new JTextArea(3, 30);
		JScrollPane scrollpane1 = new JScrollPane(textFieldWanted);
		scrollpane1.setBorder(null);
		textFieldWanted.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		textFieldWanted.setFont(new Font("Source Sans Pro", Font.PLAIN, 20));
		textFieldOffer = new JTextArea(3, 30);
		JScrollPane scrollpane2 = new JScrollPane(textFieldOffer);
		scrollpane2.setBorder(null);
		textFieldOffer.setFont(new Font("Source Sans Pro", Font.PLAIN, 20));
		textFieldOffer.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		lblWanted = new JLabel("<html>What do you need assistance with?<html/>");
		lblWanted.setFont(new Font("Source Sans Pro", Font.PLAIN, 20));
		lblOffer = new JLabel("<html>What can you offer in return?<html/>");
		lblOffer.setFont(new Font("Source Sans Pro", Font.PLAIN, 20));
		lblAvailable = new JLabel("<html>Choose a date for the meeting:<html/>");
		lblAvailable.setFont(new Font("Source Sans Pro", Font.PLAIN, 20));
		submitPost = new JButton("Submit Post");
		submitPost.setFont(new Font("Source Sans Pro", Font.PLAIN, 20));
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
                toolTip.setBackground(Color.BLACK);
                toolTip.setForeground(Color.WHITE);

                return toolTip;
            }
		};
		
		logoutAddPostsBtn.setFont(new Font("Source Sans Pro", Font.PLAIN, 24));
		logoutAddPostsBtn.setPreferredSize(new Dimension(120, 40));
		logoutAddPostsBtn.setBorder(null);
		logoutAddPostsBtn.setBackground(new Color(205, 0, 0));
		logoutAddPostsBtn.setForeground(Color.WHITE);
		logoutAddPostsBtn.setToolTipText("Click to logout of the website");
		
		helpAddPostsBtn = new JButton("<html><u>Help</u></html>") {
			@Override
            public JToolTip createToolTip() {
                JToolTip toolTip = super.createToolTip();
                toolTip.setBackground(Color.BLACK);
                toolTip.setForeground(Color.WHITE);

                    return toolTip;
            }
		};
		helpAddPostsBtn.setFont(new Font("Source Sans Pro", Font.PLAIN, 24));
		helpAddPostsBtn.setPreferredSize(new Dimension(120, 40));
		helpAddPostsBtn.setBorder(null);
		helpAddPostsBtn.setBackground(new Color(205, 0, 0));
		helpAddPostsBtn.setForeground(Color.WHITE);
		helpAddPostsBtn.setToolTipText("Click to learn how to find the instructions on this webpage");
        
		backToViewAllPostsBtn = new JButton("<html><u>Back to View All Posts</u></html>") {
			@Override
            public JToolTip createToolTip() {
                JToolTip toolTip = super.createToolTip();
                toolTip.setBackground(Color.BLACK);
                toolTip.setForeground(Color.WHITE);

                    return toolTip;
            }
		};
		backToViewAllPostsBtn.setFont(new Font("Source Sans Pro", Font.PLAIN, 24));
		backToViewAllPostsBtn.setPreferredSize(new Dimension(260, 40));
		backToViewAllPostsBtn.setBorder(null);
		backToViewAllPostsBtn.setBackground(new Color(205, 0, 0));
		backToViewAllPostsBtn.setForeground(Color.WHITE);
		backToViewAllPostsBtn.setToolTipText("Click to learn how to find the instructions on this webpage");
		
		backToViewAllPostsBtn.addActionListener(new ActionListener() {
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
						allPostsList = new JList(postsTest) {
							@Override
				            public JToolTip createToolTip() {
				                JToolTip toolTip = super.createToolTip();
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
		
		redPanelConstraints.gridx = 1;
		redPanelConstraints.gridy = 0;
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
		addPostsBottomPanel.setBackground(new Color(228, 228, 228));
		
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

