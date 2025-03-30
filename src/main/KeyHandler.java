package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{

    public static boolean up, down, left, rigth;

    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    // just this one
    @Override
    public void keyPressed(KeyEvent e) {
        
        // every time you press a key this method will be called with special e;
        // every keyEvent has a code int with that you access to your keys
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_UP) {
            up = true;

        }
        if(code == KeyEvent.VK_DOWN) {
            down = true;
            
        }
        if(code == KeyEvent.VK_LEFT) {
            left = true;
            
        }
        if(code == KeyEvent.VK_RIGHT) {
            rigth = true;
            
        }

        
    }

    @Override
    public void keyReleased(KeyEvent e) {
    
    }
    
}
