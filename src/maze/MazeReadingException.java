package maze;

/**
 * Class creating a new type of Exception that can occur while manipulating and reading files.
 * 
 * @author Hassib
 * 
 * @see Maze
 */
public class MazeReadingException extends Exception
{

	/**
	 * Constructor of a MazeReadingException. Creates an exception and prints an error message.
	 * 
	 * @param fileName
	 * @param errorLine
	 * @param errorMessage
	 */
	public MazeReadingException(String fileName, 
								int errorLine, 
								String errorMessage) 
	{
		super("Détéction d'erreur dans le fichier " + fileName +
				" à la ligne " + errorLine +". Message d'erreur : " + 
				errorMessage);
	}
}
