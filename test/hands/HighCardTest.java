package hands;

import constants.Type;
import constants.Value;
import entities.Card;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class HighCardTest {
    /**
     *
     */
    @Test
    public void testEquals() {
        ArrayList<Card> c = new ArrayList<>();
        c.add(new Card(Value.NINE, Type.CLUB));
        c.add(new Card(Value.TEN, Type.CLUB));
        c.add(new Card(Value.JACK, Type.CLUB));
        c.add(new Card(Value.QUEEN, Type.CLUB));
        c.add(new Card(Value.KING, Type.CLUB));

        HighCard h1 = new HighCard(c);
        HighCard h2 = new HighCard(c);

        assertNotEquals(h1, h2);
        assertEquals(h1.compareTo(h2), 0);
    }

    /**
     *
     */
    @Test
    public void testDifferent() {
        ArrayList<Card> c1 = new ArrayList<>();
        c1.add(new Card(Value.NINE, Type.CLUB));
        c1.add(new Card(Value.TEN, Type.CLUB));
        c1.add(new Card(Value.JACK, Type.CLUB));
        c1.add(new Card(Value.QUEEN, Type.CLUB));
        c1.add(new Card(Value.KING, Type.CLUB));

        HighCard h1 = new HighCard(c1);

        ArrayList<Card> c2 = new ArrayList<>();
        c2.add(new Card(Value.EIGHT, Type.CLUB));
        c2.add(new Card(Value.NINE, Type.CLUB));
        c2.add(new Card(Value.TEN, Type.CLUB));
        c2.add(new Card(Value.JACK, Type.CLUB));
        c2.add(new Card(Value.QUEEN, Type.CLUB));

        HighCard h2 = new HighCard(c2);

        assertNotEquals(h1.compareTo(h2), 0);
    }
}