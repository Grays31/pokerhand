package hands;

import constants.Value;
import entities.Card;

import java.util.Iterator;
import java.util.TreeSet;

public class Flush extends AbstractHand {
    /**
     *
     */
    private TreeSet<Card> flush;

    /**
     *
     * @param flush
     */
    public Flush(TreeSet<Card> flush) {
        this.handsType = Hands.FLUSH;

        // Check sizes
        if (flush.size() != 5)
            throw new IllegalArgumentException("Flush cards number invalid (must be 5)");

        // Check same color
        if (!isSameColorForAllCards(flush))
            throw new IllegalArgumentException("Invalid flush provided (cards must be same color)");

        this.flush = flush;
    }

    @Override
    public int compareTo(AbstractHand o) {
        // If hands type different
        if (handsType != o.handsType) {
            return super.compareTo(o);
        } else {
            Flush other = (Flush) o;

            Iterator<Card> itCurr = this.flush.descendingIterator();
            Iterator<Card> itOther = other.flush.descendingIterator();

            while (itCurr.hasNext() && itOther.hasNext()) {
                // Compare the 2 cards
                int compare = itCurr.next().hasSameValue(itOther.next());
                // If the two cards are different
                if (compare != 0)
                    return compare;
            }

            return 0;
        }
    }

    @Override
    public String toString() {
        return print(flush);
    }
}