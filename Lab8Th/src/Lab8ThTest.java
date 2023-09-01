import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Lab8ThTest {

    @Test
    void swap() {
        //TODO
        Lab8Th lab = new Lab8Th();
        int[] empty = null;
        int[] a = {1, 5, 3, 4, 2};
        int[] expected = {1, 2, 3, 4, 5};

        lab.swap(a, 1, 4);
        assertArrayEquals(expected,a);
    }

    @Test
    void insertionSort() {
        //TODO
        Lab8Th lab = new Lab8Th();
        int[] a = {1, 5, 3, 4, 2};
        int[] aSorted = {1, 2, 3, 4, 5};

        int[] b = {100, 30, 24, 20, 15, 10, 5};
        int[] bSorted = {5, 10, 15, 20, 24, 30, 100};
        int[] nullArray = null;


        assertNull(lab.insertionSort(nullArray));
        assertArrayEquals(aSorted,lab.insertionSort(a));
        assertArrayEquals(bSorted,lab.insertionSort(b));
    }

    @Test
    void merge() {
        //TODO
        Lab8Th l = new Lab8Th();
        int n[] ={1,2,5,3,4,6,7};
        int left = 0;
        int middle = 3;
        int right = 6;
        l.merge(n, left, middle, right);

        int m[] ={3,4,5,1,2,6,7};
        int left2 = 0;
        int middle2 = 2;
        int right2 = 6;
        l.merge(m, left2, middle2, right2);

        assertArrayEquals(m, n);
    }

    @Test
    void mergeSort() {
        //TODO
        Lab8Th l = new Lab8Th();
        int n[] ={1,2,5,3,4,6,7};
        int left = 0;
        int middle = 3;
        int right = 6;
        l.mergeSort(n, left, right);


        int m[] ={7,5,3,1,4,2,6};
        int left2 = 0;
        int right2 = 6;
        l.mergeSort(m, left2, right2);

        assertArrayEquals(m, n);
    }
}