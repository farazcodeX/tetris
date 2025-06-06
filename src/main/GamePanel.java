package main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Time;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import sound.Sound;

public class GamePanel extends JPanel implements Runnable{

    // set Screen size first
    public static final int width = 1280;
    public static final int height = 720;

    Thread gameThread;
    PlayManager playManager = new PlayManager();
    KeyHandler keyHandler = new KeyHandler();
    public static Sound sound = new Sound();
    public static Sound music = new Sound();

    BufferedImage title;
    BufferedImage backGround;


    public GamePanel()  {

        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.BLACK);
        this.setLayout(null);
        // add key 
        this.addKeyListener(keyHandler);
        this.setFocusable(true);

        try {
            title = ImageIO.read(new File("C:\\Users\\TUF\\Desktop\\tetris\\tetris\\src\\images\\Tetris-Logo-Transparent-PNG.png"));
            backGround = ImageIO.read(new File("C:\\Users\\TUF\\Desktop\\tetris\\tetris\\src\\images\\ChatGPT Image May 18, 2025, 09_26_51 PM.png"));
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }

    public void lunchGame() {

        gameThread = new Thread(this);
        // this will call the run method 
        gameThread.start();
        // start the music
        // dont have music yet
        //music.play(0, true);
    }

    // this method will be called form gameloop every 1/6 seconds to update the information of painting stufs
    private void update() {

        if(KeyHandler.pause == false && playManager.gameOver == false) {
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
        g2d.drawImage(backGround, 0, 0, 1280, 720, null);
        playManager.draw(g2d);

       g2d.drawImage(title, 70, playManager.topY + Block.size, playManager.leftX - 100 - Block.size, 400, null);
       

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
