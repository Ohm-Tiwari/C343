public class Node implements Comparable {
    private String keyword;
    private List<String> references;

    // TODO: given some keyword, and mode (1 = arraylist 2 = sorted arraylist) set up the Node
    public Node(String keyword, int mode){
        this.keyword = keyword;
        if (mode == 1){
            this.references = new ArrayList<>();
        }
        else if (mode == 2){
            this.references = new SortedArrayList<>();
        }
    }

    public String getKeyword(){
        return this.keyword;
    }

    public List getReferences(){
        return this.references;
    }

    public void insertReference(String website){
        this.references.add(website);
    }


    // TODO: Compare some other Node to this Node, String compareTo is your bestfriend here; return -1 if the other object of comparison isn't a Node
    public int compareTo(Object o){

        if(!(o instanceof Node)){
            return -1;
        }
        Node otherNode = (Node) o;
        return this.keyword.compareTo(otherNode.keyword);

    }

    // TODO: similar to compareTo except in boolean format and is only concerned if the other Node has the same keyword or not
    public boolean equals (Object o) {
        if (o instanceof Node) {
            Node other = (Node) o;
            return this.keyword.equals(other.keyword);
        }
        else return false;
    }

    public String toString(){
        return this.keyword + " " + this.references;
    }


}
