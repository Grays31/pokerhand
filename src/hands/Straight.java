package hands;

import constants.Value;
import entities.Card;

import java.util.TreeSet;

/**
 *
 */
public class Straight extends AbstractHand {
    /**
     *
     */
    private TreeSet<Card> straight;

    /**
     *
     * @param straight
     */
    public Straight(TreeSet<Card> straight) {
        this.handsType = Hands.STRAIGHT;

        // Check sizes
        if (straight.size() != 5)
            throw new IllegalArgumentException("Straight cards number invalid (must be 5)");

        this.straight = straight;
    }

    @Override
    public int compareTo(AbstractHand o) {
        // If hands type different
        if (handsType != o.handsType) {
            return super.compareTo(o);
        } else {
            Straight other = (Straight) o;

            // Compare the highest card
            Value straightValue = this.straight.last().getValue();
            Value otherValue = other.straight.last().getValue();

            // TODO: A - 2 - 3 - 4 - 5

            return straightValue.compareTo(otherValue);
        }
    }

    // TODO: Override
    @Override
    public String toString() {
        return super.toString();
    }
}