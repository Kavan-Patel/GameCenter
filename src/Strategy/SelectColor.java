/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy;

import gamecenter.HomePage;
import TicTacToe.TicTacToe;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author kavanpatel
 */
public class SelectColor implements ActionListener {

    public static JPanel contentpane;
    JButton btnRed;
    JButton btnMagenta;
    JButton btnBlue;
    JButton btnResume;
    JPanel main;
    Context context;
//    static TicTacToe tictactoe;
    TicTacToe newtictactoe;

    public SelectColor() {
        HomePage.pagestatus = 1;
//        tictactoe = new TicTacToe();
//        newtictactoe=new TicTacToe();
        contentpane = new JPanel();
        main = new JPanel(new GridLayout(1, 4));
        btnRed = new JButton("Red");
        btnMagenta = new JButton("Magenta");
        btnBlue = new JButton("Blue");
        btnResume = new JButton("Resume");
        btnRed.addActionListener(this);
        btnMagenta.addActionListener(this);
        btnBlue.addActionListener(this);
        btnResume.addActionListener(this);
        main.add(btnRed);
        main.add(btnMagenta);
        main.add(btnBlue);
        main.add(btnResume);

        contentpane.add(main);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnRed)) {
            context = new Context(new RedColorBoard());
            context.executeStrategy(Color.red);
        } else if (e.getSource().equals(btnMagenta)) {
            context = new Context(new MagentaColorBoard());
            context.executeStrategy(Color.magenta);
        } else if (e.getSource().equals(btnBlue)) {
            context = new Context(new BlueColorBoard());
            context.executeStrategy(Color.blue);
        } else if (e.getSource().equals(btnResume)) {
            HomePage.pagestatus = 2;
            System.out.println(newtictactoe);
//            if (HomePage.originator.getState().toString() == null) {
//                JOptionPane.showMessageDialog(null, "Save Your Game First", "Info Message", JOptionPane.INFORMATION_MESSAGE);
//            } else {
             try{
                 System.out.println("get state: " + HomePage.originator.getState());
                newtictactoe = (TicTacToe) HomePage.originator.getState();
                contentpane.removeAll();
                contentpane.add(newtictactoe.contentpane);
                SelectColor.contentpane.revalidate();
                SelectColor.contentpane.repaint();
             }catch(Exception ee)
             {
                 JOptionPane.showMessageDialog(null, "Save Your Game First", "Info Message", JOptionPane.INFORMATION_MESSAGE);
                 System.out.println("Exception "+ee);
             }
                
//            }
        }
    }

}
