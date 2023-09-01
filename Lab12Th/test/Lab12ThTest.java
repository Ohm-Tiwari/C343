import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Lab12ThTest {

    @Test
    void houseRobbersBottomUp() {
        //TODO
        Lab12Th l = new Lab12Th();
        int[] houses = {1, 0, 1, 4, 1};
        assertEquals(5, l.houseRobbersBottomUp(houses));

        int[] housesEmpty = {};
        assertEquals(0, l.houseRobbersBottomUp(housesEmpty));

        int[] housesNull = null;
        assertEquals(0, l.houseRobbersBottomUp(housesNull));

//        int[] housesNegative = {-1, -2, -3, -4, -5};
//        assertEquals(0, l.houseRobbersBottomUp(housesNegative));

        int[] housesZero = {0};
        assertEquals(0, l.houseRobbersBottomUp(housesZero));

        int[] housesOneDigit = {24};
        assertEquals(24,l.houseRobbersBottomUp(housesOneDigit));

        int[] housesTwoDigits = {2, 4};
        assertEquals(4, l.houseRobbersBottomUp(housesTwoDigits));

        int[] housesTwoDigitsTwo = {4, 2};
        assertEquals(4, l.houseRobbersBottomUp(housesTwoDigitsTwo));

    }

    @Test
    void knapSackTopDown() {
        //TODO
        /**
         *         capacity = 4
         *         weights = [2, 2, 3]
         *         profits = [1, 1, 3]
         *         n = 3
         */
        Lab12Th l = new Lab12Th();
        int capacity1 = 4;
        int[] weights1 = {2, 2, 3};
        int[] profits1 = {2, 2, 3};
        int n1 = 3;
        assertEquals(3, l.knapSackTopDown(capacity1, weights1, profits1, n1));

        int capacity2 = 4;
        int[] weights2 = {2, 2, 3};
        int[] profits2 = {2, 2, 3};
        int n2 = 3;
        assertEquals(3, l.knapSackTopDown(capacity2, weights2, profits2, n2));

    }

    @Test
    void knapSackBottomUp() {
        //TODO
        Lab12Th l = new Lab12Th();
        int capacity1 = 4;
        int[] weights1 = {2, 2, 3};
        int[] profits1 = {2, 2, 3};
        int n1 = 3;
        assertEquals(3, l.knapSackBottomUp(capacity1, weights1, profits1, n1));


    }
}