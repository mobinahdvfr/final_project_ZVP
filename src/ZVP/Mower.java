package ZVP;

import javax.swing.*;
import java.awt.*;

public class Mower extends JPanel {

    private GamePanel gamePanel;
    private Image image;
    private int y;
    private int mapY;
    private int x=-35;
    private boolean enable =true;
    private double speed =2;

    public Mower (GamePanel gamePanel, int y){
        setOpaque(false);
        image = new ImageIcon(this.getClass().getResource("image/lawn_mower.gif")).getImage();
        this.gamePanel = gamePanel;
        this.y = y;
        mapY = 150 + y * 120;
        setLocation(x, mapY);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }

    public void mow() {
        if (x < 1000) {
            x += 4;
        } else {
            enable=false;
//            gamePanel.remove(this);
        }
        setLocation(x, 109 + y * 120);
    }

    public boolean isEnable (){
        return enable;
    }

    public Image getImage (){
        return image;
    }

    public int getX (){
        return x;
    }

    public int getY (){
        return y;
    }

    public int getMapY (){
        return mapY;
    }

//    public void mow (){
//        gamePanel.clearTheRow(y);
//    }
}
