import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordTest {

    @Test
    void testEquals() {
        Coord c = new Coord(1, 3);
        Coord c1 = new Coord(1, 3);
        Coord c2 = new Coord(2, 3);

        assertTrue(c.equals(c1));
        assertFalse(c.equals(c2));
    }
}