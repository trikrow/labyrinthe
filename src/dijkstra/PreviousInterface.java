package dijkstra;

import java.util.ArrayList;

/**
 * Interface for the Previous function in the Dijkstra algorithm.
 * Previous(v) returns the the father of v, after executing the Dijkstra algorithm.
 * 
 * @author Hassib
 *
 */
public interface PreviousInterface 
{
	
	/**
	 * Sets the value of previous(v) to p.
	 * 
	 * @param v
	 * @param p
	 */
	public void setPrevious(VertexInterface v, VertexInterface p);
	
	/**
	 * Returns the vertex previous(v).
	 * 
	 * @param v
	 * 
	 * @return The vertex previous(v), father of v in the graph.
	 */
	public VertexInterface getPrevious(VertexInterface v) ;
	
	/**
	 * Returns a list containing the shortest path from the root to v.
	 * 
	 * @param v
	 * 
	 * @return The shortest path from the root to v, in the form of a list.
	 */
	public ArrayList<VertexInterface> getShortestPathTo(VertexInterface v);

}
