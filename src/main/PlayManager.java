package main;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.List;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.Random;

import mino.Mino;
import mino.Mino_Bar;
import mino.Mino_L1;
import mino.Mino_L2;
import mino.Mino_Square;
import mino.Mino_T;
import mino.Mino_Z2;
import mino.Mino_z1;

public class PlayManager {
    // this class is for handeling basic elements if the game

    final int width = 360;
    final int height = 600;

    public static int leftX;
    public static int rightX;
    public static int topY;
    public static int buttonY;

    Mino mino;
    final int minoStarstX;
    final int minoStartY;


    public int block = 30;
    // our game is basicly made of 30*30 blocks
    // 12 block horizental and 30 block vertical

    // drop minos
   public static int dropInterval = 50;// 60 frmaes

   // next mino details
   Mino nextMino;
   final int nextMInoX;
   final int nextMinoY;
   // store the previus minos
   public static ArrayList<Block> staticBLocks = new ArrayList<>();

   // effect :
   public Boolean effectCOunterOn = false;
   int effectCounter = 0;
   public ArrayList<Integer> effectY = new ArrayList<>();

   // late game :
   public boolean gameOver = false;

   int level = 1;
   int score = 0;
   int linee = 0;
   int lineCounter = 0;
     
    public PlayManager() {

        leftX = (GamePanel.width/2) - (width/2);
        rightX = leftX+ width;

        topY = 50;
        buttonY = topY + height;

        // exactly middle of box
        minoStarstX = leftX + width/2 - Block.size;
        minoStartY = topY + Block.size;
    
        mino = pickMino();
        mino.setXY(minoStarstX, minoStartY);

        nextMInoX = 177 + rightX;
        nextMinoY = 503 + topY;

        mino = pickMino();
        mino.setXY(minoStarstX, minoStartY);

        nextMino = pickMino();
        nextMino.setXY(nextMInoX, nextMinoY);

    }
    private Mino pickMino() {
      
       Mino mino = null;
       int rand = new Random().nextInt(7);

       switch (rand) {
         case 0: mino = new Mino_L1(); break;
         case 1: mino = new Mino_Bar(); break;
         case 2: mino = new Mino_L2(); break;
         case 3: mino = new Mino_Square(); break;
         case 4: mino = new Mino_T(); break;
         case 5: mino = new Mino_Z2(); break;
         case 6: mino = new Mino_z1(); break;  
       }
       mino.touchedOnce = false;
        return mino;
    }
    
    public void update() {

        // mino active/deactive procces
        if(mino.active) {
            mino.update();
        } else {

            mino.deactivation = false;
            mino.deactiveCounter = 0;

            // if mino is deactive :
            for(int i = 0; i < 4; ++i) {
                staticBLocks.add(mino.block[i]);
            }

            // game stats
            if(mino.block[0].x == minoStarstX && mino.block[0].y == minoStartY) {
                gameOver = true;
                GamePanel.sound.play(1, false);
            }

            // then replace current mino with the next mino :
            mino = nextMino;
            mino.setXY(minoStarstX, minoStartY);
            // creating next mino
            nextMino = pickMino();
            nextMino.setXY(nextMInoX, nextMinoY);

            // check
            checkDeleteLine();
        }
    }

    public void checkDeleteLine() {

        // we are counting blocks in each line
        // it must be 12 blocks to delete a line
        // this method is not optimized well and its heavy

        int x = leftX;
        // in dalil dare
        int y = topY;
        int blockCounter = 0;
        
        while(x < rightX && y < buttonY) {
            for(int i = 0; i < staticBLocks.size(); ++i) {
                if(staticBLocks.get(i).x == x && staticBLocks.get(i).y == y) {
                    ++blockCounter;
                }
            }
            x += Block.size;
            if(x == rightX) {
                if(blockCounter == 12) {
                    ++lineCounter;
                    linee++;

                    // add effect
                    effectCOunterOn = true;
                    effectY.add(y);
                    // remove every block in this lien :
                    for(int j = staticBLocks.size()-1; j > -1; --j) {
                        // in dalil dare ke chra az akhar baresi mikonim
                        if(staticBLocks.get(j).y == y) {
                            staticBLocks.remove(j);
                        }
                    }
                    // after removing a line we need shit remain blocks down
                    for(int i = staticBLocks.size()-1; i > -1; --i) {
                        // if block is top of line 
                        if(staticBLocks.get(i).y < y) {
                            staticBLocks.get(i).y += Block.size;
                        }
                    }
                    if(linee % 10 == 0 && dropInterval > 1) {
                        ++level;
                        if(dropInterval > 10)  {
                            dropInterval -= 10;

                        }
                        else {
                            dropInterval -= 1;
                        }
                    }
                }

                blockCounter = 0;
                x = leftX;
                y += Block.size;
            }
        }
        if(lineCounter > 0) {
            GamePanel.sound.play(0, false);
            int singleLineScore = 10 + level;
            score += singleLineScore + linee;
        }
    }
    public void draw(Graphics2D g2d) {

        g2d.setColor(Color.WHITE);
        g2d.setStroke(new BasicStroke(4f));
        g2d.drawRect(leftX-4, topY-4, width+8, height+8);
        // draw waiting room 
        int x = rightX + 100;
        int y = buttonY - 200;
        g2d.drawRect(x, y, 200, 200);
        // adding text
        g2d.setFont(new Font("Arial", Font.PLAIN, 30));
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2d.drawString("NEXT", x+60, y+60);

        // scpre
        g2d.drawRect(x, topY, 250, 300);
        x += 40;
        y = topY + 90;
        g2d.drawString("LEVEL " + level, x, y); y += 70;
        g2d.drawString("Lines " + linee, x, y); y += 70;
        g2d.drawString("SCORE " + score, x, y);
 

        for(Block block2 : staticBLocks) {
            block2.draw(g2d);
        }

        // draw the mino
        if(mino != null) {
            mino.draw(g2d);
        }
        // automaticly
        nextMino.draw(g2d);

        // pause menu
        g2d.setColor(Color.YELLOW);
        g2d.setFont(g2d.getFont().deriveFont(50f));
        if(KeyHandler.pause) {
            x = leftX + 70;
            y = topY + 320;
            g2d.drawString("PAUSED", x, y);
        } 
        
        if(effectCOunterOn) {

            ++effectCounter;
            
            g2d.setColor(Color.RED);
            for(int i = 0; i < effectY.size(); ++i) {
                g2d.fillRect(leftX, effectY.get(i), width, Block.size);
            }

            if(effectCounter == 10) {
                effectCOunterOn = false;
                effectCounter = 0;
                effectY.clear();
            }
        }
        if(gameOver) {
            g2d.setColor(Color.RED);
            g2d.setFont(new Font("Arial", Font.PLAIN, 50));
            x = leftX + 70;
            y = topY + 320;
            g2d.drawString("GAME OVER", x, y);

        } 
    }
}
