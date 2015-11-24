package hands;

import constants.Type;
import constants.Value;
import entities.Card;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.TreeSet;

import static org.junit.Assert.*;

public class FlushTest {

    private AbstractHand h1, h2;

    private static TreeSet<Card> flush1, flush2;

    @BeforeClass
    public static void init() {
        flush1 = new TreeSet<>();
        flush1.add(new Card(Value.TWO, Type.CLUB));
        flush1.add(new Card(Value.SIX, Type.CLUB));
        flush1.add(new Card(Value.JACK, Type.CLUB));
        flush1.add(new Card(Value.QUEEN, Type.CLUB));
        flush1.add(new Card(Value.KING, Type.CLUB));

        flush2 = new TreeSet<>();
        flush2.add(new Card(Value.THREE, Type.HEART));
        flush2.add(new Card(Value.SIX, Type.HEART));
        flush2.add(new Card(Value.TEN, Type.HEART));
        flush2.add(new Card(Value.JACK, Type.HEART));
        flush2.add(new Card(Value.KING, Type.HEART));

        assertEquals(5, flush1.size());
        assertEquals(5, flush2.size());
    }

    /**
     *
     */
    @Test
    public void testEquals() {
        h1 = new Flush(flush1);
        h2 = new Flush(flush1);

        assertEquals(0, h1.compareTo(h2));
    }

    /**
     *
     */
    @Test
    public void testDifferent() {
        h1 = new Flush(flush1);
        h2 = new Flush(flush2);

        assertTrue(h1.compareTo(h2) > 0);
    }
}