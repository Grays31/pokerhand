package hands;

import constants.Type;
import constants.Value;
import entities.Card;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.SortedSet;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class OnePairTest {

    private AbstractHand h1, h2;

    private static TreeSet<Card> pair1, pair2;
    private static TreeSet<Card> other1, other2;

    @BeforeClass
    public static void init() {
        pair1 = new TreeSet<>();
        pair1.add(new Card(Value.AS, Type.CLUB));
        pair1.add(new Card(Value.AS, Type.HEART));

        pair2 = new TreeSet<>();
        pair2.add(new Card(Value.KING, Type.CLUB));
        pair2.add(new Card(Value.KING, Type.HEART));

        other1 = new TreeSet<>();
        other1.add(new Card(Value.TEN, Type.CLUB));
        other1.add(new Card(Value.JACK, Type.CLUB));
        other1.add(new Card(Value.QUEEN, Type.CLUB));

        other2 = new TreeSet<>();
        other2.add(new Card(Value.TWO, Type.CLUB));
        other2.add(new Card(Value.THREE, Type.CLUB));
        other2.add(new Card(Value.FOUR, Type.CLUB));

        assertEquals(2, pair1.size());
        assertEquals(2, pair2.size());
        assertEquals(3, other1.size());
        assertEquals(3, other2.size());
    }

    /**
     *
     */
    @Test
    public void testEquals() {
        h1 = new OnePair(pair1, other1);
        h2 = new OnePair(pair1, other1);

        assertEquals(0, h1.compareTo(h2));
    }

    /**
     *
     */
    @Test
    public void testDifferent() {
        // Case : Pairs different
        h1 = new OnePair(pair1, other1);
        h2 = new OnePair(pair2, other1);

        assertTrue(h1.compareTo(h2) > 0);

        // Case : Pairs equal but other cards different
        h1 = new OnePair(pair2, other1);
        h2 = new OnePair(pair2, other2);

        assertTrue(h1.compareTo(h2) > 0);
    }
}