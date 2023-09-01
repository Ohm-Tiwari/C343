import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DoublyLinkedListTest {

    @Test
    void defaultConstructorTest() throws EmptyListE {
        DoublyLinkedList<String> l = new DoublyLinkedList<>();
        assertThrows(EmptyListE.class, () -> l.getHead());
        assertThrows(EmptyListE.class, () -> l.getTail());
        assertEquals(0, l.size());
    }

    @Test
    void insertAtHeadTester(){
        DoublyLinkedList<Integer> l = new DoublyLinkedList<>();
        l.insertAtHead(1);
        assertEquals(1,l.size());//empty case
        l.insertAtHead(24);
        l.insertAtHead(25);
        assertEquals(25,l.get(0));
        assertEquals(24,l.get(1));
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertAtHead(2);
        dll.insertAtHead(4);
        assertEquals(dll.size(), 2);
        assertEquals(dll.get(0), 4);
    }

    @Test
    void insertAtTailTester(){
        DoublyLinkedList<Integer> l = new DoublyLinkedList<>();
        l.insertAtTail(1);
        assertEquals(1,l.size());//empty case
        l.insertAtTail(24);
        l.insertAtTail(25);
        assertEquals(1,l.get(0));
        assertEquals(24,l.get(1));
        assertEquals(25,l.get(2));
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        dll.insertAtTail(1);
        dll.insertAtTail(24);
        dll.insertAtTail(2);
        assertEquals(dll.size(), 3);
        assertEquals(dll.get(2), 2);
    }

    @Test
    void deleteAtHeadTester() throws EmptyListE {
        DoublyLinkedList<Integer> l = new DoublyLinkedList<>();
        l.insertAtTail(1);
        l.insertAtTail(24);
        l.insertAtTail(25);
        l.deleteAtHead();
        assertEquals(24,l.get(0));
        DoublyLinkedList dll = new DoublyLinkedList();
        try {
            dll.deleteAtHead();
        }
        catch (EmptyListE e) {
            System.out.println("EmptyListE");
        }
        dll.insertAtHead(3);
        dll.insertAtHead(24);
        dll.insertAtHead(2);
        try {
            dll.deleteAtHead();
        }
        catch (EmptyListE e) {
            System.out.println("EmptyListE");
        }
        assertEquals(dll.size(), 2);
        assertEquals(dll.get(0), 24);
    }

    @Test
    void deleteAtTailTester() throws EmptyListE{
        DoublyLinkedList<Integer> l = new DoublyLinkedList<>();
        l.insertAtTail(1);
        l.insertAtTail(24);
        l.insertAtTail(25);
        l.deleteAtTail();
        assertEquals(24,l.get(1));

        DoublyLinkedList <Integer> dll = new DoublyLinkedList<Integer>();
        try {
            dll.deleteAtTail();
        }
        catch (EmptyListE e) {
            System.out.println("EmptyListE");
        }
        dll.insertAtTail(1);
        dll.insertAtTail(24);
        dll.insertAtTail(2);
        try {
            dll.deleteAtTail();
        }
        catch (EmptyListE e) {
            System.out.println("EmptyListE");
        }
        assertEquals(dll.size(), 2);
        assertEquals(dll.get(1), 24);

    }

    @Test
    void equalsTester(){
        DoublyLinkedList dl1 = new DoublyLinkedList();
        dl1.insertAtHead(2);
        dl1.insertAtHead(4);
        dl1.insertAtHead(24);

        DoublyLinkedList dl2 = new DoublyLinkedList();
        dl2.insertAtHead(2);
        dl2.insertAtHead(4);
        dl2.insertAtHead(24);

        DoublyLinkedList dl3 = new DoublyLinkedList();
        dl3.insertAtHead(3);
        dl3.insertAtHead(6);
        dl3.insertAtHead(9);

        assertTrue(dl1.equals(dl2));
        assertFalse(dl1.equals(dl3));

    }



    @Test
    void getTest(){
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertAtHead(1);
        dll.insertAtHead(24);
        dll.insertAtHead(2);
        try {
            dll.get(24);
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBoundsException");
        }
    }

    @Test
    void searchTest(){
        DoublyLinkedList<Integer> dl1 = new DoublyLinkedList<>();
        dl1.insertAtHead(1);
        dl1.insertAtHead(24);
        dl1.insertAtHead(3);
        assertEquals(0,dl1.search(3));
        assertEquals(-1,dl1.search(1000));

        DoublyLinkedList dl2 = new DoublyLinkedList();
        dl2.insertAtHead(1);
        dl2.insertAtHead(24);
        dl2.insertAtHead(2);
        assertEquals(dl2.search(24), 1);
        assertEquals(dl2.search(69), -1);
    }

}
