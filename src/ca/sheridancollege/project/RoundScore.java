package ca.sheridancollege.project;

public class RoundScore extends Score {

	//Singleton class
	private static RoundScore instance = null;
	
	//Max 5 tricks
	private final int MAX_SCORE = 5;
	
    private RoundScore() {
        setScoreLimit(MAX_SCORE);
    }
	
	public static RoundScore getInstance(){
		if(instance == null){
			instance = new RoundScore();
		}
		
		return instance;
	}
	
	//reset all round scores for new round
	public void resetScores(){
		setTeam1Score(0);
		setTeam2Score(0);
		setScoreLimit(5);
	}
	
	//debug only
	public String toString(){
		String out = String.format("Round Score:\nTeam 1 - %s\nTeam2 - %s\n", instance.getTeam1Score(),instance.getTeam2Score());
		return out;
		
	}
}