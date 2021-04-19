package ca.sheridancollege.project;

import ca.sheridancollege.project.GameScore;

public class EuchreGame extends Game {

    private GameScore gameScore;

    public EuchreGame(int currentGameNumber) {
        super("Euchre Game #", currentGameNumber);
        this.gameScore = new GameScore();
    }

    public GameScore getGameScore() {
        return gameScore;
    }

    public void setGameScore(GameScore gameScore) {
        this.gameScore = gameScore;
    }

    @Override
    public void play() {

    }

    public String welcomeMessage() {
        return ("Welcome to " + this.getName() + "!");
    }

    @Override
    public void declareWinner() {
    }
}
