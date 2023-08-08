/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ca.sheridancollege.project;

import static ca.sheridancollege.project.Card.Number.*;
import static ca.sheridancollege.project.Card.Suit.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author joshm
 */
public class CardTest {
    
    public CardTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getNumber method, of class Card.
     */
    @Test
    public void testGetNumberGood() {
        System.out.println("getNumberGood");
        Card instance = new Card(TWO, HEARTS) {
            @Override
            public String toString() {
            return " ";
            }
        };
        Card.Number number = TWO;
        boolean expResult = true;
        boolean result = instance.getNumber() == number;
        assertEquals(expResult, result);
    }
    @Test
    public void testGetNumberBad() {
        System.out.println("getNumberBad");
        Card instance = new Card(TWO, HEARTS) {
            @Override
            public String toString() {
            return " ";
            }
        };
        int number = 2;
        boolean expResult = false;
        boolean result = instance.getNumber().equals(number);
        assertEquals(expResult, result);
    }
    @Test
    public void testGetNumberBoundary() {
        System.out.println("getNumberBoundary");
        Card instance = new Card(KING, HEARTS) {
            @Override
            public String toString() {
            return " ";
            }
        };
        Card.Number number = QUEEN;
        boolean expResult = false;
        boolean result = instance.getNumber() == number;
        assertEquals(expResult, result);
    }

    /**
     * Test of setNumber method, of class Card.
     */
    @Test
    public void testSetNumberGood() {
        System.out.println("setNumberGood");
       
        Card instance = new Card(TWO, HEARTS) {
            @Override
            public String toString() {
            return " ";
            }
        }; 
        Card.Number number = THREE;
        instance.setNumber(THREE);
        boolean expResult = true;
        boolean result = instance.getNumber() == number;
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testSetNumberBad() {
        System.out.println("setNumberBad");
       
        Card instance = new Card(TWO, HEARTS) {
            @Override
            public String toString() {
            return " ";
            }
        }; 
        Card.Number number = TWO;
        instance.setNumber(THREE);
        boolean expResult = false;
        boolean result = instance.getNumber() == number;
        assertEquals(expResult, result);
        
    }
    @Test
    public void testSetNumberBoundary() {
        System.out.println("setNumberBoundary");
       
        Card instance = new Card(TWO, HEARTS) {
            @Override
            public String toString() {
            return " ";
            }
        }; 
        Card.Number number = QUEEN;
        instance.setNumber(JACK);
        boolean expResult = false;
        boolean result = instance.getNumber() == number;
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getSuit method, of class Card.
     */
    @Test
    public void testGetSuitGood() {
        System.out.println("getSuitGood");
        Card instance = new Card(TWO, HEARTS) {
            @Override
            public String toString() {
            return " ";
            }
        }; 
        Card.Suit suit = HEARTS;
        boolean expResult = true;
        boolean result = instance.getSuit() == suit;
        assertEquals(expResult, result);
        
    }
    @Test
    public void testGetSuitBad() {
        System.out.println("getSuitBad");
        Card instance = new Card(TWO, SPADES) {
            @Override
            public String toString() {
            return " ";
            }
        }; 
        Card.Suit suit = HEARTS;
        boolean expResult = false;
        boolean result = instance.getSuit() == suit;
        assertEquals(expResult, result);
        
    }
    @Test
    public void testGetSuitBoundary() {
        System.out.println("getSuitBoundary");
        Card instance = new Card(TWO, CLUBS) {
            @Override
            public String toString() {
            return " ";
            }
        }; 
        Card.Suit suit = DIAMONDS;
        boolean expResult = false;
        boolean result = instance.getSuit() == suit;
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setSuit method, of class Card.
     */
    @Test
    public void testSetSuitGood() {
        System.out.println("setSuitGood");
        
        Card instance = new Card(TWO, SPADES) {
            @Override
            public String toString() {
            return " ";
            }
        }; 
        Card.Suit suit = CLUBS;
        instance.setSuit(CLUBS);
        boolean expResult = true;
        boolean result = instance.getSuit() == suit;
        assertEquals(expResult, result);
        
    }
    @Test
    public void testSetSuitBad() {
        System.out.println("setSuitBad");
        
        Card instance = new Card(TWO, SPADES) {
            @Override
            public String toString() {
            return " ";
            }
        }; 
        Card.Suit suit = HEARTS;
        instance.setSuit(CLUBS);
        boolean expResult = false;
        boolean result = instance.getSuit() == suit;
        assertEquals(expResult, result);
        
    }
    @Test
    public void testSetSuitBoundary() {
        System.out.println("setSuitBoundary");
        
        Card instance = new Card(TWO, SPADES) {
            @Override
            public String toString() {
            return " ";
            }
        }; 
        Card.Suit suit = SPADES;
        instance.setSuit(CLUBS);
        boolean expResult = false;
        boolean result = instance.getSuit() == suit;
        assertEquals(expResult, result);
        
    }

    public class CardImpl extends Card {

        public String toString() {
            return "";
        }
    }
    
}
