import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BoardFrame extends JFrame {
    public static JFrame board;
    public static int xLoc = 0;
    public static int yLoc = 0;
    public static int[][] buttonArray;

    public static JFrame makeBoard(JFrame board, int x, int y, BoardArray theboardArray) {
        final int [][]boardArray = theboardArray.getBOARDARRAY();
        board = new JFrame("BattleShip");
        board.setBounds(0, 0, 800, 800);
        board.setResizable(true);
        board.setDefaultCloseOperation(BoardFrame.EXIT_ON_CLOSE);
        board.setLayout(new GridLayout(x,y,0,0));
        buttonArray = new int[y*x][2];
        int id = 0;
        for (int i = 0; i < y; i++){
            for (int j = 0; j <x; j++){
            BattleshipButton norm = new BattleshipButton("w", j, i);
            norm.setPreferredSize(new Dimension(50, 50));
            norm.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    BattleshipButton button = (BattleshipButton) e.getSource();
                    xLoc = button.getXLoc();
                    yLoc = button.getYLoc();
                    System.out.println(xLoc);
                    System.out.println(yLoc);
                    System.out.println(boardArray[y][x]);
                    System.out.println("_");
                    System.out.println(BattleShip.getturns());
                    if(boardArray[y][x]==3){
                        BattleShip.turnchange();
                        BattleShip.turnchange();
                        button.setText("ya this shit works yo");
                    }
                    if(boardArray[y][x]== 1){
                        button.setText("hit");
                        BattleShip.turnchange();
                        BattleShip.shiphit();
                        boardArray[y][x] = 3;
                    }
                    if(boardArray[y][x]==2){
                        button.setText("KABOOM mine hit,loose 1 turn");
                        BattleShip.turnchange();
                        BattleShip.turnchange();
                        boardArray[y][x] = 3;
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
                        boardArray[y][x] = 3;
                    }
            }
            });
            board.add(norm);
            buttonArrary[id][0] = j;
            buttonArrary[id][1] = i;
//        boardArray[i] = new int[]{norm.getX(), norm.getY()};
        }
    }
        board.setVisible(true);

        return board;
    }




    }
