package ZVP;

import javax.swing.*;

public class Zombie {

    private int health;
    private double speed ;
    private int damage;
    private boolean alive;
    private GamePanel gamePanel;
    private int line;
    private int x;

    public Zombie(GamePanel g , int health , double speed , int damage , int l ){
        gamePanel = g;
        this.health = health;
        this.speed = speed;
        this.damage = damage;
        alive = true;
        line = l;
        x=1000;
    }

    public void move (){

    }

    public void eat (){

    }


    public int getX (){
        return x;
    }

    public void setHealth(int h){
        health = h ;
    }

    public int getHealth(){
        return health;
    }

    public void setSpeed(double s){
        speed = s ;
    }

    public double getSpeed(){
        return speed;
    }

    public void setAlive(boolean a){
        alive = a ;
    }

    public boolean getAlive(){
        return alive;
    }

    public void setDamage(int d){
        damage = d ;
    }

    public int getDamage(){
        return damage;
    }

    public int getLine (){
        return line;
    }
}
