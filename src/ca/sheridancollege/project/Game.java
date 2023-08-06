/**
 * SYST 17796 Project Base code.
 * Group 2
 * @authors Thomas Chau
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The class that models the game.
 * @author Thomas
 */

public abstract class Game {

    private final int WIN_SCORE =21;
    private final int DEALER_HIT_THRESHOLD = 17;
    private final int listofPlayers;
    private final String name;//the title of the game
    private ArrayList<Player> listofPlayers;// the players of the game

    
    public Game(String name) {
        this.name = name;
        players = new ArrayList<>();
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
        return players;
    }

    /**
     * @param players the players of this game
     */
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

 

    
    //array that asks the user to input how many people are going to play the game.
    public void play()
    {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Welcome to our blackjack game");
        
        while (true)
        {
            System.out.println("How many players are playing?");
            int numPlayers = input.nextInt();
            for (int i = 0; i < numPlayers; i++)
            {
                Player player = new Player("Player " + i);
                listofPlayers.add(player);
            }
        }
    }
    
    private void playPlayerTurn(Player player, Scanner input)
    {
        while (!player.finish())
        {
            // To display the players current hand value
            System.out.println("Your current hand value is: " + player.getHandValue()); 
        }
            // To check if the players hand value is greater than or equal to the WIN_SCORE variable
            if (player.getHandValue() >= WIN_SCORE)
            {
                player.finish(true);
                break;
            }
            
            // Program will ask the player if they want to hit or stand
            System.out.print("Would you like to hit or stand? (H/S): ");
            String choice = input.next();
            if (choice.equalsIgnoreCase("H"))
            {
                player.addCard(deck.dealCard());
            }
            else if (choice.equalsIgnoreCase("S"));
            {
                player.finish(true);
            }
            
    }
        
    
    
    
    /**
     * To make it so that the dealer doesn't get any more cards after the dealer reaches 17.
     */
    
    private abstract void playDealerTurn()
    {
        while (dealer.getHandValue() < DEALER_HIT_THRESHOLD)
        {
            dealer.addCard(deck.dealCard());
        }
    }
    
    
    /**
     * When the game is over, use this method to declare and display a winner.
     */
    public abstract void declareWinner();
    int dealerScore = dealer.getHandValue();
    for (Player player : getPlayers())
    {
        int playerScore = player.getHandValue();
        
        if (playerScore <= WIN_SCORE && (playerScore > dealerScore || dealerScore > WIN_SCORE))
        {
            System.out.println(player.getName() + " won.");
        }
        else if (playerScore == dealerScore)
        {
            System.out.println(player.getName() + " has tied with the dealer.");
        }
        else 
        {
            System.out.println(player.getName() + " lost.");
        }
    }
    
}
//end class
