package hands;

import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import constants.Value;
import entities.Card;

/**
 *
 */
public class OnePair extends AbstractHand {
    /**
     *
     */
    private TreeSet<Card> pair;

    /**
     *
     */
    private TreeSet<Card> otherCards;

    /**
     *
     * @param pair
     * @param otherCards
     */
    public OnePair(TreeSet<Card> pair, TreeSet<Card> otherCards) {
        this.handsType = Hands.ONE_PAIR;

        // Check sizes
        if (pair.size() != 2)
            throw new IllegalArgumentException("Pair cards number invalid (must be 2)");
        if (otherCards.size() != 3)
            throw new IllegalArgumentException("Other cards number invalid (must be 3)");

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
            Value pairValue = this.pair.first().getValue();
            Value otherValue = other.pair.first().getValue();

            int compare = pairValue.compareTo(otherValue);

            if (compare != 0)
                return compare;

            Iterator<Card> itCurr = this.otherCards.descendingIterator();
            Iterator<Card> itOther = other.otherCards.descendingIterator();

            while (itCurr.hasNext() && itOther.hasNext()) {
                // Compare the 2 cards
                compare = itCurr.next().hasSameValue(itOther.next());
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