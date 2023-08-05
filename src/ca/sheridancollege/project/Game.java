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
    private final String name;//the title of the game
    private ArrayList<Player> players;// the players of the game

    
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

    /**
     * Play the game. This might be one method or many method calls depending on your game.
     */
    public abstract void play();

    
    
    /**
     * To make it so that the dealer doesn't get any more cards after the dealer reaches 17
     */
    
    private abstract void playDealerTurn()
    {
        while (dealer.getHandValue() < DEALER_HIT_THRESHOLD)
        {
            dealer.addCard(deck.dealCard());
        }
    }
    
    
    /**
     * When the game is over, use this method to declare and display a winner
     */
    public abstract void declareWinner();
    int dealerScore = dealer.getHandValue();
    for (Player player : getPlayers())
    {
        int plaerScore = player.getHandValue();
        
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
    
}//end class
