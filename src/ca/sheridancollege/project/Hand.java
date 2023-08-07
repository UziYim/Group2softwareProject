

package ca.sheridancollege.project;
/**
 * This class +++ Insert class description here +++
 *
 * @author Joshua Mahadeo
 */
public class Hand {
    private GroupOfCards current_hand;
    private int size;
    private int value;
    
    public Hand(int size){
        GroupOfCards current_Hand = new GroupOfCards(size);
        this.current_hand = current_Hand;
        this.size = size;
    }
    
    public void Add(){
        current_hand.addCard();
        this.size+=1;
    }
    
    public void Remove(Card e){
        current_hand.removeCard(e);
        this.size-=1;
    }
    
    public int getSize(){
       return this.size;
       
    }
    @Override
    public String toString(){
    return current_hand.toString();
    }

}
