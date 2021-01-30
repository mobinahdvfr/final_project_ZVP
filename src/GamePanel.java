import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class GamePanel extends JLayeredPane {

    private Image bgImage = new ImageIcon(this.getClass().getResource("images/mainBG.png")).getImage();

    private Image peashooterImage = new ImageIcon(this.getClass().getResource("images/Gifs/peashooter.gif")).getImage();
    private Image freezePeashooterImage = new ImageIcon(this.getClass().getResource("images/Gifs/freezepeashooter.gif")).getImage();
    private Image sunflowerImage = new ImageIcon(this.getClass().getResource("images/Gifs/sunflower.gif")).getImage();

    private Image peaImage = new ImageIcon(this.getClass().getResource("images/pea.png")).getImage();
    private Image freezePeaImage = new ImageIcon(this.getClass().getResource("images/freezepea.png")).getImage();

    private Image normalZombieImage = new ImageIcon(this.getClass().getResource("images/Gifs/zombie_normal.gif")).getImage();
    private Image coneHeadZombieImage = new ImageIcon(this.getClass().getResource("images/Gifs/coneheadzombie.gif")).getImage();
    private Image BucketHeadZombieImage = new ImageIcon(this.getClass().getResource("images/Gifs/bucketheadzombie.gif")).getImage();

    private ArrayList<ArrayList<Zombie>> laneZombies = new ArrayList<>();
    private ArrayList<ArrayList<Pea>> lanePeas = new ArrayList<>();
    private ArrayList<Sun> activeSuns = new ArrayList<>();

    private JPanel[] panels = new JPanel[45];



    public GamePanel (){
        for (int i = 0; i < 45; i++) {
            JPanel a = new JPanel();
            a.setLocation(44 + (i % 9) * 100, 109 + (i / 9) * 120);
            //a.setAction(new PlantActionListener((i % 9), (i / 9)));
            panels[i] = a;
            add(a, 0);
        }
    }





}
