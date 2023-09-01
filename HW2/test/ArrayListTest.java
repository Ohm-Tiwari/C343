import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {
    /*
    TODO: write test cases testing the accuracy of the methods marked with TODO. Write an efficiency test which asserts that the
    SortedArrayTest is faster than the ArrayList. Be sure to test for edge cases.
    Test add, delete, get, and search
     */

    @Test
    public void AddAndGetTest(){
        ArrayList m = new ArrayList(4);

        //tests add
        m.add(1);
        m.add(2);
        m.add(3);
        m.add(4);
        m.add(5);

        //tests get
        assertEquals(m.get(0),1);
        assertEquals(m.get(1),2);
        assertEquals(m.get(2),3);
        assertEquals(m.get(3),4);

    }

    @Test
    public void GetException(){
        //tests the get exception
        ArrayList m = new ArrayList(4);
        //tests add
        m.add(1);
        m.add(2);
        m.add(3);

        assertEquals(m.get(-1),1);
    }

    @Test
    public void deleteTest(){
        ArrayList m = new ArrayList(3);

        m.add(1);
        m.add(2);
        m.add(3);
        assertEquals(1, m.get(0));
        assertEquals(2, m.get(1));
        assertEquals(3, m.get(2));


    }


    @Test
    public void SearchTest(){
        ArrayList m = new ArrayList(3);
        m.add(1);
        m.add(2);
        m.add(3);

        assertEquals(-1, m.search(100));
        assertEquals(1, m.search(2));
        assertEquals(2, m.search(3));

    }


}
