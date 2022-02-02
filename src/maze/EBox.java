package maze;

/**
 * Class describing an Empty box in a maze.
 * 
 * @author Hassib
 * 
 * @see MBox
 */
public class EBox extends MBox 
{
	
	//--------------------
	//Constructor
	//--------------------
	
	/**
	 * Constructor of an EBox (empty box).
	 * 
	 * @param x
	 * @param y
	 * @param maze
	 */
	public EBox(int x, int y, Maze maze) 
	{		
		super(x,y,maze) ;
	}

	//--------------------
	//Methods
	//--------------------
	
	/**
	 * Returns the type of the EBox : E.
	 * 
	 * @return Type of the EBox : E.
	 */
	public char getType() 
	{
		return 'E';
	}	

}
