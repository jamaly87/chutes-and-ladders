package io.hamzaali.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class representing the game board.
 * It reflects the locations of Chutes and Ladders and the positions of Players.
 * Prepared by: Hamza Ali
 */
public class GameBoard {
private List<Chute> chutes;
private List<Ladder> ladders;
//Key represents "player" and Value represent "position on the board"
private Map<Player,Integer> playerPosition;

    public GameBoard() {
        this.playerPosition = new HashMap<>();
        putChutes();
        putLadders();
    }

    public List<Chute> getChutes() {
        return chutes;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public Map<Player, Integer> getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(Map<Player, Integer> playerPosition) {
        this.playerPosition = playerPosition;
    }

    /**
     * private method to establish the locations of Chutes on the board (based on the provided sample board)
     */
    //TODO think of a way to randomly generate Chute locations instead of hard coding the values.
    private void putChutes () {
        this.chutes= new ArrayList<>();
        this.chutes.add(new Chute(16,6));
        this.chutes.add(new Chute(49,11));
        this.chutes.add(new Chute(62,19));
        this.chutes.add(new Chute(87,24));
        this.chutes.add(new Chute(47,26));
        this.chutes.add(new Chute(56,53));
        this.chutes.add(new Chute(64,60));
        this.chutes.add(new Chute(93,73));
        this.chutes.add(new Chute(95,75));
        this.chutes.add(new Chute(78,98));
    }

    /**
     *  method to establish the locations of Ladders on the board (based on the provided sample board)
     */
    //TODO think of a way to randomly generate Ladder locations instead of hard coding the values.
    public void putLadders (){
        this.ladders= new ArrayList<>();
        this.ladders.add(new Ladder(1,38));
        this.ladders.add(new Ladder(4,14));
        this.ladders.add(new Ladder(9,31));
        this.ladders.add(new Ladder(21,42));
        this.ladders.add(new Ladder(28,84));
        this.ladders.add(new Ladder(36,44));
        this.ladders.add(new Ladder(51,67));
        this.ladders.add(new Ladder(71,91));
        this.ladders.add(new Ladder(80,100));
    }
}
