package hands;

import constants.Value;
import entities.Card;

import java.util.List;

/**
 *
 */
public class TwoPair extends AbstractHand {
    /**
     *
     */
    private List<Card> firstPair;

    /**
     *
     */
    private List<Card> secondPair;

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
    public TwoPair(List<Card> firstPair, List<Card> secondPair, Card lastCard) {
        this.handsType = Hands.TWO_PAIR;

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
            Value pairValue = this.firstPair.get(0).getValue();
            Value otherValue = other.firstPair.get(0).getValue();

            int compare = pairValue.compareTo(otherValue);

            if (compare != 0)
                return compare;

            // Compare the second pair value
            pairValue = this.secondPair.get(0).getValue();
            otherValue = other.secondPair.get(0).getValue();

            compare = pairValue.compareTo(otherValue);

            if (compare != 0)
                return compare;

            // Compare the other card (with highest cards protocol)
            compare = lastCard.compareTo(other.lastCard);

            return compare;
        }
    }

    // TODO
    @Override
    public String toString() {
        return super.toString();
    }
}
