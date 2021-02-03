package ZVP;

public class BucketHeadZombie extends Zombie{

    protected BucketHeadZombie(GamePanel g , int l) {
        super(g, 200+1100 , (g.isNormal()?3.5:3),(g.isNormal()?20:25) , l);
    }
}
