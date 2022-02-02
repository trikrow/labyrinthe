package maze;

/**
 * Class describing the Arrival box in a maze.
 * 
 * @author Hassib
 * 
 * @see EBox
 * @see MBox
 */
public class ABox extends EBox 
{
	
	//--------------------
	//Constructor
	//--------------------
	
	/**
	 * Constructor of an ABox (arrival box).
	 * 
	 * @param x
	 * @param y
	 * @param maze
	 */
	public ABox(int x, int y, Maze maze)
	{		
		super(x,y,maze);
	}
	
	//--------------------
	//Methods
	//--------------------
	
	/**
	 * Returns the type of the ABox : A.
	 * 
	 * @return Type of the ABox : A.
	 */
	public char getType() 
	{
		return 'A';
	}	
	
}
