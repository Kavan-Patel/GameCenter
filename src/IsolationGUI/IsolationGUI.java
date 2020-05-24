package IsolationGUI;

/**
 *
 * @author Team3
 */
import gamecenter.HomePage;
import gamecenter.Prototype;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

/**
 * TicTacToe Application
 *
 * @author Steve Robinson
 * @version 1.0
 */
public class IsolationGUI implements Prototype{

    JFrame frame=new JFrame();
   public static JPanel contentpane=new JPanel();
    JButton[][] buttons = new JButton[7][7];
    JLabel statusBar;
    
    JButton saveBtn=new JButton("Save");
    
   public static GamePanel panel;
    Integer turn;
    Integer[] nullArray = {-1, -1};
    Integer[] lastMoveP1 = {-1, -1};
    Integer[] lastMoveP2 = {-1, -1};

    GameListener listener = new GameListener();
    Integer count;

    public IsolationGUI() {
        
        HomePage.pagestatus=3;
        contentpane.setLayout(new BorderLayout());

        panel = new GamePanel();
        
        
        contentpane.add(panel, BorderLayout.CENTER);
       
        statusBar = new JLabel("Player1's Turn");
//        statusBar.setEditable(false);
        contentpane.add(statusBar, BorderLayout.PAGE_START);
        contentpane.setPreferredSize(new Dimension(400, 400));
//        setTitle("Tic Tac Toe!");
//        setVisible(true);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setBounds(400, 400, 300, 300);
    }

    @Override
    public Prototype doClone() {
        return new IsolationGUI();
    }

    class GamePanel extends JPanel {

        public GamePanel() {
            setLayout(new GridLayout(7, 7));
            turn = 1;
            count = 0;
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    buttons[i][j] = new JButton();
                    buttons[i][j].putClientProperty("INDEX", new Integer[]{i, j});
                    buttons[i][j].putClientProperty("OWNER", null);
                    buttons[i][j].addActionListener(listener);
                    add(buttons[i][j]);
                }
            }
        }
    }

    class GameListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            count++;
            JButton b = (JButton) e.getSource();
            Integer[] index = (Integer[]) b.getClientProperty("INDEX");

            if ((Arrays.equals(lastMoveP1, nullArray) && turn == 1) || (Arrays.equals(lastMoveP2, nullArray) && turn == 2) || ((((Math.abs(lastMoveP1[0] - index[0]))) < 2) && (((Math.abs(lastMoveP1[1] - index[1]))) < 2) && turn == 1) || ((((Math.abs(lastMoveP2[0] - index[0]))) < 2) && (((Math.abs(lastMoveP2[1] - index[1]))) < 2) && turn == 2)) {
     
                b.putClientProperty("OWNER", turn);
                Icon ico = new ImageIcon(turn.toString() + ".gif");
                b.setIcon(ico);
                b.setEnabled(false);

                if (turn == 1) {
                    lastMoveP1[0] = index[0];
                    lastMoveP1[1] = index[1];
                    statusBar.setText("Player2's Turn");
                    boolean result = checkVictoryCondition(index);
                    if (result) {

                        initComponents();
                    }

                    turn = 2;

                } else {
                    lastMoveP2[0] = index[0];
                    lastMoveP2[1] = index[1];
                    statusBar.setText("Player1's Turn");
                    boolean result = checkVictoryCondition(index);
                    if (result) {

                        initComponents();
                    }

                    turn = 1;

                }               
            }
        }

        Integer getOwner(JButton b) {
            return (Integer) b.getClientProperty("OWNER");
        }

        boolean checkVictoryCondition(Integer[] index) {
           
            int nullCount = 0;
            int nullCount1 = 0;
            int nullCount2 = 0;

            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {

                    if ((lastMoveP1[0] + i > -1) && (lastMoveP1[1] + j > -1) && (lastMoveP1[0] + i < 7) && (lastMoveP1[1] + j < 7)) {
                        System.out.println("blah");
                        System.out.println(lastMoveP2[0]);
                        System.out.println(lastMoveP2[1]);
                        if ((buttons[lastMoveP1[0] + i][lastMoveP1[1] + j].getClientProperty("OWNER") == null)) {
                            nullCount1++;
                        }
                    }

                    if ((lastMoveP2[0] + i > -1) && (lastMoveP2[1] + j > -1) && (lastMoveP2[0] + i < 7) && (lastMoveP2[1] + j < 7)) {
                        if ((buttons[lastMoveP2[0] + i][lastMoveP2[1] + j].getClientProperty("OWNER") == null)) {
                            nullCount2++;
                        }
                    }

                }
            }

            System.out.println(nullCount2);

            if (nullCount1 == 0 && nullCount2 == 0 && !Arrays.equals(lastMoveP2, nullArray)) {
                JOptionPane.showMessageDialog(null, "Tie Game!");
            }

            if (nullCount1 == 0 && !(nullCount2 == 0) && !Arrays.equals(lastMoveP2, nullArray)) {
                JOptionPane.showMessageDialog(null, "Player 2 wins!");
            }

            if (nullCount2 == 0 && !(nullCount1 == 0) && !Arrays.equals(lastMoveP2, nullArray)) {
                JOptionPane.showMessageDialog(null, "Player 1 wins!");
            }

            return (nullCount1 == 0 || nullCount2 == 0 && !Arrays.equals(lastMoveP2, nullArray));
            
        }
    }

    public void initComponents() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                buttons[i][j].putClientProperty("INDEX", new Integer[]{i, j});
                buttons[i][j].putClientProperty("OWNER", null);
                buttons[i][j].setIcon(null);
                buttons[i][j].setEnabled(true);
                turn = 1;
                count = 0;
                lastMoveP1[0] = -1;
                lastMoveP1[1] = -1;
                lastMoveP2[0] = -1;
                lastMoveP2[1] = -1;
                statusBar.setText("Player1's Turn");

            }
        }
    }

}