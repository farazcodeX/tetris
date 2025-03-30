package mino;

import java.awt.Color;
import java.awt.Graphics2D;

import main.Block;
import main.PlayManager;

public class Mino {

   // super class of all tetrominos
   public Block block[] = new Block[4];
   public Block temp[] = new Block[4];

   int autoDropCounter = 0;


   Color color;

   public void create(Color color) {

      for(int i = 0; i < 4; ++i) {
        // initialze all the objects in the array
        // even if BLock class doesnt have constructor 
        // we must do this for them
         block[i] = new Block(color); 
         temp[i] = new Block(color);

      }
      this.color = color;

   }
    
   public void setXY(int x, int y) {}
   public void updateXY(int direction) {}
   public void update() {

      ++autoDropCounter;

      if(autoDropCounter == PlayManager.dropInterval) {
         // move evry block by one block every time the counter hits the number
         for(int i = 0; i < 4; ++i) {
            block[i].y += Block.size;
            autoDropCounter = 0;

         }
      }

   }
   public void draw(Graphics2D g2d) {

      int margin = 2;

      //lets draw the mino in itself
      g2d.setColor(color);
      // bro there are just 4 blocks
      for(int i = 0; i < 4; ++i) {
         g2d.fillRect(block[i].x+margin, block[i].y+margin, Block.size-2*margin, Block.size-2*margin);


      }

      
   }

     

    
}
