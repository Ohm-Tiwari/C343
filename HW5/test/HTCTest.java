import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HTCTest {
    // TODO: accuracy tests

    @Test
    void HashTableWithChainingTest(){
        HashTableWithChaining HTC = new HashTableWithChaining<>(10, 0.75);
        assertNotNull(HTC);
        assertEquals(10,HTC.getCapacity());
        assertEquals(0.75,HTC.getloadFactor());

    }

    @Test
    void putTest(){
        HashTableWithChaining HTC = new HashTableWithChaining<>(6, 0.75);
        HTC.put(1, "ohm");
        HTC.put(2, "Kendall");
        HTC.put(3, "Roman");
        HTC.put(3, "Shiv");

        assertEquals("ohm", HTC.get(1));
        assertEquals("Kendall", HTC.get(2));
        assertEquals("Shiv", HTC.get(3));

        HTC.put(4, "Shiv");
        assertEquals("Shiv", HTC.get(4));

        HTC.put(5, "Connor");
        assertEquals("Connor", HTC.get(5));

        HTC.put(6, "Greg");
        assertEquals("Greg", HTC.get(6));

        System.out.println(HTC);
    }

    @Test
    void resizeTest(){
        HashTableWithChaining HTC = new HashTableWithChaining<>(5, 0.75);
        HTC.put(1, "ohm");
        HTC.put(2, "Kendall");
        HTC.put(3, "Roman");

        assertEquals("ohm", HTC.get(1));
        assertEquals("Kendall", HTC.get(2));
        assertEquals("Roman", HTC.get(3));

        assertEquals(5,HTC.getCapacity());

        HTC.put(4, "Shiv");
        assertEquals("Shiv", HTC.get(4));

        assertEquals(11,HTC.getCapacity());

        HTC.put(5, "Connor");
        assertEquals("Connor", HTC.get(5));


        HTC.put(6, "Greg");
        assertEquals("Greg", HTC.get(6));

    }

    @Test
    void getTest(){
        HashTableWithChaining HTC = new HashTableWithChaining<>(5, 0.75);
        HTC.put(1, "ohm");
        HTC.put(2, "Kendall");
        HTC.put(3, "Shiv");

        assertEquals("ohm", HTC.get(1));
        assertEquals("Kendall", HTC.get(2));
        assertEquals("Shiv", HTC.get(3));
        assertNull(HTC.get(4));

    }

    @Test
    void containsKeyTest(){
        HashTableWithChaining HTC = new HashTableWithChaining<>(5, 0.75);
        HTC.put(1, "ohm");
        HTC.put(2, "Kendall");
        HTC.put(3, "Shiv");

        assertTrue(HTC.containsKey(1));
        assertTrue(HTC.containsKey(2));
        assertTrue(HTC.containsKey(3));
        assertFalse(HTC.containsKey(4));

    }

    @Test
    void removeTest(){
        HashTableWithChaining HTC = new HashTableWithChaining<>(5, 0.75);
        HTC.put(1, "ohm");
        HTC.put(2, "Kendall");
        HTC.put(3, "Shiv");
        HTC.put(4, "connor");
        HTC.put(5, "roman");

        assertTrue(HTC.containsKey(1));
        assertTrue(HTC.containsKey(2));
        assertTrue(HTC.containsKey(3));
        assertTrue(HTC.containsKey(4));
        assertTrue(HTC.containsKey(5));

        HTC.remove(5);
        assertFalse(HTC.containsKey(5));

        HTC.remove(4);
        assertFalse(HTC.containsKey(4));

        HTC.remove(3);
        assertFalse(HTC.containsKey(3));

        HTC.remove(2);
        assertFalse(HTC.containsKey(2));

        HTC.remove(1);
        assertFalse(HTC.containsKey(1));

        HashTableWithChaining HTCNull = new HashTableWithChaining<>(5, 0.75);
        assertFalse(HTCNull.remove(1));

    }






}
