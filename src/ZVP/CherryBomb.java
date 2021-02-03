package ZVP;

public class CherryBomb extends Plant {
    protected CherryBomb(int x, int y, GamePanel g) {

        super(70, 150,x, y,g);
    }

    public static int getPrice (){
        return 150;
    }
}
