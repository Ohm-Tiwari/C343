import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AVL<E extends Comparable<E>> implements Tree<E>{

    private int height;
    private int size;
    private BinaryNode<E> root;
    private int RRotations; // this will be used to see if the amount of rotations was correct
    private int LRotations; // this will be used to see if the amount of rotations was correct

    public AVL(){
        this.root = null;
        this.height = 1;
        this.size = 0;
        this.RRotations = 0;
        this.LRotations = 0;
    }
    public AVL(BinaryNode<E> root){
        this.root = root;
        this.height = root.height();
        this.size = root.size();
        this.RRotations = 0;
        this.LRotations = 0;
    }
    // Access fields
    public int getRRotations(){
        return this.RRotations;
    }
    public int getLRotations(){
        return this.LRotations;
    }
    public BinaryNode<E> root() {
        return this.root;
    }
    public int height() {
        return this.height;
    }
    public int size() {
        return this.size;
    }
    public boolean isBalanced() {
        return root.isBalanced();
    }

    // TODO: updateHeight - same as BST
    public void updateHeight() {
        int leftHeight = 0;
        int rightHeight = 0;
        if (root.left() != null) {
            leftHeight = root.left().height();
        }
        if (root.right() != null) {
            rightHeight = root.right().height();
        }
        this.height = 1 + Math.max(leftHeight, rightHeight);
    }

    // TODO: Preorder traversal
    public List<E> preOrderList() {
        List<E> preOrder = new ArrayList<>();
        if (root == null) {
            return preOrder;
        }
        preOrderTraversal(root, preOrder);
        return preOrder;

    }

    private void preOrderTraversal(BinaryNode<E> node, List<E> preOrder){
        if (node == null){
            return;
        }
        preOrder.add(node.data());
        preOrderTraversal(node.left(),preOrder);
        preOrderTraversal(node.right(),preOrder);
    }

    // TODO: Inorder traversal
    public List<E> inOrderList() {
        List<E> inOrder = new ArrayList<>();
        if (root == null) {
            return inOrder;
        }
        inOrderTraversal(root, inOrder);
        return inOrder;
    }

    private void inOrderTraversal(BinaryNode<E> node, List<E> inOrder){
        if (node == null){
            return;
        }
        inOrderTraversal(node.left(),inOrder);
        inOrder.add(node.data());
        inOrderTraversal(node.right(),inOrder);
    }

    // TODO: Postorder traversal
    public List<E> postOrderList() {
        List<E> postOrder = new ArrayList<>();
        if (root == null) {
            return postOrder;
        }
        postOrderTraversal(root, postOrder);
        return postOrder;
    }

    private void postOrderTraversal(BinaryNode<E> node, List<E> postOrder){
        if (node == null){
            return;
        }
        postOrderTraversal(node.left(),postOrder);
        postOrderTraversal(node.right(),postOrder);
        postOrder.add(node.data());
    }


    /*
    TODO: rotateRight
     *              x                          y
     *            /   \                      /   \
     *           y     C     ===>           A     x
     *         /   \                             /  \
     *        A    B                            B    C
     * You should never rotateRight if the left subtree is empty.
     * Make sure you increment the RRotations.
    */
    public void rotateRight(BinaryNode<E> node){
        BinaryNode<E> lChild = node.left();
        if (lChild == null){
            RRotations++;
            return;
        }
        node.setLeft(lChild.right());
        lChild.setRight(node);
        updateHeight();
        RRotations++;
        }

    /*
     TODO: rotateLeft
      *              x                          y
      *            /   \                      /   \
      *           y     C     <==           A     x
      *         /   \                             /  \
      *        A    B                            B    C
      * You should never rotateLeft if the right subtree is empty.
      * Make sure you increment the LRotations.
      * Symmetrical to above.
     */
    public void rotateLeft(BinaryNode<E> node){
        BinaryNode<E> rChild = node.right();
        if (rChild == null){
            LRotations++;
            return;
        }
        node.setRight(rChild.left());
        rChild.setLeft(node);
        updateHeight();
        LRotations++;
    }

    /*
     TODO: possibleRotateRight
      * If the current node is unbalanced with the right tree height being smaller
      * than the left subtree height, rotate right. Otherwise, don't do anything.
    */
    public void possibleRotateRight(BinaryNode<E> node){
        if (node == null){
            return;
        }
        if (node.left() != null && node.right() != null){
            if ((node.left().height() - node.right().height()) > 1){
                rotateRight(node);
                updateHeight();
                RRotations++;
            }
        }
    }

    /*
     TODO: possibleRotateLeft
      * If the current node is unbalanced with the left tree height being smaller
      * than the right subtree height, rotate left. Otherwise, don't do anything.
    */
    public void possibleRotateLeft(BinaryNode<E> node){
        if (node.left() != null && node.right() != null){
            if ((node.right().height() - node.left().height()) < -1){
                rotateLeft(node);
                updateHeight();
                LRotations++;
            }
        }
    }

    /*
     TODO: mkBalanced
      * Given a node, balance it if the heights are unbalanced.
      * Hint: rotations!!!
    */
    public void mkBalanced(BinaryNode<E> node) {
        if (node == null) {
            return;
        }
        mkBalanced(node.left());
        mkBalanced(node.right());
        int leftHeight = 0;
        if (node.left() != null) {
            leftHeight = node.left().height();
        }
        int rightHeight = 0;
        if (node.right() != null) {
            rightHeight = node.right().height();
        }
        if (leftHeight - rightHeight > 1) {
            if (node.left().right().height() > node.left().left().height()) {
                rotateLeft(node.left());
                rotateRight(node);
            } else {
                rotateRight(node);
            }
        } else if (rightHeight - leftHeight > 1) {
            if (node.right().left().height() > node.right().right().height()) {
                rotateRight(node.right());
                rotateLeft(node);
            }
            else{
                rotateLeft(node);
            }
        }
    }

    // Helpers for BST/AVL methods
    // TODO: extractRightMost - identical to BST
    public BinaryNode<E> extractRightMost(BinaryNode<E> curNode) {
        if (curNode == null){
            return null;
        }
        else if (curNode.getRight() == null){
            return curNode;
        }
        return extractRightMost(curNode.right());
    }

    // AVL & BST Search & insert same
    // TODO: search - identical to BST
    public BinaryNode<E> search(E elem) {

        if (root == null){
            return null;
        }
        else{
            return search(elem, root);
        }
    }
    private BinaryNode<E> search(E data, BinaryNode<E> curNode) {
        if (curNode == null){
            return null;
        }
        if (curNode.data() == data){
            return curNode;
        }
        else if (data.compareTo(curNode.data()) < 0){
            return search(data, curNode.left());
        }
        return search(data, curNode.right());
    }

    /*
     TODO: insert - slightly different from BST but similar logic
      * Hint: mkBalanced will be your best friend here.
    */
    public void insert(E elem) {
        if (root == null){
            root = new BinaryNode<>(elem, null, null, null);
            size++;
            height = 1;
            return;
        }

        insert(elem, root);
        updateHeight();
        mkBalanced(root);
    }

    private void insert(E elem, BinaryNode<E> curNode) {
        if (elem == null) {
            return;
        }
        if (curNode == null) {
            this.root = new BinaryNode<E>(elem);
            size++;
            updateHeight();
        }

            if (elem.compareTo(curNode.data()) < 0) {
                if (curNode.left() == null) {
                    BinaryNode<E> newNode = new BinaryNode<>(elem);
                    curNode.setLeft(newNode);
                    size++;
                    updateHeight();
                    mkBalanced(curNode);
                } else {
                    insert(elem, curNode.left());
                    updateHeight();
                    mkBalanced(curNode);
                }
            } else if (elem.compareTo(curNode.data()) > 0) {
                if (curNode.right() == null) {
                    BinaryNode<E> newNode = new BinaryNode<>(elem);
                    curNode.setRight(newNode);
                    size++;
                    updateHeight();
                    mkBalanced(curNode);
                } else {
                    insert(elem, curNode.right());
                    updateHeight();
                    mkBalanced(curNode);
                }
            }
        }




    /*
     TODO: delete - slightly different from BST but similar logic
      * Hint: mkBalanced will be your best friend here.
    */
    public BinaryNode<E> delete(E elem) {
        //size--;
        return delete(elem, root);
    }

    private BinaryNode delete(E elem, BinaryNode<E> curNode) {
        if (curNode == null) {
            return null;
        }
        if (elem.compareTo(curNode.data()) < 0) {
            curNode.setLeft(delete(elem, curNode.left()));
        }
        else if (elem.compareTo(curNode.data()) > 0) {
            curNode.setRight(delete(elem, curNode.right()));
        }
        else {
            if (curNode.left() == null){
                size--;
                return curNode.right();
            }
            else if (curNode.right() == null) {
                size--;
                return curNode.left();
            }
            else {
                BinaryNode<E> next = curNode.right();
                while (next.left() != null) {
                    next = next.left();
                }
                curNode.setData(next.data());
                curNode.setRight(delete(next.data(), curNode.right()));
            }
        }
        updateHeight();
        mkBalanced(curNode);
        return curNode;
    }

    // Stuff to help you debug if you want
    // Can ignore or use to see if it works.
    static <E extends Comparable<E>> Tree<E> mkAVL (Collection<E> elems) {
        Tree<E> result = new AVL<>();
        for (E e : elems) result.insert(e);
        return result;
    }
    public TreePrinter.PrintableNode getLeft() {
        return this.root.hasLeft() ? this.root.left() : null;
    }
    public TreePrinter.PrintableNode getRight() {
        return this.root.hasRight() ? this.root.right() : null;
    }
    public String getText() {
        return (this.root != null) ? this.root.getText() : "";
    }

}
