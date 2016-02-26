/**
 * Created by jakesnyder-hansen on 2/26/16.
 */

import javax.swing.*;

public class BattleshipButton extends JButton {
    private int xloc;
    private int yloc;
    private int health;
    private String w;
    private String type;

    public BattleshipButton(int x, int y, String w, String type){
        super(w);
        xloc = x;
        yloc = y;
        this.type = type;
    }
    public BattleshipButton(int x, int y, String w, String type, int health){
        super(w);
        xloc = x;
        yloc = y;
        this.health = health;
        this.type = type;
    }

    public String toString(){
        return "Type: " + type + " X: " + this.getXloc() + " Y: " + this.getYloc();
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getXloc() {
        return xloc;
    }
    public void setXloc(int xloc) {
        this.xloc = xloc;
    }

    public int getYloc() {
        return yloc;
    }

    public void setYloc(int yloc) {
        this.yloc = yloc;
    }
}
