import org.junit.jupiter.api.Test;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

public class BSTTest {
    // TODO: Accuracy tests
    @Test
    void updateHeightTest(){
        BST bst = new BST<>();
        //insert example
        bst.insert(10);
        bst.insert(9);
        bst.insert(11);
        bst.insert(5);
        bst.insert(12);

        bst.updateHeight();
        assertEquals(3, bst.height());

    }

    @Test
    void preOrderListTest(){
        BST bstLeft = new BST();
        BST bstRight = new BST();
        BST bst = new BST();
        BST bstNull = new BST();
        assertEquals("[]",bstNull.preOrderList().toString());
        bstLeft.insert(1);
        bstLeft.insert(2);
        bstLeft.insert(3);
        bstLeft.insert(4);
        assertEquals("[1, 2, 3, 4]", bstLeft.preOrderList().toString());

        bstRight.insert(1);
        bstRight.insert(2);
        bstRight.insert(3);
        bstRight.insert(4);
        assertEquals("[1, 2, 3, 4]", bstRight.preOrderList().toString());

        bst.insert(4);
        bst.insert(2);
        bst.insert(6);
        bst.insert(1);
        bst.insert(3);
        bst.insert(5);
        bst.insert(7);
        assertEquals("[4, 2, 1, 3, 6, 5, 7]",bst.preOrderList().toString());
    }

    @Test
    void inOrderListTest(){
        BST bst = new BST();
        BST bstLeft = new BST();
        BST bstRight = new BST();
        BST bstNull = new BST();
        assertEquals("[]",bstNull.inOrderList().toString());
        bst.insert(4);
        bst.insert(2);
        bst.insert(6);
        bst.insert(1);
        bst.insert(3);
        bst.insert(5);
        bst.insert(7);
        assertEquals("[1, 2, 3, 4, 5, 6, 7]",bst.inOrderList().toString());

        bstLeft.insert(1);
        bstLeft.insert(2);
        bstLeft.insert(3);
        bstLeft.insert(4);
        assertEquals("[1, 2, 3, 4]", bstLeft.inOrderList().toString());

        bstRight.insert(1);
        bstRight.insert(2);
        bstRight.insert(3);
        bstRight.insert(4);
        assertEquals("[1, 2, 3, 4]", bstRight.inOrderList().toString());
    }

    @Test
    void postOrderListTest(){
        BST bst = new BST();
        BST bstLeft = new BST();
        BST bstRight = new BST();
        BST bstNull = new BST();
        assertEquals("[]",bstNull.postOrderList().toString());
        bst.insert(4);
        bst.insert(2);
        bst.insert(6);
        bst.insert(1);
        bst.insert(3);
        bst.insert(5);
        bst.insert(7);
        assertEquals("[1, 3, 2, 5, 7, 6, 4]",bst.postOrderList().toString());

        bstLeft.insert(1);
        bstLeft.insert(2);
        bstLeft.insert(3);
        bstLeft.insert(4);
        assertEquals("[4, 3, 2, 1]", bstLeft.postOrderList().toString());

        bstRight.insert(1);
        bstRight.insert(2);
        bstRight.insert(3);
        bstRight.insert(4);
        assertEquals("[4, 3, 2, 1]", bstRight.postOrderList().toString());

    }

    @Test
    void insertTest(){
        BST bst = new BST();
        bst.insert(5);
        assertEquals("[5]", bst.inOrderList().toString());
        bst.insert(9);
        assertEquals("[5, 9]", bst.inOrderList().toString());
        bst.insert(10);
        assertEquals("[5, 9, 10]", bst.inOrderList().toString());
        bst.insert(11);
        assertEquals("[5, 9, 10, 11]", bst.inOrderList().toString());
        bst.insert(12);
        assertEquals("[5, 9, 10, 11, 12]", bst.inOrderList().toString());
        assertEquals(5,bst.size());
    }


    @Test
    void deleteTest(){
        BST bst = new BST();
        bst.insert(5);
        bst.insert(9);
        bst.insert(10);
        bst.insert(11);
        bst.insert(12);
        assertEquals(5, bst.size());

        bst.delete(12);
        assertEquals(null, bst.search(12));
        assertEquals(4, bst.size());

        bst.delete(9);
        assertEquals(3, bst.size());

        bst.delete(10);
        assertEquals(2, bst.size());

        bst.delete(5);
        assertEquals(1, bst.size());

        bst.delete(11);
        assertEquals(0, bst.size());

    }

    @Test
    void searchTest(){
        BST bst1 = new BST();
        bst1.insert(5);
        bst1.insert(9);
        bst1.insert(10);
        bst1.insert(11);
        bst1.insert(12);

        assertEquals(10, bst1.search(10).data());
        assertNotNull(bst1.search(5));
        assertNull(bst1.search(24));
    }

    @Test
    void extractRightMostTest(){
        BST bst = new BST<>();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(1);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);
        BinaryNode<Integer> rightMost = bst.extractRightMost(bst.root());
        assertEquals(8, rightMost.data().intValue());
    }
}
