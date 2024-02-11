/*
 * @authors Thu Dinh, Tarun Subramanian, Farzad Ahmed, Jacob Keiley, afrideeee, ksvansia
 */
import java.awt.*;
import javax.swing.*;

public class Quoridor extends JFrame{

	public static void main(String[] args) {
		System.out.println("Starting Quoridor");
		Quoridor q = new Quoridor();		
	}
	
	private Container main;
	private Board board;
	private JMenuBar menuBar;
	private JMenu menu;
	
	private UpdateGame updater;
	
	public Quoridor()
	{
		this.setSize(new Dimension(800,765));
		
		menuBar = new JMenuBar();
		menu = new JMenu("windows");
		
		JMenuItem setAI = new JMenuItem("SetAI");
		setAI.addActionListener(evt -> this.goSetAILevelsWindow());
		menu.add(setAI);
		
		JMenuItem goBoard = new JMenuItem("Go To Board");
		goBoard.addActionListener(evt -> this.goToBoard());
		menu.add(goBoard);
		
		menuBar.add(menu);
		this.setJMenuBar(menuBar);
		
		main = this.getContentPane();
		board = new Board(4);
		updater = new UpdateGame(this, new boolean[]{true,true,true,true}, new Color[]{Color.red, Color.green, Color.yellow, Color.white});
		main.add(board);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public void goSetAILevelsWindow()
	{
		main.removeAll();
		SetAILevelsWindow setai = new SetAILevelsWindow();
		main.add(setai);
		this.pack();
		this.repaint();
	}
	
	public void goToBoard()
	{
		main.removeAll();
		main.add(board);
		this.pack();
		this.repaint();
	}
}
