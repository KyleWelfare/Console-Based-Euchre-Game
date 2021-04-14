package ca.sheridancollege.project;

/**
 *
 * @author kyled
 */
public class EuchreCard extends Card{

    private int weightedValue;
    
    public EuchreCard(Value value, Suit suit, int weightedValue) {
        this.value = value;
        this.suit = suit;
        this.weightedValue = weightedValue;
    }

    public int getWeightedValue() {
        return weightedValue;
    }
        
    @Override
    public String toString() {
        return getValue() + " of " + getSuit() + "\n";
    }
    
}
