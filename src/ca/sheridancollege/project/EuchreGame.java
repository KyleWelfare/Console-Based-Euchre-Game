package ca.sheridancollege.project;

import ca.sheridancollege.project.Card.Suit;
import ca.sheridancollege.project.Card.Value;
import ca.sheridancollege.project.GameScore;
import ca.sheridancollege.project.RoundScore;
import java.util.Scanner;

public class EuchreGame extends Game {
	
	//dunno if we should keep this but it works and its being used for debug
//	public GameScore gameScore;
//	public RoundScore roundScore;
	
    public static void main (String[] args) {
		
		//maybe some verification on lone/maker
		//cannot be lone without being maker etc.
		//thats for someone else to do elsewhere
		
		
		
        //testing/debugging - you can get rid of all this
		
		EuchreGame game = new EuchreGame();
		game.initialize();
		
		Scanner input = new Scanner(System.in);
		
		System.out.println(GameScore.getInstance().getScoreLimit());
		System.out.println(RoundScore.getInstance().getScoreLimit());
		//set scores
		System.out.println("team1 score");
		RoundScore.getInstance().setTeam1Score(input.nextInt());
		
		System.out.println("team2 score");
		RoundScore.getInstance().setTeam2Score(input.nextInt());
		
		
		//output
		System.out.println(GameScore.getInstance().toString());
		System.out.println(RoundScore.getInstance().toString());
		
		//set states
		System.out.println("lone1");
		boolean l1 = input.nextBoolean();
		System.out.println("lone2");
		boolean l2 = input.nextBoolean();
		System.out.println("make1");
		boolean m1 = input.nextBoolean();
		System.out.println("make2");
		boolean m2 = input.nextBoolean();
		
		game.declareWinner(l1, l2, m1, m2);
        
		//output
		System.out.println(GameScore.getInstance().toString());
		System.out.println(RoundScore.getInstance().toString());
		
//        Value[] cardValues = Value.values();
//        Suit[] cardSuits = Suit.values();
//        final int NUM_PLAYERS = 4;
//        final int HAND_SIZE = 5;
//        
//        EuchrePlayer[] players = new EuchrePlayer[NUM_PLAYERS];
//        for (int i = 0; i<players.length; i++) {
//            Scanner input = new Scanner(System.in);
//            System.out.println("Enter a name for Player " + (i+1) + ":");
//            String name = input.nextLine();
//            players[i] = new EuchrePlayer(name);
//        }
//        //Hand[] hands = new Hand[NUM_PLAYERS];
//        
//        EuchreDeck.getInstance().resetDeck(cardValues, cardSuits);
//        System.out.println(EuchreDeck.getInstance().toString());
//
//        EuchreDeck.getInstance().deal(players, HAND_SIZE);
//       
//        for (EuchrePlayer player : players) {
//            System.out.println(player.getHand().toString());
//        }
//        
//        System.out.println(EuchreDeck.getInstance().toString());
    }
    
    public EuchreGame () {
        super("Euchre Game #");
    }
	
	
	//initialize values and stuff i guess
	public void initialize(){
//		//Initialize scores
//		gameScore = GameScore.getInstance();
//		roundScore = RoundScore.getInstance();
		
		EuchreDeck.getInstance();
		
	}
    
    @Override
    public void play() {
      
    }

	//remove this afterwards, exists to fulfill abstract requirements
	@Override
	public void declareWinner(){
	
	}
	
	//debug/testing setup
	//remove above, uncomment override, remove all args when actually implementing
    //@Override
    public void declareWinner(boolean t1L, boolean t2L, boolean t1M, boolean t2M) {
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
//		RoundScore roundScore = RoundScore.getInstance();
//		GameScore gameScore = GameScore.getInstance();
		




		//PLACEHOLDERS
		boolean t1Lone = t1L;
		boolean t2Lone = t2L;
		boolean t1IsMaker = t1M;
		boolean t2IsMaker = t2M;
		
		
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
		
    }
}