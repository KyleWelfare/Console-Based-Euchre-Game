package ca.sheridancollege.project;

import ca.sheridancollege.project.Card.Suit;
import ca.sheridancollege.project.Card.Value;
import java.util.Scanner;

/**
 *
 * @author kyled
 */
public class EuchrePlayGame {

    public static void main(String[] args) {
        boolean isPlaying = true;
        int currentGameNumber = 1;
        EuchreDeck deck = EuchreDeck.getInstance();

        Value[] cardValues = Value.values();
        Suit[] cardSuits = Suit.values();

        System.out.println("SYST17796 Group 13's Euchre Game Project");
        System.out.println("Authors: Kyle Welfare, Chris Yeung, Owen Barrington, Jacob Bullock");
        while (isPlaying) {
            EuchreGame game = new EuchreGame(currentGameNumber);
            game.welcomeMessage();
            
            for (int i = 1; i <= 4; i++) {
                Scanner input = new Scanner(System.in);
                System.out.println("Please enter a name for player " + i + ":");
                String name = input.nextLine();
                game.getPlayers().add(new EuchrePlayer(name, i));
            }
            
            int dealerIndex = 0;
            while (game.getGameScore().getTeam1Score() <= game.getGameScore().getScoreLimit() || game.getGameScore().getTeam2Score() <= game.getGameScore().getScoreLimit()) {

                EuchreRound round = new EuchreRound((EuchrePlayer) game.getPlayers().get(dealerIndex));
                deck.resetDeck(cardValues, cardSuits);
                deck.deal(game.getPlayers());
                
                outerloop:
                for (int i = 0; i < game.getPlayers().size(); i++) {
                    round.promptUser(game.getPlayers(), i);
                    Scanner input = new Scanner(System.in);
                                 
                    while (true) {
                        System.out.println("Make your selection by entering the corresponding number");
                        int option = input.nextInt();
                        if (option == 1) {
                            round.orderUp();
                            break outerloop;
                        } else if (option == 2) {
                            break;
                        } else {
                            System.out.println("Invalid selection. Please try again.");
                        }
                    }
                }
                round.setWeightedValues(game.getPlayers());

                //tricks 
                for (int i = 0; i < 5; i++) {
                    EuchreTrick trick = new EuchreTrick(round);
                    trick.promptUser(game.getPlayers(), i);
                    Scanner input = new Scanner(System.in);
                                           
                    while (true) {
                        System.out.println("Make your selection by entering the corresponding number");
                        int option = input.nextInt();
                        
                        if (option > 0 && option <= ((EuchrePlayer)game.getPlayers().get(i)).getHand().getCards().size()) {
                            ((EuchrePlayer)game.getPlayers().get(i)).getHand().getCards().remove(option-1);
                            
                            break;
                        }
                        else {
                            System.out.println("Invalid selection. Please try again.");
                        }                        
                    }
                }
                
                if (dealerIndex < 3) {
                    dealerIndex++;
                } else {
                    dealerIndex = 0;
                }
            }
            currentGameNumber++;
        }
    }
}
