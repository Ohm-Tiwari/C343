import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

    @Test
    void PushTest() throws EmptyListE {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(24);
        s.push(2);
        assertEquals(s.size(), 3);
        assertEquals(s.peek(), 2);
    }

    @Test
    void PopTest() throws EmptyListE, EmptyStackE {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(24);
        s.push(2);
        assertEquals(s.size(), 3);
        s.pop();
        assertEquals(s.size(), 2);
        assertEquals(s.peek(), 24);


    }
    @Test
    void PeekTest() throws EmptyListE {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(24);
        s.push(2);
        assertEquals(s.size(), 3);
        assertEquals(s.peek(), 2);
    }

    @Test
    void EqualsTest(){
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> s3 = new Stack<>();
        s1.push(1);
        s1.push(24);
        s1.push(3);
        s2.push(500);
        s2.push(501);
        s2.push(502);
        s3.push(1);
        s3.push(24);
        s3.push(3);


        assertFalse(s1.equals(s2));
        assertTrue(s1.equals(s3));
        Stack<Integer> s4 = new Stack<>();
        s4.push(1);
        s4.push(24);
        s4.push(2);

        Stack<Integer> s5 = new Stack<>();
        s5.push(1);
        s5.push(24);
        s5.push(2);

        Stack<Integer> s6 = new Stack<>();
        s6.push(5);
        s6.push(5);
        s6.push(5);

        assertTrue(s4.equals(s5));
        assertFalse(s4.equals(s6));

    }

}
