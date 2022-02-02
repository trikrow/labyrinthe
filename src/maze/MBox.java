package maze;
import dijkstra.VertexInterface;

/**
 * Class describing a box in a maze.
 * 
 * @author Hassib
 * 
 * @see Maze
 */
public abstract class MBox
	implements VertexInterface
	{

		//--------------------
		//Attributes
		//--------------------
		
		/**
		 * x coordinate of the box.
		 */
		private final int x ;
		
		/**
		 * y coordinate of the box.
		 */
		private final int y ; 
		
		/**
		 * Maze containing the box.
		 * 
		 * @see Maze
		 */
		private Maze maze ;
		
		//--------------------
		//Constructor
		//--------------------
		
		/**
		 * Constructor of an MBox (can't be used because MBox is an abstract class).
		 * 
		 * @param x
		 * @param y
		 * @param maze
		 */
		public MBox(int x, int y, Maze maze)
		{		
			this.x = x ;
			this.y = y ;
			this.maze = maze ;
		}
	
		//--------------------
		//Methods
		//--------------------
		
		/**
		 * x getter.
		 * 
		 * @return x coordinate of the considered box.
		 */
		public final int getX() 
		{		
			return this.x ;	
		}
	
		/**
		 * y getter.
		 * 
		 * @return y coordinate of the considered box.
		 */
		public final int getY() 
		{
			return this.y ;
		}
		
		/**
		 * Returns the coordinates of the considered box as (x,y).
		 * 
		 * @return Coordinates of the considered box as (x,y).
		 */
		public final String getLabel()
		{		
			return "(" + this.getX() + "," + this.getY() + ")";
		}
		
		/**
		 * Returns D,A,E or W according to the box's type.
		 * 
		 * @return D,A,E or W.
		 */
		public abstract char getType();
	
	}
