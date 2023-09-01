import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    @Test
    void insertTest(){
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(1);
        bst.insert(2);
        bst.insert(3);
        bst.insert(4);
        bst.insert(5);
        assertEquals(5, bst.getSize());
        assertEquals(1, bst.getRoot().getItem());

    }

    @Test
    void removeTest(){
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(8);
        bst.insert(2);
        bst.insert(16);


        // Test removing a leaf node
        BinaryTreeNode removedNode = bst.remove(3);
        assertEquals(8, removedNode.getItem());
    }



    @Test
    void searchTest(){
        BinarySearchTree bst1 = new BinarySearchTree();
        bst1.insert(1);
        BinaryTreeNode node = bst1.search(1);
        assertEquals(1, node.getItem());

        BinarySearchTree bst2 = new BinarySearchTree();
        bst2.insert(1);
        bst2.insert(2);
        bst2.insert(3);
        BinaryTreeNode node2 = bst2.search(2);
        assertEquals(2, node2.getItem());

        BinarySearchTree bstNull = new BinarySearchTree();
        assertNull(bstNull.search(1));
    }

    @Test
    void getPreOrderStrTest(){
        BinarySearchTree bst = new BinarySearchTree();
        BinarySearchTree bstNull = new BinarySearchTree();
        bst.insert(4);
        bst.insert(2);
        bst.insert(6);
        bst.insert(1);
        bst.insert(3);
        bst.insert(5);
        bst.insert(7);
        assertEquals("4, 2, 1, 3, 6, 5, 7",bst.getPreOrderStr());
        assertEquals(null,bstNull.getInOrderStr());

    }

    @Test
   void getInOrderTest(){
        BinarySearchTree bst = new BinarySearchTree();
        BinarySearchTree bstNull = new BinarySearchTree();
        bst.insert(1);
        bst.insert(2);
        bst.insert(3);
        bst.insert(4);
        bst.insert(5);
        bst.insert(6);
        bst.insert(7);
        assertEquals("1, 2, 3, 4, 5, 6, 7",bst.getInOrderStr());
        assertEquals(null,bstNull.getInOrderStr());


    }

    @Test
    void getPostOrderTest(){
        BinarySearchTree bst = new BinarySearchTree();
        BinarySearchTree bstNull = new BinarySearchTree();
        bst.insert(4);
        bst.insert(5);
        bst.insert(2);
        bst.insert(6);
        bst.insert(7);
        bst.insert(3);
        bst.insert(1);
        assertEquals("1, 3, 2, 7, 6, 5, 4",bst.getPostOrderStr());
        assertEquals(null,bstNull.getInOrderStr());


    }

}