import java.util.ArrayList;
import java.util.HashMap;

public class TrieNode {
    HashMap<Character, TrieNode> children;
    boolean isWord;
    int frequency;

    // TODO: initialize the TrieNode's properties
    public TrieNode() {
        children = new HashMap<>();
        isWord = false;
        frequency = 0;

    }

    public String toString () {
        return children.toString();
    }

    public boolean isLetter(char c){
        return Character.isLetter(c);
    }

}
