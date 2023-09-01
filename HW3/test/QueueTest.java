import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {

    @Test
    void EnqueueTest() throws EmptyListE{
        Queue<Integer> q1 = new Queue<>();
        q1.enqueue(1);
        assertEquals(1,q1.peek());
        Queue<Integer> q2 = new Queue<>();
        q2.enqueue(1);
        q2.enqueue(24);
        q2.enqueue(2);
        assertEquals(q2.size(), 3);
        assertEquals(q2.peek(), 1);
    }

    @Test
    void DequeueTest() throws EmptyListE, EmptyQueueE {
        Queue<Integer> q1 = new Queue<>();
        q1.enqueue(1);
        assertEquals(1,q1.dequeue());
        Queue<Integer> q3 = new Queue<>();
        try {
            q3.dequeue();
        }
        catch (EmptyQueueE | EmptyListE e) {
            System.out.println("EmptyQueueE");
        }
        q3.enqueue(1);
        q3.enqueue(24);
        q3.enqueue(2);
        q3.dequeue();
        assertEquals(q3.size(), 2);
        q3.dequeue();
        assertEquals(q3.peek(), 2);
    }

    @Test
    void PeekTest() throws EmptyListE{
        Queue<Integer> q1 = new Queue<>();
        q1.enqueue(1);
        q1.enqueue(2);
        q1.enqueue(3);
        assertEquals(1,q1.peek());
        Queue<Integer> q2 = new Queue<>();
        q2.enqueue(1);
        q2.enqueue(24);
        q2.enqueue(2);
        assertEquals(q2.size(), 3);
        assertEquals(q2.peek(), 1);
    }

    @Test
    void EqualsTest(){
        Queue<Integer> queue1 = new Queue<>();
        Queue<Integer> queue2 = new Queue<>();
        Queue<Integer> queue3 = new Queue<>();
        queue1.enqueue(1);
        queue1.enqueue(2);
        queue1.enqueue(3);
        queue2.enqueue(1);
        queue2.enqueue(2);
        queue2.enqueue(3);
        queue3.enqueue(24);
        queue3.enqueue(24);
        queue3.enqueue(24);
        assertTrue(queue1.equals(queue2));
        assertFalse(queue1.equals(queue3));
    }
}



    }


}
