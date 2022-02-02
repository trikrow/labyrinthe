package dijkstra;

import java.util.HashSet;

/**
 * A collection that contains no duplicate elements. It is used here as a set of vertices.
 * 
 * @author Hassib
 *
 * @see ASetInterface
 */
public class ASet implements ASetInterface 
{
	//--------------------
	//Attributes
	//--------------------
	
	/**
	 * A hash set containing the vertices of the set.
	 */
	private final HashSet<VertexInterface> vertices; 
	
	//--------------------
	//Constructor
	//--------------------
	
	/**
	 * Constructor of an ASet
	 * 
	 * @see ASet#vertices
	 */
	public ASet()
	{
		vertices = new HashSet<VertexInterface>();
	}

	//--------------------
	//Methods
	//--------------------
	
	/**
	 * To add a vertex v to the Set.
	 * 
	 * @param v
	 */
	public void addVertex(VertexInterface v) 
	{
		vertices.add(v) ;
		return ;
	}
	
	/**
	 * Verifies if the vertex v is in the Set.
	 * 
	 * @param v
	 * 
	 * @return True if the Set contains v.
	 */
	public boolean contains(VertexInterface v) 
	{
		return vertices.contains(v) ;
	}

}
