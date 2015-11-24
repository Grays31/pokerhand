package hands;

import constants.Type;
import constants.Value;
import entities.Card;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.TreeSet;

import static org.junit.Assert.*;

public class FullHouseTest {

    private AbstractHand h1, h2;

    private static TreeSet<Card> three1, three2;
    private static TreeSet<Card> pair1, pair2;
    private static Card other1, other2;

    @BeforeClass
    public static void init() {
        three1 = new TreeSet<>();
        three1.add(new Card(Value.AS, Type.CLUB));
        three1.add(new Card(Value.AS, Type.HEART));
        three1.add(new Card(Value.AS, Type.DIAMOND));

        three2 = new TreeSet<>();
        three2.add(new Card(Value.KING, Type.CLUB));
        three2.add(new Card(Value.KING, Type.HEART));
        three2.add(new Card(Value.KING, Type.DIAMOND));

        pair1 = new TreeSet<>();
        pair1.add(new Card(Value.AS, Type.CLUB));
        pair1.add(new Card(Value.AS, Type.HEART));

        pair2 = new TreeSet<>();
        pair2.add(new Card(Value.KING, Type.CLUB));
        pair2.add(new Card(Value.KING, Type.HEART));

        assertEquals(3, three1.size());
        assertEquals(3, three2.size());
        assertEquals(2, pair1.size());
        assertEquals(2, pair2.size());
    }

    /**
     *
     */
    @Test
    public void testEquals() {
        h1 = new FullHouse(three1, pair1);
        h2 = new FullHouse(three1, pair1);

        assertEquals(0, h1.compareTo(h2));
    }

    /**
     *
     */
    @Test
    public void testDifferent() {
        // Case : Three of a kind different
        h1 = new FullHouse(three1, pair1);
        h2 = new FullHouse(three2, pair1);

        assertTrue(h1.compareTo(h2) > 0);

        // Case : Three of a kind equal, pair different
        h1 = new FullHouse(three1, pair1);
        h2 = new FullHouse(three2, pair2);

        assertTrue(h1.compareTo(h2) > 0);
    }
}