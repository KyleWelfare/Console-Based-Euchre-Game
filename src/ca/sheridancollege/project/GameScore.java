package ca.sheridancollege.project;

public class GameScore extends Score {

	//Singleton class
	private static GameScore instance = null;
	
	//10 point win limit
	private final int MAX_SCORE = 10;
	
    public GameScore() {
	setScoreLimit(MAX_SCORE);
    }
	
	public static GameScore getInstance(){
		if (instance == null)
			instance = new GameScore();
		
		return instance;
	}
	
	
	//debug only
	public String toString(){
		String out = String.format("Game Score:\nTeam 1 - %s\nTeam 2 - %s\n", this.getTeam1Score(),this.getTeam2Score());
		return out;
		
	}

}