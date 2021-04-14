package ca.sheridancollege.project;

/**
 *
 * @author kyled
 */
public class EuchrePlayer extends Player{
    
    private boolean isDealer;
    private Hand hand;
    
    public EuchrePlayer(String name) {
        super(name);
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }
    
    @Override
    public void play() {
        
    }
    
}
