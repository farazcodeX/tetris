package main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.sql.Time;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{

    // set Screen size first
    public static final int width = 1280;
    public static final int height = 720;

    Thread gameThread;
    PlayManager playManager = new PlayManager();

    public GamePanel() {

        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.BLACK);
        this.setLayout(null);


        


    }

    @Override
    public void run() {

        long currentTime;
        long lastTime;
        double perferdTime = 100_000_000/6;
        double delta = 0;


       // time in nanoSecend
       lastTime = System.nanoTime();

        while (gameThread != null) {

            currentTime = System.nanoTime();
            
            delta += currentTime - lastTime / perferdTime;
            
            if(delta >= 1) {
                update();
                repaint();
                
                --delta;
            }

            lastTime = currentTime;

            
        }
       
        


    }
    public void lunchGame() {

        gameThread = new Thread(this);
        // this will call the run method 
        gameThread.start();

    }

    // this method will be called form gameloop every 1/6 seconds to update the information of painting stufs
    private void update() {
        playManager.update();

    }
    // lets go to my darling
    @Override
    protected void paintComponent(Graphics g) {
        // this is essential
        super.paintComponent(g);
        
        // a downCacst
        Graphics2D g2d = (Graphics2D)g;
        playManager.draw(g2d);


    }

    
}
