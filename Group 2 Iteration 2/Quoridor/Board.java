import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Board extends JFrame{
	
	public static int rows = 9;
	public static int cols = 9;
	public static int squareHeight = 42;
	public static int squareWidth = 42;
	public static int wallWidth = 6;
	
	private static Color boardBrown = new Color(139,69,19);
	private static Color darkBrown = new Color(52,36,21);
	private static Color squareHighlight = new Color(210,180,140);
	
	
	public static Square[][] squares;
	public static Block[][] wallsH;
	public static Block[][] wallsV;
	public static Pawn[] pawns;
	public static ArrayList<Block> blocksPlaced;
	
	private JPanel[] playerBench;
	private JPanel mainPanel;
	private JPanel boardPanel;
	private GridBagConstraints wallForm;
	private GridBagConstraints squareForm;
	
	public Board(int players)
	{
		pawns = new Pawn[players];
		blocksPlaced = new ArrayList<Block>();
		playerBench = new JPanel[4];
		squares = new Square[rows][cols];
		wallsH = new Block[rows][cols-1];
		wallsV = new Block[rows-1][cols];
		
		this.setSize(800, 600);
		mainPanel = new JPanel();
		mainPanel.setPreferredSize(new Dimension(800,600));
		mainPanel.setLayout(new BorderLayout());
		
		getContentPane().add(mainPanel);
		
		boardPanel = new JPanel();
		//boardPanel.setPreferredSize(new Dimension(400,400));
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
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	
	public static void BlockClicked(Block block)
	{
		if(block.getBackground() == boardBrown)
			block.setBackground(Color.white);
		else
			block.setBackground(boardBrown);
	}
	
	public static void SquareClicked(Square square)
	{
		if(square.getBackground() == darkBrown)
			square.setBackground(squareHighlight);
		else
			square.setBackground(darkBrown);
	}
	
	private void makeBenches(JPanel main)
	{
		JPanel top = new JPanel();
		top.setPreferredSize(new Dimension(70,60));
		top.setBackground(boardBrown);
		main.add(top, BorderLayout.NORTH);
		playerBench[2] = top;
		
		JPanel bottom = new JPanel();
		bottom.setPreferredSize(new Dimension(70,60));
		bottom.setBackground(boardBrown);
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
}
