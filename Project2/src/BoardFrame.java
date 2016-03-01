import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BoardFrame extends JFrame {
    public static JFrame board;
    public static int xLoc = 0;
    public static int yLoc = 0;
//    public static int[][] boardArray;
    static int[][]boardArray = {{1,0,0},{0,1,1},{0,0,2},{1,2,0},{0,0,0}};

    public static JFrame makeBoard(JFrame board, int x, int y) {
//        boardArray = new int[x * y][2];
        board = new JFrame("BattleShip");
        board.setBounds(0, 0, 800, 800);
        board.setResizable(false);
        board.setDefaultCloseOperation(BoardFrame.EXIT_ON_CLOSE);
        board.setLayout(new GridLayout(x,y,0,0));
        for (int i = 0; i < x * y; i++){
            JButton norm = new JButton("w");
            norm.setPreferredSize(new Dimension(50, 50));
            norm.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton button = (JButton) e.getSource();
                    xLoc = button.getX();
                    yLoc = button.getY();
                    int x = 800/(805-xLoc);
                    int y = 800/(805-yLoc);
                    System.out.println(x);
                    System.out.println(xLoc);
                    System.out.println(y);
                    System.out.println(yLoc);
                    System.out.println(boardArray[y][x]);
                    System.out.println("_");
                    System.out.println(BattleShip.getturns());
                    if(boardArray[y][x]== 1){
                        button.setText("hit");
                        BattleShip.turnchange();
                        BattleShip.shiphit();
                    }
                    if(boardArray[y][x]==2){
                        button.setText("KABOOM mine hit,loose 1 turn");
                        BattleShip.turnchange();
                        BattleShip.turnchange();
                    }
                    if(boardArray[y][x] == 0){
                        Boolean cont = true;
                        int i = 1;
                        while(cont== true){
                            if( y+i < boardArray.length && boardArray[y+i][x]==1){
                                cont =false;
                        }
                           else if(y-i > -1 && boardArray[y-i][x]==1 ){
                               cont = false;
                           }
                           else if( x+1< boardArray[y].length && boardArray[y][x+i]==1 ){
                               cont=false;
                           }
                           else if( x-i > -1 && boardArray[y][x-i]==1 ){
                               cont = false;
                           }
                           else i++;
                        }
                        button.setText(String.valueOf(i));
                    }




            }
            });
            board.add(norm);
//        boardArray[i] = new int[]{norm.getX(), norm.getY()};
        }
        board.setVisible(true);

        return board;
    }




    }
