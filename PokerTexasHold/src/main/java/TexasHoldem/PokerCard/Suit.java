package TexasHoldem.PokerCard;

public enum Suit {
    HEARTS('H'), CLUBS('C'), DIAMONDS('D'), SPADES('S');

    public final char symbol;

    Suit(char symbol) {
        this.symbol = symbol;
    }

}