/*
 * @author Thu Dinh
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Block extends DisplayPanel{
	
	public boolean vertical, pile, placed;
	public Player player;
	
	public Block(int x, int y, boolean vertical, JPanel parent)
	{
		this.x = x;
		this.y = y;
		this.player = null;
		this.pile = false;
		this.placed = false;
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
	
	public Block(boolean pile, Player player)
	{
		this.pile = pile;
		this.player = player;
		addMouseListener(this);
	}
	
	public void mouseClicked(MouseEvent evt) 
	{
		if(this.pile)
		{
			if( UpdateGame.boardClicked(evt) )
				UpdateGame.pileClicked(player, evt);
				Board.hideConfirm();
		}
		else 
		{
			if( UpdateGame.boardClicked(evt) )
			{
				Board.showConfirm();
				setHighlights();
				repaint();
			}
		}
	}
	
	public void select()
	{
		if(pile)
		{
			setBorder(BorderFactory.createLineBorder(Color.yellow, 7));
			repaint();
		}
		else 
		{
			this.setBackground(Board.squareHighlight);
			this.placed = true;
		}
	}
	
	public void unselect()
	{
		this.setBorder(BorderFactory.createEmptyBorder());
		this.repaint();
	}
	
	public void setHighlight()
	{
		this.setBackground(Color.white);
		UpdateGame.highlighted.add(this);
	}
	
	public void setHighlights()
	{
		if(placed) { Board.hideConfirm(); return; };
		
		setHighlight();
		int nX, nY;
		if(vertical)
		{
			nX = x;
			if(y == Board.rows-1) 
			{
				nY = y - 1;
				if (Board.wallsV[nX][nY].placed || isIntersect(this,Board.wallsV[nX][nY])) { Board.hideConfirm(); return; }
				Board.wallsV[nX][nY].setHighlight();
			}
			else
			{
				nY = y + 1; 
				if (Board.wallsV[nX][nY].placed || isIntersect(this,Board.wallsV[nX][nY]))
				{
					nY = y - 1;
					if (Board.wallsV[nX][nY].placed || isIntersect(this,Board.wallsV[nX][nY])) 
					{ 
						Board.hideConfirm(); 
						this.unhighlight();
						return; 
					}
				}
				Board.wallsV[nX][nY].setHighlight();
			}
			
		}
		else
		{
			nY = y;
			if(x == Board.rows-1) 
			{
				nX = x - 1;
				if (Board.wallsH[nX][nY].placed || isIntersect(this, Board.wallsH[nX][nY])) { Board.hideConfirm(); return; }
				Board.wallsH[nX][nY].setHighlight();
			}
			else
			{
				nX = x + 1; 
				if (Board.wallsH[nX][nY].placed || isIntersect(this, Board.wallsH[nX][nY]))
				{
					nX = x - 1;
					if (Board.wallsH[nX][nY].placed || isIntersect(this, Board.wallsH[nX][nY])) 
					{ 
						Board.hideConfirm(); 
						this.unhighlight();
						return;
					}
				}
				Board.wallsH[nX][nY].setHighlight();
			}
		}
	}
	
	public void unhighlight()
	{
		this.setBackground(Board.boardBrown);
		this.repaint();
	}
	
	private static boolean isIntersect(Block b1, Block b2)
	{
		boolean intersect = false;
		boolean vertical = b1.vertical; 
		if (vertical)
		{
			if(b1.y < b2.y)
			{
				if(Board.wallsH[b1.x][b1.y].placed && Board.wallsH[b1.x + 1][b1.y].placed)
					intersect = true;
			} else {
				if(Board.wallsH[b2.x][b2.y].placed && Board.wallsH[b2.x + 1][b2.y].placed)
					intersect = true;
			}
		}
		else
		{
			if(b1.x < b2.x)
			{
				if(Board.wallsV[b1.x][b1.y].placed && Board.wallsV[b1.x][b1.y + 1].placed)
					intersect = true;
			} else {
				if(Board.wallsV[b2.x][b2.y].placed && Board.wallsV[b2.x][b2.y + 1].placed)
					intersect = true;
			}
		}
		
		return intersect;
	}
	
	public boolean isVertical() { return vertical; }
}
