import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Block extends JPanel implements MouseListener{
	private int x, y;
	private boolean vertical;
	
	public Block(int x, int y, boolean vertical, JPanel parent)
	{
		this.x = x;
		this.y = y;
		this.vertical = vertical;
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.NONE;
		Dimension size = new Dimension(vertical ? new Dimension(Board.wallWidth,Board.squareHeight) : 
			new Dimension((x == Board.rows - 1 ? Board.squareWidth : Board.squareWidth+Board.wallWidth),Board.wallWidth));
		this.setPreferredSize(size);
		c.gridx = vertical ? x*2 + 1 : x*2;
		c.gridy = vertical ? y*2 : y*2+1;
		c.gridwidth = vertical ? 1 : 2;	
		parent.add(this, c);
		addMouseListener(this);
	}
	
	public void mouseClicked(MouseEvent evt) 
	{
		Board.BlockClicked(this);
	}
	
	public int gridX() { return x; }
	public int gridY() { return y; }
	public boolean isVertical() { return vertical; }
	
	public void mouseEntered(MouseEvent arg0){}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}
}
