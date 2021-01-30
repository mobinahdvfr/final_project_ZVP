import java.awt.*;

public class Game  {

    long startTime;

    boolean isNormal;
    int whichPart = 0;
    int part1 = 150;
    int[] part1Zombies = {1,30};
    int part2 = 180;
    int[] part2Zombies = {2,30};
    int part3 = 150;
    int[] part3Zombies = {2,25};
    int skySunSpeed;
    int flowerSunSpeed;
    double normalZombieSpeed;
    double coneHeadZombieSpeed;
    double bucketHeadZombieSpeed;
    int normalZombieHarm;
    int coneHeadZombieHarm;
    int bucketHeadZombieHarm;

    public Game (boolean isNormal){
        this.isNormal = isNormal;
        setConstants();


    }

    private void setConstants (){
        normalZombieSpeed = 4;
        normalZombieHarm = 5;
        if (isNormal){
            skySunSpeed = 25;
            flowerSunSpeed = 20;
            coneHeadZombieSpeed = 3.5;
            bucketHeadZombieSpeed = 3.5;
            coneHeadZombieHarm = 10;
            bucketHeadZombieHarm = 20;
        } else {
            skySunSpeed = 30;
            flowerSunSpeed = 25;
            coneHeadZombieSpeed = 3;
            bucketHeadZombieSpeed = 3;
            coneHeadZombieHarm = 15;
            bucketHeadZombieHarm = 25;
        }
    }

    public boolean isGameOver (){
        return false;
    }

}
