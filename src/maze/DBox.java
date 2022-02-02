package maze;

/**
 * Class describing the Departure box in a maze.
 * 
 * @author Hassib
 * 
 * @see EBox
 * @see MBox
 */
public class DBox extends EBox 
{
	
	//--------------------
	//Constructor
	//--------------------
		
	/**
	 * Constructor of a DBox (departure box).
	 * 
	 * @param x
	 * @param y
	 * @param maze
	 */
	public DBox(int x, int y, Maze maze)
	{		
		super(x,y,maze);
	}
	
	//--------------------
	//Methods
	//--------------------
	
	/**
	 * Returns the type of the DBox : D.
	 * 
	 * @return Type of the DBox : D.
	 */
	public char getType() 
	{
		return 'D';
	}	
	
}
