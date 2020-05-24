package IsolationMemento;

import IsolationGUI.IsolationGUI;


public class Memento {
   private final IsolationGUI state;

   public Memento(IsolationGUI state){
      this.state = state;
   }

   public IsolationGUI getState(){
      return state;
   }	
}
