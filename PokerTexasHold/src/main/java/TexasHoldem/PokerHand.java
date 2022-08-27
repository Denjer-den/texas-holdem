package TexasHoldem;

import TexasHoldem.HandEvaluator.Combination;
import TexasHoldem.HandEvaluator.HandEvaluator;
import TexasHoldem.PokerCard.Card;

import java.util.*;
import java.util.ArrayList;


public class PokerHand implements Comparable<PokerHand> {

    private final List<Card> hand = new ArrayList<>(5);

    public PokerHand(String pokerHand) {
        String[] cards = pokerHand.split(" ");

        Arrays.stream(cards).forEach(card -> hand.add(Card.cardParse(card)));

    }

    public List<Card> getHand() {
        return hand;
    }

    public Combination getCombination() {
        return new HandEvaluator(this).getCombination();
    }

    @Override
    public String toString() {
        return "Hand{hand=" + hand + "} " + "Combination : " + getCombination().toString();
    }

    @Override
    public int compareTo(PokerHand otherHand) {
        int result = getCombination().compareTo(new HandEvaluator(otherHand).getCombination());

        if (result != 0) {
            return result;
        }

        return HandEvaluator.compareHandIfEqualCombination(this, otherHand);
    }
}
