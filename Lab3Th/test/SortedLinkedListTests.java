import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class SortedLinkedListTests {

    /*
    TODO: tests
    - Make sure you have 100% code coverage
        + This also means you should break your tests up by method
    - Make sure you test the full functionality of this class...
      think edge cases (bounds, exceptions, etc...)
    - Use JUnit (you will not receive points for testing if you do
      not use JUnit)
     */
    private Node head;

    @Test
    public void InsertSortedTest() {
        //create a new linked list with some initial values
        SortedLinkedList list = new SortedLinkedList();
        list.insertSorted(4);
        list.insertSorted(2);
        assertEquals(list.toString(), "2, 4");
        list.insertSorted(8);
        assertEquals(list.toString(), "2, 4, 8");
    }

    @Test
    public void deleteTest(){
        SortedLinkedList list = new SortedLinkedList();
        list.insertSorted(4);
        list.insertSorted(2);
        list.delete(0);
        assertEquals(list.toString(), "4");
        assertEquals(list.toString(), "-1"); //exception test
    }


    @Test
    public void GetTest(){
        SortedLinkedList s = new SortedLinkedList();
        s.insertSorted(1);
        s.insertSorted(2);
        s.insertSorted(3);
        assertEquals(1,s.get(0));
        assertEquals(1,s.get(-5000)); // tests the exception
    }

    @Test
    public void searchTest(){
        SortedLinkedList list = new SortedLinkedList();
        list.insertSorted(1);
        list.insertSorted(2);
        list.insertSorted(3);
        assertEquals(-1, list.search(5));
        assertEquals(0, list.search(1));
        assertEquals(1, list.search(2));

    }
}
