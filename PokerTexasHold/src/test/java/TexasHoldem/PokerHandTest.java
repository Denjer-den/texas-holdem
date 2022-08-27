package TexasHoldem;

import TexasHoldem.HandEvaluator.Combination;
import junit.framework.TestCase;

public class PokerHandTest extends TestCase {
    String royalFlashHand = "TS JS QS KS AS";

    public void testGetCombination() {
        assertEquals(Combination.ROYAL_FLASH, new PokerHand(royalFlashHand).getCombination());
    }

    public void testCompareTo() {

        String highHand = "KC 2H 5C JD TD";
        PokerHand pokerHand1 = new PokerHand(highHand);

        String fullHouse1 = "2C 2S 3S 3C 3D";
        PokerHand pokerHand2 = new PokerHand(fullHouse1);

        int result = pokerHand1.compareTo(pokerHand2);
        assertTrue(result > 0);

        String fullHouse2 = "4C 4S 5S 5C 5D";
        PokerHand pokerHand3 = new PokerHand(fullHouse2);
        result = pokerHand3.compareTo(pokerHand2);
        assertTrue(result < 0);

        PokerHand pokerHand4 = new PokerHand(royalFlashHand);
        result = pokerHand4.compareTo(pokerHand2);
        assertTrue(result < 0);

        String fullHouseHand3 = "4C 4S 5S 5C 5D";
        PokerHand pokerHand5 = new PokerHand(fullHouseHand3);
        result = pokerHand5.compareTo(pokerHand3);
        assertEquals(0, result);
    }
}