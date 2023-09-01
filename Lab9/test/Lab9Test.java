import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Lab9Test {

    @Test
    void bucketSort() {
        //TODO

        int[] arr = {12 ,2 ,33, 45, 24, 15};
        int[] expected = {2, 12, 15,24, 33, 45};
        Lab9.bucketSort(arr, 2);
        Assertions.assertArrayEquals(expected, arr);

        int[] arrEmpty = {};
        int[] emptyExpectation = {};
        Lab9.bucketSort(arrEmpty, 5);
        Assertions.assertArrayEquals(emptyExpectation, arrEmpty);

        int[] arrNegatives = {-12 ,-2 ,-33, -45, -24, -15, -25, -28, -30, -50, -69, -100};
        int[] negativeExpectation = {-100, -69, -50, -45, -33, -30, -28, -25, -24, -15, -12, -2};
        Lab9.bucketSort(arrNegatives, 5);
        Assertions.assertArrayEquals(negativeExpectation, arrNegatives);





    }

    @Test
    void radixSort() {
        //TODO

        int[] a = {3,2,1};
        int[] sorted = {1,2,3};
        Lab9.radixSort(a);
        Assertions.assertArrayEquals(a, sorted);

        int[] arr = {10,9,8,7,6,5,4,3,2,1};
        int[] ordered = {1,2,3,4,5,6,7,8,9,10};
        Lab9.radixSort(arr);
        Assertions.assertArrayEquals(arr, ordered);
    }

    @Test
    void max() {
        //TODO
        int[] arr = {1 ,2 ,3, 4, 24};
        int[] arrZero = {};
        Assertions.assertEquals(0,Lab9.max(arrZero));
        Assertions.assertEquals(24,Lab9.max(arr));
    }

    @Test
    void min() {
        //TODO
        int[] arr = {3, 2, 1, 4, 24};
        int[] arrZero = {};
        Assertions.assertEquals(0,Lab9.min(arrZero));
        Assertions.assertEquals(1,Lab9.min(arr));
    }
}