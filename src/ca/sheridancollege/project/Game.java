/**
 * SYST 17796 Project Base code.
 * Group 2
 *
 * @author Thomas Chau
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

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
    private Player dealer = new Player("Dealer") {}; 
    //Edit from Sam, Deck is a groupofcards and changing it to protected so other classes can use it. 
    protected GroupOfCards deck;

    public Game(String name) {
        this.name = name;
        listOfPlayers = new ArrayList<>();
        deck = new GroupOfCards(52);
    }

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
            
            //Edit by Sam doing a try and catch thing here incase the user enters wrong input
            try {
                int numPlayers = input.nextInt();
            }
            catch(Exception e)
                {
                    System.out.println("Error, not a valid input. Will default to 1 player."); 
                    numPlayers = 1; 
                }
            //For easy access to remove dealer. 
            listOfPlayers.add(dealer); 
            
            for (int i = 0; i < numPlayers; i++) {
                Player player = new Player("Player " + (i + 1)){};
                listOfPlayers.add(player);
            }
            
            deck.shuffle();
            
            //To remove dealer from the player turns. 
            dealer = listOfPlayers.get(0); 
            listOfPlayers.remove(0); 
            
            // To let each player play their turn
            for (Player player : listOfPlayers) {
                playPlayerTurn(player, input);
            }
            // Playing the dealers turn
            playDealerTurn();

            // Declare winner
            declareWinner();
        }
    }
    // To deal two cards to each player, Deck must be shuffled. 
        private void dealHands()
        {
            for (int i = 0; i < 2; i++) {
                for (Player player : listOfPlayers) {
                    //Takes the top card of the deck and deals it to the players.
                    deck.addCard(player); 
                }
            }

        }


    
    private void playPlayerTurn(Player player, Scanner input) {
        // Edit Changing the condition to only check if player is finished. 
        while (!(player.finish)) {

            // To display the players current hand value
            System.out.println("Player " + (listOfPlayers.indexOf(player) + 1) + "your current hand value is: " + player.hand.getHandValue());

            
            //Will automatically stand the player. 
            // To check if the players hand value is greater than or equal to the WIN_SCORE variable
            if (player.hand.getHandValue() >= WIN_SCORE) {
                player.stand();
                break;
                }
                
            
            // Program will ask the player if they want to hit or stand according to their hand value
            System.out.print("Would you like to hit or stand? (H/S): ");
            String choice = input.next();
            if (choice.equalsIgnoreCase("H")) {
                player.hit(); 
            } else if (choice.equalsIgnoreCase("S"));
            {
                player.stand(); 
            }
        }
    }

    /**
     * To make it so that the dealer doesn't get any more cards after the dealer reaches 17.
     */
    private void playDealerTurn() {
        while (dealer.hand.getHandValue() < DEALER_HIT_THRESHOLD) {
            dealer.hit(); 
        }
        dealer.stand(); 
    }

    /**
     * When the game is over, use this method to declare and display a winner.
     */
    public void declareWinner()
    {
        int dealerScore = dealer.hand.getHandValue(); 
        
        for (Player player : listOfPlayers) {
            int playerScore = player.hand.getHandValue();

            if (player.hand.getHandValue() > WIN_SCORE) {
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