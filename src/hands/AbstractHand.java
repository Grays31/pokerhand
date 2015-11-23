package hands;

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
        STRAIGHT_FLUSH;
    }

    /**
     *
     */
    protected Hands handsType;

    /**
     *
     */
    public AbstractHand() {
        this.handsType = Hands.HIGH_CARD;
    }

    @Override
    public int compareTo(AbstractHand o) {
        return handsType.compareTo(o.handsType);
    }

}
