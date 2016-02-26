**
 * Created by timroels on 2/25/16.
 */
public class Pieces {

    private int xlocation;
    private int ylocation;
    private int health;

    public int getXlocation() {
        return xlocation;
    }

    public void setXlocation(int xlocation) {
        this.xlocation = xlocation;
    }

    public int getYlocation() {
        return ylocation;
    }

    public void setYlocation(int ylocation) {
        this.ylocation = ylocation;
    }
    public int getHealth(){
        return health;
    }
    public void shiphit(){
        health -= 1;
    }
    public void setHealth(int x){
        health = x;
    }

}
