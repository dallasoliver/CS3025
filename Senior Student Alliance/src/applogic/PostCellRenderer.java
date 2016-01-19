package applogic;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import objects.Post;

public class PostCellRenderer extends JLabel implements ListCellRenderer {
	  private static final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);

	  public PostCellRenderer() {
	    setOpaque(true);
	  }

	  public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		  Post post = (Post) value;
		  setText("<html>I am looking for help with: " + post.getWanted() + "<br>I am willing to offer: " + post.getOffer() + "<html/>");
          setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,Color.BLACK));
  		  setBackground(new Color(240,248,255));

		  if (isSelected) {
			  setBackground(HIGHLIGHT_COLOR);
		      setForeground(Color.white);
		  } else {
	  		  setBackground(new Color(240,248,255));
		      setForeground(Color.black);
		  }
		  return this;
	  }
}