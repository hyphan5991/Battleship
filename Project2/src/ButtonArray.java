import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jakesnyder-hansen on 2/26/16.
 */
public class ButtonArray {
    private BattleshipButton[][] buttArray;

    public ButtonArray(int x, int y) {
        buttArray = new BattleshipButton[y - 1][x - 1];
        int max = x * y;
        int num;
        Ship[] shipArray;
        if (max <= 16){
            num = 1;
            shipArray = new Ship[1];
        } else if (max > 16 && max <= 36){
            num = 2;
            shipArray = new Ship[1];

        }

        for (int i = 0; i < buttArray.length; i++) {
            for (int j = 0; j < buttArray[i].length; j++) {
                buttArray[i][j] = new BattleshipButton(j, i, "W", null);
                buttArray[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        BattleshipButton button = (BattleshipButton) e.getSource();
                        button.setText("Miss");
                    }
                });
            }
        }

    }
}
