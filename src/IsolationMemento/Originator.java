package IsolationMemento;

import IsolationGUI.IsolationGUI;

public class Originator {
   private IsolationGUI state;

   public void setState(IsolationGUI state){
      this.state = state;
   }

   public IsolationGUI getState(){
      return state;
   }

   public Memento saveStateToMemento(){
      return new Memento(state);
   }

   public void getStateFromMemento(Memento memento){
      state = memento.getState();
   }
}