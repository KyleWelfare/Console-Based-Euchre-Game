package ca.sheridancollege.project;

import java.util.Iterator;

public class Hand extends GroupOfCards {

    public Hand() {
        super(5);
    }
    
    public void cardPlayed(int handIndex) {
        cards.remove(handIndex);
    }  
    
    @Override
    public String toString() {
        Iterator<Card> itCards = cards.iterator();
        String display = "";
        int iteration = 1;
        while(itCards.hasNext()) {
            
            Card card = itCards.next();
            display += "[" + iteration + "] " + card.toString();
            iteration++;
        }
        return display;
    }
}