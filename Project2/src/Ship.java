/**
 * Created by jakesnyder-hansen on 2/25/16.
 */
import java.util.Random;

public class Ship {
    private int[] strLoc;
    private int length;
    private int orient;
    private int health;

    public Ship(int health, int length, int x){
        this.health = health;
        Random rand = new Random();
        int xpos = rand.nextInt(x);
        int ypos = rand.nextInt(x);
        strLoc = new int[2];
        strLoc[0] = xpos;
        strLoc[1] = ypos;

    }

    public int check(int x, int length, int[] loc){


    }
}
