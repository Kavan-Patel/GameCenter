package Memento;

import TicTacToe.TicTacToe;

public class Originator {
   private TicTacToe state;

   public void setState(TicTacToe state){
      this.state = state;
   }

   public TicTacToe getState(){
      return state;
   }

   public Memento saveStateToMemento(){
      return new Memento(state);
   }

   public void getStateFromMemento(Memento memento){
      state = memento.getState();
   }
}