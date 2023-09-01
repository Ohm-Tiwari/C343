import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GraphLTest {

    @Test
    void nodeCountTest(){
        GraphL g = new GraphL(5);
        assertEquals(5, g.nodeCount());


    }

    @Test
    void edgeCountTest(){
        GraphL g = new GraphL(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        assertEquals(3, g.edgeCount());
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        assertEquals(3, g.edgeCount());

    }

    @Test
    void addEdgeTest(){
        GraphL g = new GraphL(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        assertEquals(3, g.edgeCount());
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        assertEquals(3, g.edgeCount());
    }

    @Test
    void removeEdgeTest(){
        GraphL g = new GraphL(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        assertEquals(3, g.edgeCount());
        g.removeEdge(1,3);
        assertEquals(2, g.edgeCount());
        g.removeEdge(0,2);
        assertEquals(1, g.edgeCount());
        g.removeEdge(0, 1);
        assertEquals(0, g.edgeCount());
    }

    @Test
    void hasEdgeTest(){
        GraphL g = new GraphL(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        assertTrue(g.hasEdge(0,1));
        assertFalse(g.hasEdge(2,4));

    }

    @Test
    void neighborsTest(){
        GraphL g = new GraphL(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 1);
        g.addEdge(2, 2);
        assertEquals("[1, 2]",g.neighbors(0).toString());
        assertEquals("[3]",g.neighbors(1).toString());
        assertEquals("[1, 2]",g.neighbors(2).toString());
    }

    @Test
    void topologicalStackTest() throws CycleDetected {
        Node v0 = new Node(0);
        Node v1 = new Node(1);
        Node v2 = new Node(2);
        Node v3 = new Node(3);

        ArrayList<Node> nodes = new ArrayList<>(Arrays.asList(v0,v1,v2,v3));

        ArrayList<Node>[] neighbors = new ArrayList[4];
        neighbors[0] = new ArrayList<>(Arrays.asList(v1, v2));
        neighbors[1] = new ArrayList<>(Collections.singletonList(v3));
        neighbors[2] = new ArrayList<>(Collections.singletonList(v3));
        neighbors[3] = new ArrayList<>();


        GraphL g = new GraphL(neighbors, nodes);
        List<Node> sort = g.topologicalSortStack();
        assertEquals(4, sort.size());
        assertEquals(v0, sort.get(0));
        assertEquals(v2, sort.get(1)); // these could potentially be switched
        assertEquals(v1, sort.get(2)); // these could potentially be switched
        assertEquals(v3, sort.get(3));
    }

    @Test
    void topologicalSortQueueTest() throws CycleDetected{
        Node v0 = new Node(0);
        Node v1 = new Node(1);
        Node v2 = new Node(2);
        Node v3 = new Node(3);

        ArrayList<Node> nodes = new ArrayList<>(Arrays.asList(v0,v1,v2,v3));

        ArrayList<Node>[] neighbors = new ArrayList[4];
        neighbors[0] = new ArrayList<>(Arrays.asList(v1, v2));
        neighbors[1] = new ArrayList<>(Collections.singletonList(v3));
        neighbors[2] = new ArrayList<>(Collections.singletonList(v3));
        neighbors[3] = new ArrayList<>();


        GraphL g = new GraphL(neighbors, nodes);
        List<Node> sort = g.topologicalSortQueue();
        assertEquals(4, sort.size());
        assertEquals(v0, sort.get(0));
        assertEquals(v1, sort.get(1)); // these could potentially be switched
        assertEquals(v2, sort.get(2)); // these could potentially be switched
        assertEquals(v3, sort.get(3));

    }


}