package maze;

/**
 * Class describing a Wall box in a maze.
 * 
 * @author Hassib
 * 
 * @see MBox
 */
public class WBox extends MBox
{
	
	//--------------------
	//Constructor
	//--------------------
	
	/**
	 * Constructor of a WBox (wall box).
	 * 
	 * @param x
	 * @param y
	 * @param maze
	 */
	public WBox(int x, int y, Maze maze) 
	{		
		super(x,y,maze);
	}	
	
	//--------------------
	//Methods
	//--------------------
	
	/**
	 * Returns the type of the WBox : W
	 * 
	 * @return Type of the WBox : W.
	 */
	public char getType() 
	{
		return 'W';
	}	

}
