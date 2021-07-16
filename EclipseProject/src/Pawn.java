/*
 * @author Thu Dinh
 */
import javax.swing.*;
import javax.swing.JPanel;
import java.awt.*;

public class Pawn extends JPanel{
	private int x;
	private int y;
	private Color color;
	
	public Pawn(int x, int y, Color color)
	{
		this.x = x;
		this.y = y;
		this.color = color;
		this.setBackground(color);
		this.setPreferredSize(new Dimension(25,25));
		this.setMaximumSize(new Dimension(25,25));
		
		Board.squares[x][y].setPawn(this);
	}
	
	public int gridX() { return x; }
	public int gridY() { return y; }
}
