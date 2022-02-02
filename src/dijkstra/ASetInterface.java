package dijkstra;

/**
 * An interface for a collection that contains no duplicate elements.
 * It is used here as a set of vertices.
 * 
 * @author Hassib
 */

public interface ASetInterface 
{
	
	/**
	 * To add a vertex v to the Set.
	 * 
	 * @param v
	 */
	public void addVertex(VertexInterface v);
	
	/**
	 * Verifies if the vertex v is in the Set.
	 * 
	 * @param v
	 * 
	 * @return True if the Set contains v.
	 */
	public boolean contains(VertexInterface v);
	
}
