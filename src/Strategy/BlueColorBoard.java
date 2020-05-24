/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy;

import java.awt.Color;

/**
 *
 * @author kavanpatel
 */
public class BlueColorBoard extends ColorBoard implements Strategy{

//    TicTacToe tictactoe;
    @Override
    public void execute(Color c) {
        super.execute(c);
//        tictactoe=(TicTacToe) SelectColor.tictactoe.doClone();
//        tictactoe.setUI(c);
//        SelectColor.contentpane.removeAll();        
//        SelectColor.contentpane.add(tictactoe.contentpane);
//        SelectColor.contentpane.revalidate();
//        SelectColor.contentpane.repaint();
    }
    
}
