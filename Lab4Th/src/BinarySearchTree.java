public class BinarySearchTree {

    private int size;
    private BinaryTreeNode root;

    //helper to help with pre,in,post order methods
    private int order;

    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
        this.order = 1;
    }

    public BinaryTreeNode getRoot() {
        return this.root;
    }

    public int getSize() {
        return this.size;
    }


    /**
     * Inserts the given integer and return nothing. It inserts this int such that the tree remains a BST.
     * @param data The integer to be inserted
     */
    public void insert(int data) {
        // TODO
        if (root == null){
            root = new BinaryTreeNode(data, null, null, null);
            size++;
        }
        else{
            insert(data, root);
        }
    }

    /**
     * Inserts the given integer and return nothing. It inserts this int such that the tree remains a BST.
     * @param data The integer to be inserted
     * @param curNode The current Node in the traversal
     */
    private void insert(int data, BinaryTreeNode curNode) {
        // TODO
        if (curNode.getItem() > data) {
            if (curNode.getLeft() == null) {
                curNode.setLeft(new BinaryTreeNode(data, null, null, null));
                size++;
            } else {
                insert(data, curNode.getLeft());
            }
        } else {
            if (curNode.getRight() == null) {
                curNode.setRight(new BinaryTreeNode(data, null, null, null));
                size++;
            } else {
                insert(data, curNode.getRight());
            }
        }
    }

    /**
     * Deletes a Node containing the given integer. If the Node has 2 children, replaces with the Node of the minimum
     * value in the right child of the node. If the data is not present, returns null.
     * @param data The integer to be removed
     * @return The Node containing the integer to remove or null if one is not found
     */
    public BinaryTreeNode remove(int data) {
        // TODO
        if (root == null){
            root = new BinaryTreeNode(data, null, null, null);
            size++;
        }
            return remove(data, root);
    }


    /**
     * Deletes a Node containing the given integer. If the Node has 2 children, replaces with the Node of the minimum
     * value in the right child of the node. If the data is not present, returns null.
     * @param data The integer to be removed
     * @param curNode The current Node in the traversal
     * @return The Node containing the integer to remove or null if one is not found
     */
    private BinaryTreeNode remove(int data, BinaryTreeNode curNode) {
        // TODO
        if (curNode == null) {
            return null;
        }
        if (curNode.getItem() == data) {
            if (curNode.getRight() == null) {
                return curNode.getLeft();
            }
            else if (curNode.getLeft() == null) {
                return curNode.getRight();
            }
            else {
                BinaryTreeNode next = curNode.getRight();
                while (next.getLeft() != null) {
                    next = next.getLeft();
                }
                curNode.setItem(next.getItem());
                curNode.setRight(remove(next.getItem(), curNode.getRight()));
            }
        }
        else if (curNode.getItem() > data) {
            curNode.setLeft(remove(data, curNode.getLeft()));
        }
        else {
            curNode.setRight(remove(data, curNode.getRight()));
        }
        return curNode;
    }

    /**
     * A recursive method that starts at the right child of a parent and extracts the minimum from this child's tree.
     * @param curNode The current Node in the traversal
     * @return The minimum Node in the child's tree
     */
    private BinaryTreeNode extractRightMin(BinaryTreeNode curNode) {
        // TODO
        if (curNode == null){
            return null;
        }
        else if (curNode.getRight() == null){
            return curNode;
        }
        return extractRightMin(curNode.getRight());
    }

    /**
     * Returns a Node containing the given integer or null if one is not found
     * @param data The integer to search for
     * @return A Node containing the given integer or null if one is not found
     */
    public BinaryTreeNode search(int data) {
        if (root == null){
            return null;
        }
        else{
            return search(data, root);
        }
    }

    /**
     * Returns a Node containing the given integer or null if one is not found
     * @param data The integer to search for
     * @param curNode The current Node in the traversal
     * @return A Node containing the given integer or null if one is not found
     */
    private BinaryTreeNode search(int data, BinaryTreeNode curNode) {
        // TODO
        if (curNode == null){
            return null;
        }
        if (curNode.getItem() == data){
            return curNode;
        }
        else if (data < curNode.getItem()){
            return search(data, curNode.getLeft());
        }
        return search(data, curNode.getRight());
    }

    /**
     * Returns the pre-order traversal of this. The output must be in the form of: "x, x, x, x, x, x". Each number
     * except the last is followed by ", ". (i.e. for a tree with one node, the output would take the form: "x")
     * @return A String representation of the traversal
     */
    public String getPreOrderStr() {
        // TODO
        if (root == null){
            return null;
        }
        return getPreOrderStr(root);
    }

    /**
     * Returns the pre-order traversal of this. The output must be in the form of: "x, x, x, x, x, x". Each number
     * except the last is followed by ", ". (i.e. for a tree with one node, the output would take the form: "x")
     * @return A String representation of the traversal
     */
    private String getPreOrderStr(BinaryTreeNode curNode) {
        // TODO
        if (curNode == null) {
            return "";
        }
        if(order == size){
            order = 1;
            return "" + curNode.getItem();
        }
        else{
            order++;
        }
        return curNode.getItem() + ", " + getPreOrderStr(curNode.getLeft()) + getPreOrderStr(curNode.getRight());
    }


    /**
     * Returns the in-order traversal of this. The output must be in the form of: "x, x, x, x, x, x". Each number
     * except the last is followed by ", ". (i.e. for a tree with one node, the output would take the form: "x")
     * @return A String representation of the traversal
     */
    public String getInOrderStr() {
        // TODO
        if (root == null){
            return null;
        }
        return getInOrderStr(root);
    }

    /**
     * Returns the in-order traversal of this. The output must be in the form of: "x, x, x, x, x, x". Each number
     * except the last is followed by ", ". (i.e. for a tree with one node, the output would take the form: "x")
     * @return A String representation of the traversal
     */
    private String getInOrderStr(BinaryTreeNode curNode) {
        // TODO
        if (curNode == null) {
            return null;
        }
        String left = getInOrderStr(curNode.getLeft());
        String right = getInOrderStr(curNode.getRight());
        if (left == null && right == null) {
            return String.valueOf(curNode.getItem());
        } else if (left == null) {
            return curNode.getItem() + ", " + right;
        } else if (right == null) {
            return left + ", " + curNode.getItem();
        } else {
            return left + ", " + curNode.getItem() + ", " + right;
        }
    }


    /**
     * Returns the post-order traversal of this. The output must be in the form of: "x, x, x, x, x, x". Each number
     * except the last is followed by ", ". (i.e. for a tree with one node, the output would take the form: "x")
     * @return A String representation of the traversal
     */
    public String getPostOrderStr() {
        // TODO
        if (root == null){
            return null;
        }
        return getPostOrderStr(root);
    }

    /**
     * Returns the post-order traversal of this. The output must be in the form of: "x, x, x, x, x, x". Each number
     * except the last is followed by ", ". (i.e. for a tree with one node, the output would take the form: "x")
     * @return A String representation of the traversal
     */
    private String getPostOrderStr(BinaryTreeNode curNode) {
        // TODO
        if (curNode == null) {
            return "";
        }
        else if(order == 1){
            if (order != size){
                order++;
            }
            order++;
            return getPostOrderStr(curNode.getLeft()) + getPostOrderStr(curNode.getRight()) + curNode.getItem();
        }
        if (order == size){
            order = 1;
        }
        return getPostOrderStr(curNode.getLeft()) + getPostOrderStr(curNode.getRight()) + curNode.getItem() + ", ";
    }
}
