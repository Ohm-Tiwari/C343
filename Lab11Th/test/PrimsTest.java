import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PrimsTest {

    /**
     * Some test inspiration...
     *
     * What if a graph had a disconnected node?
     *
     * What if a MST was a line?
     *     Example:
     *      0 > 1
     *      1 > 2
     *      2 > 3
     *
     * What if a MST was NOT in a line?
     *     Example:
     *      0 > 1
     *      0 > 2
     *      0 > 3
     */
    @Test
    void mst(){
        int[][] graphArr = {
                {0, 1, 0, 1},
                {1, 0, 0, 0},
                {0, 0, 0, 1},
                {1, 0, 1, 0}};
        Graph g = new Graph(graphArr);
        Prims p = new Prims();

        int[] expected = { -1, 0, 3, 0};
        assertArrayEquals(expected , p.mst(g));

        int[] m = p.mst(g);
        //System.out.println(Arrays.toString(m));
    }

    @Test
    void mst2(){
        int[][] graphArr = {
                {0, 1, 0, 0},
                {1, 0, 0, 0},
                {0, 0, 0, 1},
                {0, 0, 1, 0}};
        Graph g = new Graph(graphArr);
        Prims p = new Prims();
        assertThrows(DisconnectedGraphException.class, () -> p.mst(g));
    }

    @Test
    void minIndex() {
        int[] weights = {2, 5, 1, 4, 3};
        Boolean[] mstSet = {false, false, false, false, false};
        int numNodes = 5;
        Prims p = new Prims();

        assertEquals(2,p.minIndex(weights, mstSet, numNodes));

    }

    @Test
    void minIndex2(){
        int[] weights = {2, 5, 1, 4, 3};
        Boolean[] mstSet = {true, true, true, true, true};
        int numNodes = 5;
        Prims p = new Prims();

        assertEquals(-1, p.minIndex(weights, mstSet, numNodes));
    }

    @Test
    void minIndex3(){
        int[] weights = {2, 5, 1, 4, 3};
        Boolean[] mstSet = {false, true, false, true, true};
        int numNodes = 5;
        Prims p = new Prims();

        assertEquals(2, p.minIndex(weights, mstSet, numNodes));
    }
}