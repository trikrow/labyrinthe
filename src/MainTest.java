import java.io.IOException;
import maze.*;

/**
 * Class to test the methods initFromTextFile and saveToTextFile.
 * @author Hassib
 *
 */
public class MainTest 
{
	public static void main(String[] args) 
			throws MazeReadingException, IOException, Exception 
	{
		Maze maze = new Maze();
		
		maze.initFromTextFile("data/labyrinthe.txt");
		
		maze.saveToTextFile("data/labyrinthe2.txt");
	}

}
