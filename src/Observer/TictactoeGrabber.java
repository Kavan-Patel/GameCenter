/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Observer;

import java.util.ArrayList;

/**
 *
 * @author kavanpatel
 */
public class TictactoeGrabber implements SubjectIF{

    private ArrayList<ObserverIF> observer;
    private String playerTurn;
    private String decesionFinal;
    
    public TictactoeGrabber()
    {
         observer=new ArrayList<ObserverIF>();
    }
    
    @Override
    public void register(ObserverIF o) {
        observer.add(o);
    }

    @Override
    public void unregister(ObserverIF o) {
        int observerIndex=observer.indexOf(o);
        observer.remove(observerIndex);
    }

    @Override
    public void notifyObserver() {
        for (ObserverIF observer1 : observer) {
            observer1.update(playerTurn, decesionFinal);
        }
    }
    
    public void setPlayerTurn(String pTurn){
        playerTurn=pTurn;
        notifyObserver();
    }
    
    public void setDecesionFinal(String fdecesion)
    {
        decesionFinal=fdecesion;
        notifyObserver();
    }
    
}
