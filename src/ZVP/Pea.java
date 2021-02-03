package ZVP;

public class Pea extends Bullet{

    public Pea (GamePanel gamePanel, int x, int row){
        super(gamePanel,x,row,30);
    }

    public Zombie attack (){
        Zombie z = super.attack();
        if (z != null) {
            //z.setSpeed(getSpeed()/2);
        }
        return null;
    }

}
