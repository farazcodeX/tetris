package main;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import mino.Mino;
import mino.Mino_L1;

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
   public final static int dropInterval = 60;// 60 frmaes
   

    public PlayManager() {

        leftX = (GamePanel.width/2) - (width/2);
        rightX = leftX+ width;

        topY = 50;
        buttonY = topY + height;

        // exactly middle of box
        minoStarstX = leftX + width/2 - Block.size;
        minoStartY = topY + Block.size;
    
        mino = new Mino_L1();
        mino.setXY(minoStarstX, minoStartY);




    }
    public void update() {

        mino.update();

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

        // draw the mino
        if(mino != null) {
            mino.draw(g2d);
        }





        

    }


}
