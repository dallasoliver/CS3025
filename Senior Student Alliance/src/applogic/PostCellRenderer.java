package applogic;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;

import objects.Post;

public class PostCellRenderer extends JLabel implements ListCellRenderer {

	public PostCellRenderer() {
		setOpaque(true);
	}

	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		Post post = (Post) value;
		setFont(new Font("Source Sans Pro", Font.BOLD, 20));
		setText("<html><br>" + post.getUser().toUpperCase() + "<br>Need assistance: " + post.getWanted() + "<br>Can offer: " + post.getOffer()  + "<br>Date(s) available: " + new SimpleDateFormat("yyyy-MM-dd").format(post.getDate()) + "<br><html/>");
        setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,Color.BLACK));
 		setBackground(new Color(255,255,255));
 
		if (isSelected) {
			setBackground(new Color (164,211,238));
		    setForeground(Color.black);
		} else {
	  		setBackground(new Color(255, 255, 255));
		    setForeground(Color.black);
		}
		return this;
	}
}