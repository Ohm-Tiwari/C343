import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {


    @Test
    void putTest(){
        HashTable hashTable = new HashTable();

        hashTable.put("Ohm", "Student");
        hashTable.put("Nazim", "Professor");
        assertEquals("Student", hashTable.get("Ohm"));
        assertEquals("Professor", hashTable.get("Nazim"));

    }

    @Test
    void getTest(){
        HashTable hashTable = new HashTable();
        hashTable.put("Ohm", "Student");
        hashTable.put("Nazim", "Professor");
        assertEquals("Student", hashTable.get("Ohm"));
        assertEquals("Professor", hashTable.get("Nazim"));
        assertEquals(null, hashTable.get("Biden"));

    }

    @Test
    void removeTest(){
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
    void rehashTest(){
        HashTable hashTable = new HashTable();
        HashTable hashTable2 = new HashTable();

        hashTable.put("Ohm", "Student");
        hashTable.put("Nazim", "Professor");


    }

}