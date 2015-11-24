package hands;

import constants.Value;
import entities.Card;

import java.util.TreeSet;

/**
 *
 */
public class TwoPair extends AbstractHand {
    /**
     *
     */
    private TreeSet<Card> firstPair;

    /**
     *
     */
    private TreeSet<Card> secondPair;

    /**
     *
     */
    private Card lastCard;

    /**
     *
     * @param firstPair
     * @param secondPair
     * @param lastCard
     */
    public TwoPair(TreeSet<Card> firstPair, TreeSet<Card> secondPair, Card lastCard) {
        this.handsType = Hands.TWO_PAIR;

        // Check sizes
        if (firstPair.size() != 2)
            throw new IllegalArgumentException("First pair cards number invalid (must be 2)");
        if (secondPair.size() != 2)
            throw new IllegalArgumentException("Second pair cards number invalid (must be 2)");

        this.firstPair = firstPair;
        this.secondPair = secondPair;
        this.lastCard = lastCard;
    }

    @Override
    public int compareTo(AbstractHand o) {
        // If hands type different
        if (handsType != o.handsType) {
            return super.compareTo(o);
        } else {
            TwoPair other = (TwoPair) o;

            // Compare the first pair value
            Value pairValue = this.firstPair.first().getValue();
            Value otherValue = other.firstPair.first().getValue();

            int compare = pairValue.compareTo(otherValue);

            if (compare != 0)
                return compare;

            // Compare the second pair value
            pairValue = this.secondPair.first().getValue();
            otherValue = other.secondPair.first().getValue();

            compare = pairValue.compareTo(otherValue);

            if (compare != 0)
                return compare;

            // Compare the other card (with highest cards protocol)
            return lastCard.compareTo(other.lastCard);
        }
    }

    @Override
    public String toString() {
        return print(firstPair) + ", " + print(secondPair) + ", " + lastCard;
    }
}
