import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.basic.DefaultMenuLayout;

public class FirstFrame extends JFrame {
    private JFrame initframe;
    private JLabel message;
    private JPanel buttonpanel;
    public static int inittextx;
    public static int inittexty;
    public JTextField fieldx;
    public JTextField fieldy;
    public static boolean test;

    public FirstFrame(){
        prepareGUI();
    }
    public static void main(String[] args){
        FirstFrame firstFrame = new FirstFrame();
        firstFrame.showfirstframe();
    }
    public void prepareGUI(){
        initframe = new JFrame("Initial Frame");
        initframe.setSize(550,150);
        initframe.setResizable(true);
        initframe.setLayout(new FlowLayout());
        message = new JLabel("", JLabel.CENTER);
        buttonpanel = new JPanel();
        buttonpanel.setLayout(new FlowLayout());
        initframe.add(message);
        initframe.add(buttonpanel);
        fieldx = new JTextField(10);
        fieldy = new JTextField(10);
        initframe.add(fieldx, BorderLayout.EAST);
        initframe.add(fieldy, BorderLayout.WEST);
        initframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
    public void showfirstframe(){
        message.setText("Type height dimensions on the left, width on the right and hit submit");
        JButton submitbutton = new JButton("submit");
        JButton submitTestmode = new JButton("submit w/ Test");
        submitbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inittextx = Integer.parseInt(fieldx.getText());
                inittexty = Integer.parseInt(fieldy.getText());
                if((inittextx>2&&inittextx<11)&&(inittexty>2&&inittexty<11)) {
                    BoardFrame board = new BoardFrame();
                    BoardArray x = new BoardArray(inittextx, inittexty);
                    board.makeBoard(inittextx, inittexty, x);
                    ScoreBoard scoreBoard = new ScoreBoard();
                    initframe.dispose();
                }
            }
        });
        submitTestmode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FirstFrame.test = true;
                inittextx = Integer.parseInt(fieldx.getText());
                inittexty = Integer.parseInt(fieldy.getText());
                if((inittextx>2&&inittextx<11)&&(inittexty>2&&inittexty<11)) {
                    BoardFrame board = new BoardFrame();
                    BoardArray x = new BoardArray(inittextx, inittexty);
                    board.makeBoard(inittextx, inittexty, x);
                    ScoreBoard scoreBoard = new ScoreBoard();
                    initframe.dispose();
                    for (int i = 0; i < BoardArray.getBoardArray().length; i++) {
                        for (int j = 0; j < BoardArray.getBoardArray()[i].length; j++) {
                            System.out.print(BoardArray.getBoardArray()[i][j] + " ");
                        }
                        System.out.print("\n");
                    }
                }
            }
        });
        buttonpanel.add(submitbutton);
        buttonpanel.add(submitTestmode);
        initframe.setVisible(true);

    }
}
