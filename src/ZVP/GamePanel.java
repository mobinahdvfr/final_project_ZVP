package ZVP;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;

public class GamePanel extends JLayeredPane implements MouseMotionListener {

    private boolean isNormal;

    private int sunScore;
    private JLabel sun;
    private Timer MakeSun;
    private Random random;

    private Timer moves;
    private Timer sunMovingTimer;
    private Timer redrawTimer;
    private Timer sunProducer;

    ImageMaker im;
    PlantCardsPanel cards;

    private PlantPanel[][] plantPanels = new PlantPanel[9][5];
    private ArrayList<Zombie> [] rowsZombies = new ArrayList[5];
    private ArrayList<Bullet> [] rowsPeas = new ArrayList[5];
    private ArrayList<Sun> suns = new ArrayList<>();
    Mower[] mowers;

    public GamePanel(boolean isNormal){
        this.isNormal = isNormal;
        im = new ImageMaker();
        random = new Random();
        setSize(1000, 752);
        setLayout(null);
        repaint();
        setCards();
        setPlantPanels();

        for (int i = 0 ; i<5 ; i++){
            rowsZombies[i] = new ArrayList<>();
            rowsPeas[i] = new ArrayList<>();
        }


        mowers = new Mower[5];
        for (int i=0; i<5 ; i++){
            Mower mower = new Mower(this,i);
            mower.setLocation(0,150 + i * 120);
            mowers[i] = mower;
            add(mower,0);
        }


        //////////////////////////////////////////////////////////////
        sun = new JLabel("Sun : " ) ;
        sun.setLocation(37, 80);
        sun.setSize(60, 20);
        setSunScore(1000);
        sun.setLocation(32,80);
        this.add(sun);

        MakeSun= new Timer((isNormal?25000:30000), (ActionEvent e) -> {
            Sun sta = new Sun(this, random.nextInt(850)+100 , 0, random.nextInt(600)+100);
            suns.add(sta);
            add(sta, new Integer(1));
        });
        MakeSun.start();
        //////////////////////////////////////////////////////////////
        moves = new Timer(60, (ActionEvent e) -> {
            sunMove();
            peasMove();
        });
        moves.start();

        redrawTimer = new Timer(60, (ActionEvent e) -> {
           repaint();
        });
        redrawTimer.start();

    }

    public boolean isNormal (){
        return isNormal;
    }

    private void setPlantPanels (){
        for (int i = 0; i < 9; i++) {
            for (int j = 0 ; j<5 ; j++) {
                PlantPanel a = new PlantPanel();
                a.setLocation(44 + i * 100, 109 + j * 120);
                //a.setAction(new PlantActionListener((i % 9), (i / 9)));
                int finalI = i;
                int finalJ = j;
                a.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        paintPlant(finalI, finalJ);
                    }
                });
                plantPanels[i][j] = a;
                add(a, 0);
            }
        }
    }

    private void setCards (){
        cards = new PlantCardsPanel();
        cards.setLocation(100,8);
        add(cards,0);
    }

    public ArrayList<Zombie> getRowZombies (int row){
        return rowsZombies[row-1];
    }

    public ArrayList<Bullet> getRowPeas (int row){
        return rowsPeas[row-1];
    }

    public void setSunScore(int sunScore) {
        this.sunScore = sunScore;
        sun.setText("Suns : " + sunScore);
    }

    public int getSunScore(){
        return sunScore;
    }

    public ArrayList<Sun> getSuns (){
        return suns;
    }

//    public void setActivePlantingBrush(PlantType activePlantingBrush) {
//        this.activePlantingBrush = activePlantingBrush;
//    }

    public void paintPlant (int x, int y){

        switch (cards.getWhichCard()){
            case 1:
                if (getSunScore() >= SunFlower.getPrice()) {
                    plantPanels[x][y].setPlant(new SunFlower(x, y, this));
                    setSunScore(getSunScore() - SunFlower.getPrice());
                }
                break;
            case 2:
                if (getSunScore() >= PeaShooter.getPrice()){
                    plantPanels[x][y].setPlant(new PeaShooter(x,y,this));
                    setSunScore(getSunScore() - PeaShooter.getPrice());
                }
                break;
            case 3:
                if (getSunScore() >= FreezePeaShooter.getPrice()){
                    plantPanels[x][y].setPlant(new FreezePeaShooter(x,y,this));
                    setSunScore(getSunScore() - FreezePeaShooter.getPrice());
                }
                break;
            case 4:
                if (getSunScore() >= GiantWall.getPrice()) {
                    plantPanels[x][y].setPlant(new GiantWall(x, y, this));
                    setSunScore(getSunScore() - GiantWall.getPrice());
                }
                break;
            case 5:
                if (getSunScore() >= CherryBomb.getPrice()){
                    plantPanels[x][y].setPlant(new CherryBomb(x,y,this));
                    setSunScore(getSunScore() - CherryBomb.getPrice());
                }
                break;
        }
        plantPanels[x][y].repaint();
        cards.resetWhichCard();
    }

    @Override
    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
        g.drawImage(im.getBackgroundImage(), 0, 0, null);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 5; j++) {
                PlantPanel c = plantPanels[i][j];
                if (c.getPlant() != null) {
                    Plant p = c.getPlant();
                    if (p instanceof PeaShooter) {
                        g.drawImage(im.getPeashooterImage(), 60 + i * 100, 129 + j * 120, null);
                    } else if (p instanceof FreezePeaShooter) {
                        g.drawImage(im.getFreezePeashooterImage(), 60 + i * 100, 129 + j * 120, null);
                    } else if (p instanceof SunFlower) {
                        g.drawImage(im.getSunflowerImage(), 60 + i * 100, 129 + j * 120, null);
                    } else if (p instanceof GiantWall) {
                        g.drawImage(im.getGiantImage(), 60 + i * 100, 129 + j * 120, null);
                    } else if (p instanceof CherryBomb) {
                        g.drawImage(im.getCherryBombImage(), 60 + i * 100, 129 + j * 120, null);
                    }
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            for (Zombie z : rowsZombies[i]) {
                if (z instanceof NormalZombie) {
                    g.drawImage(im.getNormalZombieImage(), z.getX(), 109 + ((i+1) * 120), null);
                } else if (z instanceof ConeHeadZombie) {
                    g.drawImage(im.getConeHeadZombieImage(), z.getX(), 109 + ((i+1) * 120), null);
                } else if (z instanceof BucketHeadZombie) {
                    g.drawImage(im.getBucketHeadZombieImage(), z.getX(), 109 + ((i+1) * 120), null);
                }
            }

            for (Bullet b : rowsPeas[i]) {
                if (b instanceof FreezePea) {
                    g.drawImage(im.getFreezePeaImage(), b.getX()+65, 135 + ((i+1) * 120), null);
                } else {
                    g.drawImage(im.getPeaImage(), b.getX()+65, 135 + ((i+1) * 120), null);
                }
            }
        }


        for (int i=0; i<5 ; i++){
            Mower mower = mowers[i];
            if (mower.isEnable()){
                g.drawImage(mower.getImage(), mower.getX(), mower.getMapY(), null);
            }
        }
    }

    public void sunMove(){
        for (Sun value : suns) {
            value.move();
        }
    }

    public void peasMove (){
        for (int i = 0 ; i<5 ; i++){
            for (Bullet b : rowsPeas[i]){
                b.attack();
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) { }
    @Override
    public void mouseMoved(MouseEvent e) { }
}
