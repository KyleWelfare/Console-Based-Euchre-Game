package ca.sheridancollege.project;

public class Score {

    private int team1Score;
    private int team2Score;
    private int scoreLimit;

    public int getTeam1Score() {
        return this.team1Score;
    }

    /**
     * 
     * @param team1Score
     */
    public void setTeam1Score(int team1Score) {
        this.team1Score = team1Score;
    }

    public int getTeam2Score() {
        return this.team2Score;
    }

    /**
     * 
     * @param team2Score
     */
    public void setTeam2Score(int team2Score) {
        this.team2Score = team2Score;
    }

    public String displayScore() {
        // TODO - implement Score.displayScore
        throw new UnsupportedOperationException();
    }

    public int getScoreLimit() {
        return this.scoreLimit;
    }

    /**
     * 
     * @param scoreLimit
     */
    public void setScoreLimit(int scoreLimit) {
        this.scoreLimit = scoreLimit;
    }

}