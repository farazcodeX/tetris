import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{

    // set Screen size first
    public static final int width = 1280;
    public static final int height = 720;

    Thread gameThread;

    public GamePanel() {

        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.BLACK);
        this.setLayout(null);


        


    }

    @Override
    public void run() {
       
        


    }
    public void lunchGame() {

        gameThread = new Thread(this);
        // this will call the run method 
        gameThread.start();

    }

    // this method will be called form gameloop every 1/6 seconds to update the information of painting stufs
    private void update() {

    }
    // lets go to my darling
    @Override
    protected void paintComponent(Graphics g) {
        // this is essential
        super.paintComponent(g);

        
    }

    
}
