import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrieTest {
    //TODO: Your own JUnit tests for every method

    @Test
    void insertTest(){
        Trie t = new Trie();
        //System.out.println(t.root.children[0].isWord);
        t.insert("a");
        t.insert("aqua");
        t.insert("dad");
        t.insert("data");
        t.insert("day");
        t.insert("days");
        t.insert(null);
    }

    @Test
    void searchTest(){
        Trie t = new Trie();
        t.insert("a");
        t.insert("aqua");
        t.insert("dad");
        t.insert("data");
        t.insert("day");
        t.insert("days");
        t.insert("ohm");

        assertTrue(t.search("ohm"));
        assertFalse(t.search("dane"));

        assertTrue(t.search("a"));

        Trie tNull = new Trie();
        assertFalse(tNull.search("bruh"));
        assertFalse(tNull.search(null));
    }

    @Test
    void deleteTest(){
        Trie t = new Trie();
        t.insert("a");
        t.insert("aqua");
        t.insert("dad");
        t.insert("data");
        t.insert("day");
        t.insert("days");

        assertTrue(t.search("a"));
        assertTrue(t.search("aqua"));
        assertTrue(t.search("dad"));
        assertTrue(t.search("data"));
        assertTrue(t.search("day"));
        assertTrue(t.search("days"));

        t.delete("days");
        assertFalse(t.search("days"));

        t.delete("day");
        assertFalse(t.search("day"));

        t.delete("data");
        assertFalse(t.search("data"));

        t.delete("dad");
        assertFalse(t.search("days"));

        t.delete("aqua");
        assertFalse(t.search("aqua"));

        t.delete("a");
        assertFalse(t.search("a"));


        Trie tNull = new Trie();
        tNull.delete("a");
        tNull.delete(null);
        assertFalse(tNull.search("a"));
    }

}