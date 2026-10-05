import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main {

    static int playerX = 100;
    static int playerY = 100;

    static int boxX = 250;
    static int boxY = 100;



    public static void main(String[] args) {



        JFrame frame = new JFrame();
        frame.setTitle("A game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(420,420);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.BLACK);

        // PANEL

        JPanel panel = new JPanel() {
            public void paint(Graphics g){
                super.paint(g);
                g.setColor(Color.green);
                g.fillRect(playerX,playerY,50,50);

                g.setColor(Color.RED);
                g.fillRect(boxX, boxY, 50, 50);
            }
        };

        JLabel label = new JLabel();
        label.setText("Press Enter Start The Game");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setForeground(Color.GREEN);
        label.setFont(new Font("MV Boli",Font.PLAIN,20));
        frame.add(label);

        frame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    frame.remove(label);
                    frame.add(panel);
                    frame.revalidate();
                    frame.repaint();
                    frame.add(panel);
                }
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    if (playerX < 355){
                        playerX += 5;
                        panel.repaint();
                        System.out.println(playerX);
                    } else{
                        //System.out.println("PLAYER ON THE BOARDER");
                    }
                }

                if (e.getKeyCode() == KeyEvent.VK_A){
                    if (playerX > 0){
                        playerX -= 5;
                        panel.repaint();
                        System.out.println(playerX);
                    }
                }

                Rectangle player  = new Rectangle(playerX,playerY,50,50);
                Rectangle box  = new Rectangle(boxX,boxY,50,50);

                if (player.intersects(box)){
                    frame.remove(panel);

                    JLabel Ended = new JLabel("PLAYER DIED");
                    Ended.setHorizontalAlignment(JLabel.CENTER);
                    Ended.setVerticalAlignment(JLabel.CENTER);
                    Ended.setForeground(Color.red);
                    Ended.setFont(new Font("MV Boli",Font.PLAIN,20));

                    frame.add(Ended);
                    frame.revalidate();
                    frame.repaint();
                }


            }
        });

        frame.getContentPane().setBackground(Color.BLACK);
        frame.setVisible(true);
    }
}