package hands;

import constants.Type;
import constants.Value;
import entities.Card;

import java.util.Iterator;
import java.util.TreeSet;

/**
 *
 * @version 0.1
 */
public class AbstractHand implements Comparable<AbstractHand> {
    /**
     *
     */
    protected enum Hands {
        HIGH_CARD,
        ONE_PAIR,
        TWO_PAIR,
        THREE_OF_A_KIND,
        STRAIGHT,
        FLUSH,
        FULL_HOUSE,
        FOUR_OF_A_KIND,
        STRAIGHT_FLUSH
    }

    /**
     *
     */
    protected Hands handsType;

    /**
     * Used to know if it's the same value for all cards in the TreeSet
     * @param cards
     * @return
     */
    public boolean isSameValueForAllCards(TreeSet<Card> cards) {
        Value v = cards.first().getValue();
        Iterator<Card> it = cards.iterator();
        while (it.hasNext()) {
            if (!it.next().getValue().equals(v)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Used to know if it's the same color for all cards in the TreeSet
     * @param cards
     * @return
     */
    public boolean isSameColorForAllCards(TreeSet<Card> cards) {
        Type t = cards.first().getType();
        Iterator<Card> it = cards.iterator();
        while (it.hasNext()) {
            if (!it.next().getType().equals(t)) {
                return false;
            }
        }
        return true;
    }

    protected String print(TreeSet<Card> cards) {
        String s = "";
        Iterator<Card> it = cards.iterator();
        while (it.hasNext()) {
            Card c = it.next();
            if (!c.equals(cards.first())) {
                s += ", ";
            }
            s += c.toString();
        }
        return s;
    }

    @Override
    public int compareTo(AbstractHand o) {
        return handsType.compareTo(o.handsType);
    }
}
