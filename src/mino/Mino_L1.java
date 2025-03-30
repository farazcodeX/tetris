package mino;

import java.awt.Color;

import main.Block;

public class Mino_L1 extends Mino{

    public Mino_L1() {
        create(Color.ORANGE);
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
    public void updateXY(int direction) {
       
    }
    
}
