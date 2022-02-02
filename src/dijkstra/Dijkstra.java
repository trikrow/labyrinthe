package dijkstra;

/**
 * Dijkstra class that implements dijkstra methods to find 
 * the shortest path in a graph from a vertex to all others.
 * 
 * @author Hassib
 *
 */
public class Dijkstra 
{
	
	/**
	 * The method that executes the Dijkstra algorithm.
	 * 
	 * @param g
	 * @param r
	 * @param a
	 * @param pi
	 * @param previous
	 * 
	 * @return A Hash Table that associates to a vertex a father. The shortest path found by the Dijkstra algorithm contains these vertices.
	 */
	private static PreviousInterface dijkstra(
			GraphInterface g,
			VertexInterface r,
			ASetInterface a,
			PiInterface pi,
			PreviousInterface previous)
	{
		a.addVertex(r);
		VertexInterface pivot = r;
		
		for (VertexInterface v : g.getAllVertices()) 
		{
			pi.setPiInfini(v);
		}
		
		pi.setPi(r, 0);
		
		int n = g.getNbVertices();
		for (int j = 1; j < n ; j++) 
		{
			for (VertexInterface v : g.getSuccessors(pivot)) 
			{
				int newPi = pi.getPi(pivot)+g.getWeight(v, pivot);
				if (!a.contains(v) && (newPi < pi.getPi(v))) 
				{	
					pi.setPi(v, newPi);
					previous.setPrevious(v, pivot);
				}
			}
			
			int minPi = Integer.MAX_VALUE;
			
			for (VertexInterface v : g.getAllVertices()) 
			{
				if (!a.contains(v) && minPi > pi.getPi(v)) 
				{
					minPi = pi.getPi(v);
					pivot = v;
				}
			}
			
			a.addVertex(pivot);
		}
		return previous;
	}

	/**
	 * The method that executes the Dijkstra algorithm.
	 * 
	 * @param g
	 * @param r
	 * 
	 * @return A Hash Table that associates to a vertex a father. The shortest path found by the Dijkstra algorithm contains these vertices.
	 */
	public static PreviousInterface dijkstra(
			GraphInterface g,
			VertexInterface r)
	{
		ASet a = new ASet() ;
		Pi pi = new Pi() ;
		Previous previous = new Previous() ;
		return dijkstra(g,r,a,pi,previous);		
	}
			
}