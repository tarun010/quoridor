/*
 * @author Thu Dinh
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Board extends JPanel implements MouseListener{
	
	public static int rows = 9;
	public static int cols = 9;
	public static int squareHeight = 42;
	public static int squareWidth = 42;
	public static int wallWidth = 6;
	public static Dimension boardDimension = new Dimension(800,700);
	public static int fontSize = 45;
	
	public static Color boardBrown = new Color(139,69,19);
	public static Color darkBrown = new Color(52,36,21);
	public static Color squareHighlight = new Color(210,180,140);
	
	
	public static Square[][] squares;
	public static Block[][] wallsH;
	public static Block[][] wallsV;
	public static Pawn[] pawns;
	public static Block[] blockPiles;
	public static ArrayList<Block> blocksPlaced;
	
	private static JPanel[] playerBench;
	private static JPanel[] southBench;
	
	private static JPanel mainPanel;
	private static JPanel boardPanel;
	
	private static ConfirmButton confirmButton;
	
	public Board(int players)
	{
		pawns = new Pawn[players];
		blocksPlaced = new ArrayList<Block>();
		playerBench = new JPanel[4];
		squares = new Square[rows][cols];
		wallsH = new Block[rows][cols-1];
		wallsV = new Block[rows-1][cols];
		
		this.setSize(boardDimension);
		mainPanel = new JPanel();
		mainPanel.setPreferredSize(boardDimension);
		mainPanel.setLayout(new BorderLayout());
		
		this.add(mainPanel);
		
		boardPanel = new JPanel();
		boardPanel.setLayout(new GridBagLayout());
		boardPanel.setBackground(boardBrown);
		mainPanel.add(boardPanel, BorderLayout.CENTER);
		makeBenches(mainPanel);
		
		Square temp;
		Block temp2;
		for(int x=0; x < cols; x++)
			for(int y=0; y < rows; y++) 
			{
				temp = new Square(x,y, boardPanel);
				temp.setBackground(darkBrown);
				squares[x][y] = temp;
				if(x < cols - 1)
				{
					temp2 = new Block(x,y, true, boardPanel);
					temp2.setBackground(boardBrown);
					wallsV[x][y] = temp2;
				}
				if(y < rows -1)
				{
					temp2 = new Block(x,y,false, boardPanel);
					temp2.setBackground(boardBrown);
					wallsH[x][y] = temp2;
				}
			}
		
		pawns[0] = new Pawn(4,8, Color.red);
		pawns[1] = new Pawn(0,4,Color.black);
		pawns[2] = new Pawn(4,0,Color.yellow);
		pawns[3] = new Pawn(8,4,Color.white);
		confirmButton = new ConfirmButton();
		this.addMouseListener(this);
	}
	
	public static void SquareClicked(Square square, MouseEvent evt)
	{
		if( UpdateGame.boardClicked(evt) )
		{
			if(square.getBackground() == darkBrown)
				square.setBackground(squareHighlight);
			else
				square.setBackground(darkBrown);
		}
	}
	
	private void makeBenches(JPanel main)
	{
		JPanel top = new JPanel();
		top.setPreferredSize(new Dimension(70,90));
		top.setBackground(boardBrown);
		main.add(top, BorderLayout.NORTH);
		playerBench[2] = top;
		
		JPanel bottom = new JPanel();
		bottom.setPreferredSize(new Dimension(70,90));
		bottom.setBackground(Color.white);
		main.add(bottom, BorderLayout.SOUTH);
		playerBench[0] = bottom;
		
		JPanel left = new JPanel();
		left.setPreferredSize(new Dimension(175,400));
		left.setBackground(darkBrown);
		main.add(left, BorderLayout.WEST);
		playerBench[1] = left;
		
		JPanel right = new JPanel();
		right.setPreferredSize(new Dimension(175,400));
		right.setBackground(darkBrown);
		main.add(right, BorderLayout.EAST);
		playerBench[3] = right;
	}
	
	public static void addBlockPiles(Player[] players)
	{
		blockPiles = new Block[4];
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.NONE;
		for(Player player : players)
		{
			int bench = player.side.getValue();
			Block panel = new Block(true, player);
			panel.setLayout(new GridBagLayout());
			player.blockPilePanel = panel;
			JLabel label = new JLabel(Integer.toString(player.blockPile));
			label.setFont(new Font(label.getFont().getName(), Font.PLAIN, fontSize));
			if(bench == 0)
			{
				southBench = new JPanel[3];
				playerBench[bench].setLayout(new GridBagLayout());
				for(int i = 0; i < 3; i++)
				{
					c.gridx = i; c.gridy = 1;
					c.weightx = 1; c.weighty = 1;
					c.fill = GridBagConstraints.BOTH;
					southBench[i] = new JPanel();
					southBench[i].setLayout(new GridBagLayout());
					southBench[i].setBackground(boardBrown);
					//southBench[i].setBorder(BorderFactory.createLineBorder(Color.black));
					playerBench[bench].add(southBench[i], c);
				}
				c.fill = GridBagConstraints.NONE;
				c.weightx = 0; c.weighty = 0;
				panel.setPreferredSize(new Dimension(90,60));
				blockPiles[bench] = panel;
				panel.setBackground(squareHighlight);
				c.gridx = 2;
				c.gridy = 1;
				panel.add(label, c);
				southBench[1].add(panel, c);
			}
			else if(bench == 2)
			{
				playerBench[bench].setLayout(new GridBagLayout());
				panel.setPreferredSize(new Dimension(90,60));
				blockPiles[bench] = panel;
				panel.setBackground(squareHighlight);
				c.gridx = 2;
				c.gridy = 1;
				panel.add(label, c);
				playerBench[bench].add(panel, c);
			}
			else
			{
				playerBench[bench].setLayout(new GridBagLayout());
				panel.setPreferredSize(new Dimension(60,80));
				blockPiles[bench] = panel;
				panel.setBackground(squareHighlight);
				c.gridx = 1;
				c.gridy = 2;
				panel.add(label, c);
				playerBench[bench].add(panel, c);
			}
		}
	}
	
	public static void updateBlockPiles(Player[] players)
	{
		for (int i = 0 ; i < players.length; i++)
		{
			((JLabel)blockPiles[i].getComponent(0)).setText(Integer.toString(players[i].blockPile));
			blockPiles[i].repaint();
		}
	}
	
	public static void unselect(DisplayPanel selected)
	{
		selected.unselect();
	}
	
	public static void removeHighlights(ArrayList<DisplayPanel> items)
	{
		for(DisplayPanel pane : items)
		{
			pane.unhighlight();
		}
	}
	public void mouseClicked(MouseEvent evt)
	{
		UpdateGame.boardClicked(evt);
	}
	
	public static void showConfirm() { 
		if (southBench[2].getComponentCount() > 0) return;
		GridBagConstraints c = new GridBagConstraints();
		southBench[2].add(confirmButton, c);
		southBench[2].repaint();
		UpdateGame.validate();
	}
	
	public static void hideConfirm()
	{
		if(southBench[2].getComponentCount() < 1) return;
		southBench[2].remove(confirmButton);
		southBench[2].repaint();
	}
	
	public void mouseEntered(MouseEvent arg0){}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}
}
