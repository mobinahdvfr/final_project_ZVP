package ZVP;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class FreezePeaShooter extends Plant {


    private Timer shootFreezePea;

    protected FreezePeaShooter(int x, int row, GamePanel g) {
        super(100, 175, x, row, g);
        shootFreezePea = new Timer(1000, (ActionEvent e) -> {
            FreezePea fp = new FreezePea(g, 60 + x * 100, row);
            g.getRowPeas(row).add(fp);
//            gamePanel.add(fp, new Integer(0));
        });
        shootFreezePea.start();
    }

    public static int getPrice (){
        return 175;
    }
}
