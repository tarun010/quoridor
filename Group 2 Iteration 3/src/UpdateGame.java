/*
 * @author Thu Dinh
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class UpdateGame {
	
	public enum BoardSide {
		SOUTH(0), WEST(1), NORTH(2), EAST(3);
		private int value;
		private BoardSide(int value) { this.value = value; }
		public int getValue() { return value; }
	}
	
	private static Quoridor frame;
	private static Player[] players;
	private static int playerTurn;
	private static DisplayPanel selected;
	public static ArrayList<DisplayPanel> highlighted;
	
	
	public UpdateGame(Quoridor frame, boolean[] humans, Color[] colors)
	{
		this.frame = frame;
		highlighted = new ArrayList<DisplayPanel>();
		selected = null;
		players = new Player[humans.length];
		int blocks = 20 / humans.length;
		for (int i = 0; i < players.length; i++)
		{
			players[i] = new Player( Board.pawns[i], humans[i], blocks, BoardSide.values()[i]);
			players[i].pawn.setBackground(colors[i]);
		}
		playerTurn = 0;
		
		Board.addBlockPiles(players);
	}
	
	
	public static void endTurn()
	{
		playerTurn = (playerTurn + 1) % players.length;
	}
	
	public static void pileClicked(Player player, MouseEvent evt)
	{
		if(player == players[playerTurn])
		{
			player.blockPilePanel.select();
			selected = player.blockPilePanel;
		}
	}
	
	public static boolean boardClicked(MouseEvent evt)
	{
		boolean cont = false;
		boolean isPile = false;
		if(selected != null)
			isPile = selected instanceof Block ? ((Block)selected).pile : false;
		if(!evt.getComponent().equals(selected))
		{
			if (selected != null && !(evt.getComponent().getClass().equals(selected.getClass())) && !highlighted.contains(evt.getComponent())) 
			{
				//System.out.println(1);
				cont = false;
				Board.unselect(selected);
				Board.removeHighlights(highlighted);
				highlighted.clear();
				selected = null;
				Board.hideConfirm();
				
			} else if (highlighted.contains(evt.getComponent()) && evt.getComponent() instanceof Square) {
				//System.out.println(2);
				Square sq = (Square) evt.getComponent();
				
			} else if (isPile && evt.getComponent() instanceof Block){
				//System.out.println(3);
				Board.removeHighlights(highlighted);
				highlighted.clear();
				if(((Block)evt.getComponent()).pile) cont = false;
				else cont = true;
				
			} else if(evt.getComponent() instanceof Block) {
				//System.out.println(4);
				cont = ((Block)evt.getComponent()).pile;
				Board.hideConfirm();
			}
		} else if (evt.getComponent() instanceof Block) {
			Board.removeHighlights(highlighted);
		
		}
		//System.out.println(cont);
		return cont;
	}
	
	public static void validate() { frame.validate(); }
	public static void confirm() 
	{
		if(selected == null) return;
		if(selected instanceof Block)
		{
			for (DisplayPanel pane : highlighted)
				pane.select();
			highlighted.clear();
			players[playerTurn].takeBlock();
			Board.updateBlockPiles(players);
			endTurn();
			Board.hideConfirm();
			Board.unselect(selected);
			selected = null;
		}
	}
}
