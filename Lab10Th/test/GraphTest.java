import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    @Test
    void unweighted() {
        //TODO
        Node a = new Node(0);
        Node b = new Node(1);
        Node c = new Node(2);

        // Create the adjacency list for the graph
        HashMap<Node, List<Node>> neighbors = new HashMap<Node, List<Node>>();
        neighbors.put(a, Arrays.asList(b, c));
        neighbors.put(b, Arrays.asList(a));
        neighbors.put(c, Arrays.asList(a));

        // Create the graph
        Graph graph = new Graph(Arrays.asList(a, b, c), neighbors);

        // Run the unweighted algorithm
        graph.unweighted(a);

        // Test the distances and paths
        assertEquals(0, a.getDistance());
        assertEquals(1, b.getDistance());
        assertEquals(1, c.getDistance());

        assertNull(a.getPath());
        assertEquals(a, b.getPath());
        assertEquals(a, c.getPath());

    }

    @Test
    void unweighted2(){
        Node a = new Node(0);
        Node b = new Node(1);
        Node c = new Node(2);

        // Create the adjacency list for the graph (with negative weights)
        HashMap<Node, List<Node>> neighbors = new HashMap<Node, List<Node>>();
        neighbors.put(a, Arrays.asList(b));
        neighbors.put(b, Arrays.asList(a, c));
        neighbors.put(c, Arrays.asList(b));

        // Create the graph
        Graph graph = new Graph(Arrays.asList(a, b, c), neighbors);

        // Run the unweighted algorithm
        graph.unweighted(a);

        // Test the distances and paths
        assertEquals(0, a.getDistance());
        assertEquals(1, b.getDistance());
        assertEquals(2, c.getDistance());

        assertNull(a.getPath());
        assertEquals(a, b.getPath());
        assertEquals(b, c.getPath());
    }

    @Test
    void unweighted3() {
        // Create nodes
        Node a = new Node(0);
        Node b = new Node(1);
        Node c = new Node(2);

        // Create the adjacency list for the graph (disconnected graph)
        HashMap<Node, List<Node>> neighbors = new HashMap<Node, List<Node>>();
        neighbors.put(a, Arrays.asList(b));
        neighbors.put(b, Arrays.asList(a));
        neighbors.put(c, new ArrayList<Node>());

        // Create the graph
        Graph graph = new Graph(Arrays.asList(a, b, c), neighbors);

        // Run the unweighted algorithm
        graph.unweighted(a);

        // Test the distances and paths
        assertEquals(0, a.getDistance());
        assertEquals(1, b.getDistance());
        assertEquals(Integer.MAX_VALUE, c.getDistance());

        assertNull(a.getPath());
        assertEquals(a, b.getPath());
        assertNull(c.getPath());
    }


    @Test
    void pathAndDistance() {
        /**
         * This is not required since you need to call this method to test unweighted()
         * properly, but here is the template if you wish to make your own tests
         */
    }
}