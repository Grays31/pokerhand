package hands;

import constants.Type;
import constants.Value;
import entities.Card;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class HighCardTest {

    private AbstractHand h1, h2;

    private static TreeSet<Card> c1, c2;

    @BeforeClass
    public static void init() {
        c1 = new TreeSet<>();
        c1.add(new Card(Value.NINE, Type.CLUB));
        c1.add(new Card(Value.TEN, Type.CLUB));
        c1.add(new Card(Value.JACK, Type.CLUB));
        c1.add(new Card(Value.QUEEN, Type.CLUB));
        c1.add(new Card(Value.KING, Type.CLUB));

        c2 = new TreeSet<>();
        c2.add(new Card(Value.EIGHT, Type.CLUB));
        c2.add(new Card(Value.NINE, Type.CLUB));
        c2.add(new Card(Value.TEN, Type.CLUB));
        c2.add(new Card(Value.JACK, Type.CLUB));
        c2.add(new Card(Value.QUEEN, Type.CLUB));

        assertEquals(5, c1.size());
        assertEquals(5, c2.size());
    }

    /**
     *
     */
    @Test
    public void testEquals() {
        h1 = new HighCard(c1);
        h2 = new HighCard(c1);

        assertEquals(0, h1.compareTo(h2));
    }

    /**
     *
     */
    @Test
    public void testDifferent() {
        h1 = new HighCard(c1);
        h2 = new HighCard(c2);

        assertTrue(h1.compareTo(h2) > 0);
    }
}