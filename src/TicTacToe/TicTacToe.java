package TicTacToe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import Observer.TicTacToeObserver;
import Observer.TictactoeGrabber;
import gamecenter.HomePage;
import gamecenter.Prototype;
import java.awt.Dimension;

/**
 *
 * @author kavanpatel
 */

public class TicTacToe implements ActionListener, Prototype,TicTacToeIF {

    JPanel tictactoeboardpanel;
    JPanel messagepanel;
    JPanel playerspanel;
    public static JPanel contentpane;
    public static JLabel scoreboard, playerTurn;
    JButton jb1, jb2, jb3, jb4, jb5, jb6, jb7, jb8, jb9;
    String b1, b2, b3, b4, b5, b6, b7, b8, b9;
    JFrame mainframe;
    TictactoeGrabber tictactoegrabber;
    TicTacToeObserver tictactoeoberver;
    int flag = 0, counter = 0;
    Color c;

    public TicTacToe() {              
    }

    @Override
    public void setUI(Color c)
    {
        initUI(c);
    }
    
    @Override
    public void initUI(Color c) {
        HomePage.pagestatus = 2;
        contentpane = new JPanel();
        tictactoeboardpanel = new JPanel();
        messagepanel = new JPanel();
        playerspanel = new JPanel();
        tictactoegrabber = new TictactoeGrabber();
        tictactoeoberver = new TicTacToeObserver(tictactoegrabber);
        mainframe = new JFrame();
        jb1 = new JButton("");
        jb2 = new JButton(" ");
        jb3 = new JButton("  ");
        jb4 = new JButton("   ");
        jb5 = new JButton("    ");
        jb6 = new JButton("     ");
        jb7 = new JButton("      ");
        jb8 = new JButton("       ");
        jb9 = new JButton("        ");

        playerTurn = new JLabel("P1's Turn!");
        scoreboard = new JLabel("Match Start");

        scoreboard.setHorizontalAlignment(SwingConstants.CENTER);
        scoreboard.setFont(new Font("Arial", Font.BOLD, 15));
        playerTurn.setHorizontalAlignment(SwingConstants.CENTER);
        playerTurn.setFont(new Font("Arial", Font.BOLD, 15));
        playerTurn.setBackground(Color.ORANGE);

        contentpane.setLayout(new BorderLayout());

        messagepanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        messagepanel.add(new JLabel("Tic-Tac-Toe"));
        messagepanel.setBackground(Color.ORANGE);

        tictactoeboardpanel.setLayout(new GridLayout(3, 3, 2, 2));
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
        jb4.addActionListener(this);
        jb5.addActionListener(this);
        jb6.addActionListener(this);
        jb7.addActionListener(this);
        jb8.addActionListener(this);
        jb9.addActionListener(this);
        tictactoeboardpanel.add(jb1);
        tictactoeboardpanel.add(jb2);
        tictactoeboardpanel.add(jb3);
        tictactoeboardpanel.add(jb4);
        tictactoeboardpanel.add(jb5);
        tictactoeboardpanel.add(jb6);
        tictactoeboardpanel.add(jb7);
        tictactoeboardpanel.add(jb8);
        tictactoeboardpanel.add(jb9);

        playerspanel.setLayout(new GridLayout(2, 1));

        playerspanel.add(playerTurn);
        playerspanel.add(scoreboard);

        outOfFocus();
        setAllBtnOpaq();
        setColorAllButton(c);
        contentpane.add(messagepanel, BorderLayout.NORTH);
        contentpane.add(tictactoeboardpanel, BorderLayout.CENTER);
        contentpane.add(playerspanel, BorderLayout.PAGE_END);
        contentpane.setPreferredSize(new Dimension(600, 600));
//        mainframe.setContentPane(contentpane);         
//        mainframe.setSize(333, 333);        
//        mainframe.setVisible(true);
//        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        mainframe.setTitle("Welcome");

    }

//    public static void main(String[] args) {
//        TicTacToe ttt=new TicTacToe();
//        ttt.initUI();
//        
//    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(jb1)) {
            setButtonText(jb1);
            checkLogic();
        } else if (e.getSource().equals(jb2)) {
            setButtonText(jb2);
            checkLogic();
        } else if (e.getSource().equals(jb3)) {
            setButtonText(jb3);
            checkLogic();
        } else if (e.getSource().equals(jb4)) {
            setButtonText(jb4);
            checkLogic();
        } else if (e.getSource().equals(jb5)) {
            setButtonText(jb5);
            checkLogic();
        } else if (e.getSource().equals(jb6)) {
            setButtonText(jb6);
            checkLogic();
        } else if (e.getSource().equals(jb7)) {
            setButtonText(jb7);
            checkLogic();
        } else if (e.getSource().equals(jb8)) {
            setButtonText(jb8);
            checkLogic();
        } else if (e.getSource().equals(jb9)) {
            setButtonText(jb9);
            checkLogic();
        }

    }

    @Override
    public void setButtonText(JButton b) {

        if (flag == 0) {
            b.setFont(new Font("Arial", Font.BOLD, 30));
            tictactoegrabber.setPlayerTurn("P2's Turn");
            b.setText("0");
            flag = 1;
        } else if (flag == 1) {
            b.setFont(new Font("Arial", Font.BOLD, 30));
            tictactoegrabber.setPlayerTurn("P1's Turn");
            b.setText("×");
            flag = 0;
        }
        b.setEnabled(false);
    }

    @Override
    public void checkLogic() {
        b1 = jb1.getText();
        b2 = jb2.getText();
        b3 = jb3.getText();
        b4 = jb4.getText();
        b5 = jb5.getText();
        b6 = jb6.getText();
        b7 = jb7.getText();
        b8 = jb8.getText();
        b9 = jb9.getText();
        counter++;

        if (counter == 1) {
            tictactoegrabber.setDecesionFinal("---Match Started---");
        }
        if (counter == 9) {
            setAllBtnDisable();
            tictactoegrabber.setDecesionFinal("---Match Draw---");
            scoreboard.setBackground(Color.YELLOW);
        }
        //Check horizontally
        if (b1.equals(b2) && b2.equals(b3)) {
            winMovement(b1, jb1, jb2, jb3);
            setAllBtnDisable();
        } else if (b4.equals(b5) && b5.equals(b6)) {
            winMovement(b4, jb4, jb5, jb6);
            setAllBtnDisable();
        } else if (b7.equals(b8) && b8.equals(b9)) {
            winMovement(b7, jb7, jb8, jb9);
            setAllBtnDisable();
        } //check Vertically
        else if (b1.equals(b4) && b4.equals(b7)) {
            winMovement(b1, jb1, jb4, jb7);
            setAllBtnDisable();
        } else if (b2.equals(b5) && b5.equals(b8)) {
            winMovement(b2, jb2, jb5, jb8);
            setAllBtnDisable();

        } else if (b3.equals(b6) && b6.equals(b9)) {
            winMovement(b3, jb3, jb6, jb9);
            setAllBtnDisable();
        } //check diagonally
        else if (b1.equals(b5) && b5.equals(b9)) {
            winMovement(b1, jb1, jb5, jb9);
            setAllBtnDisable();
        } else if (b3.equals(b5) && b5.equals(b7)) {
            winMovement(b3, jb3, jb5, jb7);
            setAllBtnDisable();
        }

    }

    @Override
    public void winMovement(String s, JButton b1, JButton b2, JButton b3) {
        b1.setBackground(Color.GREEN);
        b2.setBackground(Color.GREEN);
        b3.setBackground(Color.GREEN);
        tictactoegrabber.setPlayerTurn("---congratulation---");
        tictactoegrabber.setDecesionFinal("---" + s + " is Win---");
        scoreboard.setBackground(Color.GREEN);
    }

    @Override
    public void outOfFocus() {
        jb1.setFocusable(false);
        jb2.setFocusable(false);
        jb3.setFocusable(false);
        jb4.setFocusable(false);
        jb5.setFocusable(false);
        jb6.setFocusable(false);
        jb7.setFocusable(false);
        jb8.setFocusable(false);
        jb9.setFocusable(false);

    }

    @Override
    public void setAllBtnDisable() {
        jb1.setEnabled(false);
        jb2.setEnabled(false);
        jb3.setEnabled(false);
        jb4.setEnabled(false);
        jb5.setEnabled(false);
        jb6.setEnabled(false);
        jb7.setEnabled(false);
        jb8.setEnabled(false);
        jb9.setEnabled(false);
    }

    @Override
    public void setAllBtnOpaq() {
        playerTurn.setOpaque(true);
        scoreboard.setOpaque(true);
        jb1.setOpaque(true);
        jb2.setOpaque(true);
        jb3.setOpaque(true);
        jb4.setOpaque(true);
        jb5.setOpaque(true);
        jb6.setOpaque(true);
        jb7.setOpaque(true);
        jb8.setOpaque(true);
        jb9.setOpaque(true);
    }

    @Override
    public void setColorAllButton(Color c) {
        jb1.setBackground(c);
        jb2.setBackground(c);
        jb3.setBackground(c);
        jb4.setBackground(c);
        jb5.setBackground(c);
        jb6.setBackground(c);
        jb7.setBackground(c);
        jb8.setBackground(c);
        jb9.setBackground(c);

    }

    @Override
    public Prototype doClone() {
        return new TicTacToe();
    }
}
