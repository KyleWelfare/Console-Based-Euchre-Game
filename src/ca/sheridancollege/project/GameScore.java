package ca.sheridancollege.project;

public class GameScore extends Score {

	//Singleton class
	private static GameScore instance = null;
	
	//10 point win limit
	private final int MAX_SCORE = 10;
	
    private GameScore() {
		setScoreLimit(MAX_SCORE);
    }
	
	public static GameScore getInstance(){
		if (instance == null)
			instance = new GameScore();
		
		return instance;
	}

}