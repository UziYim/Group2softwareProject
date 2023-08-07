/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public class GroupOfCards extends Card{

    //The group of cards, stored in an ArrayList
    protected ArrayList<Card> cards = new ArrayList<Card>();
    private int size;//the size of the grouping
    public GroupOfCards(int size) {
        Random random = new Random();
        int numberlimit = Card.Number.values().length;
        int suitlimit = Card.Suit.values().length;
        
        for(int i=0; i < size; i++){
            Card card = new Card(){
                @Override
                public String toString(){
                    return this.getNumber() + " of " + this.getSuit();
            }
            };
            card.setNumber(Card.Number.values()[random.nextInt(numberlimit)]);
            card.setSuit(Card.Suit.values()[random.nextInt(suitlimit)]);
            cards.add(card);
            
        }
    }
    
    public void removeCard(Card e){
        cards.remove(e);
    }
    
    public void addCard(){
        Random random = new Random();
        int numberlimit = Card.Number.values().length;
        int suitlimit = Card.Suit.values().length;
    Card card = new Card(){
                @Override
                public String toString(){
                    return this.getNumber() + " of " + this.getSuit();
            }
            };
            card.setNumber(Card.Number.values()[random.nextInt(numberlimit)]);
            card.setSuit(Card.Suit.values()[random.nextInt(suitlimit)]);
            cards.add(card);
    }

    /**
     * A method that will get the group of cards as an ArrayList
     *
     * @return the group of cards.
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the max size for the group of cards
     */
    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        String list = "";
        
        return list + cards;
    }
    
    
   

}//end class
