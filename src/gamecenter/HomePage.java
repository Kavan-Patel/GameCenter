package gamecenter;

import IsolationGUI.GettingToIsolation;
import Strategy.SelectColor;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import IsolationGUI.IsolationGUI;
import Memento.Caretaker;
import Memento.Originator;
import TicTacToe.TicTacToe;
import javax.swing.JOptionPane;

/**
 *
 * @author Team3
 */
public class HomePage implements ActionListener {

    JLabel message;
    JButton btnTtt;
    JButton btnIL;
    public static JFrame mainFrame;
    JPanel jp2;
    JPanel jp3;
    JPanel jp1;
    JPanel contentpane, bottompanel, toppanel;
    public static JPanel mainPanel;
    public static JButton back, save, reset;
    public static int pagestatus = 0;
    public static Originator originator;
    public static IsolationMemento.Originator iOriginator;
    public static IsolationMemento.Caretaker isolationCaretaker;
    public static Caretaker caretaker;
    ChangePanel changePanel;
    public static Prototype tictactoe;
    public static Prototype isolation;
//    public IsolationGUI ig;
    public GettingToIsolation isoGUI;
    public static int flag = 1;

    public HomePage() {
        initUI();
    }

    private void initUI() {
        pagestatus = 0;
        message = new JLabel("Welcome to GameSpace Centre!!");
        btnTtt = new JButton("Tic-Tac-Toe");
        btnIL = new JButton("Isolation");
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp1 = new JPanel();
        mainPanel = new JPanel();
        back = new JButton("Back");
        save = new JButton("Save");
        reset = new JButton("Undo");
        toppanel = new JPanel();
        bottompanel = new JPanel();
        changePanel = new ChangePanel();

        contentpane = new JPanel();
        mainFrame = new JFrame();

        btnIL.addActionListener(this);
        btnTtt.addActionListener(this);
        back.addActionListener(this);
        save.addActionListener(this);
        reset.addActionListener(this);
        contentpane.setLayout(new GridLayout(4, 1));
        jp1.add(message);
        jp3.add(new JLabel("Select a game which you want to play!"));
        jp2.add(btnTtt);
        jp2.add(btnIL);

        contentpane.add(jp1);
        contentpane.add(jp3);
        contentpane.add(jp2);

        toppanel.add(new JLabel("GameCenter"));
        bottompanel.setLayout(new GridLayout(1, 3));
        bottompanel.add(back);
        bottompanel.add(save);
        bottompanel.add(reset);

        mainPanel.add(contentpane);

        mainFrame.setLayout(new BorderLayout());

        mainFrame.add(toppanel, BorderLayout.PAGE_START);
        mainFrame.add(mainPanel, BorderLayout.CENTER);
        mainFrame.add(bottompanel, BorderLayout.PAGE_END);
        mainFrame.setBackground(Color.yellow);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setSize(733, 733);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setTitle("Welcome");

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                HomePage hp = new HomePage();

            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(pagestatus);
        if (e.getSource().equals(btnTtt)) {
            tictactoe = new TicTacToe();
            isolation = new IsolationGUI();
            SelectColor ss = new SelectColor();
            changePanel.panelChange(mainPanel, ss.contentpane);
        } else if (e.getSource().equals(btnIL)) {
            isoGUI=new GettingToIsolation();
//            ig = new IsolationGUI();
            changePanel.panelChange(mainPanel, GettingToIsolation.contentpane);

        } else if (e.getSource().equals(back)) {
            if (pagestatus == 1) {
                System.out.println("jsdklfjldfjsdklfjd");
                  // HomePage hp = new HomePage();
                changePanel.panelChange(mainPanel, contentpane);
            } else if (pagestatus == 2) {
                SelectColor ss = new SelectColor();
                changePanel.panelChange(mainPanel, SelectColor.contentpane);
            }else if(pagestatus==3)
            {
                GettingToIsolation gi=new GettingToIsolation();
                pagestatus=1;
                changePanel.panelChange(mainPanel, GettingToIsolation.contentpane);
            }else
            {
                changePanel.panelChange(mainPanel, contentpane);
            }
        } else if (e.getSource().equals(reset)) {

            
           // changePanel.panelChange(mainPanel, SelectColor.contentpane);
        } else if (e.getSource().equals(save)) {
            
            if (pagestatus == 2) {
                
                originator = new Originator();
                caretaker = new Caretaker();
                originator.setState((TicTacToe) tictactoe.doClone());
                caretaker.add(originator.saveStateToMemento());
                JOptionPane.showMessageDialog(null, "Your game is Now Started to Saving ", "Info Message" , JOptionPane.INFORMATION_MESSAGE);
            }else if(pagestatus==3)
            {
                System.out.println("save");
                System.out.println(GettingToIsolation.isolation);
                iOriginator=new IsolationMemento.Originator();
                isolationCaretaker=new IsolationMemento.Caretaker();
                iOriginator.setState((IsolationGUI) GettingToIsolation.isolation);                
                isolationCaretaker.add(iOriginator.saveStateToMemento());
            }

        }
    }

}
