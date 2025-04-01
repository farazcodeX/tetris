package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Block extends Rectangle{
 
    public int x, y;
    public static final int size = 30;// block
    public Color color;

    public Block(Color color) {
        this.color = color;
    }
    public void draw(Graphics2D g2d) {

        int margin = 2;

        g2d.setColor(color);
        g2d.fillRect(x + margin, y + margin, size-(2* margin), size-(2*margin));
    }

}
