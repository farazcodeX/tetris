package mino;

import java.awt.Color;

import main.Block;

public class Mino_T extends Mino{

    public Mino_T() {
        create(Color.MAGENTA);
    }

    @Override
    public void setXY(int x, int y) {
        // O
      // O O O

        block[0].x = x;
        block[0].y = y;
        block[1].x = block[0].x;
        block[1].y = block[0].y - Block.size;
        block[2].x = block[0].x;
        block[2].y = block[0].y + Block.size;
        block[3].x = block[0].x + Block.size;
        block[3].y = block[0].y + Block.size;
       
    }

    @Override
    public void getDirection1() {

        
    
    }

    @Override
    public void getDirection2() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDirection2'");
    }

    @Override
    public void getDirection3() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDirection3'");
    }

    @Override
    public void getDirection4() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDirection4'");
    }

    
    
}
