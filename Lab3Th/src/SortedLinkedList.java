public class SortedLinkedList {

    /**
     * The 0th indexed Node in the list.
     */
    Node head;

    /**
     * Creates a SortedLinkedList.
     */
    public SortedLinkedList() {
        head = null;
    }


    /**
     * Inserts the given data at a location that maintains sorted order (ascending).
     * @param data The value to be inserted into the list.
     */
    public void insertSorted(int data) {
        if (head == null){
            head = new Node(data, null);
            return;
        }
        Node current = head;
        Node previous = null;

        while(current != null && current.data < data) {
            previous = current;
            current = current.next;
        }
        Node newNode = new Node(data, current);
        if(previous == null) {
            head = newNode;
        } else {
            previous.next = newNode;
        }
    }


    /**
     * Deletes the Node at the given index. Throws an IndexOutOfBoundException if index
     * is negative or too large.
     * @param idx Index of the int to be deleted.
     */
    public void delete(int idx) throws IndexOutOfBoundsException {
        if (idx < 0){
            throw new IndexOutOfBoundsException();
        }
        else if (idx == 0){
            head = head.next;
            return;
        }
        Node prevNode = head;
        Node currentNode = head.next;
        int currentIdx = 1;

        while (currentNode != null){
            if(currentIdx == idx){
                prevNode.next = currentNode.next;
                return;
            }
            prevNode = currentNode;
            currentNode = currentNode.next;
            currentIdx++;
        }
    }

    /**
     * Gets the int at the given index. Throws an IndexOutOfBoundException if index
     * is negative or too large.
     * @param idx Index of the int to be return.
     * @return The int at the given index
     */
    public int get(int idx) throws IndexOutOfBoundsException {
        if (idx < 0){
            throw new IndexOutOfBoundsException();
        }
        Node curr = head;
        for (int i = 0; i < idx; i++) {
            curr = curr.next;
        }
        return curr.data;
    }

    /**
     * Searches for the given int and returns its index if found. If the int is not
     * found, returns -1.
     * @param data The int to search for.
     * @return The data at the given index
     */
    public int search(int data) {
        Node current = head;
        int index = 0;
        while(current != null){
            if(current.data > data){
                return -1;
            }
            if(current.data == data){
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public String toString() {
        return printList();
    }

    /**
     * A recursive helper for toString that generates a String representation of this.
     * @return A String representation of the this.
     */
    private String printList() {
        String listStr = "";
        String delimiter = ", ";
        Node cur = head;
        while (cur != null) {
            listStr += cur.data + delimiter;
            cur = cur.next;
        }

        return listStr.substring(0, listStr.length()-delimiter.length());
    }
}
