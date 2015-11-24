package hands;

import constants.Value;
import entities.Card;

import java.util.TreeSet;

/**
 *
 */
public class FourOfAKind extends AbstractHand {
    /**
     *
     */
    private TreeSet<Card> fourOfAKind;

    /**
     *
     */
    private Card lastCard;

    /**
     *
     * @param fourOfAKind
     * @param lastCard
     */
    public FourOfAKind(TreeSet<Card> fourOfAKind, Card lastCard) {
        this.handsType = Hands.FOUR_OF_A_KIND;

        // Check sizes
        if (fourOfAKind.size() != 4)
            throw new IllegalArgumentException("Four of a kind cards number invalid (must be 4)");

        this.fourOfAKind = fourOfAKind;
        this.lastCard = lastCard;
    }

    @Override
    public int compareTo(AbstractHand o) {
        // If hands type different
        if (handsType != o.handsType) {
            return super.compareTo(o);
        } else {
            FourOfAKind other = (FourOfAKind) o;

            // Compare the first pair value
            Value pairValue = this.fourOfAKind.first().getValue();
            Value otherValue = other.fourOfAKind.first().getValue();

            int compare = pairValue.compareTo(otherValue);

            if (compare != 0)
                return compare;

            // Compare the other card (with highest cards protocol)
            return lastCard.compareTo(other.lastCard);
        }
    }

    @Override
    public String toString() {
        return print(fourOfAKind) + ", " + lastCard.toString();
    }
}
