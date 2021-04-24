package io.hamzaali.model;
/**
 * Class representing the Player Object
 * Contains normal getter methods and a setter method for the playerStatus
 * Prepared by: Hamza Ali
 */
public class Player {
    private String playerName;
    private String playerStatus;

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getPlayerStatus() {
        return playerStatus;
    }

    public void setPlayerStatus(String playerStatus) {
        this.playerStatus = playerStatus;
    }

    @Override
    public String toString() {
        return playerName ;
    }
}
