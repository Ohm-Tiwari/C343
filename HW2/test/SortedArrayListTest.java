import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class SortedArrayListTest {
    /*
    TODO: write test cases testing the accuracy of the methods marked with TODO. Write an efficiency test which asserts that the
    SortedArrayTest is faster than the ArrayList. Be sure to test for edge cases.
     */


    @Test
    public void AddAndGetTest(){

        SortedArrayList s = new SortedArrayList<>();
        //tests add
        s.add(1);
        s.add(3);
        s.add(4);


        //tests get
        assertEquals(s.get(0),1);
        assertEquals(s.get(1),3);
        assertEquals(s.get(2),4);

    }

    @Test
    public void deleteTest(){
        SortedArrayList s = new SortedArrayList(4);

        s.add(1);
        s.add(2);
        s.add(3);
        assertEquals(1, s.get(0));
        assertEquals(2, s.get(1));
        assertEquals(3, s.get(2));


    }

    @Test
    public void searchTest(){
        SortedArrayList s = new SortedArrayList(4);

        s.add(1);
        s.add(2);
        s.add(3);
        assertEquals(1, s.get(0));
        assertEquals(2, s.get(1));
        assertEquals(3, s.get(2));


    }





}
