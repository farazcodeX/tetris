import javax.swing.ImageIcon;
import javax.swing.JFrame;

import main.GamePanel;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tetris");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(GamePanel.width, GamePanel.height);

        ImageIcon icon = new ImageIcon("C:\\Users\\TUF\\Desktop\\tetris\\tetris\\src\\images\\Tetris-Logo-Transparent-PNG.png");
        frame.setIconImage(icon.getImage());

        GamePanel gamePanel = new GamePanel();

        // when you add a panel to the frame it will adapt all the frame size
        frame.add(gamePanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // lucnh game here
        gamePanel.lunchGame();




    }
}