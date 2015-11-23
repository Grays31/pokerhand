package hands;

import constants.Type;
import constants.Value;
import entities.Card;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class OnePairTest {

    private AbstractHand h1, h2;

    private static ArrayList<Card> pair1, pair2;
    private static ArrayList<Card> other1, other2;


    @BeforeClass
    public static void init() {
        pair1 = new ArrayList<>(2);
        pair1.add(new Card(Value.AS, Type.CLUB));
        pair1.add(new Card(Value.AS, Type.HEART));

        pair2 = new ArrayList<>(2);
        pair2.add(new Card(Value.KING, Type.CLUB));
        pair2.add(new Card(Value.KING, Type.HEART));

        other1 = new ArrayList<>(3);
        other1.add(new Card(Value.TEN, Type.CLUB));
        other1.add(new Card(Value.JACK, Type.CLUB));
        other1.add(new Card(Value.QUEEN, Type.CLUB));

        other2 = new ArrayList<>(3);
        other2.add(new Card(Value.TWO, Type.CLUB));
        other2.add(new Card(Value.THREE, Type.CLUB));
        other2.add(new Card(Value.FOUR, Type.CLUB));

        assertEquals(pair1.size(), 2);
        assertEquals(pair2.size(), 2);
        assertEquals(other1.size(), 3);
        assertEquals(other2.size(), 3);
    }

    /**
     *
     */
    @Test
    public void testEquals() {
        h1 = new OnePair(pair1, other1);
        h2 = new OnePair(pair1, other1);

        assertEquals(h1.compareTo(h2), 0);
    }

    /**
     *
     */
    @Test
    public void testDifferent() {
        h1 = new OnePair(pair1, other1);
        h2 = new OnePair(pair2, other1);

        assertNotEquals(h1.compareTo(h2), 0);

        h1 = new OnePair(pair2, other1);
        h2 = new OnePair(pair2, other2);

        assertNotEquals(h1.compareTo(h2), 0);
    }
}