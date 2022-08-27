import TexasHoldem.PokerHand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        PokerHand highHand = new PokerHand("KC 2H 5C JD TD");
        PokerHand highHand2 = new PokerHand("KC 2H AC JD TD");
        PokerHand onePair = new PokerHand("6S 6D JS 4H 8S");
        PokerHand onePair2 = new PokerHand("TS TD JS 4H 8S");
        PokerHand twoPair = new PokerHand("6S 6D JS 8H 8S");
        PokerHand twoPair2 = new PokerHand("6S 6D JS TH TS");
        PokerHand threeOfAKind = new PokerHand("9S 3D 3S 3C AS");
        PokerHand threeOfAKind2 = new PokerHand("9S 4D 4S 4C AS");
        PokerHand straight = new PokerHand("8C 9S TS JC QD");
        PokerHand straight2 = new PokerHand("9C TS JS QC KD");
        PokerHand flush = new PokerHand("6D KD 3D 4D 8D");
        PokerHand flush2 = new PokerHand("6D AD 3D 4D 8D");
        PokerHand fullHouse = new PokerHand("7D 7S TC TD TS");
        PokerHand fullHouse2 = new PokerHand("7D 7S QC QD QS");
        PokerHand fourOfAKind = new PokerHand("QD QS QC QC 5S");
        PokerHand fourOfAKind2 = new PokerHand("KD KS KC KC 5S");
        PokerHand straightFlush = new PokerHand("2S 3S 4S 5S 6S");
        PokerHand straightFlush2 = new PokerHand("3D 4D 5D 6D 7D");
        PokerHand flushRoyal = new PokerHand("TD JD QD KD AD");

        List<PokerHand> pokerHands = new ArrayList<>();
        pokerHands.add(highHand);
        pokerHands.add(onePair);
        pokerHands.add(fourOfAKind2);
        pokerHands.add(twoPair);
        pokerHands.add(threeOfAKind);
        pokerHands.add(straightFlush);
        pokerHands.add(twoPair2);
        pokerHands.add(threeOfAKind2);
        pokerHands.add(straight);
        pokerHands.add(fullHouse2);
        pokerHands.add(straight2);
        pokerHands.add(flush);
        pokerHands.add(fullHouse);
        pokerHands.add(onePair2);
        pokerHands.add(fourOfAKind);
        pokerHands.add(flush2);
        pokerHands.add(straightFlush2);
        pokerHands.add(highHand2);
        pokerHands.add(flushRoyal);


        pokerHands.forEach(System.out::println);
        System.out.println("------------------------------------------------------------------");

        Collections.sort(pokerHands);

        pokerHands.forEach(System.out::println);
        System.out.println("Win hand" + pokerHands.get(0));


    }
}
