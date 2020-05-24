package Memento;

import TicTacToe.TicTacToe;


public class Memento {
   private final TicTacToe state;

   public Memento(TicTacToe state){
      this.state = state;
   }

   public TicTacToe getState(){
      return state;
   }	
}
