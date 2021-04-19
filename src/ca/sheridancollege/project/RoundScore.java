package ca.sheridancollege.project;

public class RoundScore extends Score {

    //Max 5 tricks
    private final int MAX_SCORE = 5;

    public RoundScore() {
        setScoreLimit(MAX_SCORE);
    }

    public void addTrick(EuchrePlayer winningPlayer) {
        if (winningPlayer.getTeam() == 1) {
            addScoreTeam1(1);
        }
        else {
             addScoreTeam2(1);
        }
    }

    //debug only
    public String toString() {
        String out = String.format("Round Score:\nTeam 1 - %s\nTeam 2 - %s\n", getTeam1Score(), getTeam2Score());
        return out;

    }
}
