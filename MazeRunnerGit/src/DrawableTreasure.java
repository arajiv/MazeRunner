/**
 * DrawableTreasure.java
 * The DrawableTreasure class represents the treasure that is drawn in the maze.
 * @author Anand Rajiv, CPE 102-02
 * @version 02/21/17
 *
 */
public class DrawableTreasure extends Treasure implements Drawable {
   
   public DrawableTreasure(Maze maze) { 
      super(maze); 
   }
   
   public DrawableTreasure(Maze maze, long seed) { 
      super(maze, seed); 
   }
   
   public DrawableTreasure(Maze maze, Square location) { 
      super(maze, location); 
   }
   
   public void draw() { 
      
   }

}
