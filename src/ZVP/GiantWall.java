package ZVP;

public class GiantWall extends Plant{
    public GiantWall(int x, int y, GamePanel g) {
        super(150,50,x,y,g);
    }

    public static int getPrice (){
        return 50;
    }
}
