
/**
 * DrawableSquare.java
 * The DrawableSquare represents the square that is drawn in the maze. 
 * @author Anand Rajiv, CPE 102-02
 * @version 02/21/17
 *
 */
public class DrawableSquare extends Square implements Drawable {

  
   public DrawableSquare(boolean up, boolean right, boolean down,
         boolean left, int row, int col) { 
      super(up,right,down,left,row,col); 
   }
   
   public void draw() {
     if(this.seen()) { 
        
     }
   }

}
