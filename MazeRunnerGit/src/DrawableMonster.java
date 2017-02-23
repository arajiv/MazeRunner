
/**
 * DrawableMonster.java
 * The DrawableMonster class represents the monster that is drawn in the maze. 
 * @author Anand Rajiv, CPE 102-02
 * @version 02/21/17
 *
 */
public class DrawableMonster extends Monster implements Drawable {

   public DrawableMonster(Maze maze) { 
      super(maze); 
   }
   
   public DrawableMonster(Maze maze, long seed) { 
      super(maze, seed); 
   }
   
   public DrawableMonster(Maze maze, Square location) { 
      super(maze, location); 
   }
   
   public void draw() { 
      
   }
}
