import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BoardFrame extends JFrame {
    public static JFrame board;
    public static int xLoc = 0;
    public static int yLoc = 0;
    public static int[][] buttonArray;



    public static JFrame makeBoard(int x, int y, BoardArray theboardArray) {
        final int [][]boardArray = theboardArray.getBOARDARRAY();
        board = new JFrame("BattleShip");
        board.setBounds(0, 0, 800, 800);
        board.setResizable(true);
        board.setDefaultCloseOperation(BoardFrame.EXIT_ON_CLOSE);
        board.setLayout(new GridLayout(y,x,0,0));
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
                        if(boardArray[yLoc][xLoc]==3){
                            BattleShip.turnchange();
                            BattleShip.turnchange();
                            if(button.getText().contains("button has \n already been hit")){}
                            else button.setText(button.getText()+" button has \n already been hit");

                        }
                        if(boardArray[yLoc][xLoc]== 1){
                            button.setText("hit");
                            BattleShip.turnchange();
                            BattleShip.shiphit();
                            boardArray[yLoc][xLoc] = 3;
                            ScoreBoard.ships.setText(("Ships " + (BoardArray.num - (BattleShip.gethitvalue() / 3))));
                            if(BoardArray.shipNumber == BattleShip.gethitvalue()){
                                board.setVisible(false);
                                if (BattleShip.getturns() < ScoreBoard.highScore1){
                                    ScoreBoard.highScore1 = BattleShip.getturns();
                                    ScoreBoard.highScore.setText("High Score: " + String.valueOf(ScoreBoard.highScore1));
                                }
                            }
                        }
                        if(boardArray[yLoc][xLoc]==2){
                            button.setText("And Boom Goes the Dynamite \n Lose 1 Turn");
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
                            if (i - 1 == 1){
                                button.setText("Miss Very Close");
                            }
                            else if(i - 1 == 2){
                                button.setText("Miss Kinda Close");
                            }
                            else if(i - 1 > 2){
                                button.setText("Miss Very Far");
                            }

                            boardArray[yLoc][xLoc] = 3;
                            BattleShip.turnchange();
                        }
                        ScoreBoard.turns.setText("Turncount="+ String.valueOf(BattleShip.getturns()));
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
