/**
 * Created by jakesnyder-hansen on 2/25/16.
 */
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class BoardFrame extends JFrame {
    private JFrame board;

    public BoardFrame(int x, int y, ButtonArray[][] b) {
        board = new JFrame("BattleShip");
        board.setSize(800, 800);
        board.setResizable(true);
        board.setLayout(new GridLayout(x, y));
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                board.add(b[i][j]);
            }
        }
    }

    

    public static void main(String[] args) {
        BoardFrame board1 = new BoardFrame(3);
        Ship ship1 = new Ship(3);
        Mines mines1 = new Mines(3);
        ship1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BattleshipButton button = (BattleshipButton) e.getSource();
                button.setText("Ship");
            }
        });
        mines1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BattleshipButton button = (BattleshipButton) e.getSource();
                button.setText("mine");
            }
        });
        board1.setButtonarray(ship1, ship1.getXloc(), ship1.getYloc());
        board1.setButtonarray(mines1, ship1.getXloc(), ship1.getYloc());

        for (int i = 0; i < board1.getButtonarray().length; i++) {
            for (int j = 0; j < board1.getButtonarray()[i].length; j++) {
                board1.add(board1.getButtonarray()[i][j]);
                board1.getButtonarray()[i][j].setVisible(true);
                board1.setVisible(true);
            }
        }

    }
}
