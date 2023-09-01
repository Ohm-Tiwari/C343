import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class GraphTest {

    // TODO: Write accuracy tests + test different graphs :)
    @Test
    void addEdgeTest(){
        Graph graph = new Graph();
        graph.init(5);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        // Test adding edges between nodes
        graph.addEdge(n1, n2, 5);
        graph.addEdge(n1, n3, 10);
        graph.addEdge(n2, n4, 15);
        graph.addEdge(n2, n5, 20);

        assertEquals(2, n1.getEdges().size());
        assertEquals(5, n1.getEdges().get(0).getWeight());
        assertEquals(n2, n1.getEdges().get(0).getDestVertex());
        assertEquals(10, n1.getEdges().get(1).getWeight());
        assertEquals(n3, n1.getEdges().get(1).getDestVertex());

    }

    @Test
    void removeEdgeTest(){
        Graph graph = new Graph();
        graph.init(5);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        // Test adding edges between nodes
        graph.addEdge(n1, n2, 5);
        graph.addEdge(n1, n3, 10);
        graph.addEdge(n2, n4, 15);
        graph.addEdge(n2, n5, 20);

        graph.removeEdge(n1, n2);
        assertEquals(1, n1.getEdges().size());



    }

    @Test
    public void shortestPath1(){
        Node n0 = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        List<Node> nodes = List.of(n0,n1,n2,n3);
        Graph g = new Graph(nodes);

        g.addEdge(n0, n1, 1);
        g.addEdge(n0, n2, 1);
        g.addEdge(n1, n3, 4);
        g.addEdge(n2, n3,2);

        List<Node> traverse = g.shortestPath(0, 3);
        assertEquals(0, n0.getValue());
        assertEquals(1, n2.getValue());
        assertEquals(3, n3.getValue());
        assertEquals(3, traverse.size());
        g.reset();

        traverse = g.shortestPath(2, 0);
        assertNull(traverse);
    }

    @Test
    public void testGraph2() throws IOException {
        List<Node> nodes = new ArrayList<>();
        Graph g = new Graph(nodes);
        String filename = "graph2.txt";
        List<String> lines = Files.readAllLines(new File(filename).toPath());
        int numNodes = Integer.parseInt(lines.get(0));
        g.init(numNodes);

        for (int i = 1; i < lines.size(); i++) {
            String[] parts = lines.get(i).split(" ");
            int srcIndex = Integer.parseInt(parts[0]);
            int destIndex = Integer.parseInt(parts[1]);
            int weight = Integer.parseInt(parts[2]);
            Node src = nodes.get(srcIndex);
            Node dest = nodes.get(destIndex);
            g.addEdge(src, dest, weight);
        }
        List<Node> path = g.shortestPath(0, 5);
        assertEquals(4, path.size());
        assertEquals(0, path.get(0).getName());
        assertEquals(2, path.get(1).getName());
        assertEquals(3, path.get(2).getName());
        assertEquals(5, path.get(3).getName());
        g.reset();
        assertNull(nodes.get(0).getPrev());
        assertEquals(Integer.MAX_VALUE, nodes.get(0).getValue());
    }

    @Test
    public void restTest(){
        Node n0 = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);

        List<Node> nodes = List.of(n0, n1, n2);
        Graph g = new Graph(nodes);

        n0.setValue(1);
        n1.setValue(2);
        n2.setValue(3);

        g.reset();

        assertEquals(Integer.MAX_VALUE, n0.getValue());
        assertEquals(Integer.MAX_VALUE, n1.getValue());
        assertEquals(Integer.MAX_VALUE, n2.getValue());
    }

}
