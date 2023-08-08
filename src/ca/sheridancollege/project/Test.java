

package ca.sheridancollege.project;

import static ca.sheridancollege.project.Card.Number.TWO;
import static ca.sheridancollege.project.Card.Suit.HEARTS;

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
        System.out.println(group.getNumber());
        Card card;
        card = new Card (TWO, HEARTS) {
            @Override
            public String toString() {
                return "";
            }
        };
        System.out.println(card.getNumber());
    
    }
        
        
    }
     
}
