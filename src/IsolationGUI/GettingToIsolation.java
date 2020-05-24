/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IsolationGUI;

import Strategy.SelectColor;
import gamecenter.HomePage;
import gamecenter.Prototype;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author kavanpatel
 */
public class GettingToIsolation implements ActionListener {

    public static JPanel contentpane;
    JButton btnIsolation;   
    JButton btnResume;
    IsolationGUI newIsolation;
    JPanel main;
    public static Prototype isolation;
    

    public GettingToIsolation() {
        HomePage.pagestatus = 1;
//        tictactoe = new TicTacToe();
//        newtictactoe=new TicTacToe();
        contentpane = new JPanel();
        main = new JPanel(new GridLayout(1, 2));
        btnIsolation = new JButton("Isolation");
        btnResume = new JButton("Resume");
        isolation=new IsolationGUI();
       
        btnIsolation.addActionListener(this);                
        btnResume.addActionListener(this);
        main.add(btnIsolation);        
        main.add(btnResume);

        contentpane.add(main);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnIsolation)) {
           
        HomePage.mainPanel.removeAll();        
        HomePage.mainPanel.add(IsolationGUI.contentpane);
        HomePage.mainPanel.revalidate();
        HomePage.mainPanel.repaint();
        }  else if (e.getSource().equals(btnResume)) {   
                       
                         
            newIsolation = (IsolationGUI) HomePage.iOriginator.getState();         
            System.out.println(newIsolation);
            HomePage.mainPanel.removeAll();
            HomePage.mainPanel.add(newIsolation.contentpane);
            HomePage.mainPanel.revalidate();
            HomePage.mainPanel.repaint();
        }
    }

}
