package mino;

import java.awt.Color;

import main.Block;

public class Mino_Square extends Mino{

    public Mino_Square() {
        create(Color.YELLOW);
    }

    @Override
    public void setXY(int x, int y) {
        // O O
        // O O
      block[0].x = x;
      block[0].y = y;
      block[1].x = block[0].x;
      block[1].y = block[0].y + Block.size;
      block[2].x = block[0].x + Block.size;
      block[2].y = block[0].y;
      block[3].x = block[0].x + Block.size;
      block[3].y = block[0].y + Block.size;



    }
    
    // squer doesnt have any rotation so we dont need them
    @Override
    public void getDirection1() {}
    @Override
    public void getDirection2() {}
    @Override
    public void getDirection3() {}
    @Override
    public void getDirection4() {}
     
      
    
}
