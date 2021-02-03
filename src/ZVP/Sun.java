package ZVP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Sun extends JPanel implements MouseListener {

    private GamePanel gp;
    private Image Sun;

    private int X;
    private int Y;
    private int Y2;
    private int sunTime;

    public Sun(GamePanel parent, int FirstX, int FirstY,int endY) {
        this.Sun = new ImageIcon(this.getClass().getResource("image/sun.gif")).getImage();
        this.gp = parent;
        setX(FirstX);
        setY2(endY);
        setSunTime(150);

        setSize(50, 50);
        setOpaque(false);

        setX(FirstX);
        setY(FirstY);
        setLocation(X,Y);
        addMouseListener(this);
    }

    @Override
    public int getX() {
        return X;
    }

    @Override
    public int getY() {
        return Y;
    }

    public int getY2() {
        return Y2;
    }

    public void setX(int x) {
        X = x;
    }

    public void setY(int y) {
        Y = y;
    }

    public void setY2(int y2) {
        Y2 = y2;
    }

    public void move() {
//        while (true){
            if (Y < Y2) {
                Y += 4;
            }
            setLocation(X,Y);
//        }
    }

    public void setSun(Image sun) {
        Sun = sun;
    }

    public int getSunTime() {
        return sunTime;
    }

    public void setSunTime(int sunTime) {
        this.sunTime = sunTime;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Sun, 0, 0, null);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        gp.setSunScore(gp.getSunScore() + 25);
        gp.remove(this);
        gp.getSuns().remove(this);
    }
    @Override
    public void mouseEntered(MouseEvent e) { }
    @Override
    public void mouseExited(MouseEvent e) { }
    @Override
    public void mouseClicked(MouseEvent e) { }
    @Override
    public void mousePressed(MouseEvent e) { }
}
