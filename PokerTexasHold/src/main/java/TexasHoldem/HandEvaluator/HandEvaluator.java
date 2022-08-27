package TexasHoldem.HandEvaluator;

import TexasHoldem.PokerCard.Card;
import TexasHoldem.PokerCard.CardRank;
import TexasHoldem.PokerCard.Suit;
import TexasHoldem.PokerHand;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HandEvaluator {
    private final List<Card> hand;
    private final Map<CardRank, Integer> ranksMap;

    public HandEvaluator(PokerHand hand) {
        this.hand = getSortedCards(hand);
        ranksMap = getRanksCountsMap(this.hand);
    }

    private static Map<CardRank, Integer> getRanksCountsMap(List<Card> hand) {
        Map<CardRank, Integer> rankMap = new HashMap<>();

        for (Card card : hand) {
            if (rankMap.containsKey(card.getCardRank())) {
                rankMap.put(card.getCardRank(), rankMap.get(card.getCardRank()) + 1);
            } else {
                rankMap.put(card.getCardRank(), 1);
            }
        }

        return rankMap;
    }

    private static List<Card> getSortedCards(PokerHand hand) {
        hand.getHand().sort(Comparator.comparing(Card::getCardRank));
        return hand.getHand();
    }

    public Combination getCombination() {

        if (isHighCard()) return Combination.HIGH_HAND;
        if (isPair()) return Combination.ONE_PAIR;
        if (isTwoPairs()) return Combination.TWO_PAIRS;
        if (isThreeOfAKind()) return Combination.THREE_OF_A_KIND;
        if (isFullHouse()) return Combination.FULL_HOUSE;
        if (isFourOfAKind()) return Combination.FOUR_OF_A_KIND;

        if (isFlush(hand)) {
            if (isStraight(hand)) {
                if (hand.get(0).getCardRank() == CardRank.TEN) {
                    return Combination.ROYAL_FLASH;
                }
                return Combination.STRAIGHT_FLUSH;
            }
        }
        if (isStraight(hand)) return Combination.STRAIGHT;

        return Combination.FLUSH;
    }

    private boolean isHighCard() {
        //check case (AC 2C 3C 4C 5C)"
        if (isFlush(hand)) return false;
        if (isStraight(hand)) return false;

        return ranksMap.values().size() == 5;
    }

    private boolean isPair() {
        return ranksMap.values().size() == 4;
    }

    private boolean isTwoPairs() {
        return ranksMap.containsValue(2) && ranksMap.values().size() == 3;
    }

    private boolean isThreeOfAKind() {
        return ranksMap.containsValue(3) && ranksMap.containsValue(1);
    }

    private boolean isFullHouse() {
        return ranksMap.containsValue(3) && ranksMap.containsValue(2);
    }

    private boolean isFourOfAKind() {
        return ranksMap.containsValue(4);
    }

    private boolean isStraight(List<Card> cards) {
        return (cards.get(0).getCardRank().value == cards.get(1).getCardRank().value - 1 &&
                cards.get(1).getCardRank().value == cards.get(2).getCardRank().value - 1 &&
                cards.get(2).getCardRank().value == cards.get(3).getCardRank().value - 1 &&
                cards.get(3).getCardRank().value == cards.get(4).getCardRank().value - 1);
    }

    private boolean isFlush(List<Card> cards) {
        Suit suit = cards.get(0).getSuit();

        for (Card card : cards) {
            if (card.getSuit() != suit) {
                return false;
            }
        }

        return true;
    }

    public static int compareHandIfEqualCombination(PokerHand pokerHand1, PokerHand pokerHand2) {
        List<Card> sortedHand1 = getSortedCards(pokerHand1);
        List<Card> sortedHand2 = getSortedCards(pokerHand2);

        if (pokerHand1.getCombination() == Combination.HIGH_HAND ||
                pokerHand1.getCombination() == Combination.STRAIGHT ||
                pokerHand1.getCombination() == Combination.FLUSH ||
                pokerHand1.getCombination() == Combination.STRAIGHT_FLUSH) {
            return Integer.compare(sortedHand2.get(4).getCardRank().value, sortedHand1.get(4).getCardRank().value);
        }

        if (pokerHand1.getCombination() == Combination.ONE_PAIR) {

            int cardRank1 = 0;

            for (Map.Entry<CardRank, Integer> entry : getRanksCountsMap(sortedHand1).entrySet()) {
                if (2 == entry.getValue()) {
                    cardRank1 = entry.getKey().value;
                }
            }

            int cardRank2 = 0;

            for (Map.Entry<CardRank, Integer> entry : getRanksCountsMap(sortedHand2).entrySet()) {
                if (2 == entry.getValue()) {
                    cardRank2 = entry.getKey().value;
                }
            }

            return Integer.compare(cardRank2, cardRank1);
        }

        if (pokerHand1.getCombination() == Combination.TWO_PAIRS) {
            return Integer.compare(sortedHand2.get(3).getCardRank().value, sortedHand1.get(3).getCardRank().value);
        }

        if (pokerHand1.getCombination() == Combination.THREE_OF_A_KIND ||
                pokerHand1.getCombination() == Combination.FOUR_OF_A_KIND ||
                pokerHand1.getCombination() == Combination.FULL_HOUSE) {
            return Integer.compare(sortedHand2.get(2).getCardRank().value, sortedHand1.get(2).getCardRank().value);
        }

        return 0;

    }
}
