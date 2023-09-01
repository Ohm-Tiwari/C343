class EmptyStackE extends Exception{}

public class Stack<E>{
    private DoublyLinkedList<E> st;
    private static int size;

    // TODO: default constructor
    public Stack(){
        st = new DoublyLinkedList<>();
        size = 0;

    }
    //helper function
    public static boolean isEmpty(){
        return size == 0; // means head is null
    }


    // TODO: Push the element to the top of stack
    public void push(E elem){
        st.insertAtHead(elem);
        size++;

    }

    // TODO: Pop the element off the top of the stack. If nothing to pop, throw EmptyStackE
    public E pop() throws EmptyStackE, EmptyListE {
        if (isEmpty()){
            throw new EmptyStackE();
        }
        E popElement;
        try {
            popElement = st.getHead();
        } catch (EmptyListE e) {
            throw new EmptyStackE();
        }
        st.deleteAtHead();
        size--;
        return popElement;
    }

    // TODO: Without affecting the stack, return the element at the top of the stack
    public E peek() throws IndexOutOfBoundsException, EmptyListE {
        if (isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        return st.getHead();

    }

    public int size() {
        return this.size;
    }

    // TODO: Check if some other object is the same Stack
    public boolean equals(Object o){
        if(this.toString().equals(o.toString())){
            return true;
       }
        else{
            return false;
        }
    }

    public String toString(){
        return st.toString();
    }

}
