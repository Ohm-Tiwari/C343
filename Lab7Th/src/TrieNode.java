public class TrieNode {
    TrieNode [] children;
    boolean isWord;

    //Helpers for the junit testing
    public TrieNode[] getChildren(){
        return children;
    }

    public boolean getisWord(){
        return isWord;
    }

    public TrieNode() {
        //TODO
        children = new TrieNode[26];
        isWord = false;
    }

    boolean isEmpty() {
        //TODO
        for (int i = 0 ; i < children.length; i++){
            if (children[i]  != null){
                return false;
            }
        }
        return true;
    }

}