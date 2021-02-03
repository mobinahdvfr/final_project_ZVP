package ZVP;

import javax.swing.*;
import java.awt.*;

public class Bullet extends JPanel {

        private Image image;

        private int harm;
        private GamePanel gamePanel;
        private int x;
        private int y;
        private int row;
        private double speed;

        public Bullet (GamePanel gamePanel, int x, int row, int harm){
            this.gamePanel = gamePanel;
            this.x = x;
            y = 130 + (row * 120);
            this.harm = harm;
            speed =3;
        }

        public void setImage (Image image){
            this.image = image;
        }

        public int getX (){
            return x;
        }

        public Zombie attack (){
            Zombie z = null;
//            for (int i = 0; i < gamePanel.getRowZombies(row).size(); i++) {
//                z = gamePanel.getRowZombies(row).get(i);
//                if (x == z.getX()) {
//                    z.setHealth(z.getHealth() - harm);
//                    if (z.getHealth() < 0) {
//                        System.out.println("Zombie died");
//                        gamePanel.getRowZombies(row).remove(i);
////                        GamePanel.setProgress(10);
//                        return null;
//                    }
//                    gamePanel.getRowPeas(row).remove(this);
//                    break;
//                }
//            }
            x += 14;
            setLocation(x,y);
            return z;
        }

        public void paintComponent (Graphics g){
            g.drawImage(image,0,0,null);
        }

        public int getRow (){
            return row;
        }

}
