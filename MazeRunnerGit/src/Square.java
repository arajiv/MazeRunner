
/**
 * Square.java
 * The Square class represents a square in the maze in which an occupant can be
 * in
 * @author Anand Rajiv, CPE 102-02
 * @version 02/21/17
 */
public class Square {

    public static final int SQUARE_SIZE = 50;
    public static final int UP = 0; 
    public static final int RIGHT = 1;
    public static final int DOWN = 2;
    public static final int LEFT = 3; 
    
    private boolean[] walls; 
    private boolean seen; 
    private boolean inView; 
    private int row; 
    private int column; 
    private Treasure treasure; 
    
    public Square(boolean up, boolean right, boolean down, boolean left, 
          int row, int col) { 
       walls = new boolean[4]; 
       walls[0] = up; 
       walls[1] = right; 
       walls[2] = down; 
       walls[3] = left; 
       
       this.row = row; 
       column = col; 
       
       seen = false; 
       inView = false; 
       
       treasure = null; 
    }
    
    public boolean wall(int direction) { 
       return walls[direction]; 
    }
    
    public boolean seen() { 
       return seen; 
    }
    
    public boolean inView() { 
       return inView; 
    }
    
    public int row() { 
       return row; 
    }
    
    public int col() { 
       return column; 
    }
    
    public Treasure treasure() { 
       return treasure; 
    }
    
    public int x() { 
       return column * SQUARE_SIZE; 
    }
    
    public int y() { 
       return row * SQUARE_SIZE; 
    }
    
    public void setInView(boolean inView) { 
       this.inView = inView; 
       if(inView) { 
          seen = true; 
       }
    }
    
    public void setTreasure(Treasure t) { 
       treasure = t; 
    }
    
    public void enter() { 
       
       if(treasure != null) {  
          treasure.setFound();
       }
    }
    
}
