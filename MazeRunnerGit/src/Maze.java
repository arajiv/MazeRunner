import java.util.*;
/**
 * Maze.java
 * Class that contains all the logic to model a Maze with Occupants. 
 * @author Anand Rajiv, CPE 102-02  
 * @version 02/21/17
 */
public class Maze
{
   // named constants
   public static final int ACTIVE = 0;
   public static final int EXPLORER_WIN = 1;
   public static final int MONSTER_WIN = 2;
    
    // instance variables
   private Square[][] squares;
   private ArrayList<RandomOccupant> randOccupants;
   private Explorer explorer;
   private int rows;
   private int cols;

   /**
    * Constructor for objects of class Maze
    */
   public Maze(Square[][] squares, int rows, int cols)
   {
      this.squares = squares; 
      this.rows = rows; 
      this.cols = cols; 
		
     randOccupants = new ArrayList<RandomOccupant>(); 
		
   }
	
   // QUERIES
   public Square getSquare(int row, int col) { 
      return squares[row][col]; 
   }
   public int rows() {
      return rows;
   }
   public int cols() {
      return cols;
   }
   public String explorerName() {
      return explorer.name();
   }
   public Explorer getExplorer() {
      return explorer;
   }
    
   
   public RandomOccupant getRandomOccupant(int index) {
      return randOccupants.get(index);
   }
   
   public int getNumRandOccupants() {
      return randOccupants.size();
   }
	
   // COMMANDS
   // CHANGE - implement the following method
   public void addRandomOccupant(RandomOccupant ro) {  
      randOccupants.add(ro); 
   }
	
   public void setExplorer(Explorer e) {
      explorer = e;
   }
	
   public void explorerMove(int key) {
      explorer.move(key);
   }
	
   public void randMove() {
      // CHANGE - instruct each object in the RandomOccupant to move
      for(int i = 0; i < randOccupants.size(); i++) { 
         randOccupants.get(i).move();
      }
   }
	
   /**
    * Returns the status of the game.
    *
    * If all treasures have been found, return EXPLORER_WIN.
    * If not, check each maze occupant, if it is a Monster and
    *    it is in the same location as the Explorer, return
    *    MONSTER_WIN.  Note that you can use == to check locations, do you know why?
    * Otherwise, return ACTIVE.
    */
   public int gameStatus()
   {
      int status = ACTIVE;
        
      // CHANGE - implement
      if(foundAllTreasures()) { 
         return EXPLORER_WIN; 
      }
      
      for(int i = 0; i < randOccupants.size(); i++) { 
         RandomOccupant currentRand = randOccupants.get(i); 
         if(currentRand instanceof Monster) { 
            Monster m = (Monster)currentRand; 
            if(explorer.location() == m.location()) { 
               return MONSTER_WIN; 
            }
         }
      }
        
      return status;
   }
	
   private boolean foundAllTreasures()
   {
      boolean foundAll = true;
        
      // CHANGE - search through all the occupants to see if the Treasures have been found.  Return false if
      //        - there is a Treasure that hasn't been found.
      for(int i = 0; i < randOccupants.size(); i++) { 
         RandomOccupant currentRand = randOccupants.get(i); 
         if(currentRand instanceof Treasure) { 
            Treasure t = (Treasure)currentRand; 
            if(!t.found()) { 
               return false; 
            }
         }
      }
              
      return foundAll;
   }
    
   public void lookAround(Square s)
   {
      int row = s.row();
      int col = s.col();
        
      // Clear what was previously in view
      resetInView();
        
      // Set the current square so that we are viewing it (obviously)
      s.setInView(true);
        
      // CHANGE - Check the adjacent squares.  If there isn't a wall in the way, set their inview to true.
      //        - Check the diagonal squares.  If there isn't a wall in the way, set their inview to true.
      
      if(!squares[row][col].wall(Square.UP)) { 
         squares[row-1][col].setInView(true); 
         if(!squares[row-1][col].wall(Square.LEFT)) {
            squares[row-1][col-1].setInView(true);
         }
         if(!squares[row-1][col].wall(Square.RIGHT)) { 
            squares[row-1][col+1].setInView(true);
         }
      }
      
      if(!squares[row][col].wall(Square.LEFT)) { 
         squares[row][col-1].setInView(true);
         if(!squares[row][col-1].wall(Square.UP)) { 
            squares[row-1][col-1].setInView(true);
         }
         if(!squares[row][col-1].wall(Square.DOWN)) { 
            squares[row+1][col-1].setInView(true);
         }
      }
      
      if(!squares[row][col].wall(Square.RIGHT)) { 
         squares[row][col+1].setInView(true);
         if(!squares[row][col+1].wall(Square.UP)) { 
            squares[row-1][col+1].setInView(true);
         }
         if(squares[row][col+1].wall(Square.DOWN)) { 
            squares[row+1][col+1].setInView(true);
         }
      }
      
      if(!squares[row][col].wall(Square.DOWN)) { 
         squares[row+1][col].setInView(true);
         if(!squares[row+1][col].wall(Square.RIGHT)) { 
            squares[row+1][col+1].setInView(true);
         }
         if(!squares[row+1][col].wall(Square.LEFT)) { 
            squares[row+1][col-1].setInView(true);
         }
      }
   }
    
   private void resetInView()
   {
      for (int i = 0; i<rows; i++) {
         for (int j = 0; j<cols; j++) {
            squares[i][j].setInView(false);
         }
      }
   }
}
