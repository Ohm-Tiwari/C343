import java.util.ArrayList;
public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public Trie(TrieNode root) {
        this.root = root;
    }

    // Setters & Getters
    public TrieNode getRoot() {
        return this.root;
    }

    public void setRoot(TrieNode root) {
        this.root = root;
    }


    // Actual methods -- part of Lab7
    // TODO:
    void insert(String word) {
        insertHelper(root, word);
    }

    //helper for the insert method
    void insertHelper(TrieNode node, String word) {
        try{
            if (word == null){
                return;
            }
            if (word.length() == 0){
                node.isWord = true;
                node.frequency++;
                return;
            }

            if (!node.children.containsKey(word.charAt(0))) {
                node.children.put(word.charAt(0), new TrieNode());
            }
            node = node.children.get(word.charAt(0));
            insertHelper(node, word.substring(1));
        }
        catch(IndexOutOfBoundsException e){
            return;
        }
    }



    // TODO:
    boolean search(String word) {
        if (word == null || word.isEmpty()) {
            TrieNode newNode = new TrieNode();
            newNode.isWord = false;
            return false;
        }
        return searchHelper(root, word);
    }

    //Helper for the search method
    boolean searchHelper(TrieNode node, String word) {
        if (word.length() == 0) {
            return node.isWord;
        }
        if (node.children.containsKey(word.charAt(0))) {
            TrieNode childNode = node.children.get(word.charAt(0));
            String WordRemain = word.substring(1);
            return searchHelper(childNode, WordRemain);
        } else {
            return false;
        }
    }

    /*
    TODO: Remove the TrieNodes associated with the word. There are 3 cases to be concerned with.
        - key is unique: no part of key contains another key nor is the key itself a prefix of another key in the trie: remove all nodes
        - key is prefix key of another key: unmark the leaf node
        - key has at least one other word as a prefix: delete the nodes from the end of the key :p
        This is NOT the delete you implemented in lab.
 */
    void delete(String word) {
        if (word == null || word.isEmpty()) {
            return;
        }
        deleteHelper(root, word);
    }

    void deleteHelper(TrieNode node, String word) {
        if (word.length() == 0) {
            node.isWord = false;
            return;
        }
        TrieNode child = node.children.get(word.charAt(0));
        if(node.children.containsKey(word.charAt(0))){
            deleteHelper(child, word.substring(1));
        }

        if(child == null){
            return;
        }

        deleteHelper(child, word.substring(1));
        if (!child.isWord && child.children.isEmpty()) {
            node.children.remove(word.charAt(0));
        }
    }

    // TODO: Gets all possible words with the prefix through traversing the Trie. If it's a word, then turn it into an Entry.
    //       If not, ignore. Put the Entry's into a list and return.
    //       Hint: Look at your MazeSolver with a stack for inspiration for the traversal.
    //       EX: If you have prefix "ca", then it should look at all combinations of the words starting with "ca".
    public ArrayList<Entry> generateWordsFromPrefix(String prefix) {
        ArrayList<Entry> ls = new ArrayList<>();
        TrieNode point = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!point.children.containsKey(c)) {
                return ls;
            }
            point = point.children.get(c);
        }
        generateWordsFromPrefixHelper(point, prefix, ls);
        return ls;
    }
    public void generateWordsFromPrefixHelper(TrieNode node, String prefix, ArrayList<Entry> entries){
        if(node.isWord){
            entries.add(new Entry( node.frequency, prefix));

        }
        for(char c : node.children.keySet()){
            generateWordsFromPrefixHelper(node.children.get(c),prefix + c, entries);
        }
    }

    }

