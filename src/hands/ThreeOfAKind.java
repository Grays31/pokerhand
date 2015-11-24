package hands;

import constants.Value;
import entities.Card;

import java.util.List;

/**
 *
 */
public class ThreeOfAKind extends AbstractHand {
    /**
     *
     */
    private List<Card> threeOfAKind;

    /**
     *
     */
    private List<Card> otherCards;

    /**
     * @param threeOfAKind
     * @param otherCards
     */
    public ThreeOfAKind(List<Card> threeOfAKind, List<Card> otherCards) {
        this.handsType = Hands.THREE_OF_A_KIND;

        // Check sizes
        if (threeOfAKind.size() != 3)
            throw new IllegalArgumentException("Three of a kind cards number invalid (must be 3)");
        if (otherCards.size() != 2)
            throw new IllegalArgumentException("Other cards number invalid (must be 2)");

        this.threeOfAKind = threeOfAKind;
        this.otherCards = otherCards;
    }

    @Override
    public int compareTo(AbstractHand o) {
        // If hands type different
        if (handsType != o.handsType) {
            return super.compareTo(o);
        } else {
            ThreeOfAKind other = (ThreeOfAKind) o;

            // Compare the pair value
            Value threeValue = this.threeOfAKind.get(0).getValue();
            Value otherValue = other.threeOfAKind.get(0).getValue();

            int compare = threeValue.compareTo(otherValue);

            if (compare != 0)
                return compare;

            // Compare the other cards (with highest cards protocol)
            for (int i = otherCards.size() - 1; i >= 0; i--) {
                // Compare the 2 cards
                compare = otherCards.get(i).compareTo(other.otherCards.get(i));
                // If the two cards are different
                if (compare != 0)
                    return compare;
            }

            // The two hands are equals
            return 0;
        }
    }

    // TODO:
    @Override
    public String toString() {
        return super.toString();
    }
}

