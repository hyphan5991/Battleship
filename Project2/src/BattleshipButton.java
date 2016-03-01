/**
 * Created by jakesnyder-hansen on 2/26/16.
 */

import javax.swing.*;

public class BattleshipButton extends JButton {
    private int xLoc;
    private int yLoc;

    public BattleshipButton(String w, int x, int y){
        super(w);
        xLoc = x;
        yLoc = y;
    }

    public int getxLoc() {
        return xLoc;
    }

    public void setxLoc(int xLoc) {
        this.xLoc = xLoc;
    }

    public int getyLoc() {
        return yLoc;
    }

    public void setyLoc(int yLoc) {
        this.yLoc = yLoc;
    }

}
