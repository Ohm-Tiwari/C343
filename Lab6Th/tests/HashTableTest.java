import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {
    private final int INITIAL_CAPACITY = 11;


    @Test
    void PutTest(){
        HashTable hashTable = new HashTable();
        hashTable.put("Ohm", "1");
        hashTable.put("Nazim", "2");
        assertEquals("1", hashTable.get("Ohm"));
        assertEquals("2", hashTable.get("Nazim"));
        hashTable.put("Obama", "2");
        assertEquals("2", hashTable.get("Obama"));

    }

    @Test
    void GetTest(){
        HashTable hashTable = new HashTable();
        hashTable.put("Ohm", "Student");
        hashTable.put("Nazim", "Professor");
        assertEquals("Student", hashTable.get("Ohm"));
        assertEquals("Professor", hashTable.get("Nazim"));
        assertEquals(null, hashTable.get("Biden"));
    }

    @Test
    void RemoveTest(){
        HashTable hashTable = new HashTable();
        hashTable.remove("FAIL");

        hashTable.put("Apple", "Cook");
        hashTable.put("Twitter", "Musk");

        assertEquals("Cook", hashTable.get("Apple"));
        assertEquals("Musk", hashTable.get("Twitter"));

        hashTable.remove("Twitter");

        // Check that the removed key-value pair is no longer in the HashTable
        assertNull(hashTable.get("Twitter"));

    }

    @Test
    void RehashTest(){

        HashTable ht = new HashTable();
        ht.setCapacity(2);


        ht.put("Ohm", "Student");
        ht.put("Nazim", "Professor");
        ht.put("brock", "clown");

    }

    @Test
    void NextPrimeTest(){
        HashTable ht = new HashTable();
        //assertEquals(2, ht.nextPrime(1));
       // assertEquals(2, ht.nextPrime(2));


    }




}