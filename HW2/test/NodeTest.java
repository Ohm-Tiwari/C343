import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class NodeTest {
        /*
    TODO: write test cases testing the accuracy of the methods marked with TODO.s.
     */

   @Test
   public void NodeTest(){
       Node node1 = new Node("BLACKPINK", 1);
       assertEquals("BLACKPINK", node1.getKeyword());
       assertTrue(node1.getReferences() instanceof ArrayList);


       Node node2 = new Node("BTS", 2);
       assertEquals("BTS", node2.getKeyword());
       assertTrue(node2.getReferences() instanceof SortedArrayList);
   }



    @Test
    public void compareToTest(){
        Node node1 = new Node("BLACKPINK", 1);
        Node node2 = new Node("BLACKPINK", 2);
        Object o = new Object();
        assertEquals(-1,node1.compareTo(o));
        assertEquals(0,node1.compareTo(node2));

    }



    @Test
    public void equalsTest(){
        Node node1 = new Node("BLACKPINK", 1);
        Node node2 = new Node("BLACKPINK", 2);
        Node node3 = new Node("BTS", 2);
        assertTrue(node1.equals(node2));
        assertFalse(node1.equals(node3));

    }
}
