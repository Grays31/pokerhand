package constants;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValueTest {
    /**
     * Test if the enum Value is with the correct order
     */
    @Test
    public void testOrder() {
        assertTrue(Value.TWO.compareTo(Value.THREE) < 0);
        assertTrue(Value.THREE.compareTo(Value.FOUR) < 0);
        assertTrue(Value.FOUR.compareTo(Value.FIVE) < 0);
        assertTrue(Value.FIVE.compareTo(Value.SIX) < 0);
        assertTrue(Value.SIX.compareTo(Value.SEVEN) < 0);
        assertTrue(Value.SEVEN.compareTo(Value.EIGHT) < 0);
        assertTrue(Value.EIGHT.compareTo(Value.NINE) < 0);
        assertTrue(Value.NINE.compareTo(Value.TEN) < 0);
        assertTrue(Value.TEN.compareTo(Value.JACK) < 0);
        assertTrue(Value.JACK.compareTo(Value.QUEEN) < 0);
        assertTrue(Value.QUEEN.compareTo(Value.KING) < 0);
        assertTrue(Value.KING.compareTo(Value.AS) < 0);
    }
}