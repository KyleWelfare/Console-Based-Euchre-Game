package ca.sheridancollege.project;

/**
 *
 * @author kyled
 */
public class EuchrePlayer extends Player{
    
    private boolean isDealer;
    private Hand hand;
    private int id;
    EuchreCard trickCardPlayed;
    private int team;
    private boolean isMaker;
    
    public EuchrePlayer(String name, int id) {
        super(name);
        this.id = id;
        if (id == 1 || id == 3) {
            this.team = 1;
        } 
        else {
            this.team = 2;
        }
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public EuchreCard getTrickCardPlayed() {
        return trickCardPlayed;
    }

    public void setTrickCardPlayed(EuchreCard trickCardPlayed) {
        this.trickCardPlayed = trickCardPlayed;
    }

    public int getTeam() {
        return team;
    }
 
    @Override
    public void play() {
        
    }
    
}
