/**
 * Created by jakesnyder-hansen on 2/25/16.
 */
import java.util.Random;

public class Ship extends BattleshipButton{
    private int length;
    private int orient;
    private int[][] locs;

    public Ship(int x){
        super(findX(x), findY(x), "w", "ship", 3);
        length = 3;
        orient = check(this.getXloc(), this.getYloc());
        locs = new int[3][2];
        if (orient == 0){
            for (int i = 0; i < locs.length; i++){
                locs[i][0] = this.getXloc();
                locs[i][1] = this.getYloc() - i;
            }
        } else if (orient == 90){
            for (int i = 0; i < locs.length; i++){
                locs[i][0] = this.getXloc() + i;
                locs[i][1] = this.getYloc();
            }
        } else if (orient == 180){
            for (int i = 0; i < locs.length; i++){
                locs[i][0] = this.getXloc();
                locs[i][1] = this.getYloc() + i;
            }
        } else if (orient == 270){
            for (int i = 0; i < locs.length; i++){
                locs[i][0] = this.getXloc() - i;
                locs[i][1] = this.getYloc();
            }
        }
    }

    public static int findX(int x){
        Random rand = new Random();
        return rand.nextInt(x - 1);
    }
    public static int findY(int x){
        Random rand = new Random();
        return rand.nextInt(x - 1);
    }

    public int check(int x, int y){
        Random rand = new Random();
        int maxX = x - 1;
        int maxY = y - 1;
        int[] orient = new int[4];
        int orientation = -1;

        if (this.getYloc() + this.length <= maxY){
            orient[0] = -1;
        }
        else {
            orient[0] = -1;
        }
        if (this.getYloc() - this.length > 0){
            orient[1] = 180;
        }
        else {
            orient[1] = -1;
        }
        if (this.getXloc() + this.length <= maxX) {
            orient[2] = 90;
        }
        else {
            orient[2] = -1;
        }
        if (this.getXloc() - length > 0){
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

    public int[][] getLocs() {
        return locs;
    }

}
