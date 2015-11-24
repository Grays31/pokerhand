package hands;

import constants.Type;
import constants.Value;
import entities.Card;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TwoPairTest {

    private AbstractHand h1, h2;

    private static ArrayList<Card> pair1, pair2, pair3;
    private static Card other1, other2;

    @BeforeClass
    public static void init() {
        pair1 = new ArrayList<>(2);
        pair1.add(new Card(Value.AS, Type.CLUB));
        pair1.add(new Card(Value.AS, Type.HEART));

        pair2 = new ArrayList<>(2);
        pair2.add(new Card(Value.KING, Type.CLUB));
        pair2.add(new Card(Value.KING, Type.HEART));

        pair3 = new ArrayList<>(2);
        pair3.add(new Card(Value.TEN, Type.CLUB));
        pair3.add(new Card(Value.TEN, Type.CLUB));

        other1 = new Card(Value.SEVEN, Type.HEART);
        other2 = new Card(Value.THREE, Type.DIAMOND);

        assertEquals(pair1.size(), 2);
        assertEquals(pair2.size(), 2);
        assertEquals(pair3.size(), 2);
    }

    /**
     *
     */
    @Test
    public void testEquals() {
        h1 = new TwoPair(pair1, pair2, other1);
        h2 = new TwoPair(pair1, pair2, other1);

        assertEquals(h1.compareTo(h2), 0);
    }

    /**
     *
     */
    @Test
    public void testDifferent() {
        // Case : First pair different
        h1 = new TwoPair(pair1, pair2, other1);
        h2 = new TwoPair(pair2, pair3, other1);

        assertTrue(h1.compareTo(h2) > 0);

        // Case : First pair equal, second pair different
        h1 = new TwoPair(pair1, pair2, other1);
        h2 = new TwoPair(pair1, pair3, other1);

        assertTrue(h1.compareTo(h2) > 0);

        // Case : Pairs equal, last card different
        h1 = new TwoPair(pair1, pair2, other1);
        h2 = new TwoPair(pair1, pair2, other2);

        assertTrue(h1.compareTo(h2) > 0);
    }
}