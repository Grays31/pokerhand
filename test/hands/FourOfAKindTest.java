package hands;

import constants.Type;
import constants.Value;
import entities.Card;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.TreeSet;

import static org.junit.Assert.*;

public class FourOfAKindTest {

    private AbstractHand h1, h2;

    private static TreeSet<Card> four1, four2;
    private static Card other1, other2;

    @BeforeClass
    public static void init() {
        four1 = new TreeSet<>();
        four1.add(new Card(Value.AS, Type.CLUB));
        four1.add(new Card(Value.AS, Type.HEART));
        four1.add(new Card(Value.AS, Type.SPADE));
        four1.add(new Card(Value.AS, Type.DIAMOND));

        four2 = new TreeSet<>();
        four2.add(new Card(Value.KING, Type.CLUB));
        four2.add(new Card(Value.KING, Type.HEART));
        four2.add(new Card(Value.KING, Type.SPADE));
        four2.add(new Card(Value.KING, Type.DIAMOND));

        other1 = new Card(Value.SEVEN, Type.HEART);
        other2 = new Card(Value.THREE, Type.DIAMOND);

        assertEquals(4, four1.size());
        assertEquals(4, four2.size());
    }

    /**
     *
     */
    @Test
    public void testEquals() {
        h1 = new FourOfAKind(four1, other1);
        h2 = new FourOfAKind(four1, other1);

        assertEquals(0, h1.compareTo(h2));
    }

    /**
     *
     */
    @Test
    public void testDifferent() {
        // Case : Four of a kind different
        h1 = new FourOfAKind(four1, other1);
        h2 = new FourOfAKind(four2, other1);

        assertTrue(h1.compareTo(h2) > 0);

        // Case : Four of a kind equal, last card different
        h1 = new FourOfAKind(four1, other1);
        h2 = new FourOfAKind(four1, other2);

        assertTrue(h1.compareTo(h2) > 0);
    }
}