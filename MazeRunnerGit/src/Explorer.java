import java.awt.event.KeyEvent;

/**
 * Explorer.java
 * The Explorer class represents an occupant that travels around the maze looking
 * for the treasure. Controlled by the user.  
 * @author Anand Rajiv, CPE 102-02
 * @version 02/21/17
 */
public class Explorer extends Occupant {

   private String name;

   public Explorer(Square location, Maze maze, String name) {
      super(maze, location);
      this.name = name;
      maze.lookAround(location);
   }

   public String name() {
      return name;
   }

   public void move(int key) {
      Square currentLoc = this.location();
      int row = currentLoc.row();
      int col = currentLoc.col();
      Square newLoc;
      if (key == KeyEvent.VK_UP || key == KeyEvent.VK_KP_UP) {
         if (!currentLoc.wall(Square.UP)) {
            newLoc = this.maze().getSquare(row - 1, col);
            this.moveTo(newLoc);
         }
      }

      else if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_KP_RIGHT) {
         if (!currentLoc.wall(Square.RIGHT)) {
            newLoc = this.maze().getSquare(row, col + 1);
            this.moveTo(newLoc);
         }
      }

      else if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_KP_DOWN) {
         if (!currentLoc.wall(Square.DOWN)) {
            newLoc = this.maze().getSquare(row + 1, col);
            this.moveTo(newLoc);
         }
      }

      else if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_KP_LEFT) {
         if (!currentLoc.wall(Square.LEFT)) {
            newLoc = this.maze().getSquare(row, col - 1);
            this.moveTo(newLoc);
         }
      }
   }

   public void moveTo(Square s) {
      super.moveTo(s);
      s.enter();
      this.maze().lookAround(s);
   }
}
