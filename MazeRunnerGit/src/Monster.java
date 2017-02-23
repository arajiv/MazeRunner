
/**
 * Monster.java
 * The Monster class represents a RandomOccupant that ends the game if the 
 * explorer encounters it. 
 * @author Anand Rajiv, CPE 102-02
 * @version 02/21/17
 */
public class Monster extends RandomOccupant  {
   
   public Monster(Maze maze) { 
      super(maze); 
   }
   
   public Monster(Maze maze, long seed) { 
      super(maze, seed); 
   }
   
   public Monster(Maze maze, Square location) { 
      super(maze, location); 
   }
   
}
