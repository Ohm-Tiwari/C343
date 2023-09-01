import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BST<E extends Comparable<E>> implements Tree<E> {

    private int height;
    private int size;
    private BinaryNode<E> root;

    public BST() {
        this.root = null;
        this.height = 1;
        this.size = 0;
    }

    // TODO: BST
    public BST(BinaryNode<E> root) {
        this.root = root;
        this.height = height;
        this.size = size;

    }

    // Access field
    public BinaryNode<E> root() {
        return this.root;
    }

    // Basic properties
    public int height() {
        return this.height;
    }

    public int size() {
        return this.size;
    }

    public boolean isBalanced() {
        return root.isBalanced();
    }

    // TODO: updateHeight - Update the root height to reflect any changes
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




    // Traversals that return lists
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

    // Helpers for BST/AVL methods
    // TODO: extractRightMost
    //    This will be called on the left subtree and will get the maximum value.
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
    // TODO: search
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

    // TODO: insert
    public void insert(E elem) {
        if (root == null) {
            root = new BinaryNode<>(elem);
            size++;
            updateHeight();
            return;
        }
            insert(elem, root);
    }

    private void insert(E elem, BinaryNode<E> curNode) {
        if (elem.compareTo(curNode.data()) < 0) {
            if (curNode.getLeft() == null) {
                BinaryNode<E> newNode = new BinaryNode<>(elem);
                curNode.setLeft(newNode);
                size++;
                updateHeight();
                return;
            } else {
                insert(elem, curNode.left());
            }
        } else {
            if (curNode.getRight() == null) {
                BinaryNode<E> newNode = new BinaryNode<>(elem);
                curNode.setRight(newNode);
                size++;
                updateHeight();
                return;
            } else {
                insert(elem, curNode.right());
            }
        }
    }




    // TODO: delete
    public BinaryNode<E> delete(E elem) {
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
            if (curNode.left() == null && curNode.right() == null){
                size--;
                return null;
            }
            else if (curNode.left() == null || curNode.right() == null){
                    size--;
                if (curNode.left() == null) {
                    return curNode.right();
                } else {
                    return curNode.left();
                }
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
        return curNode;
    }

    // Stuff to help you debug if you want
    // Can ignore or use to see if it works.
    static <E extends Comparable<E>> Tree<E> mkBST (Collection<E> elems) {
        Tree<E> result = new BST<>();
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
