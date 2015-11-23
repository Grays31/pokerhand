package hands;

import java.util.List;

import constants.Value;
import entities.Card;

/**
 *
 */
public class OnePair extends AbstractHand {
    /**
     *
     */
    private List<Card> pair;

    /**
     *
     */
    private List<Card> otherCards;

    /**
     *
     * @param pair
     * @param otherCards
     */
    public OnePair(List<Card> pair, List<Card> otherCards) {
        this.handsType = Hands.ONE_PAIR;

        this.pair = pair;
        this.otherCards = otherCards;
    }

    @Override
    public int compareTo(AbstractHand o) {
        // If hands type different
        if (handsType != o.handsType) {
            return super.compareTo(o);
        } else {
            OnePair other = (OnePair) o;

            // Compare the pair value
            Value pairValue = this.pair.get(0).getValue();
            Value otherValue = other.pair.get(0).getValue();

            int compare = pairValue.compareTo(otherValue);

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

    @Override
    public String toString() {
        return super.toString();
    }
}