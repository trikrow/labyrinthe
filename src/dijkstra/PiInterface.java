package dijkstra;

/**
 * Interface for the Pi function from the Dijkstra algorithm.
 * Pi(v) returns the distance from the root to v in the graph.
 * 
 * @author Hassib
 */
public interface PiInterface 
{
	
	/**
	 * Returns the value of pi(v).
	 * 
	 * @param v
	 * 
	 * @return The value of pi(v).
	 */
	public int getPi(VertexInterface v);
	
	/**
	 * Sets the value of pi(v) to d.
	 * 
	 * @param v
	 * @param d
	 */
	public void setPi(VertexInterface v, int d);
	
	/**
	 * Sets the value of pi(v) to infinity.
	 * 
	 * @param v
	 */
	public void setPiInfini(VertexInterface v);
	
}
