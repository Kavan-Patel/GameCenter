/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy;

import TicTacToe.TicTacToe;
import gamecenter.HomePage;
import java.awt.Color;

/**
 *
 * @author kavanpatel
 */
public class ColorBoard{
    private TicTacToe tictactoe;
    
    
    public void execute(Color c) {                  
        tictactoe=(TicTacToe) HomePage.tictactoe.doClone();
        tictactoe.setUI(c);
        SelectColor.contentpane.removeAll();        
        SelectColor.contentpane.add(tictactoe.contentpane);
        SelectColor.contentpane.revalidate();
        SelectColor.contentpane.repaint();
    }
}
