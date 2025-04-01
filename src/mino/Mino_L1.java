package mino;

import java.awt.Color;

import main.Block;

public class Mino_L1 extends Mino{

    public Mino_L1() {
        create(new Color(255, 165, 0));
    }

    @Override
    public void setXY(int x, int y) {
        // all minos in tetris is 4 blocks 
        // in super Mino class we have 4 one coloered blocks
        block[0].x = x;
        block[0].y = y;
        block[1].x = block[0].x;
        block[1].y = block[0].y - Block.size;
        block[2].x = block[0].x;
        block[2].y = block[0].y + Block.size;
        block[3].x = block[0].x + Block.size;
        block[3].y = block[0].y + Block.size;
        // az vasat mino migirim va ono rotate midim
        // actually besorat gostaresh az vasat block haro mikeshim
       
    }

    @Override
    public void getDirection1() {

        // direction 1 : is default block but making rotation we put them in temp 
        temp[0].x = block[0].x;
        temp[0].y = block[0].y;
        temp[1].x = block[0].x;
        temp[1].y = block[0].y - Block.size;
        temp[2].x = block[0].x;
        temp[2].y = block[0].y + Block.size;
        temp[3].x = block[0].x + Block.size;
        temp[3].y = block[0].y + Block.size;

        updateXY(1);


    }

    @Override
    public void getDirection2() {
        // O O O O
       //  O
       temp[0].x = block[0].x;
       temp[0].y = block[0].y;
       temp[1].x = block[0].x + Block.size;
       temp[1].y = block[0].y;
       temp[2].x = block[0].x - Block.size;
       temp[2].y = block[0].y;
       temp[3].x = block[0].x - Block.size;
       temp[3].y = block[0].y + Block.size;

       updateXY(2);

    }

    @Override
    public void getDirection3() {
       //O O 
       //  O
      //   O
      temp[0].x = block[0].x;
      temp[0].y = block[0].y;
      temp[1].x = block[0].x;
      temp[1].y = block[0].y + Block.size;
      temp[2].x = block[0].x;
      temp[2].y = block[0].y - Block.size;
      temp[3].x = block[0].x - Block.size;
      temp[3].y = block[0].y - Block.size;

      updateXY(3);

    }

    @Override
    public void getDirection4() {
      //     O 
      // O O O       
      temp[0].x = block[0].x;
      temp[0].y = block[0].y;
      temp[1].x = block[0].x - Block.size;
      temp[1].y = block[0].y;
      temp[2].x = block[0].x + Block.size;
      temp[2].y = block[0].y;
      temp[3].x = block[0].x + Block.size;
      temp[3].y = block[0].y - Block.size;

      updateXY(4);
    }
    
}
