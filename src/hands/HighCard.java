package hands;

import java.util.List;
import entities.Card;

/**
 *
 */
public class HighCard extends AbstractHand {
    /**
     *
     */
    private List<Card> highestCards;

    /**
     *
     * @param highestCards
     */
    public HighCard(List<Card> highestCards) {
        this.handsType = Hands.HIGH_CARD;

        this.highestCards = highestCards;
    }

    @Override
    public int compareTo(AbstractHand o) {
        // If hands type different
        if (handsType != o.handsType) {
            return super.compareTo(o);
        } else {
            HighCard other = (HighCard) o;
            for (int i = highestCards.size() - 1; i >= 0; i--) {
                // Compare the 2 cards
                int compare = highestCards.get(i).compareTo(other.highestCards.get(i));
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
