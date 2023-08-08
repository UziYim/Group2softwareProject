/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
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
public class GroupOfCardsTest {
    
    public GroupOfCardsTest() {
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
     * Test of removeCard method, of class GroupOfCards.
     */
    @Test
    public void testRemoveCard() {
        System.out.println("removeCard");
        int e = 1;
        GroupOfCards instance = new GroupOfCards(5);
        instance.removeCard(e);
        boolean expResult = true;
        boolean result = instance.getSize() == 4;
        assertEquals(expResult, result);
    }

    /**
     * Test of addCard method, of class GroupOfCards.
     */
    @Test
    public void testAddCard_0args() {
        System.out.println("addCard");
        GroupOfCards instance = new GroupOfCards(5);
        instance.addCard();
        boolean expResult = true;
        boolean result = instance.getSize() == 6;
        assertEquals(expResult, result);
    }

    /**
     * Test of addCard method, of class GroupOfCards.
     */
    @Test
    public void testAddCard_Card() {
        System.out.println("addCard");
        Card e = null;
        GroupOfCards instance = new GroupOfCards(5);
        instance.addCard();
        boolean expResult = true;
        boolean result = instance.getSize() == 6;
        assertEquals(expResult, result);
    }

    /**
     * Test of getSize method, of class GroupOfCards.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        GroupOfCards instance = new GroupOfCards(5);
        int size = 5;
        boolean expResult = true;
        boolean result = instance.getSize() == size;
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setSize method, of class GroupOfCards.
     */
    @Test
    public void testSetSize() {
        System.out.println("setSize");
        int size = 0;
        GroupOfCards instance = new GroupOfCards(5);
        instance.setSize(size);
        boolean expResult = true;
        boolean result = instance.getSize() == size;
        assertEquals(expResult, result);
    }
    
}
