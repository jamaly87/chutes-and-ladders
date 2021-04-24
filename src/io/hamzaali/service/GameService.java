package io.hamzaali.service;

import io.hamzaali.model.Chute;
import io.hamzaali.model.GameBoard;
import io.hamzaali.model.Ladder;
import io.hamzaali.model.Player;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Game Service class which implements the game's logic
 * Prepared by: Hamza
 */

public class GameService {
private GameBoard board;
private List<Player> players; //List of players in the game
private static final int BOARDSIZE = 100;

    public GameService() {
        this.board = new GameBoard();
        this.players = new ArrayList<>();
    }


    /**
     * private method to initialize the game players and set their starting locations.
     */
    public void setPlayersAndStaringLocations(List<Player> playerList){
        this.players = new ArrayList<>();
        //Set player location to 0
        Map<Player , Integer > playerPosition = new HashMap<>();
        for (Player player : playerList){
            //Add players to list
            this.players.add(player);
            playerPosition.put(player,0);
        }
        board.setPlayerPosition(playerPosition);
    }

    /**
     * Moves a player based on the number of steps generated from the spinner.
     * @param player - A given player to move
     * @param steps - number of steps to move ranges from (1-6)
     * @return The method returns True when a player reaches to the 100th square
     */
    public boolean movePlayer (Player player, int steps){
        int position = board.getPlayerPosition().get(player);
        int updatedPosition = position + steps;
        /*check if the updated position is larger than the default board size
         * if it is "True" then the player's position remains unchanged.
         */
        if (updatedPosition>BOARDSIZE) {
            updatedPosition=position;
        }

        //If the player lands on a chute or a ladder update the position accordingly
        updatedPosition=changePositionDueToChuteOrLadder(player, updatedPosition);
        if (updatedPosition==100){
            return true;
        } else {
            board.getPlayerPosition().put(player, updatedPosition);
            return false;
        }
    }

    /**
     * Method updates the player position in case encountering a Chute or a Ladder
     * Sets the Player status on the board to be displayed on the console
     * @param player - current player
     * @param updatedPosition - position after spinning
     * @return the new position if affected by a Chute or Ladder
     */
    private int changePositionDueToChuteOrLadder (Player player, int updatedPosition){
        int position = updatedPosition;
        // Check whether the player has landed on a Chute
        for (Chute chute : board.getChutes()) {
            if (updatedPosition == chute.getStart()) {
                updatedPosition = chute.getEnd();
                //set the status of the player to display on the screen
                player.setPlayerStatus(player + ": " + board.getPlayerPosition().get(player) + "---->"
                        + chute.getStart() + "---CHUTE---> " + chute.getEnd());
                return updatedPosition;
            }
        }
            //Check whether the player has landed on a Ladder
            for (Ladder ladder : board.getLadders()){
                if (updatedPosition == ladder.getStart()){
                    updatedPosition= ladder.getEnd();
                    //set the status of the player to display on the screen
                    player.setPlayerStatus(player+": "+board.getPlayerPosition().get(player)+"---->"
                            +ladder.getStart()+"--LADDER--> "+ladder.getEnd());
                    return updatedPosition;
                }
            }

            // The player doesn't encounter neither a chute nor a ladder
            player.setPlayerStatus(player+": "+board.getPlayerPosition().get(player)+
                    " ------> "+updatedPosition);
            return updatedPosition;
    }
}
