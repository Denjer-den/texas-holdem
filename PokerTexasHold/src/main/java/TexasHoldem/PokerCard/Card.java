package TexasHoldem.PokerCard;

public class Card {

    private final CardRank cardRank;
    private final Suit suit;

    public Card(CardRank cardRank, Suit suit) {
        this.cardRank = cardRank;
        this.suit = suit;
    }

    public static Card cardParse(String card) {
        Suit resultCardSuit = null;
        CardRank resultCardRank = null;

        char suitSymbol = card.charAt(card.length() - 1);

        for (Suit suit : Suit.values()) {
            if (suit.symbol == suitSymbol) {
                resultCardSuit = suit;
                break;
            }
        }

        String ranksStrength = card.substring(0, card.length() - 1);
        for (CardRank rank : CardRank.values()) {
            if (rank.name.equals(ranksStrength)) {
                resultCardRank = rank;
                break;
            }
        }

        return new Card(resultCardRank, resultCardSuit);
    }

    @Override
    public String toString() {
        return cardRank + " " + suit;
    }

    public CardRank getCardRank() {
        return cardRank;
    }

    public Suit getSuit() {
        return suit;
    }
}
