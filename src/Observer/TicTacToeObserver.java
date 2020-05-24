/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Observer;

import TicTacToe.TicTacToe;

/**
 *
 * @author kavanpatel
 */
public class TicTacToeObserver implements ObserverIF{
    
    
    private String decesionFinal;
    private String playerMove;
    private static int observerIdTracker=0;
    private int observerId;
    private SubjectIF tictactoeGrabber;
    
    public TicTacToeObserver(TictactoeGrabber tictactoeGrabber)
    {
        
        this.tictactoeGrabber=tictactoeGrabber;
        this.observerId=observerId++;
        tictactoeGrabber.register(this);
    }

    @Override
    public void update(String playerTurn, String decesionFinal) {
        
        this.playerMove=playerTurn;
        this.decesionFinal=decesionFinal;
        
        TicTacToe.playerTurn.setText(playerTurn+"");
        TicTacToe.scoreboard.setText(decesionFinal);
        
    }
    
    
}
