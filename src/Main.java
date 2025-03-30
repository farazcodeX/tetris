import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tetris");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
       
        frame.setSize(GamePanel.width, GamePanel.height);

        GamePanel gamePanel = new GamePanel();

        // when you add a panel to the frame it will adapt all the frame size
        frame.add(gamePanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);




    }
}