package hands;

import constants.Type;
import constants.Value;
import entities.Card;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class ThreeOfAKindTest {

    private AbstractHand h1, h2;

    private static TreeSet<Card> three1, three2;
    private static TreeSet<Card> other1, other2;

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

        other1 = new TreeSet<>();
        other1.add(new Card(Value.NINE, Type.CLUB));
        other1.add(new Card(Value.TEN, Type.HEART));

        other2 = new TreeSet<>();
        other2.add(new Card(Value.JACK, Type.CLUB));
        other2.add(new Card(Value.QUEEN, Type.HEART));

        assertEquals(3, three1.size());
        assertEquals(3, three2.size());
        assertEquals(2, other1.size());
        assertEquals(2, other2.size());
    }

    /**
     *
     */
    @Test
    public void testEquals() {
        h1 = new ThreeOfAKind(three1, other1);
        h2 = new ThreeOfAKind(three1, other1);

        assertEquals(0, h1.compareTo(h2));
    }

    /**
     *
     */
    @Test
    public void testDifferent() {
        // Case : Three of a kind different
        h1 = new ThreeOfAKind(three1, other1);
        h2 = new ThreeOfAKind(three2, other1);

        assertTrue(h1.compareTo(h2) > 0);

        // Case : Three of a kind equal, other cards different
        h1 = new ThreeOfAKind(three1, other1);
        h2 = new ThreeOfAKind(three1, other2);

        assertTrue(h1.compareTo(h2) < 0);
    }
}