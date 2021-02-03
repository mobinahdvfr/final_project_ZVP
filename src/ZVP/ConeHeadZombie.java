package ZVP;

public class ConeHeadZombie extends Zombie {

    protected ConeHeadZombie(GamePanel g , int l) {
        super(g, 200+360 , (g.isNormal()?3.5:3),(g.isNormal()?10:15) , l);
    }
}
