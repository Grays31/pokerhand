package hands;

import constants.Type;
import constants.Value;
import entities.Card;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class TwoPairTest {

    private AbstractHand h1, h2;

    private static TreeSet<Card> pair1, pair2, pair3;
    private static Card other1, other2;

    @BeforeClass
    public static void init() {
        pair1 = new TreeSet<>();
        pair1.add(new Card(Value.AS, Type.CLUB));
        pair1.add(new Card(Value.AS, Type.HEART));

        pair2 = new TreeSet<>();
        pair2.add(new Card(Value.KING, Type.CLUB));
        pair2.add(new Card(Value.KING, Type.HEART));

        pair3 = new TreeSet<>();
        pair3.add(new Card(Value.TEN, Type.CLUB));
        pair3.add(new Card(Value.TEN, Type.HEART));

        other1 = new Card(Value.SEVEN, Type.HEART);
        other2 = new Card(Value.THREE, Type.DIAMOND);

        assertEquals(2, pair1.size());
        assertEquals(2, pair2.size());
        assertEquals(2, pair3.size());
    }

    /**
     *
     */
    @Test
    public void testEquals() {
        h1 = new TwoPair(pair1, pair2, other1);
        h2 = new TwoPair(pair1, pair2, other1);

        assertEquals(0, h1.compareTo(h2));
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