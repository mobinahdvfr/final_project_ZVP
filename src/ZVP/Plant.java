package ZVP;

public class Plant {

    private int health;
    private static int price;
    private int x;
    private int y;
    private int row;
    private boolean alive;
    private GamePanel gamePanel;

    protected Plant(int h, int p, int x, int row, GamePanel g){
        health = h ;
        price = p ;
        this.x = x;
        this.row = row;
        alive = true;
        gamePanel = g;

    }

    public void setHealth(int h){
        health = h ;
    }
    public static void setPrice(int p){
        price = p ;
    }
    public void setAlive(boolean a){
        alive = a ;
    }
    public boolean getAlive(){
        return alive;
    }
    public int getHealth(){
        return health;
    }

    public static int getPrice(){
        return price;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
}
