/**
 * Created by jakesnyder-hansen on 3/1/16.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScoreBoard extends JFrame{
    public static JFrame scoreboard;
    public static JLabel turns;
    public static JLabel ships;
    public static JLabel highScore;
    public static JButton newGame;
    public static JButton replay;
    public static JButton quit;
    public static int highScore1;
    public String highScore2;

    public ScoreBoard(){
        scoreboard = new JFrame("Scoreboard");
        scoreboard.setBounds(1000,0,200,175);
        scoreboard.setResizable(true);
        scoreboard.setLayout(new FlowLayout());
        turns = new JLabel("Turncount = 0");
        ships = new JLabel("Ships " + (BoardArray.num - (BattleShip.gethitvalue() / 3)));
        highScore2 = "High Score Not Set";
        highScore1 = 1000000;
        highScore = new JLabel(highScore2);
        newGame = new JButton("New Game");
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scoreboard.dispose();
                FirstFrame firstFrame = new FirstFrame();
                firstFrame.showfirstframe();
                BattleShip.setHitvalue(0);
            }
        });
        quit = new JButton("quit");
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        replay = new JButton("Replay");
        replay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BattleShip.setHitvalue(0);
                if (BattleShip.getturns() < highScore1){
                    highScore1 = BattleShip.getturns();
                    highScore.setText("High Score: " + String.valueOf(highScore1));
                }
                BattleShip.setTurns(0);
                BoardFrame board = new BoardFrame();
                BoardArray x = new BoardArray(FirstFrame.inittextx,FirstFrame.inittexty);
                ships.setText("Ships " + (BoardArray.num - (BattleShip.gethitvalue() / 3)));
                turns.setText("Turncount = 0");
                board.makeBoard(FirstFrame.inittextx, FirstFrame.inittexty, x);
                if (FirstFrame.test == true){
                    System.out.print("\n");
                    for (int i = 0; i < BoardArray.getBoardArray().length; i++) {
                        for (int j = 0; j < BoardArray.getBoardArray()[i].length; j++) {
                            System.out.print(BoardArray.getBoardArray()[i][j] + " ");
                        }
                        System.out.print("\n");
                    }
                }

            }
        });
        scoreboard.add(turns);
        scoreboard.add(ships);
        scoreboard.add(highScore);
        scoreboard.add(newGame);
        scoreboard.add(replay);
        scoreboard.add(quit);
        scoreboard.setVisible(true);

    }
}
