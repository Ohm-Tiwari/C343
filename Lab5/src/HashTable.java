import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

public class HashTable {
    private final int INITIAL_CAPACITY = 11;
    private int capacity = INITIAL_CAPACITY;
    private int size = 0;
    private List<LinkedList<Entry>> entries;

    public HashTable() {
        entries = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            entries.add(new LinkedList<>());
        }
    }

    public List<LinkedList<Entry>>getEntries() {
        return entries;
    }

    public int getSize() {
        return size;
    }

    private int hash(String key) {
        int index = key.hashCode() % capacity;
        return index;
    }


    public int put(String key, String value) {
        int index = key.hashCode() % capacity;
        int steps = 1;
        LinkedList<Entry> l = entries.get(index);
        steps++;

        if ((double)size / capacity >= 0.5){
            rehash();
        }

        for(int i = 0; i < l.size() ; i++){
            Entry entry = l.get(i);
            steps++;
            if (entry.key.equals(key)) {
                entry.value = value;
                steps++;
                return steps;
            }
        }
        l.add(new Entry(key, value));
        size++;
        return steps;

    }

    public String get(String key) {
        int index = key.hashCode() % capacity;
        int steps = 0;
        LinkedList<Entry> l = entries.get(index);
        steps++;
        for (int i = 0; i < l.size(); i++) {
            Entry entry = l.get(i);
            steps++;
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    public void remove(String key) {
        int index = key.hashCode() % capacity;
        LinkedList<Entry> l = entries.get(index);
        for (int i = 0; i < l.size(); i++) {
            Entry entry = l.get(i);
            if (entry.key.equals(key)) {
                l.remove(entry);
                size--;
            }
        }


    }

    private void rehash() {

        capacity *= 2;
        List<LinkedList<Entry>> newTable = new ArrayList<>(capacity);
        for (int i = 0 ; i < entries.size() ; i++){
            newTable.add(i, entries.get(i));
        }

        for (int i = entries.size(); i < capacity; i++) {
            newTable.add(i, new LinkedList<>());
        }
        entries = newTable;

    }

    public String StepsTakenToSearch(String key) {
        int index = key.hashCode() % capacity;
        int steps = 1;
        LinkedList<Entry> l = entries.get(index);
        steps++;
        for (int i = 0; i < l.size(); i++) {
            Entry entry = l.get(i);
            steps++;
            if (entry.key.equals(key)) {
                return Integer.toString(steps);
            }
        }
        return Integer.toString(steps);
    }


//used for testing
    public static void main(String[] args) {
            HashTable ht = new HashTable();
            ht.put("ohm", "Student");
            System.out.println("Steps taken to insert 'ohm': " + ht.put("ohm", "Student"));
            ht.put("TJD", "Athlete");
            System.out.println("Steps taken to insert 'TJD': " + ht.put("TJD", "Athlete"));
            ht.put("Nazim", "Professor");
            System.out.println("Steps taken to insert 'Nazim': " + ht.put("Nazim", "Professor"));
            ht.put("Ash", "Student");
            System.out.println("Steps taken to insert 'Ash': " + ht.put("Ash", "Student"));


            System.out.println(" ");


            System.out.println("Steps taken to search 'ohm': " + ht.StepsTakenToSearch("ohm"));
            System.out.println("Steps taken to search 'TJD': " + ht.StepsTakenToSearch("TJD"));
            System.out.println("Steps taken to search 'Nazim': " + ht.StepsTakenToSearch("Nazim"));
            System.out.println("Steps taken to search 'Ash': " + ht.StepsTakenToSearch("Ash"));
        }

    }




