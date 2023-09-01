import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.abs;

public class HashTableOpenAddressing<K, V> extends Dictionary<K,V>{

    private int capacity;  // size of the table
    private int size;  // number of elements in the table
    private int previousPrime; //store prev prime so that it is not calculated again and again in double hashing.
    private int mode;

    public static int LINEARPROBING = 1;
    public static int QUADRATICPROBING = 2;
    public static int DOUBLEHASHING = 3;
    private double loadFactor;
    private Entry<K, V>[] table;

    public HashTableOpenAddressing() {
        this(DOUBLEHASHING, 11, 0.75);  // default initial capacity of 10
    }

    public HashTableOpenAddressing(int mode) {
        this( mode, 11, 0.75);
    }

    public HashTableOpenAddressing(int capacity, double loadFactor) {
        this(DOUBLEHASHING, capacity, loadFactor);
    }

    //helpers to help with the tests and methods
    public int getMode() {
        return mode;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getloadFactor() {
        return loadFactor;
    }


    /*
    TODO:
    This constructor takes a mode, capacity, loadFactor, and sets those variables + relevant variables
    according to such. Additionally, it will set up the table according to the capacity.
    If the mode is DOUBLEHASHING, please calculate the previousPrime and set it.
     */
    public HashTableOpenAddressing(int mode, int capacity, double loadFactor) {
        this.mode = mode;
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        this.previousPrime = previousPrime(capacity);
        this.table = (Entry<K, V>[]) new Entry[capacity];
        if(mode == DOUBLEHASHING){
            previousPrime = previousPrime(capacity - 1);
        }
    }

    private int previousPrime(int number) {
        while( true ) {
            if( isPrime( number ) ) {
                return number;
            }
            number--;
        }
    }


    // TODO:
    //  second hash should be prevPrime - (key % prevPrime)...shouldn't be negative
    private int hash2(K key) {
        int newIndex = previousPrime - (key.hashCode() % previousPrime);
        return newIndex;
    }


    // TODO: gets the next index given the index and the offset. Please take into account the mode.
    private int getNextIndex(K key, int offset) {
        int index = hash(key) % capacity;
        if(key == null){
            return 1;
        }
        if (mode == LINEARPROBING) { // LINEARPROBING
            index = (hash(key) + offset) % capacity;
        } else if (mode == QUADRATICPROBING) { //QUADRATIC PROBING
            index = (hash(key) + offset * offset) % capacity;
        } else if (mode == DOUBLEHASHING) { //DOUBLEHASH
            index = Math.abs(hash(key) + offset * hash2(key)) % capacity;
        }
        return index;
    }


    // TODO:
    //  Put a key, value pair into the table.
    //  If the key already exists/inactive, override it. Else, put it into the table.
    //  Throw a RuntimeException if there is an infinite loops.
    public void put(K key, V value) throws RuntimeException{
        int offset = 0;
        Entry e = new Entry<>(key, value);
        while (true){
            int index = getNextIndex(key, offset);
            if(table[index] == null ||table[index].getKey().equals(key) || !table[index].isActive){
                if(table[index] == null || !table[index].isActive){
                    size++;
                }
                table[index] = e;
                if (size >= (loadFactor * capacity)){
                    resize();
                }
                break;
            }
            offset++;
            if(offset >= capacity){
                throw new RuntimeException("Infinite loop.");
            }
        }
    }

    // TODO:
    //  Retrieves the value of a key in the table.
    //  If there is an infinite loop, throw a RuntimeException.
    //  Return null if not there.
    public V get(K key) throws RuntimeException{
        int offset = 0;
        while (true){
            int index = getNextIndex(key, offset);
            if (table[index] == null){
                return null;
            }
            if (table[index].getKey().equals(key) && table[index].getActive()){
                return table[index].getValue();
            }
            offset++;
            if (offset >= capacity){
                throw new RuntimeException("Infinite loop.");
            }
        }
    }

    // TODO: Searches the table to see if the key exists or not.
    public boolean containsKey(K key) {
        int offset = 0;
        while (offset < capacity) {
            int index = getNextIndex(key, offset);
            if (table[index] == null) {
                return false;
            } else if (table[index].getKey().equals(key)) {
                return true;
            } else {
                offset++;
            }
        }
        return false;
    }

    // TODO:
    //  Set the key as inactive if it exists in the table. Return true.
    //  If there is no key, return false.
    //  If there's an infinite loop, throw a RuntimeException.
    public boolean remove(K key) throws RuntimeException {
        int offset = 0;
        while (true) {
            int index = getNextIndex(key, offset);
            if (table[index] == null) {
                return false;
            }
            if (table[index].getKey().equals(key)) {
                if(table[index].isActive){
                    size--;
                    table[index].setActive(false);
                }
                return true;
            }
            offset++;
            if (offset >= capacity){
                throw new RuntimeException("Infinite loop.");
            }
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // TODO:
    //  Calculate the absolute hash of the key. Do not overthink this.
    private int hash(K key) {
        int newIndex = Math.abs(key.hashCode()) % capacity;
        return newIndex;
    }


    private boolean isPrime(int number) {
        for( int i = 2; i <= number / 2; i++ ) {
            if( number % i == 0 ) {
                return false;
            }
        }
        return true;
    }

    private int nextPrime(int number) {
        while( true ) {
            if( isPrime( number ) ) {
                return number;
            }
            number++;
        }
    }

    // TODO:
    //  Set the capacity to the nextPrime of the capacity doubled.
    //  Calculate the previousPrime and set up the new table with the old tables'
    //  contents now hashed to the new.
    private void resize() {
        this.capacity = capacity * 2;
        this.capacity = nextPrime(capacity);
        previousPrime = previousPrime(capacity - 1);
        Entry<K, V>[] newTable = Arrays.copyOf(table, table.length);
        table = new Entry[capacity];
        for (Entry<K, V> i :newTable) {
            if (i == null){
                continue;
        }
            put(i.getKey(), i .getValue());
            size--;
            }
        }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        int index = 0;

        for (Entry<K, V> entry : table) {
            sb.append(index + ": ");
            index++;
            if (entry != null) {
                sb.append(entry.getKey() + "=" + entry.getValue() + ",");
            }
            sb.append(";");
        }

        if (sb.length() > 1) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("}");
        return sb.toString();
    }

    private class Entry<K, V> {
        private K key;
        private V value;

        private boolean isActive;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            isActive = true;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public boolean getActive() {
            return isActive;
        }

        public void setActive(boolean active) {
            isActive = active;
        }
    }

    public static void main(String []args ) {
        HashTableOpenAddressing<Integer, Integer> hashTable = new HashTableOpenAddressing<>(QUADRATICPROBING, 10, 1);

        hashTable.put(2,2);
        System.out.println(hashTable);
        for (int i = 0; i < 280; i += 10) {
            hashTable.put(i, i);
            hashTable.remove(0);
            System.out.println(hashTable.get(i));
        }
    }

}
