import java.lang.reflect.Array;

public class SortedArrayList<E extends Comparable> extends List<E> {

    private int size;
    private int capacity;
    private Object[] ls;

    // TODO: default: should create a sortedarraylist that is capable of holding 10 element
    public SortedArrayList(){
        this.capacity = 10;
        this.size = 0;
        this.ls = new Object[10];

    }

    // TODO: second constructor - should create a sortedarraylist that is capable of holding x element that size
    public SortedArrayList(int capacity){
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

    // TODO: inserts element while maintaining the sorted order of the contents; resize to double capacity if no space
    public void add(E value) {
        if (size == capacity) {
            capacity = capacity * 2;
            Object[] newArray = new Object[capacity];

            for (int i = 0; i < size; i++) {
                newArray[i] = ls[i];
            }
            ls = newArray;
        }
        int idx = 0;
        while (idx < size && ((Comparable)value).compareTo(ls[idx]) > 0){
            idx++;
        }
        for(int i = size - 1; i >= idx ; i--){
            ls[i + 1] = ls[i];
        }
        ls[idx] = value;
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

    // TODO: search - binary search O(log(n)) for the element; returns -1 if not found
    public int search(E value){
        int low = 0;
        int high = size - 1;
        int mid;

        while (low <= high){
            mid = high - low / 2;
            if(ls[mid].equals(value)){
                return mid;
            }
            else if(value.compareTo(ls[mid]) > 0){
                low = mid + 1;
            }
            high = mid - 1;
        }
        return -1;
    }

    // TODO: given some other sortedarraylist, compare it to see if it has the same contents (also in same order)
    public boolean equals(Object o){
        return false;
    }

    // helper
    public String toString(){
        String ret = "";
        for(int i = 0; i < this.capacity; i++){
            ret += i + ": "+ this.ls[i] + "\n";
        }
        return ret;
    }
}
