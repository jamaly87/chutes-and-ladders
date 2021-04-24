package io.hamzaali;

import io.hamzaali.model.Player;
import io.hamzaali.service.GameService;
import io.hamzaali.service.SpinnerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChutesAndLaddersGame {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //Enter the number of Players (1-4)
        int numOfPlayers = 0;
        while (numOfPlayers <= 0 || numOfPlayers > 4) {
            System.out.println("Please Enter the Number of Players (1-4): ");
            numOfPlayers = scanner.nextInt();
            //TODO Implement a condition to throw an exception if the number of players more than 4
        }

        //Initialize each player and add them to the Player List.
        List<Player> playerList = new ArrayList<>();
        for (int i = 1; i <= numOfPlayers; i++) {
            //Scanner nameEntry = new Scanner(System.in);
            System.out.println("Please enter Player" + i + " name");
            playerList.add(new Player(scanner.next()));
        }

        //Initialize GameService and set the players and their starting locations.
        GameService gameService = new GameService();
        gameService.setPlayersAndStaringLocations(playerList);

        //TODO - It is better to implement the logic below in the game service class to keep the main method cleaner
        //TODO - Make the game interactive by allowing player input during their turns (i.e prompt the player to spin)

        //Loop until one of the players gets to the 100th square
        //Players will take turns consecutively by incrementing the player number after each turn
        boolean gameWon = false;
        int playerTurnCounter = 0;
        int playerNumber = 0;
        while (!gameWon) {
            Player currentPlayer = playerList.get(playerNumber);
            int spin = SpinnerService.spin();
            gameWon = gameService.movePlayer(currentPlayer, spin);
            playerTurnCounter++;
            System.out.println(currentPlayer+" Spun to number "+spin);
            System.out.println(playerTurnCounter + ": " + currentPlayer.getPlayerStatus());

            //When a player wins the game then make an announcement and end the game.
            if (gameWon) {
                System.out.println("The winner is " + currentPlayer);
            }
            //Move to the next player's turn
            playerNumber++;
            //When we reach to the last player's turn; we reset the playerNumber to start over.
            if (playerNumber == numOfPlayers) {
                playerNumber = 0;
            }
        }
    }
}
