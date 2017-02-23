

/**
 * Occupant.java
 * The occupant class represents an object that takes up a square in the maze.  
 * @author Anand Rajiv, CPE 102-02
 * @version 02/21/17 
 */
public abstract class Occupant {

   private Square location; 
   private Maze maze; 
   
   public Occupant(Maze maze) { 
      this.maze = maze; 
   }
   
   public Occupant(Maze maze, Square location) { 
      this.maze = maze; 
      this.location = location; 
   }
   
   public Square location() { 
      return location; 
   }
   
   public Maze maze() { 
      return maze; 
   }
   
   public void moveTo(Square newLoc) { 
      location = newLoc; 
   }

}
