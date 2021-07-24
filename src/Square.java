/*
 * @author Thu Dinh
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Square extends DisplayPanel {
	
	private Pawn pawn;
	
	public Square(int x, int y, JPanel parent)
	{
		this.x = x;
		this.y = y; 
		this.pawn = null;
		GridBagConstraints c = new GridBagConstraints();
		setPreferredSize(new Dimension(Board.squareWidth, Board.squareHeight));
		c.gridx = x*2;
		c.gridy = y*2;
		c.gridwidth = 1;
		parent.add(this, c);
		this.addMouseListener(this);
	}
	
	public void mouseClicked(MouseEvent evt) 
	{
		Board.SquareClicked(this, evt);
	}

	public Pawn getPawn() { return pawn; }
	
	public void setPawn(Pawn p) 
	{
		if(pawn != null) { return; }
		pawn = p; 
		this.add(pawn);
	}
	public void removePawn() 
	{
		if( pawn != null)
		{
			this.removeAll();
			pawn = null;
		}
	}
	
	public void unselect()
	{
		this.setBackground(Board.darkBrown);
		this.repaint();
	}
	
	public void unhighlight()
	{
		this.removeAll();
		this.repaint();
	}
	
	public void setHighlight()
	{
		
	}
	public void setHighlights() 
	{
		
	}
	
	public void mouseEntered(MouseEvent arg0){}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}
}

