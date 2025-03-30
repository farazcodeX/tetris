package mino;

import java.awt.Color;
import java.awt.Graphics2D;

import main.Block;

public abstract class Mino {

   // super class of all tetrominos
   public Block block[] = new Block[4];
   public Block temp[] = new Block[4];

   public void create(Color color) {

      for(int i = 0; i < 4; ++i) {
        // initialze all the objects in the array
        // even if BLock class doesnt have constructor 
        // we must do this for them
         block[i] = new Block(color); 
         temp[i] = new Block(color);
      }

   }
    
   public abstract void setXY(int x, int y);
   public abstract void updateXY(int direction);
   public void update() {

   }
   public void draw(Graphics2D g2d) {
      
   }

     

    
}
