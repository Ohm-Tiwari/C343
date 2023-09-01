import java.lang.reflect.Array;

public class ArrayList<E extends Comparable> extends List<E> {
    private int size;
    private int capacity;
    private Object[] ls;

    // TODO: default: should create an arraylist that is capable of holding 10 element
    public ArrayList(){
        this.capacity = 10;
        this.size = 0;
        this.ls = new Object[10];

    }

    // TODO: second constructor - should create an arraylist that is capable of holding x element
    public ArrayList(int capacity){
        this.size = 0;
        this.capacity = capacity;
        this.ls = new Object[capacity];

    }

    public int size(){
        return this.size;
    }

    public E get(int index) throws IndexOutOfBoundsException{
        if(index >= this.size){
            throw new IndexOutOfBoundsException();
        }
        return (E) this.ls[index];
    }

    // TODO: insert --> takes some element and inserts it at the end of the arraylist, resizes to double capacity if no space
    public void add(E value){
        if (size == capacity) {
            //The method should double the size of the array and copy all elements before inserting.
            capacity = capacity * 2;
            Object[] temporary = new Object[capacity];
            for(int i = 0 ; i < size;i++){
                temporary[i] = ls[i];
            }
            ls = temporary;
        }
        ls[size] = value;
        size++;
    }

    // TODO: delete - deletes an element at said index; moves elements such that there are no gaps in between them
    public void delete(int index) throws IndexOutOfBoundsException{
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        for (int i = 0 ; i < size - 1 ; i ++){
            this.ls[i] = this.ls[i + 1];
        }
        this.ls[size - 1] = '\0';
        size--;
    }

    // TODO: searches one by one to find the element, if it doesn't exist then return -1
    public int search(E value){
        int index = -1;
        for (int i = 0 ; i < size ; i++){
            if(ls[i] == value){
                index = i;
                break;
            }
        }
        return index;

    }

    // TODO: given some other arraylist, compare it to see if it has the same contents
    public boolean equals(Object o){

        if (o == null){
            return false;
        }
        ArrayList other = (ArrayList) o;
        if (this.size != other.size) {
            return false;
        }
        for (int i = 0 ; i < this.size ; i++){
            if (!this.ls[i].equals(other.ls[i])) {
                return false;
            }
        }
        return true;
    }

    // to help you
    public String toString(){
        String ret = "";
        for(int i = 0; i < this.size; i++){
            ret += i + ": "+ this.ls[i] + "\n";
        }
        return ret;
    }

}
