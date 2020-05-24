/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TicTacToe;

import java.awt.Color;
import javax.swing.JButton;

/**
 *
 * @author kavanpatel
 */
public interface TicTacToeIF {
    public void setUI(Color c);
    public void initUI(Color c);
    public void setButtonText(JButton btn);
    public void checkLogic();
    public void winMovement(String s, JButton b1, JButton b2, JButton b3);
    public void outOfFocus();
    public void setAllBtnDisable();
    public void setAllBtnOpaq();
    public void setColorAllButton(Color c);
}
