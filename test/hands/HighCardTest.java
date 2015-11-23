package hands;

import constants.Type;
import constants.Value;
import entities.Card;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class HighCardTest {

    private AbstractHand h1, h2;

    private static ArrayList<Card> c1, c2;

    @BeforeClass
    public static void init() {
        c1 = new ArrayList<>();
        c1.add(new Card(Value.NINE, Type.CLUB));
        c1.add(new Card(Value.TEN, Type.CLUB));
        c1.add(new Card(Value.JACK, Type.CLUB));
        c1.add(new Card(Value.QUEEN, Type.CLUB));
        c1.add(new Card(Value.KING, Type.CLUB));

        c2 = new ArrayList<>();
        c2.add(new Card(Value.EIGHT, Type.CLUB));
        c2.add(new Card(Value.NINE, Type.CLUB));
        c2.add(new Card(Value.TEN, Type.CLUB));
        c2.add(new Card(Value.JACK, Type.CLUB));
        c2.add(new Card(Value.QUEEN, Type.CLUB));

        assertEquals(c1.size(), 5);
        assertEquals(c2.size(), 5);
    }

    /**
     *
     */
    @Test
    public void testEquals() {
        h1 = new HighCard(c1);
        h2 = new HighCard(c1);

        assertEquals(h1.compareTo(h2), 0);
    }

    /**
     *
     */
    @Test
    public void testDifferent() {
        h1 = new HighCard(c1);
        h2 = new HighCard(c2);

        assertNotEquals(h1.compareTo(h2), 0);
    }
}