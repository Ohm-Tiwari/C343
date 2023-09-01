public class MyArrayList {
    private int capacity;
    private int size;
    private int[] list;

    // TODO: default constructor - store 10 elements with nothing in the array
    public MyArrayList(){
        this.capacity = 10;
        this.size = 0;
        this.list = new int[10];

    }

    // TODO: secondary constructor - store some capacity elements with nothing in the array
    public MyArrayList(int capacity){
        this.capacity = capacity;
        this.size = 0;
        this.list = new int[capacity];

    }

    // TODO: insert - insert some value at the index; if the index is not possible, throw the exception
    // Resize to double the capacity if array is full.
    public void insert(int index, int value) throws IndexOutOfBoundsException{
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException(String.format("Out of bounds"));
        }
        else if (size == capacity) {
            //The method should double the size of the array and copy all elements before inserting.
            int[] temporary = new int[capacity];
            this.capacity = capacity * 2;
            for(int i = 0 ; i < size;i++){
                temporary[i] = list[i];

            }
            this.list = temporary;

        }
        else{
            this.list[index] = value;
            this.size = size+1;
            }
    }

    // TODO: delete - deletes a value at the index; if index is not possible throw the exception
    // No empty spaces in the array should be left between elements
    public void delete(int index) throws IndexOutOfBoundsException{
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException(String.format("Out of bounds"));
        }
        for (int i = index ; i < size - 1; i++){
            this.list[i] = this.list[i+1];
        }
        this.list[size - 1] = '\0';
        size--;
    }

    // TODO: get - returns the value at the index; if index not possible throw exception
    public int get(int index) throws IndexOutOfBoundsException{
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException(String.format("Out of bounds"));
        }
        return list[index];
    }

    // TODO: search - searches for the value and returns its found index; if not found return -1
    public int search(int value){
        int index = -1;
        for(int i = 0 ; i < size ; i++){
            if (list[i] == value){
                index = i;
                break;
            }
        }
        return index;
    }

}
