import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BoardFrame extends JFrame {
    public static JFrame board;
    public static int xLoc = 0;
    public static int yLoc = 0;
    public static int[][] buttonArray;
    public static JFrame scoreboard;
    public static JLabel turns;


    public static JFrame makeBoard(JFrame board, int x, int y, BoardArray theboardArray) {
        final int [][]boardArray = theboardArray.getBOARDARRAY();
        board = new JFrame("BattleShip");
        scoreboard = new JFrame("Scoreboard");
        scoreboard.setBounds(1000,0,400,400);
        scoreboard.setLayout(new FlowLayout());
        scoreboard.setVisible(true);
        turns = new JLabel("Turncount = 0");
        scoreboard.add(turns);
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
                        xLoc = button.getxLoc();
                        yLoc = button.getyLoc();
                        System.out.println(xLoc);
                        System.out.println(yLoc);
                        System.out.println(boardArray[yLoc][xLoc]);
                        System.out.println("_");
                        System.out.println(BattleShip.getturns());
                        if(boardArray[yLoc][xLoc]==3){
                            BattleShip.turnchange();
                            BattleShip.turnchange();
                        if(button.getText().contains("button has already been hit")){}
                        else button.setText(button.getText()+" button has already been hit");

                        }
                        if(boardArray[yLoc][xLoc]== 1){
                            button.setText("hit");
                            BattleShip.turnchange();
                            BattleShip.shiphit();
                            boardArray[yLoc][xLoc] = 3;
                        }
                        if(boardArray[yLoc][xLoc]==2){
                            button.setText("KABOOM mine hit,lose 1 turn");
                            BattleShip.turnchange();
                            BattleShip.turnchange();
                            boardArray[yLoc][xLoc] = 3;
                        }
                        if(boardArray[yLoc][xLoc] == 0){
                            boolean cont = true;
                            int i = 0;
                            int maxX = boardArray[0].length;
                            int maxY = boardArray.length;
                            while(cont == true){
                                if (i < maxX || i < maxY) {
                                    try {
                                        if (yLoc + i < boardArray.length && boardArray[yLoc + i][xLoc] == 1) {
                                            cont = false;
                                        }
                                    } catch (ArrayIndexOutOfBoundsException t) {
                                        cont = false;
                                    } catch (IndexOutOfBoundsException b) {
                                        cont = false;
                                    }
                                    try {
                                        if (yLoc - i > -1 && boardArray[yLoc - i][xLoc] == 1) {
                                            cont = false;
                                        }
                                    } catch (ArrayIndexOutOfBoundsException t) {
                                        cont = false;
                                    } catch (IndexOutOfBoundsException b) {
                                        cont = false;
                                    }
                                    try {
                                        if (xLoc + i < boardArray[yLoc].length && boardArray[yLoc][xLoc + i] == 1) {
                                            cont = false;
                                        }
                                    } catch (ArrayIndexOutOfBoundsException t) {
                                        cont = false;
                                    } catch (IndexOutOfBoundsException b) {
                                        cont = false;
                                    }
                                    try {
                                        if (xLoc - i > -1 && boardArray[yLoc][xLoc - i] == 1) {
                                            cont = false;
                                        }
                                    } catch (ArrayIndexOutOfBoundsException t) {
                                        cont = false;
                                    } catch (IndexOutOfBoundsException b) {
                                        cont = false;
                                    }

                                    i++;
                                }
                                else{
                                    cont = false;
                                }
                            }
                            button.setText(String.valueOf(i - 1));
                            boardArray[yLoc][xLoc] = 3;
                            BattleShip.turnchange();
                        }
                    turns.setText("Turncount="+ String.valueOf(BattleShip.getturns()));
                    }
                });
                board.add(norm);
                buttonArray[id][0] = j;
                buttonArray[id][1] = i;
//        boardArray[i] = new int[]{norm.getX(), norm.getY()};
            }
        }
        board.setVisible(true);

        return board;
    }




}
