/**
 * Created by jakesnyder-hansen on 2/25/16.
 */

import java.util.Random;

public class Mines extends BattleshipButton{


    public Mines(int x, int y){
        super(findX(x), findY(y), "w", "mine", 1);
    }

    public static int findX(int x){
        Random rand = new Random();
        return rand.nextInt(x - 1);
    }
    public static int findY(int x){
        Random rand = new Random();
        return rand.nextInt(x - 1);
    }
}
