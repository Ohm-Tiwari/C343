import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrieNodeTest {
    //TODO: Your own JUnit tests for every method

    @Test
    void TrieNodeTest(){
        TrieNode t = new TrieNode();
        TrieNode[] children = t.getChildren();
        boolean isWord = t.getisWord();

        assertNotNull(children);
        assertEquals(26, children.length);
        assertFalse(isWord);
    }

    @Test
    void isEmptyTest(){
        TrieNode t = new TrieNode();
        t.children['o'] = new TrieNode();
        t.children['d'] = new TrieNode();
        assertFalse(t.isEmpty());

        TrieNode tNull = new TrieNode();
        assertTrue(tNull.isEmpty());
    }


}
