/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Observer;

/**
 *
 * @author kavanpatel
 */
public interface SubjectIF {
    public void register(ObserverIF o);
    public void unregister(ObserverIF o);
    public void notifyObserver();
}
