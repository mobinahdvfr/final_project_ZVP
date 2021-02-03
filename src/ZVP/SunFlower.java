package ZVP;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class SunFlower extends Plant {

    private Timer MakeSun;

    public SunFlower(int x, int row, GamePanel g) {
        super(50,50, x , row , g);
        MakeSun = new Timer(/*(g.isNormal()?20000:25000)*/4000, (ActionEvent e) -> {
            Sun sta = new Sun(g, 60 + x * 100, 110 + row * 120, 130 + row * 120);
            g.getSuns().add(sta);
            g.add(sta, new Integer(1));
        });
        MakeSun.start();
    }

    public static int getPrice (){
        return 50;
    }
}
