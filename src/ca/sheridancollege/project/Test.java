

package ca.sheridancollege.project;

/**
 * This class +++ Insert class description here +++
 *
 * @author Joshua Mahadeo
 */
public class Test {

    public static void main(String[] args){
    
        GroupOfCards group = new GroupOfCards(6);
        
        Hand hand = new Hand(2);
        
        System.out.println(group.getCards());
        //System.out.println(group.toString());
        System.out.println(hand.toString());
        System.out.println(hand.getHandValue());
        
    }
     
}
