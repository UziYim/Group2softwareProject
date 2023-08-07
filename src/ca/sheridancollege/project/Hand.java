

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
    

    public void add(){
        current_hand.addCard();
        this.size+=1;
    }
    
    public void add(Card e){
        current_hand.addCard(e);
        this.size+=1;
    }
    
    public void remove(int e){
        current_hand.removeCard(e);
        this.size-=1;
    }
    public void remove(Card e){
        current_hand.removeCard(e);
        this.size-=1;
    }
    
    public int getSize(){
       return this.size;
       
    }

    public int getHandValue()
    {
        int position = 1; 
        int hold = 0; 
        //Make edits for this later, need to lookup how to iterate through a enum again
       for(int i =0; i = size; i++)
           {
        for(Numbers n: Number.values())
            {
                if(current_hand.get(i).getNumber() == n.value)
                {
                    hold+=position; 
                }
                if(position <10 )
                {
                    position++; 
                }
            }
               position =1; 
           }
        return value; 
    }
    
    @Override
    public String toString(){
    return current_hand.toString();
    }

}
