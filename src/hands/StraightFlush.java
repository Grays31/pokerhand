package hands;

import entities.Card;

import java.util.TreeSet;

public class StraightFlush extends Straight {

    public StraightFlush(TreeSet<Card> straight) {
        super(straight);

        this.handsType = Hands.STRAIGHT_FLUSH;

        // Check same color
        if (!isSameColorForAllCards(straight))
            throw new IllegalArgumentException("Invalid straight flush provided (cards must be same color)");
    }
}
