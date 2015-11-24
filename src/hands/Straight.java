package hands;

import constants.Value;
import entities.Card;

import java.util.List;

/**
 *
 */
public class Straight extends AbstractHand {
    /**
     *
     */
    private List<Card> straight;

    /**
     *
     * @param straight
     */
    public Straight(List<Card> straight) {
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

            Value straightValue = this.straight.get(straight.size() - 1).getValue();
            Value otherValue = other.straight.get(other.straight.size() - 1).getValue();

            return straightValue.compareTo(otherValue);
        }
    }

    // TODO: Override
    @Override
    public String toString() {
        return super.toString();
    }
}