package mino;

import java.awt.Color;
import java.sql.Blob;

import main.Block;

public class Mino_L2 extends Mino {

    public Mino_L2() {
        create(Color.MAGENTA);
    }

     

    @Override
    public void setXY(int x, int y) {
       // O
       // O
      //O O
      block[0].x = x;
      block[0].y = y;
      block[1].x = block[0].x;
      block[1].y = block[0].y - Block.size;
      block[2].x = block[0].x;
      block[2].y = block[0].y + Block.size;
      block[3].x = block[0].x - Block.size;
      block[3].y = block[0].y + Block.size;

        
    }

    @Override
    public void getDirection1() {

        temp[0].x = block[0].x;
        temp[0].y = block[0].y;
        temp[1].x = block[0].x;
        temp[1].y = block[0].y - Block.size;
        temp[2].x = block[0].x;
        temp[2].y = block[0].y + Block.size;
        temp[3].x = block[0].x - Block.size;
        temp[3].y = block[0].y + Block.size;

        updateXY(1);


  
    }

    @Override
    public void getDirection2() {
        
        temp[0].x = block[0].x;
        temp[0].y = block[0].y;
        temp[1].x = block[0].x + Block.size;
        temp[1].y = block[0].y;
        temp[2].x = block[0].x - Block.size;
        temp[2].y = block[0].y;
        temp[3].x = block[0].x - Block.size;
        temp[3].y = block[0].y - Block.size;

        updateXY(2);

    }

    @Override
    public void getDirection3() {

        temp[0].x = block[0].x;
        temp[0].y = block[0].y;
        temp[1].x = block[0].x;
        temp[1].y = block[0].y + Block.size;
        temp[2].x = block[0].x;
        temp[2].y = block[0].y - Block.size;
        temp[3].x = block[0].x + Block.size;
        temp[3].y = block[0].y - Block.size;

        updateXY(3);
  
    }

    @Override
    public void getDirection4() {

        temp[0].x = block[0].x;
        temp[0].y = block[0].y;
        temp[1].x = block[0].x - Block.size;
        temp[1].y = block[0].y;
        temp[2].x = block[0].x + Block.size;
        temp[2].y = block[0].y;
        temp[3].x = block[0].x + Block.size;
        temp[3].y = block[0].y + Block.size;

        updateXY(4);

        // ina az ye pattern peyravy mikonan

        
    }
    
}
