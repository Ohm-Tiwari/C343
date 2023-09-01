import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HTOATest {
    // TODO: accuracy tests

    @Test
    void HashTableOpenAddressingTest(){
        HashTableOpenAddressing HTO1 = new HashTableOpenAddressing(HashTableOpenAddressing.LINEARPROBING, 10, 0.75);
        assertNotNull(HTO1);
        assertEquals(10,HTO1.getCapacity());
        assertEquals(0.75,HTO1.getloadFactor());
        assertEquals(HashTableOpenAddressing.LINEARPROBING,HTO1.getMode());

        HashTableOpenAddressing HTO2 = new HashTableOpenAddressing(HashTableOpenAddressing.DOUBLEHASHING, 10, 0.75);
        assertNotNull(HTO2);
        assertEquals(10,HTO2.getCapacity());
        assertEquals(0.75,HTO2.getloadFactor());
        assertEquals(HashTableOpenAddressing.DOUBLEHASHING,HTO2.getMode());

        HashTableOpenAddressing HTO3 = new HashTableOpenAddressing(HashTableOpenAddressing.QUADRATICPROBING, 10, 0.75);
        assertNotNull(HTO3);
        assertEquals(10,HTO3.getCapacity());
        assertEquals(0.75,HTO3.getloadFactor());
        assertEquals(HashTableOpenAddressing.QUADRATICPROBING,HTO3.getMode());
    }

    @Test
    void putTest(){
        HashTableOpenAddressing HTOLinear = new HashTableOpenAddressing(HashTableOpenAddressing.LINEARPROBING, 5, 0.75);
        HTOLinear.put(1, "ohm");
        HTOLinear.put(2, "Kendall");
        HTOLinear.put(3, "Roman");
        HTOLinear.put(3, "Shiv");

        assertEquals("ohm", HTOLinear.get(1));
        assertEquals("Kendall", HTOLinear.get(2));
        //assertEquals("Shiv", HTOLinear.get(4));

        HTOLinear.put(4, "Shiv");
        assertEquals("Shiv", HTOLinear.get(4));

        HTOLinear.put(5, "Connor");
        assertEquals("Connor", HTOLinear.get(5));

        HTOLinear.put(6, "Greg");
        assertEquals("Greg", HTOLinear.get(6));

        HashTableOpenAddressing HTODouble = new HashTableOpenAddressing(HashTableOpenAddressing.DOUBLEHASHING, 5, 0.75);
        HTODouble.put(1, "ohm");
        HTODouble.put(2, "Kendall");
        HTODouble.put(3, "Roman");
        HTODouble.put(3, "Shiv");

        assertEquals("ohm", HTODouble.get(1));
        assertEquals("Kendall", HTODouble.get(2));
        assertEquals("Shiv", HTODouble.get(3));

        HTODouble.put(4, "Shiv");
        assertEquals("Shiv", HTODouble.get(4));

        HTODouble.put(5, "Connor");
        assertEquals("Connor", HTODouble.get(5));

        HTODouble.put(6, "Greg");
        assertEquals("Greg", HTODouble.get(6));

        HashTableOpenAddressing HTOQuad = new HashTableOpenAddressing(HashTableOpenAddressing.QUADRATICPROBING, 5, 0.75);
        HTOQuad.put(1, "ohm");
        HTOQuad.put(2, "Kendall");
        HTOQuad.put(3, "Roman");
        HTOQuad.put(3, "Shiv");

        assertEquals("ohm", HTOQuad.get(1));
        assertEquals("Kendall", HTOQuad.get(2));
        assertEquals("Shiv", HTOQuad.get(3));

        HTOQuad.put(4, "Shiv");
        assertEquals("Shiv", HTOQuad.get(4));

        HTOQuad.put(5, "Connor");
        assertEquals("Connor", HTOQuad.get(5));

        HTOQuad.put(6, "Greg");
        assertEquals("Greg", HTOQuad.get(6));

    }

    @Test
    void getTest(){
        HashTableOpenAddressing HTOLinear = new HashTableOpenAddressing(HashTableOpenAddressing.LINEARPROBING, 5, 0.75);
        HTOLinear.put(1, "ohm");
        HTOLinear.put(2, "Kendall");
        HTOLinear.put(3, "Shiv");

        assertEquals("ohm", HTOLinear.get(1));
        assertEquals("Kendall", HTOLinear.get(2));
        assertEquals("Shiv", HTOLinear.get(3));
        assertNull(HTOLinear.get(4));

        HashTableOpenAddressing HTODouble = new HashTableOpenAddressing(HashTableOpenAddressing.DOUBLEHASHING, 5, 0.75);
        HTODouble.put(1, "ohm");
        HTODouble.put(2, "Kendall");
        HTODouble.put(3, "Shiv");

        assertEquals("ohm", HTODouble.get(1));
        assertEquals("Kendall", HTODouble.get(2));
        assertEquals("Shiv", HTODouble.get(3));
        assertNull(HTODouble.get(4));

        HashTableOpenAddressing HTOQuad = new HashTableOpenAddressing(HashTableOpenAddressing.QUADRATICPROBING, 5, 0.75);
        HTOQuad.put(1, "ohm");
        HTOQuad.put(2, "Kendall");
        HTOQuad.put(3, "Shiv");

        assertEquals("ohm", HTOQuad.get(1));
        assertEquals("Kendall", HTOQuad.get(2));
        assertEquals("Shiv", HTOQuad.get(3));
        assertNull(HTOQuad.get(4));

    }

    @Test
    void containsKeyTest(){
        HashTableOpenAddressing HTOLinear = new HashTableOpenAddressing(HashTableOpenAddressing.LINEARPROBING, 5, 0.75);
        HTOLinear.put(1, "ohm");
        HTOLinear.put(2, "Kendall");
        HTOLinear.put(3, "Shiv");

        assertTrue(HTOLinear.containsKey(1));
        assertTrue(HTOLinear.containsKey(2));
        assertTrue(HTOLinear.containsKey(3));
        assertFalse(HTOLinear.containsKey(4));

        HashTableOpenAddressing HTODouble = new HashTableOpenAddressing(HashTableOpenAddressing.DOUBLEHASHING, 5, 0.75);
        HTODouble.put(1, "ohm");
        HTODouble.put(2, "Kendall");
        HTODouble.put(3, "Shiv");

        assertTrue(HTODouble.containsKey(1));
        assertTrue(HTODouble.containsKey(2));
        assertTrue(HTODouble.containsKey(3));
        assertFalse(HTODouble.containsKey(4));

        HashTableOpenAddressing HTOQuad = new HashTableOpenAddressing(HashTableOpenAddressing.QUADRATICPROBING, 5, 0.75);
        HTOQuad.put(1, "ohm");
        HTOQuad.put(2, "Kendall");
        HTOQuad.put(3, "Shiv");

        assertTrue(HTOQuad.containsKey(1));
        assertTrue(HTOQuad.containsKey(2));
        assertTrue(HTOQuad.containsKey(3));
        assertFalse(HTOQuad.containsKey(4));
    }

    @Test
    void removeTest(){
        HashTableOpenAddressing HTOANull = new HashTableOpenAddressing(HashTableOpenAddressing.LINEARPROBING, 5, 0.75);
        assertFalse(HTOANull.remove(1));

        HashTableOpenAddressing HTLinear = new HashTableOpenAddressing(HashTableOpenAddressing.LINEARPROBING, 5, 0.75);
        HTLinear.put(1, "ohm");
        HTLinear.put(2, "Kendall");
        HTLinear.put(3, "Shiv");


        assertTrue(HTLinear.containsKey(1));
        assertTrue(HTLinear.containsKey(2));
        assertTrue(HTLinear.containsKey(3));


        HTLinear.remove(3);

        assertTrue(HTLinear.containsKey(3));

        HTLinear.remove(2);
        assertTrue(HTLinear.containsKey(2));

        HTLinear.remove(1);
        assertTrue(HTLinear.containsKey(1));

        HashTableOpenAddressing HTDouble = new HashTableOpenAddressing(HashTableOpenAddressing.DOUBLEHASHING, 5, 0.75);
        HTDouble.put(1, "ohm");
        HTDouble.put(2, "Kendall");
        HTDouble.put(3, "Shiv");


        assertTrue(HTDouble.containsKey(1));
        assertTrue(HTDouble.containsKey(2));
        assertTrue(HTDouble.containsKey(3));


        HTDouble.remove(3);
        assertTrue(HTDouble.containsKey(3));

        HTDouble.remove(2);
        assertTrue(HTDouble.containsKey(2));

        HTDouble.remove(1);
        assertTrue(HTDouble.containsKey(1));




        HashTableOpenAddressing HTQuad = new HashTableOpenAddressing(HashTableOpenAddressing.QUADRATICPROBING, 5, 0.75);
        HTQuad.put(1, "ohm");
        HTQuad.put(2, "Kendall");
        HTQuad.put(3, "Shiv");


        assertTrue(HTQuad.containsKey(1));
        assertTrue(HTQuad.containsKey(2));
        assertTrue(HTQuad.containsKey(3));


        HTQuad.remove(3);
        assertTrue(HTQuad.containsKey(3));

        HTQuad.remove(2);
        assertTrue(HTQuad.containsKey(2));

        HTQuad.remove(1);
        assertTrue(HTQuad.containsKey(1));
    }

    @Test
    void resizeTest(){
        HashTableOpenAddressing HTLinear = new HashTableOpenAddressing(HashTableOpenAddressing.LINEARPROBING, 5, 0.75);
        HTLinear.put(1, "ohm");
        HTLinear.put(2, "Kendall");
        HTLinear.put(3, "Roman");

        assertEquals(5,HTLinear.getCapacity());

        HTLinear.put(4, "Shiv");
        assertEquals("Shiv", HTLinear.get(4));

        HTLinear.put(5, "Connor");
        assertEquals("Connor", HTLinear.get(5));


        HTLinear.put(6, "Greg");
        assertEquals("Greg", HTLinear.get(6));


        HashTableOpenAddressing HTDouble = new HashTableOpenAddressing(HashTableOpenAddressing.DOUBLEHASHING, 5, 0.75);
        HTDouble.put(1, "ohm");
        HTDouble.put(2, "Kendall");
        HTDouble.put(3, "Roman");


        HTDouble.put(4, "Shiv");
        assertEquals("Shiv", HTDouble.get(4));


        HTDouble.put(5, "Connor");
        assertEquals("Connor", HTDouble.get(5));


        HTDouble.put(6, "Greg");
        assertEquals("Greg", HTDouble.get(6));

        HashTableOpenAddressing HTQuad = new HashTableOpenAddressing(HashTableOpenAddressing.QUADRATICPROBING, 5, 0.75);
        HTQuad.put(1, "ohm");
        HTQuad.put(2, "Kendall");
        HTQuad.put(3, "Roman");


        HTQuad.put(4, "Shiv");
        assertEquals("Shiv", HTQuad.get(4));


        HTQuad.put(5, "Connor");
        assertEquals("Connor", HTQuad.get(5));


        HTQuad.put(6, "Greg");
        assertEquals("Greg", HTQuad.get(6));

    }
}
