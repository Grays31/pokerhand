package hands;

import constants.Value;
import entities.Card;

import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/**
 *
 */
public class ThreeOfAKind extends AbstractHand {
    /**
     *
     */
    private TreeSet<Card> threeOfAKind;

    /**
     *
     */
    private TreeSet<Card> otherCards;

    /**
     * @param threeOfAKind
     * @param otherCards
     */
    public ThreeOfAKind(TreeSet<Card> threeOfAKind, TreeSet<Card> otherCards) {
        this.handsType = Hands.THREE_OF_A_KIND;

        // Check sizes
        if (threeOfAKind.size() != 3)
            throw new IllegalArgumentException("Three of a kind cards number invalid (must be 3)");
        if (otherCards.size() != 2)
            throw new IllegalArgumentException("Other cards number invalid (must be 2)");

        // Check same value
        if (!isSameValueForAllCards(threeOfAKind))
            throw new IllegalArgumentException("Invalid three of a kind provided (cards must be same value)");

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
            Value threeValue = this.threeOfAKind.first().getValue();
            Value otherValue = other.threeOfAKind.first().getValue();

            int compare = threeValue.compareTo(otherValue);

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
        return print(threeOfAKind) + ", " + print(otherCards);
    }
}

