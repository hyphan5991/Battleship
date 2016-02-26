/**
 * Created by jakesnyder-hansen on 2/25/16.
 */
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class BoardFrame extends JFrame {
    private JFrame board;
    private JButton[][] buttonarray;

    public BoardFrame(int x, ButtonArray[][] b) {
        board = new JFrame("BattleShip");
        board.setSize(800, 800);
        board.setResizable(true);
        board.setLayout(new GridLayout(x, x));
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                buttonarray[i][j] = new BattleshipButton(j, i, "W", null);
                buttonarray[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        BattleshipButton button = (BattleshipButton) e.getSource();
                        button.setText("Miss");
                    }
                });
            }
        }
    }
    public void Display() {
        for (int i = 0; i < buttonarray.length; i++) {
            for (int j = 0; j < buttonarray[i].length; j++) {
                System.out.println(buttonarray[i][j]);
            }
        }
    }

    public JButton[][] getButtonarray() {
        return buttonarray;
    }

    public void setButtonarray(JButton a, int x, int y) {
        this.buttonarray[y][x] = a;
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
