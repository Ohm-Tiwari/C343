import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class HashTable {
    private final int INITIAL_CAPACITY = 11;
    private List<Entry> entries;
    private int size;
    private int capacity = INITIAL_CAPACITY;

    public HashTable() {
        // TODO
        this.size = 0;
        this.entries = new ArrayList<Entry>(capacity);
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public int getSize() {
        return size;
    }
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }

    /**
     * Generates the hash (index) for the given key and the number of collisions encountered. This should be computed
     * using quadratic probing; please implement the function according to the following requirements:
     *  ('keyHashCode' + collisions^2) % capacity
     */
    private int hash(String key, int collisions) {
        // TODO
        return (key.hashCode() + collisions * collisions) % capacity;
    }
    /**
     * Inserts the given key-value pair into the HashTable or updates the value of the current Entry if the key is
     * already stored.
     * Complexity:
     */
    public void put(String key, String value) {
        // TODO
        Entry newEntry = new Entry(key, value);
        if ((double)size / capacity >= 0.5){
            rehash();
        }

        List <Entry> l = entries;
        int collisions = 0;


            for(int i = 0; i < l.size() ; i++){
                if (l.get(i).getKey().equals(newEntry.getKey())) {
                    l.get(i).setValue(newEntry.getValue());
                    size++;
                    entries = l;
                    return;
                }
            }
            l.add(newEntry);
            entries = l;
            size++;

            }

    /**
     * Gets the value from the Entry in the HashTable containing the given key and returns it. Returns null if the key
     * was not found.
     */
    public String get(String key) {
        // TODO
        int index = key.hashCode() % capacity;
        int steps = 0;
        List <Entry> l = entries;
        steps++;
        for (int i = 0; i < l.size(); i++) {
            Entry entry = l.get(i);
            steps++;
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    /**
     * If the key is found in the HashTable, marks the corresponding entry as a deleted (a tombstone).
     * COMPLEXITY: O(N)
     */
    public void remove(String key) {
        // TODO

        List <Entry> l = entries;
        boolean found = false;
        if(this.get(key) != null){
            for (int i = 0 ; i < l.size() ; i++){
                if(l.get(i).getKey().equals(key)){
                    l.remove(i);
                }
            }
        }

            }

    /**
     * Increase the capacity of the 'entries' ArrayList (double the capacity then find the next prime) and puts the
     * key-value pairs of the smaller 'entries' into the
     * COMPLEXITY:
     */
    private void rehash() {
        // TODO
        capacity *= 2;
        int PrimeNext = nextPrime(capacity);
        List<Entry> newTable = new ArrayList<>(capacity);

       for (int i = 0 ; i < entries.size() ; i++){
           newTable.add(i, entries.get(i));
        }
        for (int i = 0; i < capacity; i++) {
            newTable.add(i, null);
        }
        entries = newTable;
    }

    /**
     * Finds the prime immediately following the given number.
     * COMPLEXITY: Big-O of O(N)
     */
    private int nextPrime(int number) {
        // https://stackoverflow.com/a/57904191
        BigInteger b = new BigInteger(String.valueOf(number));
        return (int) Long.parseLong(b.nextProbablePrime().toString());
    }
}
