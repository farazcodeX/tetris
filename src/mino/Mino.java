package mino;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.jar.JarEntry;

import javax.swing.text.html.HTMLDocument.BlockElement;

import main.Block;
import main.PlayManager;
import main.KeyHandler;



public abstract class Mino {

   // super class of all tetrominos
   public Block block[] = new Block[4];
   public Block temp[] = new Block[4];

   int autoDropCounter = 0;
   public int direction = 1; // 1, 2, 3, 4;
   // each mino has 4 rotations


   Color color;

   public void create(Color color) {

       this.color = color;

      for(int i = 0; i < 4; ++i) {
        // initialze all the objects in the array
        // even if BLock class doesnt have constructor 
        // we must do this for them
         block[i] = new Block(color); 
         temp[i] = new Block(color);

      }
     

   }
   
    
   public abstract void setXY(int x, int y);
   public void updateXY(int direction) {
      // this method apply the changes form each rotation
      this.direction = direction;

      for(int i = 0; i < 4; ++i) {
         block[i].x = temp[i].x;
         block[i].y = temp[i].y;

      }
      // why using temp array : if you touch a mino the rotation will be canceled 
      // so we need to re store privuse position

   }
   public abstract void getDirection1();
   public abstract void getDirection2();
   public abstract void getDirection3();
   public abstract void getDirection4();

   public void update() {
      // first mino drop
      ++autoDropCounter;
      if(autoDropCounter == PlayManager.dropInterval) {
         // move evry block by one block every time the counter hits the number
         for(int i = 0; i < 4; ++i) {
            block[i].y += Block.size;
            autoDropCounter = 0;

         }
      }

      // second : mino rutation
      if(KeyHandler.up) {

         switch (direction) {
            case 1: getDirection2(); break;
            case 2: getDirection3(); break;
            case 3: getDirection4(); break;
            case 4: getDirection1(); break;

         }
         autoDropCounter = 0;
         KeyHandler.up = false;

      }
      if(KeyHandler.down) {
         // ez
         for(int i = 0; i < 4; ++i) {
            block[i].y += Block.size;
         }
         autoDropCounter = 0;
         KeyHandler.down = false;

      }
      if(KeyHandler.left) {

      }
      if(KeyHandler.rigth) {

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
