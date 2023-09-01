class EmptyListE extends Exception{}

public class DoublyLinkedList<E> {

    private NodeDL<E> head;
    private NodeDL<E> tail;
    private int size;

    // TODO: default constructor
    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;

    }

    // TODO: secondary constructor
    public DoublyLinkedList(NodeDL<E> head, NodeDL<E> tail){
        this.head = head;
        this.tail = tail;
        this.size = 0;
        NodeDL n = this.head;
        while (n != null){
            size++;
            n = n.next;
        }
    }

    public E getHead() throws EmptyListE{
        if (head == null) {
            throw new EmptyListE();
        }
        return head.data;
    }

    public E getTail() throws EmptyListE{
        if (tail == null) {
            throw new EmptyListE();
        }
        return tail.data;
    }

    public int size() {
        return this.size;
    }

    //helper function
    public boolean isEmpty(){
        return size == 0; // means head is null
    }

    // TODO: Insert elem at the start of the DoublyLinkedList
    void insertAtHead(E elem){
        NodeDL newNode = new NodeDL(elem);
        if(isEmpty()){
            tail = newNode;
        }
        else{
            head.prev = newNode;
        }
        newNode.next = head;
        head = newNode;
        size++;

    }

    // TODO: Insert elem at the end of the DoublyLinkedList
    void insertAtTail(E elem){
        NodeDL newNode = new NodeDL(elem);
        if(isEmpty()){
            head = newNode;
        }
        else{
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        size++;

    }

    // TODO: Delete the element from the start of the DoublyLinkedList. Throw an EmptyListE if there's nothing to delete
    E deleteAtHead() throws EmptyListE{
        if (this.head == null){
            throw new EmptyListE();
        }
        E deleted = this.head.data;
        this.head = this.head.next;
        if (this.head == null){
            this.tail = null;
        }
        else{
            this.head.prev = null;;
        }
        this.size--;
        return deleted;
    }


    // TODO: Delete the element from the end of the DoublyLinkedList. Throw an EmptyListE if there's nothing to delete
    E deleteAtTail() throws EmptyListE{
        if (this.tail == null){
            throw new EmptyListE();
        }
        E deleted = this.tail.data;
        this.tail = this.tail.prev;

        if (this.tail == null){
            this.head = null;
        }
        else{
            this.tail.next = null;
        }
        size--;
        return deleted;
    }

    // TODO: Get the element at some position. If it's not possible, throw an IndexOutOfBoundsException
    E get (int index) throws IndexOutOfBoundsException{
        if (index >= this.size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        NodeDL<E> curr = head;
        for (int i = 0 ; i < index ; i++){
            curr = curr.next;
        }
        return curr.data;
    }

    // TODO: Search the DoublyLinkedList for elem. If not found, return -1;
    public int search(E elem){
        int idx = 0;
        NodeDL<E> curr = head;

        while (curr != null){
            if(curr.data.equals(elem)){
                return idx;
            }
            curr = curr.next;
            idx++;
        }
        return -1;
    }

    // TODO: When passed some object, return true if it's a DoublyLinkedList, has the same elements in the same order.
    public boolean equals(Object o){

        if(!(o instanceof DoublyLinkedList)){
            return false;
        }

        DoublyLinkedList other = (DoublyLinkedList) o;
        if(other.size != this.size){
            return false;
        }
        NodeDL thisCurr = this.head;
        NodeDL otherCurr = other.head;
        while(thisCurr != null){
            if(!thisCurr.data.equals(otherCurr.data)){
                return false;
            }
            thisCurr = thisCurr.next;
            otherCurr = otherCurr.next;
        }
        return true;
    }

    public String toString(){
        String ret = "";
        NodeDL<E> temp = head;
        for(int i = 0; i < size; i++){
            ret += temp.data + " ";
            temp = temp.next;
        }
        return ret;
    }
}
