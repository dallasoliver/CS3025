package applogic;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import objects.Response;

public class ResponseCellRenderer extends JLabel implements ListCellRenderer {
	  private static final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);

	  public ResponseCellRenderer() {
	    setOpaque(true);
	  }

	  public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		  Response response = (Response) value;
		  setFont(new Font("Georgia", Font.BOLD, 20));
		  setText("<html>" + response.getMessage() + "<br>Contact Information: " + response.getContactBy() + "<html/>");
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