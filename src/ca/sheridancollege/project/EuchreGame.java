package ca.sheridancollege.project;

import ca.sheridancollege.project.Card.Suit;
import ca.sheridancollege.project.Card.Value;
import ca.sheridancollege.project.GameScore;
import ca.sheridancollege.project.RoundScore;
import java.util.Scanner;

public class EuchreGame extends Game {
    public static void main (String[] args) {
        
        //testing/debugging - you can get rid of all this
        Value[] cardValues = Value.values();
        Suit[] cardSuits = Suit.values();
        final int NUM_PLAYERS = 4;
        final int HAND_SIZE = 5;
        
        EuchrePlayer[] players = new EuchrePlayer[NUM_PLAYERS];
        for (int i = 0; i<players.length; i++) {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter a name for Player " + (i+1) + ":");
            String name = input.nextLine();
            players[i] = new EuchrePlayer(name);
        }
        //Hand[] hands = new Hand[NUM_PLAYERS];
        
        EuchreDeck.getInstance().resetDeck(cardValues, cardSuits);
        System.out.println(EuchreDeck.getInstance().toString());

        EuchreDeck.getInstance().deal(players, HAND_SIZE);
       
        for (EuchrePlayer player : players) {
            System.out.println(player.getHand().toString());
        }
        
        System.out.println(EuchreDeck.getInstance().toString());
    }
    
    public EuchreGame () {
        super("Euchre Game #");
    }
	
	
	//initialize values and stuff i guess
	public void initialize(){
		//Initialize scores
		GameScore.getInstance();
		RoundScore.getInstance();
		
		EuchreDeck.getInstance();
		
	}
    
    @Override
    public void play() {
      
    }

    @Override
    public void declareWinner() {
		/*
		Score Reference
		Makers win 3-4 tricks - 1 point
		Makers win 5 tricks - 2 points
		Lone wins 3-4 tricks - 1 point
		Lone wins 5 tricks - 4 points
		Makers/Lone gets euchered - Defenders score 2 points
		*/
		
		
        //Maybe check if scores are valid before determining the winner, but idk what criteria that would be if we do that
		
		//cache, maybe make global
		RoundScore roundScore = RoundScore.getInstance();
		GameScore gameScore = GameScore.getInstance();
		
		//PLACEHOLDERS
		boolean t1Lone = true;
		boolean t2Lone = true;
		boolean t1IsMaker = true;
		boolean t2IsMaker = true;
		
		
		//Majority means >= 3 points
		//Team 1 has majority
		
		//Should probably display team 1 winner or something
		
		if(roundScore.getTeam1Score() > roundScore.getTeam2Score()){
			//If team 1 are makers
			if(t1IsMaker){
				if(roundScore.getTeam1Score() == 5){	//If Team 1 scores ace
					if(t1Lone)	//4 points for lone ace						
						gameScore.addScoreTeam1(4);
					
					else	//2 points for maker ace						
						gameScore.addScoreTeam1(2);
				}
				
				//Add 1 point for winning 3-4 tricks
				else
					gameScore.addScoreTeam1(1);
			}
			//Team 2Euchred
			//Team 1 gets 2 points
			else{
				gameScore.addScoreTeam1(2);
			}
		}
		
		//Team 2 has majority
		
		//should probably display team 2 winner or something
		
		else{
			//If team 2 are makers
			if(t2IsMaker){
				if(roundScore.getTeam2Score() == 5){	//If Team 2 scores ace
					if(t2Lone)	//4 points for lone ace						
						gameScore.addScoreTeam2(4);
					
					else	//2 points for maker ace						
						gameScore.addScoreTeam2(2);
				}
				
				//Add 1 point for winning 3-4 tricks
				else
					gameScore.addScoreTeam2(1);
			}
			//Team 1 Euchred
			//Team 2 gets 2 points
			else{
				gameScore.addScoreTeam2(2);
			}
		}
		
		
		
		
		
		
		
//		//Majority means >= 3 points
//		//Team 1 has majority
//		if(roundScore.getTeam1Score() > roundScore.getTeam2Score()){
//			//Add 2 points for ace
//			if(roundScore.getTeam1Score() == 5){
//				//4 points for lone ace
//				if(lone)
//					gameScore.setTeam1Score(gameScore.getTeam1Score() + 4);
//				else
//					gameScore.setTeam1Score(gameScore.getTeam1Score() + 2);
//			}
//			//Add 1 point for winning 3-4 tricks
//			else
//				gameScore.setTeam1Score(gameScore.getTeam1Score() + 1);
//		}
//		
//		//Team 2 has majority
//		else{
//			//Add 2 points for winning all 5 tricks
//			if(roundScore.getTeam2Score() == 5)
//				gameScore.setTeam2Score(gameScore.getTeam2Score() + 2);
//			//Add 1 point for winning 3-4 tricks
//			else
//				gameScore.setTeam2Score(gameScore.getTeam2Score() + 1);
//			
//		}
		
    }
}