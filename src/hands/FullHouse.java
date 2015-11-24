package hands;

import constants.Value;
import entities.Card;

import java.util.TreeSet;

public class FullHouse extends AbstractHand {
    /**
     *
     */
    private TreeSet<Card> threeOfAKind;

    /**
     *
     */
    private TreeSet<Card> pair;

    /**
     *
     * @param threeOfAKind
     * @param pair
     */
    public FullHouse(TreeSet<Card> threeOfAKind, TreeSet<Card> pair) {
        this.handsType = Hands.FULL_HOUSE;

        // Check sizes
        if (threeOfAKind.size() != 3)
            throw new IllegalArgumentException("Three of a kind cards number invalid (must be 3)");
        if (pair.size() != 2)
            throw new IllegalArgumentException("Pair cards number invalid (must be 2)");

        this.threeOfAKind = threeOfAKind;
        this.pair = pair;
    }

    @Override
    public int compareTo(AbstractHand o) {
        // If hands type different
        if (handsType != o.handsType) {
            return super.compareTo(o);
        } else {
            FullHouse other = (FullHouse) o;

            // Compare the three of a kind value
            Value pairValue = this.threeOfAKind.first().getValue();
            Value otherValue = other.threeOfAKind.first().getValue();

            int compare = pairValue.compareTo(otherValue);

            if (compare != 0)
                return compare;

            // Compare the  pair value
            pairValue = this.pair.first().getValue();
            otherValue = other.pair.first().getValue();

            return pairValue.compareTo(otherValue);
        }
    }

    // TODO
    @Override
    public String toString() {
        return super.toString();
    }
}
