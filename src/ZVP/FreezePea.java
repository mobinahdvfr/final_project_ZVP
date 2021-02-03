package ZVP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FreezePea extends Bullet {



    public FreezePea (GamePanel gamePanel, int x, int row){
        super(gamePanel,x,row,35);
        ImageMaker imageMaker = new ImageMaker();
        super.setImage(imageMaker.getFreezePeaImage());
    }

    public Zombie attack (){
        Zombie z = super.attack();
        if (z != null) {
            //z.setSpeed(getSpeed()/2);
        }
        return null;
    }



}
