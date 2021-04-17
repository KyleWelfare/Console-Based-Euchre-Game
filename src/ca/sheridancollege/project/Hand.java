package ca.sheridancollege.project;

public class Hand extends GroupOfCards {

    public Hand() {
        super(5);
    }
    
    public void cardPlayed(int handIndex) {
        cards.remove(handIndex);
    }
  
}