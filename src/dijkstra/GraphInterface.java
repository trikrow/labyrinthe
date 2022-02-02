package dijkstra;

import java.util.ArrayList;

/**
 * An interface for graphs of vertices (a maze for example).
 * 
 * @author Hassib
 *
 */
public interface GraphInterface 
{
	
	/**
	 * Builds a list of the graph's vertices.
	 * 
	 * @return A list of all of the graph's vertices.
	 */
	public ArrayList<VertexInterface> getAllVertices();
	
	/**
	 * Calculates the number of vertices in the graph.
	 * 
	 * @return The number of vertices in the graph.
	 */
	public int getNbVertices();
	
	/**
	 * Returns the weight of the arc between u and v.
	 * 
	 * @param u
	 * @param v
	 * 
	 * @return The weight of the arc between u and v.
	 */
	public int getWeight(VertexInterface u, VertexInterface v);
	
	/**
	 * Returns the successors of the vertex v in the graph.
	 * 
	 * @param v
	 * 
	 * @return The successors of the vertex v in the graph.
	 */
	public ArrayList<VertexInterface> getSuccessors(VertexInterface v);
	
}
