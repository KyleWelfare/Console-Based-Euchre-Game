package ca.sheridancollege.project;

/**
 *
 * @author kyled
 */
public class EuchrePlayer extends Player{
    
    private boolean isDealer;
    private Hand hand;
    private int id;
    
    public EuchrePlayer(String name, int id) {
        super(name);
        this.id = id;
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
