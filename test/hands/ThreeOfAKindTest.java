package hands;

import constants.Type;
import constants.Value;
import entities.Card;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ThreeOfAKindTest {

    private AbstractHand h1, h2;

    private static ArrayList<Card> three1, three2;
    private static ArrayList<Card> other1, other2;

    @BeforeClass
    public static void init() {
        three1 = new ArrayList<>(3);
        three1.add(new Card(Value.AS, Type.CLUB));
        three1.add(new Card(Value.AS, Type.HEART));
        three1.add(new Card(Value.AS, Type.DIAMOND));

        three2 = new ArrayList<>(3);
        three2.add(new Card(Value.KING, Type.CLUB));
        three2.add(new Card(Value.KING, Type.HEART));
        three2.add(new Card(Value.KING, Type.DIAMOND));

        other1 = new ArrayList<>(2);
        other1.add(new Card(Value.NINE, Type.CLUB));
        other1.add(new Card(Value.TEN, Type.HEART));

        other2 = new ArrayList<>(2);
        other2.add(new Card(Value.JACK, Type.CLUB));
        other2.add(new Card(Value.QUEEN, Type.HEART));

        assertEquals(three1.size(), 3);
        assertEquals(three2.size(), 3);
        assertEquals(other1.size(), 2);
        assertEquals(other2.size(), 2);
    }

    /**
     *
     */
    @Test
    public void testEquals() {
        h1 = new ThreeOfAKind(three1, other1);
        h2 = new ThreeOfAKind(three1, other1);

        assertEquals(h1.compareTo(h2), 0);
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