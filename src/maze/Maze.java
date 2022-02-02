package maze;
import java.io.*;
import java.util.ArrayList;

import dijkstra.GraphInterface;
import dijkstra.VertexInterface;

/**
 * Class describing a maze.
 * 
 * @author Hassib
 * 
 * @see GraphInterface
 */
public class Maze 
	implements GraphInterface
	{
	
		//--------------------
		//Attributes
		//--------------------

		/**
		 * Width of the maze.
		 */
		private int width;
		
		/**
		 * Height of the maze.
		 */
		private int height;
		
		/**
		 * Matrix of all the boxes of the maze
		 * @see MBox
		 */
		private ArrayList<ArrayList<MBox>> boxes;
		
		/**
		 * Departure box of the maze.
		 * @see DBox
		 */
		private DBox dBox;
		
		/**
		 * Arrival box of the maze.
		 * @see ABox
		 */
		private ABox aBox;
		
		/**
		 * List of the empty boxes of the maze.
		 * @see EBox
		 */
		private ArrayList<EBox> eBoxes;
		
		/**
		 * List of the wall boxes of the maze.
		 * @see WBox
		 */
		private ArrayList<WBox> wBoxes;
		
		//--------------------
		//Constructors
		//--------------------
		
		/**
		 * Maze basic constructor, with empty fields.
		 */
		public Maze()
		{
			this.width = 0;
			this.height = 0;
			this.boxes = new ArrayList<ArrayList<MBox>>();
			this.dBox = null;
			this.aBox = null;
			this.eBoxes = new ArrayList<EBox>();
			this.wBoxes = new ArrayList<WBox>();
		}
		
		/**
		 * Maze constructor with only empty boxes.
		 * 
		 * @param width
		 * @param height
		 */
		public Maze(int width, 
					int height) 
		{		
			this.width = width ;
			this.height = height ;
	
			//construction of the maze's boxes
			boxes = new ArrayList<ArrayList<MBox>>();
			eBoxes = new ArrayList<EBox>();
			wBoxes = new ArrayList<WBox>();
			
			for (int i = 0; i < width; i++)
			{
				ArrayList<MBox> columns = new ArrayList<MBox>();
				for (int j = 0; j < height; j++)
				{
					EBox eBox = new EBox(i,j,this);
					columns.add(j, eBox);
				}
				
				boxes.add(i, columns);
			}
		}
	
		/**
		 * Maze constructor with all specified boxes.
		 * 
		 * @param width
		 * @param height
		 * @param dBox
		 * @param aBox
		 * @param eBoxes
		 * @param wBoxes
		 */
		public Maze(int width, 
					int height, 
					DBox dBox,
					ABox aBox,
					ArrayList<EBox> eBoxes,
					ArrayList<WBox> wBoxes) 
		{		
			this.width = width ;
			this.height = height ;
		
			//construction of the maze boxes and
			//the boxes' list boxes
			this.dBox = dBox ;
			this.aBox = aBox ;
			
			for(EBox eBox : eBoxes) 
			{
				this.eBoxes.add(eBox);
				this.boxes.get(eBox.getX()).add(eBox.getY(), eBox);
			}
			this.eBoxes.add(dBox);
			this.boxes.get(dBox.getX()).add(dBox.getY(), dBox);
			this.eBoxes.add(aBox);
			this.boxes.get(aBox.getX()).add(aBox.getY(), aBox);
			
			for(WBox wBox : wBoxes) 
			{
				this.wBoxes.add(wBox);
				this.boxes.get(wBox.getX()).add(wBox.getY(), wBox);
			}
			boxes.get(aBox.getX()).set(aBox.getY(), aBox);
			boxes.get(dBox.getX()).set(dBox.getY(), dBox);
		}
		
		//--------------------
		//Attribute's getters
		//--------------------

		/**
		 * Maze's width getter.
		 * 
		 * @return Width of the maze.
		 */
		public int getWidth() 
		{
			return this.width ;
		}
	
		/**
		 * Maze's height getter.
		 * 
		 * @return Height of the maze.
		 */
		public int getHeight() 
		{
			return this.height ;
		}
	
		/**
		 * Maze's boxes matrix getter.
		 * 
		 * @return The maze as a matrix of boxes.
		 */
		public ArrayList<ArrayList<MBox>> getBoxes() 
		{
			return this.boxes;
		}
	
		/**
		 * Empty boxes getter.
		 * 
		 * @return List of the maze's empty boxes.
		 */
		public ArrayList<EBox> getEBoxes() 
		{
			return this.eBoxes;
		}

		/**
		 * Walls boxes getter.
		 * 
		 * @return List of the maze's wall boxes.
		 */
		public ArrayList<WBox> getWBoxes() 
		{
			return this.wBoxes;	
		}

		/**
		 * Maze's departure box getter.
		 * 
		 * @return Maze's departure box.
		 */
		public DBox getDBox() 
		{	
			return this.dBox;
		}
	
		/**
		 * Maze's arrival box getter.
		 * 
		 * @return Maze's arrival box.
		 */
		public ABox getABox() 
		{	
			return this.aBox;
		}
		
		//--------------------
		//Methods
		//--------------------

		/**
		 * Builds a maze from the file fileName.
		 * 
		 * @param fileName
		 * 
		 * @throws Exception
		 * @throws MazeReadingException
		 * @throws IOException
		 */
		public final void initFromTextFile(String fileName)
			throws Exception, MazeReadingException, IOException
		{
			BufferedReader br =  null;
			
			try {
				FileReader f = new FileReader (new File(fileName)) ;
				br = new BufferedReader(f);
				
				//verifies if the file is empty
				if (fileName.length()==0)
					throw new MazeReadingException(fileName,0,"le fichier est vide.");
				
				//gets the width of the maze with the length of the first line
				this.width = br.readLine().length();
				br.close();
				
				FileReader f1 = new FileReader (new File(fileName)) ;
				br = new BufferedReader(f1);
				//gets the height of the maze by going through the file until finding an empty line
				int lines = 0;
				while (br.readLine() != null)
				{
					lines++;
				}
				this.height = lines;
				br.close();
				
				FileReader f2 = new FileReader (new File(fileName)) ;
				br = new BufferedReader(f2);
				
				//initializing the boxes list to an empty boxes list
				for (int i = 0; i < width; i++)
				{
					ArrayList<MBox> columns = new ArrayList<MBox>();
					for (int j = 0; j < height; j++)
					{
						EBox eBox = new EBox(i,j,this);
						columns.add(j, eBox);
					}
					
					boxes.add(i, columns);
				}
				
				//going through the file and building the maze				
				for (int line = 0; line < this.height; line++)
				{
					String readLine = br.readLine();
					
					//if there are too many lines in the file
					if (readLine == null)
						throw new MazeReadingException(fileName,line+1,"nombre de lignes supérieur à la hauteur du labyrinthe.");
					//if there are too many columns at the line line
					if (readLine.length() > this.width)
						throw new MazeReadingException(fileName,line+1,"nombre de colonnes supérieur à la largeur du labyrinthe.");
					//if there are not enough columns at the line line
					if (readLine.length() < this.width)
						throw new MazeReadingException(fileName,line+1,"nombre de colonnes inférieur à la largeur du labyrinthe.");
					
					for (int column = 0; column < this.width; column++)
					{
						switch(readLine.charAt(column))
						{
						case 'E' : 
							EBox eBox = new EBox(column, line, this);
							this.boxes.get(column).add(line, eBox);
							this.eBoxes.add(eBox);
							break;
						case 'W' : 
							WBox wBox = new WBox(column, line, this);
							this.boxes.get(column).add(line, wBox);
							this.wBoxes.add(wBox);
							break;
						case 'D' : 
							DBox dBox = new DBox(column, line, this);
							this.boxes.get(column).add(line, dBox);
							this.dBox = dBox;
							break;
						case 'A' : 
							ABox aBox = new ABox(column, line, this);
							this.boxes.get(column).add(line, aBox);
							this.aBox = aBox;
							break;		
						default :
							throw new MazeReadingException(fileName, line, "caractère non valide : " + readLine.charAt(column) +" ,caractères acceptés : E,W,D,A.");
						}
					}
				}
				} catch (Exception e) {
					e.printStackTrace() ;
				} finally { 
					try { 
						br.close() ;
						} catch(IOException e) {}
						}
		}
	
		/**
		 * Saves the maze in the file fileName.
		 * 
		 * @param fileName
		 * 
		 * @throws FileNotFoundException
		 * @throws MazeReadingException
		 */
		public final void saveToTextFile(String fileName) 
				throws FileNotFoundException, MazeReadingException
		{
			PrintWriter f= null;
			
			try{
				f = new PrintWriter(new File(fileName));
				
				for (int line = 0; line < this.height; line++)
				{
					for (int column = 0; column < this.width; column++)
					{
						switch (boxes.get(column).get(line).getType())
						{
						case 'E' :
							f.write('E');
							break;
						case 'W' :
							f.write('W');
							break;
						case 'D' :
							f.write('D');
							break;
						case 'A' :
							f.write('A');
							break;
						default :
							throw new MazeReadingException(fileName,line,"type de case non reconnu :" +	boxes.get(column).get(line).getType());
						}
					}
					f.write("\n"); //back to the line after a line of boxes
				}
			
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try { 
						f.close();
						} catch(Exception e) {}
							}
		}
					
		/**
		 * Returns the list of box's neighbors.
		 * 
		 * @param box
		 * 
		 * @return A list of the neighbors of box.
		 */
		public ArrayList<MBox> getNeighbors(MBox box)
		{
			ArrayList<MBox> neighboursList = new ArrayList<MBox>();
			int x = box.getX();
			int y = box.getY();
		
			//case where box is not in the maze
			if (x<0 || x>this.width-1 || y<0 || y>this.height-1)
			{
				return null;
			}
		
			//case where box is in the maze
			else 
			{
				//case where box is not on the left border
				if (x > 0) 
				{
					neighboursList.add(boxes.get(x-1).get(y));
				}
			
				//case where box is not on the right border
				if (x < this.width - 1)
				{
					neighboursList.add(boxes.get(x+1).get(y));
				}
			
				//case where box is not on the top border
				if (y > 0) 
				{
					neighboursList.add(boxes.get(x).get(y-1));
				}
			
				//case where box is not on the bottom border
				if (y < this.height - 1) 
				{
					neighboursList.add(boxes.get(x).get(y+1));
				}
			
			return neighboursList ;
			}
		}
	
		/**
		 * Verifies if box is an Empty box (EBox, ABox or DBox).
		 * 
		 * @param box
		 * 
		 * @return True if box is an Empty box.
		 */
		public boolean containsEBox(MBox box) 
		{
			if (box.getType() == 'D' || box.getType() == 'A')
			{
				return true;
			}
			return eBoxes.contains(box);
		}
	
		/**
		 * Returns a list of all of the maze's boxes (vertices).
		 * 
		 * @return List of all of the maze's boxes.
		 */
		public ArrayList<VertexInterface> getAllVertices()
		{
			ArrayList<VertexInterface> allVertices = new ArrayList<VertexInterface>();
			for (ArrayList<MBox> column : boxes) 
			{
				for (MBox box : column) 
				{
					allVertices.add(box);
				}
			}
		
			return allVertices;
		}
	
		/**
		 * Returns the successors of the box (vertex) v in the maze (the other boxes you can directly get to from v).
		 * 
		 * @param v
		 * 
		 * @return List of box's successors.
		 */
		public ArrayList<VertexInterface> getSuccessors(VertexInterface v)
		{
			MBox box = (MBox) v ;
		
			ArrayList<VertexInterface> successors = new ArrayList<VertexInterface>();
			ArrayList<MBox> neighbours = this.getNeighbors(box);
		
			//finds the neighbors of box that are empty,
			//that are the successors of v
			for (MBox neighbour : neighbours) 
			{
				if (this.containsEBox(neighbour)) 
				{
					successors.add(neighbour);
				}
			}
			return successors;		
		}
	
		/**
		 * Returns the weight of the arc between u and v, which is always equal to 1 here.
		 * 
		 * @param u
		 * @param v
		 * 
		 * @return Weight of the arc between u and v, equal to 1.
		 */
		public int getWeight(VertexInterface u, VertexInterface v) 
		{
			return 1 ;
		}
	
		/**
		 * Returns the number of boxes in the maze.
		 * 
		 * @return Number of boxes in the maze
		 */
		public int getNbVertices() 
		{
			return this.height*this.width ;
		}
	
	}
