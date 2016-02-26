/**
 * Created by jakesnyder-hansen on 2/25/16.
 */

import java.util.Random;

public class Mines {


    private int health;
    private int[] location;

    public Mines(int x){
        health = 1;
        Random number = new Random();
        int xpos = number.nextInt(x);
        int ypos = number.nextInt(x);
        int[] location = new int[2];
        location[0] = xpos;
        location[1] = ypos;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
