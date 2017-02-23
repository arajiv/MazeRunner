import java.util.Random;

/**
 * RandomOccupant.java
 * The RandomOccupant class represents an occupant that moves randomly about the
 * maze. 
 * @author Anand Rajiv, CPE 102-02
 * @version 02/21/17
 */
public abstract class RandomOccupant extends Occupant {
   
   private Random rand; 
   
   public RandomOccupant(Maze maze) { 
      super(maze); 
      rand = new Random(); 
      int row = rand.nextInt(maze.rows()); 
      int col = rand.nextInt(maze.cols()); 
      Square loc = maze.getSquare(row, col); 
      this.moveTo(loc); 
      
   }
   
   public RandomOccupant(Maze maze, long seed) { 
      super(maze); 
      rand = new Random(seed); 
      int row = rand.nextInt(maze.rows()); 
      int col = rand.nextInt(maze.cols()); 
      Square loc = maze.getSquare(row, col); 
      this.moveTo(loc);
   }
   
   public RandomOccupant(Maze maze, Square location) { 
      super(maze, location); 
      rand = new Random(); 
      
   }
   
   public void move() { 
      int row = this.location().row(); 
      int col = this.location().col(); 
      int direction = rand.nextInt(4);
      Square nextLoc = null; 
      boolean foundValid = false; 
      while(!foundValid) { 
         if(!this.maze().getSquare(row, col).wall(direction)) { 
            foundValid = true; 
            if(direction == Square.UP) { 
               nextLoc = this.maze().getSquare(row-1, col); 
            } else if(direction == Square.RIGHT) { 
               nextLoc = this.maze().getSquare(row, col+1);  
            } else if(direction == Square.DOWN) { 
               nextLoc = this.maze().getSquare(row+1, col); 
            } else if(direction == Square.LEFT){ 
               nextLoc = this.maze().getSquare(row, col-1);
            }
            
         } else { 
            direction = rand.nextInt(4); 
         }
      }
      this.moveTo(nextLoc);
   }
   
}
