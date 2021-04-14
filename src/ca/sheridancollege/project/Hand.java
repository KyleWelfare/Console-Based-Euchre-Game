package ca.sheridancollege.project;

public class Hand extends GroupOfCards {

    public Hand(int size) {
        super(size);
    }
    
    public void cardPlayed(int handIndex) {
        cards.remove(handIndex);
    }
  
}