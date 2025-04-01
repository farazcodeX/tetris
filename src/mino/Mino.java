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
   
   // collision
   public Boolean rightCo, leftCo, buttonCO;
   public Boolean active = true;


   // set a delay when mino is about to be deacivate
   public boolean deactivation = false;
   public int deactiveCounter = 0;


   

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

      checkRotateCollision();

      if(leftCo == false && rightCo == false && buttonCO == false) {
          for(int i = 0; i < 4; ++i) {
           block[i].x = temp[i].x;
           block[i].y = temp[i].y;

         }
      }

     
      // why using temp array : if you touch a mino the rotation will be canceled 
      // so we need to re store privuse position

   }
   public abstract void getDirection1();
   public abstract void getDirection2();
   public abstract void getDirection3();
   public abstract void getDirection4();

   // we need to check if current mino is making collision with other static blocks or no
   public void checkBLockCollision() {

      // insect isnt working : 
      for(Block block1 : PlayManager.staticBLocks) {
         int x = block1.x;
         int y = block1.y;

         for(int i = 0; i < block.length; ++i) {
            if(block[i].x == x && block[i].y + Block.size == y) {
               buttonCO = true;
            }
         }
         for(int i = 0; i < block.length; ++i) {
            if(block[i].x - Block.size == x && block[i].y == y) {
               leftCo = true;
            }
         }
         for(int i = 0; i < block.length; ++i) {
            if(block[i].x + Block.size == x && block[i].y == y) {
               rightCo = true;
            }
         }
         
         
      }

   }

   public void checkMoveCollision() {

      rightCo = false;
      leftCo = false;
      buttonCO = false;

      // blocks collison
      checkBLockCollision();

      for(int i = 0; i < 4; ++i) {
         if(block[i].x == PlayManager.leftX) {
            leftCo = true;
         }
      }
      for(int i = 0; i < 4; ++i) {
         if(block[i].x + Block.size == PlayManager.rightX) {
            rightCo = true;
         }
      }
      for(int i = 0; i < 4; ++i) {
         if(block[i].y + Block.size == PlayManager.buttonY) {
             buttonCO = true;
         }
      }

   }
   public void checkRotateCollision() {

      // you need to check if you rotate you have make sure you r not making any collison

      rightCo = false;
      leftCo = false;
      buttonCO = false;

      checkBLockCollision();

      for(int i = 0; i < 4; ++i) {
         if(temp[i].x < PlayManager.leftX) {
            leftCo = true;
         }
      }
      for(int i = 0; i < 4; ++i) {
         if(temp[i].x + Block.size > PlayManager.rightX) {
            rightCo = true;
         }
      }
      for(int i = 0; i < 4; ++i) {
         if(temp[i].y + Block.size > PlayManager.buttonY) {
             buttonCO = true;
         }
      }


   }
   public void deactiveDelay() {
      ++deactiveCounter;
      if(deactiveCounter == 35) {

         // first check if the buttom is still hitting or no
         checkMoveCollision(); 
         if(buttonCO) {
            active = false;

         }
      }
   }

   public void update() {

      if(deactivation) {
         deactiveDelay();
      }


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

      checkMoveCollision();
      //if collision is happening so the mino cannot move

      if(KeyHandler.down) {
         // ez
         if(buttonCO == false) {
            for(int i = 0; i < 4; ++i) {
            block[i].y += Block.size;
            }
            autoDropCounter = 0;
         }
         
         KeyHandler.down = false;

      }
      if(KeyHandler.left) {

         if(leftCo == false) {
            for(int i = 0; i < 4; ++i) {
            block[i].x -= Block.size;
            }
         }
         KeyHandler.left = false;
      }
      if(KeyHandler.rigth) {

         if(rightCo == false) {
            for(int i = 0; i < 4; ++i) {
            block[i].x += Block.size;
            }
         }
         
         KeyHandler.rigth = false;
      }


       if(buttonCO) {
         // if mino reaches button we deactive the mino and deploy next one
         // instead of deactive immdaitly we put some delay in proccess

         deactivation = true;

       }
       else {
         ++autoDropCounter;
         if(autoDropCounter == PlayManager.dropInterval) {
         // move evry block by one block every time the counter hits the number
            for(int i = 0; i < 4; ++i) {
              block[i].y += Block.size;
              autoDropCounter = 0;

            }
         }
       }
      // first mino drop
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
