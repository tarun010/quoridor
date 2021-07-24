/*
 * @author Thu Dinh
 */
public class Player {
	
	public boolean human;
	public Pawn pawn;
	public Block blockPilePanel;
	public int blockPile;
	public UpdateGame.BoardSide side;
	
	public Player()
	{
		pawn = null;
		human = false;
		blockPile = 10;
		side = UpdateGame.BoardSide.SOUTH;
	}
	
	public Player(Pawn p, boolean human, int blocks, UpdateGame.BoardSide side)
	{
		this.pawn = p;
		this.human = human;
		this.blockPile = blocks;
		this.side = side;
	}
	
	public void takeBlock() { blockPile--; }
	public void addBlock() { blockPile++; }
}
