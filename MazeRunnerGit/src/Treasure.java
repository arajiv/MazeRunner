
/**
 * Treasure.java
 * The Treasure class represents an occupant in which the Explorer tries to find
 * to win the game. 
 * @author Anand Rajiv, CPE 102-02
 * @version 02/21/17
 */
public class Treasure extends RandomOccupant {
   
   private boolean isFound; 
   
   public Treasure(Maze maze) { 
      super(maze); 
      isFound = false; 
      this.location().setTreasure(this);
   }
   
   public Treasure(Maze maze, long seed) { 
      super(maze,seed); 
      isFound = false; 
      this.location().setTreasure(this);
   }
   
   public Treasure(Maze maze, Square location) { 
      super(maze, location); 
      isFound = false; 
      location.setTreasure(this);
   }
   
   public boolean found() { 
      return isFound; 
   }
   
   public void setFound() { 
      isFound = true; 
   }
   
   public void move() { 
      return; 
   }
   
}
