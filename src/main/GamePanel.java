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
    KeyHandler keyHandler = new KeyHandler();


    public GamePanel() {

        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.BLACK);
        this.setLayout(null);
        // add key 
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    /*@Override
    public void run() {

        long currentTime;
        long lastTime;
        double perferdTime = 1000000000/6;
        double delta = 0;


       // time in nanoSecend
       lastTime = System.nanoTime();

        while (gameThread != null) {

            System.out.println("run");

            currentTime = System.nanoTime();
            
            delta += currentTime - lastTime / perferdTime;
             lastTime = currentTime;
            if(delta >= 1) {
                update();
                repaint();
                
                --delta;
            }   
        }
    }*/
    
    public void lunchGame() {

        gameThread = new Thread(this);
        // this will call the run method 
        gameThread.start();

    }

    // this method will be called form gameloop every 1/6 seconds to update the information of painting stufs
    private void update() {

        if(KeyHandler.pause == false) {
            playManager.update();
        }
        

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
    // re write run method form my other game
    @Override
    public void run() {
        
        double drawInterval = 1_000_000_000/60;// THIS is basicly our TARGET_TIME_TO_CYCLE
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        
        while ( gameThread != null)
        {
            currentTime = System.nanoTime();
             delta += (currentTime-lastTime)/drawInterval;// میخوایم ببینیم ایا دلتا به حد نسابش رسیدع یا نه
             if (delta >= 1)
             {
              update();//
              repaint();// THIS call paint method (PaintCompnent)
              delta--;
             }
             lastTime = currentTime;// update our lastTime 
        }
    }

    
}
