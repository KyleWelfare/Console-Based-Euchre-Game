package ca.sheridancollege.project;

import ca.sheridancollege.project.Card.Suit;

public class EuchreRound {

    private Suit trumpSuit;
    private Player dealer;
    private Card rightBower;
    private Card leftBower;

    public Suit getTrumpSuit() {
        return this.trumpSuit;
    }

    /**
     * 
     * @param trumpSuit
     */
    public void setTrumpSuit(Suit trumpSuit) {
        this.trumpSuit = trumpSuit;
    }

    public Player getDealer() {
        return this.dealer;
    }

    /**
     * 
     * @param dealer
     */
    public void setDealer(Player dealer) {
        this.dealer = dealer;
    }

    public Card getRightBower() {
        return this.rightBower;
    }

    /**
     * 
     * @param rightBower
     */
    public void setRightBower(Card rightBower) {
        this.rightBower = rightBower;
    }

    public Card getLeftBower() {
        return this.leftBower;
    }

    /**
     * 
     * @param leftBower
     */
    public void setLeftBower(Card leftBower) {
        this.leftBower = leftBower;
    }

}