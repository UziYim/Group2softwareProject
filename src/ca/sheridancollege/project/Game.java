/**
 * SYST 17796 Project Base code.
 * Group 2
 *
 * @author Thomas Chau
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The class that models the game.
 *
 * @author Thomas
 */
public abstract class Game {

    private final int WIN_SCORE = 21;
    private final int DEALER_HIT_THRESHOLD = 17;
    private final int listofPlayers;
    private final String name;//the title of the game
    private ArrayList<Player> listOfPlayers; // the players of the game
    private Player player;
    private Deck deck;

    public Game(String name) {
        this.name = name;
        listOfPlayers = new ArrayList<>();
        deck = new Deck();
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the players of this game
     */
    public ArrayList<Player> getPlayers() {
        return listOfPlayers;
    }

    /**
     * Method to start the game, will ask how the users how many players are going to play
     */
    public void play() {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to our blackjack game");

        while (true) {
            System.out.println("How many players are playing?");
            int numPlayers = input.nextInt();
            for (int i = 0; i < numPlayers; i++) {
                Player player = new Player("Player " + (i + 1));
                listOfPlayers.add(player);
            }
            deck.shuffle();

            // To deal two cards to each player and to the dealer
            for (int i = 0; i < 2; i++) {
                for (Player player : listOfPlayers) {
                    player.addCard(deck.dealCard());
                }
            }

            // To let each player play their turn
            for (Player player : listOfPlayers) {
                playPlayerTurn(player, input);
            }

            // Playing the dealers turn
            playDealerTurn();

            // Declare winner
            declareWinner();
        }
    
    
    

    private void playPlayerTurn(Player player, Scanner input) {
        while (!player.finish() && !player.Bust()) {

            // To display the players current hand value
            System.out.println("Player " + (listOfPlayers.indexOf(player) + 1) + "your current hand value is: " + player.getHandValue());

            // To check if the players hand value is greater than or equal to the WIN_SCORE variable
            if (player.getHandValue() >= WIN_SCORE) {
                player.finish(true);
                break;
            }

            // Program will ask the player if they want to hit or stand according to their hand value
            System.out.print("Would you like to hit or stand? (H/S): ");
            String choice = input.next();
            if (choice.equalsIgnoreCase("H")) {
                player.addCard(deck.dealCard());
            } else if (choice.equalsIgnoreCase("S"));
            {
                player.finish(true);
            }
        }
    }

    /**
     * To make it so that the dealer doesn't get any more cards after the dealer reaches 17.
     */
    private void playDealerTurn() {
        Player dealer = new Player();
        dealer.addCard(deck.dealCard());

        while (dealer.getHandValue() < DEALER_HIT_THRESHOLD) {
            dealer.addCard(deck.dealCard());
        }
        listOfPlayers.add(dealer);
    }

    /**
     * When the game is over, use this method to declare and display a winner.
     */
    public void declareWinner();

    {
        int dealerScore = listOfPlayers.get(listOfPlayers.size() - 1).getHandValue();

        for (Player player : listOfPlayers) {
            int playerScore = player.getHandValue();

            if (player.Bust()) {
                System.out.println("Player " + listOfPlayers.indexOf(player) + 1 + " busted and lost.");
            } else if (playerScore <= WIN_SCORE && (playerScore > dealerScore || dealerScore > WIN_SCORE)) {
                System.out.println("Player " + (listOfPlayers.indexOf(player) + 1) + " wins.");
            } else if (playerScore == dealerScore) {
                System.out.println("Player " + (listOfPlayers.indexOf(player) + 1) + " tied with the dealer.");
            } else {
                System.out.println("Player " + (listOfPlayers.indexOf(player) + 1) + " lost.");
            }
        }

    }
}
//end class
