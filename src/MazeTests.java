import java.io.IOException;
import java.util.ArrayList;

import dijkstra.Dijkstra;
import dijkstra.Previous;
import dijkstra.VertexInterface;
import maze.ABox;
import maze.DBox;
import maze.MBox;
import maze.Maze;
import maze.MazeReadingException;

/**
 * Class to find the solution for any maze. Replace fileName in line 29 by the file name containing the maze and execute.
 * @author Hassib
 *
 */
public class MazeTests 
{
	
	public static void main(String[] args) 
			throws MazeReadingException, IOException, Exception
	{
		//Main Test Class to solve mazes with the Dijkstra algorithm,
		//Enter the name of the file (fileName) containing the maze in line 29 and execute.
		
		Maze maze = new Maze();
		
		maze.initFromTextFile("fileName");
		
		DBox departure = maze.getDBox();
		
		Previous prev = (Previous) Dijkstra.dijkstra(maze, departure);
		
		ABox arrival = maze.getABox();
		
		ArrayList<VertexInterface> path = prev.getShortestPathTo(arrival);
		
		//verifies if the maze has a solution
		if (!path.contains(departure))
		{
			System.out.print("Le labyrinthe n'a pas de solution");
			return ;
		}
		
		
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
