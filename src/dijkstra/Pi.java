package dijkstra;

import java.util.Hashtable;

/**
 * Pi class that implements the Pi function in the Dijkstra algorithm.
 * Pi(v) returns the distance from the root to v in the graph.
 * 
 * @author Hassib
 * 
 * @see PiInterface
 */
public class Pi implements PiInterface 
{
	
	//--------------------
	//Attributes
	//--------------------
	
	/**
	 * A hash table that associates pi(v) to every vertex v in the graph.
	 */
	private final Hashtable<VertexInterface, Integer> piValues; //hash table that associates pi(v) to every vertex v in the graph
	
	//--------------------
	//Constructor
	//--------------------
	
	/**
	 * Constructor of a Pi function.
	 */
	public Pi()
	{
		piValues = new Hashtable<VertexInterface, Integer>();
	}
	
	//--------------------
	//Methods
	//--------------------
	
	/**
	 * Returns the value of pi(v).
	 * 
	 * @param v
	 * 
	 * @return The value of pi(v). 
	 */
	public int getPi(VertexInterface v) 
	{
		return piValues.get(v);
	}

	/**
	 * Sets the value of pi(v) to d.
	 * 
	 * @param v
	 * @param d
	 */
	public void setPi(VertexInterface v, int d)
	{
		Integer i = Integer.valueOf(d);
		piValues.put(v, i) ;
		return ;
	}

	/**
	 * Sets the value of pi(v) to infinity.
	 * 
	 * @param v
	 */
	public void setPiInfini(VertexInterface v) 
	{
		Integer inf = Integer.valueOf(Integer.MAX_VALUE) ;
		piValues.put(v, inf) ;
	}
	
}
