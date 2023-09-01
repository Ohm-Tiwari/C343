class EmptyQueueE extends Exception{}

public class Queue<E> {
    private DoublyLinkedList<E> q;
    private int size;

    // TODO: default constructor
    public Queue(){
        q = new DoublyLinkedList<>();
        size = 0;
    }

    //helper
    public boolean isEmpty() {
        return size == 0;
    }


    // TODO: Put element at end of queue
    public void enqueue(E elem){
        q.insertAtTail(elem);
        size++;

    }

    // TODO: Return the head of the queue; If there's nothing to return then throw EmptyQueueE
    public E dequeue() throws EmptyQueueE, EmptyListE {
        if(isEmpty()){
            throw new EmptyQueueE();
        }
        E head = q.getHead();
        q.deleteAtHead();
        size--;
        return head;
    }

    // TODO: Without affecting the queue, return the element at the top of the queue
    public E peek() throws IndexOutOfBoundsException, EmptyListE {
        if (isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        return q.getHead();
    }

    public int size() {
        return this.size;
    }

    // TODO: Checks if inputted is the same Queue
    public boolean equals(Object o) {
        if (this.toString().equals(o.toString())) {
            return true;
        }
        else {
            return false;
        }
    }


    public String toString(){
        return "" + q.size();
    }
}
