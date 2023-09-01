import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;

import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

public class AVLTest {
    // TODO: Accuracy test
    @Test
    void preOrderListTest(){
        AVL avl = new AVL();
        AVL avlNull = new AVL();
        AVL avlLeft = new AVL();
        AVL avlRight = new AVL();
        avl.insert(4);
        avl.insert(2);
        avl.insert(6);
        avl.insert(1);
        avl.insert(3);
        avl.insert(5);
        avl.insert(7);
        assertEquals("[4, 2, 1, 3, 6, 5, 7]",avl.preOrderList().toString());
        assertEquals("[]",avlNull.preOrderList().toString());

        avlLeft.insert(1);
        avlLeft.insert(2);
        avlLeft.insert(3);
        avlLeft.insert(4);
        assertEquals("[1, 2, 3, 4]", avlLeft.preOrderList().toString());

        avlRight.insert(1);
        avlRight.insert(2);
        avlRight.insert(3);
        avlRight.insert(4);
        assertEquals("[1, 2, 3, 4]", avlRight.preOrderList().toString());

    }

    @Test
    void inOrderListTest(){
        AVL avl = new AVL();
        AVL avlNull = new AVL();
        AVL avlLeft = new AVL();
        AVL avlRight = new AVL();
        avl.insert(4);
        avl.insert(2);
        avl.insert(6);
        avl.insert(1);
        avl.insert(3);
        avl.insert(5);
        avl.insert(7);
        assertEquals("[1, 2, 3, 4, 5, 6, 7]",avl.inOrderList().toString());
        assertEquals("[]",avlNull.inOrderList().toString());

        avlLeft.insert(1);
        avlLeft.insert(2);
        avlLeft.insert(3);
        avlLeft.insert(4);
        assertEquals("[1, 2, 3, 4]", avlLeft.inOrderList().toString());

        avlRight.insert(1);
        avlRight.insert(2);
        avlRight.insert(3);
        avlRight.insert(4);
        assertEquals("[1, 2, 3, 4]", avlRight.inOrderList().toString());

    }

    @Test
    void postOrderListTest(){
        AVL avl = new AVL();
        AVL avlNull = new AVL();
        AVL avlLeft = new AVL();
        AVL avlRight = new AVL();
        avl.insert(4);
        avl.insert(2);
        avl.insert(6);
        avl.insert(1);
        avl.insert(3);
        avl.insert(5);
        avl.insert(7);
        assertEquals("[1, 3, 2, 5, 7, 6, 4]",avl.postOrderList().toString());
        assertEquals("[]",avlNull.postOrderList().toString());

        avlLeft.insert(1);
        avlLeft.insert(2);
        avlLeft.insert(3);
        avlLeft.insert(4);
        assertEquals("[4, 3, 2, 1]", avlLeft.postOrderList().toString());

        avlRight.insert(1);
        avlRight.insert(2);
        avlRight.insert(3);
        avlRight.insert(4);
        assertEquals("[4, 3, 2, 1]", avlRight.postOrderList().toString());

    }

    @Test
    void rotateRightTest(){
        AVL avl = new AVL();
        avl.insert(1);
        avl.insert(2);
        avl.insert(3);
        avl.insert(4);
        avl.rotateRight(avl.root());
        assertEquals(2, avl.getRRotations());

    }

    @Test
    void rotateLeftTest(){
        AVL avl = new AVL();
        avl.insert(4);
        avl.insert(3);
        avl.insert(2);
        avl.insert(1);
        avl.rotateLeft(avl.root());
        assertEquals(3, avl.getLRotations());
    }


    @Test
    void insertTest(){
        AVL avl = new AVL();
        avl.insert(5);
        assertEquals("[5]", avl.inOrderList().toString());
        avl.insert(9);
        assertEquals("[5, 9]", avl.inOrderList().toString());
        avl.insert(10);
        assertEquals("[5, 9, 10]", avl.inOrderList().toString());
        avl.insert(11);
        assertEquals("[5, 9, 10, 11]", avl.inOrderList().toString());
        avl.insert(12);
        assertEquals("[5, 9, 10, 11, 12]", avl.inOrderList().toString());

        assertEquals(5, avl.size());

    }


    @Test
    void deleteTest(){
        AVL avl = new AVL();
        avl.insert(5);
        avl.insert(9);
        avl.insert(10);
        avl.insert(11);
        avl.insert(12);
        assertEquals(5, avl.size());

        avl.delete(12);
        assertEquals(null, avl.search(12));
        assertEquals(4, avl.size());

        avl.delete(9);
        assertEquals(3, avl.size());

        avl.delete(10);
        assertEquals(2, avl.size());

        avl.delete(5);
        assertEquals(1, avl.size());

        avl.delete(11);
        assertEquals(0, avl.size());
    }

    @Test
    void searchTest(){
        AVL avl1 = new AVL();
        avl1.insert(5);
        avl1.insert(9);
        avl1.insert(10);
        avl1.insert(11);
        avl1.insert(12);

        assertEquals(10, avl1.search(10).data());
        assertNotNull(avl1.search(5));
        assertNull(avl1.search(24));
    }

}
