/**
 * @author Thu Dinh
 * @created Nov. 9, 2020
 */

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public abstract class DisplayPanel extends JPanel implements MouseListener{
	
	protected int x, y;
	public int gridX() { return x; }
	public int gridY() { return y; }
	
	public void unhighlight() {}
	public void setHighlight() {}
	public void setHighlights() {}
	public void select() {}
	public void unselect() {}
	
	public void mouseClicked(MouseEvent evt){}
	public void mouseEntered(MouseEvent arg0){}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}
}
