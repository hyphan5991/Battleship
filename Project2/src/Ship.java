/**
 * Created by jakesnyder-hansen on 2/25/16.
 */
import java.util.Random;

public class Ship extends Pieces {
    private int xpos;
    private int ypos;
    private int length;
    private int orient;
    private int health;

    public Ship(int health, int length, int x){
        this.health = health;
        this.length = length;
        Random rand = new Random();
        xpos = rand.nextInt(x - 1);
        ypos = rand.nextInt(x - 1);
        this.orient = check(x);

    }

    public int check(int x){
        Random rand = new Random();
        int max = x - 1;
        int[] orient = new int[4];
        int orientation = -1;

        if (this.ypos + this.length < max){
            orient[0] = -1;
        }
        else {
            orient[0] = -1;
        }
        if (this.ypos - this.length > 0){
            orient[1] = 180;
        }
        else {
            orient[1] = -1;
        }
        if (this.xpos + this.length < max) {
            orient[2] = 90;
        }
        else {
            orient[2] = -1;
        }
        if (this.xpos - length > 0){
            orient[3] = 270;
        }
        else {
            orient[3] = -1;
        }

        while (orientation == -1){
            int index = rand.nextInt(3);
            orientation = orient[index];
        }

        return orientation;
    }
    System.out.println("hello")
}
