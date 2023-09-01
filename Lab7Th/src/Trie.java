import com.sun.source.tree.BreakTree;

public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    /* Insert the word into the Trie by making new TrieNodes and marking the last TrieNode as a word.
     * @param word The word to be inserted
     */
    void insert( String word ) {
        //TODO
        if(word == ""){
            return;
        }
        insertHelper(root ,word);
    }

    void insertHelper(TrieNode node, String word) {
        //TODO
        try {
            if (word == null) {
                return;
            }
            if (word.length() == 0) {
                node.isWord = true;
                return;
            }
            int index = (int) word.charAt(0) - (int) 'a';
            if (node.children[index] != null) {
                node = node.children[index];
                word = word.substring(1);
                insertHelper(node, word);
            } else {
                node.children[index] = new TrieNode();
                node = node.children[index];
                word = word.substring(1);
                insertHelper(node, word);
            }
        }catch (IndexOutOfBoundsException e){
            return;
        }
    }

    /* Given a word, returns if it is represented in this Trie.
     * @param word The word to be searched for
            */
    boolean search(String word) {
        //TODO
        if(word == null || word == ""){
            TrieNode newNode = new TrieNode();
            newNode.isWord = false;
            return false;
        }
        return searchHelper(root ,word);
    }

    boolean searchHelper(TrieNode node, String word) {
        //TODO
        try {
            if (word.length() == 0) {
                return node.isWord;
            }
            int index = (int) word.charAt(0) - (int) 'a';
            if (node.children[index] != null) {
                node = node.children[index];
                word = word.substring(1);
                return searchHelper(node, word);
            } else {
                return false;
            }
        }catch (IndexOutOfBoundsException e){
            return false;
        }

    }

    /**
     * Marks the TrieNode representing the last char in the given word is no longer a word.
     * @param word The word to be deleted
     */
    void delete(String word) {
        //TODO
        if (word == null  ||  word == "") {
            TrieNode newNode = new TrieNode();
            newNode.isWord = false;
            return;
        }
        deleteHelper(root, word);
    }

    void deleteHelper(TrieNode node, String word) {
        //TODO
        try {
            if (word.length() == 0) {
                node.isWord = false;
                return;
            }
            int index = (int) word.charAt(0) - (int) 'a';
            if (node.children[index] == null) {
                return;
            }
            node = node.children[index];
            word = word.substring(1);
            deleteHelper(node, word);
        } catch (IndexOutOfBoundsException e) {
            return;
        }
    }
}