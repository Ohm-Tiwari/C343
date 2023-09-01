import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
public class TrieTest {
    // TODO: accuracy tests

    @Test
    void insertTest(){
        Trie t = new Trie();
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

    @Test
    void generateWordsFromPrefixTest(){
        Trie t = new Trie();
        t.insert("cat");
        t.insert("calf");
        t.insert("cant");
        t.insert("rome");
        ArrayList<Entry> arr = t.generateWordsFromPrefix("ca");
        ArrayList<Entry> res = new ArrayList<>();
        res.add(new Entry(0, "cat"));
        res.add(new Entry(0, "calf"));
        res.add(new Entry(0, "cant"));
        assertArrayEquals(res.toArray(), arr.toArray());

    }

}
