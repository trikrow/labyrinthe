package dijkstra;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Previous class that implements the previous function in the Dijkstra algorithm.
 * Previous(v) returns the the father of v, after executing the Dijkstra algorithm.
 * 
 * @author Hassib
 *
 * @see PreviousInterface
 */
public class Previous implements PreviousInterface 
{
	
	//--------------------
	//Attributes
	//--------------------
	
	/**
	 * Hash table that associates previous(v) to every vertex v in the graph.
	 */
	private final Hashtable<VertexInterface, VertexInterface> previousVertices;

	//--------------------
	//Constructor
	//--------------------
	
	/**
	 * Constructor of the Previous function.
	 */
	public Previous()
	{
		previousVertices = new Hashtable<VertexInterface, VertexInterface>();
	}
	
	//--------------------
	//Methods
	//--------------------
	
	/**
	 * Sets the value of previous(v) to p.
	 * 
	 * @param v
	 * @param p
	 */
	public void setPrevious(VertexInterface v, VertexInterface p) 
	{
		previousVertices.put(v,p) ;
		return ;
	}

	/**
	 * Returns the vertex previous(v).
	 * 
	 * @param v
	 * 
	 * @return The vertex previous(v), father of v in the graph.
	 */
	public VertexInterface getPrevious(VertexInterface v) 
	{
		return previousVertices.get(v);
	}

	/**
	 * Returns a list containing the shortest path from the root to v.
	 * 
	 * @param v
	 * 
	 * @return The shortest path from the root to v, in the form of a list.
	 */
	public ArrayList<VertexInterface> getShortestPathTo(VertexInterface v)
	{
		ArrayList<VertexInterface> shortestPath = new ArrayList<VertexInterface>();
		
		//while we don't get to the departure box, we keep building the path
		while (v != null)
		{
			shortestPath.add(v);
			v = this.getPrevious(v);
		}
		
		return shortestPath ;
	}

}
