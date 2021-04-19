package ca.sheridancollege.project;

import ca.sheridancollege.project.Card.Suit;
import ca.sheridancollege.project.Card.Value;
import java.util.ArrayList;
import java.util.Scanner;

public class EuchreRound {

    private EuchrePlayer dealer;
    private Suit trumpSuit;
    private Card rightBower;
    private Card leftBower;
    private GroupOfCards cardsPlayed;

    public EuchreRound(EuchrePlayer dealer) {
        this.dealer = dealer;
    }

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

    public EuchrePlayer getDealer() {
        return this.dealer;
    }

    /**
     *
     * @param dealer
     */
    public void setDealer(EuchrePlayer dealer) {
        this.dealer = dealer;
    }

    public Card getRightBower() {
        return this.rightBower;
    }

    public GroupOfCards getCardsPlayed() {
        return cardsPlayed;
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

    public void promptUser(ArrayList<Player> players, int playerIndex) {
        System.out.println("Your Hand: ");
        ((EuchrePlayer) players.get(playerIndex)).getHand().toString();

        System.out.println("Top Card of Deck: ");
        System.out.println(EuchreDeck.getInstance().cards.get(0).toString());

        System.out.println("Choose from the following options: ");
        System.out.println("[1] Order Up (Set trump suit to " + EuchreDeck.getInstance().cards.get(0).getSuit() + "and dealer picks up top card.");
        System.out.println("[2] Pass.");
    }

    public void orderUp() {
        System.out.println("Choose a card to remove from your hand: ");
        System.out.println("Your Hand: ");
        dealer.getHand().toString();
        
        Scanner input = new Scanner(System.in);
              
        while (true) {
            System.out.println("Make your selection by entering the corresponding number");
            int option = input.nextInt();
            
            if (option > 0 && option < 6) {
                dealer.getHand().getCards().remove(option);
                break;
            }
            else {
                System.out.println("Invalid option. Please try again.");
            }
        }
        
        setTrumpSuit(EuchreDeck.getInstance().getCards().get(0).getSuit());
        EuchreDeck.getInstance().getCards().remove(0);
    }
    
    public void setWeightedValues(ArrayList<Player> players) {
        final int JACK_WEIGHTED_VALUE = 11;
        setRightBower(new EuchreCard(Value.JACK, trumpSuit, JACK_WEIGHTED_VALUE));
        
        Suit leftBowerSuit = null;
        if (trumpSuit == Suit.CLUBS) {
            leftBowerSuit = Suit.SPADES;
        }
        else if (trumpSuit == Suit.SPADES) {
            leftBowerSuit = Suit.CLUBS;
        }
        else if (trumpSuit == Suit.HEARTS) {
            leftBowerSuit = Suit.DIAMONDS;
        }
        else if (trumpSuit == Suit.DIAMONDS) {
            leftBowerSuit = Suit.HEARTS;
        }
        setLeftBower(new EuchreCard(Value.JACK, leftBowerSuit, JACK_WEIGHTED_VALUE));
        
        for (int i = 0; i < players.size(); i++) {
            for (int j = 0; j < ((EuchrePlayer)players.get(i)).getHand().size; j++) {
                if (((EuchrePlayer)players.get(i)).getHand().getCards().get(j).equals(this.rightBower)) {
                    ((EuchreCard)((EuchrePlayer)players.get(i)).getHand().getCards().get(j)).setWeightedValue(500);
                }
                if (((EuchrePlayer)players.get(i)).getHand().getCards().get(j).equals(this.leftBower)) {
                    ((EuchreCard)((EuchrePlayer)players.get(i)).getHand().getCards().get(j)).setWeightedValue(300);
                }
                if (((EuchrePlayer)players.get(i)).getHand().getCards().get(j).getSuit() == trumpSuit) {
                    ((EuchreCard)((EuchrePlayer)players.get(i)).getHand().getCards().get(j)).setWeightedValue(100);
                }                
            } 
        }
    }  
}

