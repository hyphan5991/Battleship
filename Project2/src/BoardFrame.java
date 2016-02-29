import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BoardFrame extends JFrame {
    public static JFrame board;
    public static int xLoc = 0;
    public static int yLoc = 0;
    public static int[][] boardArray;

    public static JFrame makeBoard(JFrame board, int x, int y) {
        boardArray = new int[x * y][2];
        board = new JFrame("BattleShip");
        board.setBounds(0, 0, 800, 800);
        board.setResizable(false);
        board.setDefaultCloseOperation(BoardFrame.EXIT_ON_CLOSE);
        board.setLayout(new GridLayout(x, y, 0, 0));
        for (int i = 0; i < x * y; i++){
            JButton norm = new JButton("w");
            norm.setPreferredSize(new Dimension(50, 50));
            norm.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton button = (JButton) e.getSource();
                    xLoc = button.getX();
                    yLoc = button.getY();
                    System.out.println(xLoc);
                    System.out.println(yLoc);
                    button.setEnabled(false);
                }
            });
        board.add(norm);
//        boardArray[i] = new int[]{norm.getX(), norm.getY()};
        }
        board.setVisible(true);

        return board;
    }


    public static void main(String[] args) {
        makeBoard(board, 6, 6);
        for (int i =0; i < boardArray.length; i++) {
            for (int j = 0; j < boardArray[i].length; j++) {
                System.out.println(boardArray[i][j]);
            }
        }


//        ShipArray tmp = new ShipArray(5, 5);
//        ButtonArray tmp1 = new ButtonArray(5, 5, tmp);
//        BoardFrame board1 = new BoardFrame(5, 5, tmp1);
//
////        mines1.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                BattleshipButton button = (BattleshipButton) e.getSource();
//                button.setText("mine");
//            }
//        });
//        board1.setButtonarray(ship1, ship1.getXloc(), ship1.getYloc());
//        board1.setButtonarray(mines1, ship1.getXloc(), ship1.getYloc());
//
//        for (int i = 0; i < board1.getButtonarray().length; i++) {
//            for (int j = 0; j < board1.getButtonarray()[i].length; j++) {
//                board1.add(board1.getButtonarray()[i][j]);
//                board1.getButtonarray()[i][j].setVisible(true);
//                board1.setVisible(true);
//            }
//        }
//
//    }
//}
    }
}

