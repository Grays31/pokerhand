package hands;

import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import entities.Card;

/**
 *
 */
public class HighCard extends AbstractHand {
    /**
     *
     */
    private TreeSet<Card> highestCards;

    /**
     *
     * @param highestCards
     */
    public HighCard(TreeSet<Card> highestCards) {
        this.handsType = Hands.HIGH_CARD;

        // Check sizes
        if (highestCards.size() != 5)
            throw new IllegalArgumentException("Cards number invalid (must be 5)");

        this.highestCards = highestCards;
    }

    @Override
    public int compareTo(AbstractHand o) {
        // If hands type different
        if (handsType != o.handsType) {
            return super.compareTo(o);
        } else {
            HighCard other = (HighCard) o;

            Iterator<Card> itCurr = this.highestCards.descendingIterator();
            Iterator<Card> itOther = other.highestCards.descendingIterator();

            while (itCurr.hasNext() && itOther.hasNext()) {
                // Compare the 2 cards
                int compare = itCurr.next().hasSameValue(itOther.next());
                // If the two cards are different
                if (compare != 0)
                    return compare;
            }

            // The two hands are equals
            return 0;
        }
    }

    // TODO: Override
    @Override
    public String toString() {
        return super.toString();
    }
}
