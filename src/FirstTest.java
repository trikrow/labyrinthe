import java.io.IOException;
import java.util.ArrayList;

import dijkstra.Dijkstra;
import dijkstra.Previous;
import dijkstra.VertexInterface;
import maze.*;

/**
 * First test class to test the solution for the maze provided in the TP.
 * @author Hassib
 *
 */
public class FirstTest {

	public static void main(String[] args) 
			throws MazeReadingException, IOException, Exception 
	{
		Maze maze = new Maze();
		
		maze.initFromTextFile("data/labyrinthe.txt");
		
		DBox departure = maze.getDBox();
		
		Previous prev = (Previous) Dijkstra.dijkstra(maze, departure);
		
		ABox arrival = maze.getABox();
		
		ArrayList<VertexInterface> path = prev.getShortestPathTo(arrival);
		
		for (int line = 0; line < maze.getHeight(); line++)
		{
			for (int column = 0; column < maze.getWidth(); column++)
			{
				MBox box = maze.getBoxes().get(column).get(line);
				VertexInterface v = box;
				
				switch (box.getType())
				{
				case 'E' :
					if (path.contains(v))
					{
						System.out.print(".");
					}
					else
					{
						System.out.print('E');
					}
					break;
				case 'W' :
					System.out.print('W');
					break;
				case 'D' :
					System.out.print('D');
					break;
				case 'A' :
					System.out.print('A');
					break;
				default :
					throw new MazeReadingException("console",line,"type de case non reconnu :" + maze.getBoxes().get(column).get(line).getType());
				}
			}
			System.out.println(); //back to line after a line of boxes
		}
		
	}

}
