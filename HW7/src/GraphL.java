import java.util.*;

class CycleDetected extends Exception{}

public class GraphL implements Graph {
    // An Array of nodes where each item points to a list of adjacent nodes
    private List<Node>[] nodeArray;
    // A List of nodes that will be referenced in the nodeArray
    private List<Node> nodes;
    // Number of edges in the graph
    private int numEdge;

    public GraphL(int n) {
        this.nodeArray = new ArrayList[n];
        this.nodes = new ArrayList<>();
        init(n);
    }

    // TODO:
    public GraphL(List<Node>[] nodeArray, List<Node> nodes) {
        this.nodeArray = nodeArray;
        this.nodes = nodes;
        numEdge = edgeCount();
    }

    // Implement the missing functions here:
    // TODO:
    public void init(int n) {
        this.nodes = new ArrayList<>(n);
        this.nodeArray = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            this.nodeArray[i] = new ArrayList<>();
            Node nodeNew = new Node(i);
            this.nodes.add(nodeNew);
        }
    }

    // Hint: may need a reset function for the Runner class (not in the Interface)
    public void reset() {

    }

    // TODO:
    public int nodeCount() {
        return nodes.size();
    }

    // TODO:
    public int edgeCount() {
        int edgeAmount = 0;
        for (int i = 0; i < nodeArray.length; i++) {
            edgeAmount += nodeArray[i].size();
        }
        numEdge = edgeAmount;
        return edgeAmount;

    }

    // TODO:
    public void addEdge(int v, int w) {
        if (!hasEdge(v, w)) {
            nodeArray[v].add(nodes.get(w));
            numEdge++;
        }
    }

    // TODO:
    public void removeEdge(int v, int w) {
        if (hasEdge(v, w)) {
            nodeArray[v].remove(nodes.get(w));
            numEdge--;
        }

    }

    // TODO:
    public boolean hasEdge(int v, int w) {
        for (int i = 0; i < nodeArray[v].size(); i++) {
            if (nodeArray[v].get(i).getName() == w) {
                return true;
            }
        }
        return false;
    }

    // TODO:
    public List<Node> neighbors(int v) {
        return nodeArray[v];
    }

    // TODO: Implement topological sort with stack.
    /*
    Potential way to implement:
    1. For each node in the nodes, you can perform DFS
     */
    // Hint: think of how you can use the value of the Node (not the name)
    public List<Node> topologicalSortStack() throws CycleDetected {
        List<Node> ordered = new ArrayList<>();
        Stack<Node> stack = new Stack<Node>();

        for (Node n : nodes) {
            if (!n.getVisited()) {
                topologicalSortStackHelper(n, ordered, stack);
            }
        }

        Collections.reverse(ordered);
        return ordered;

    }


    private void topologicalSortStackHelper(Node node, List<Node> ordered, Stack<Node> stack) throws CycleDetected {
        node.setVisited();
        stack.add(node);
        int nodeNames = node.getName();
        for (Node neighbor : neighbors(nodeNames)) {
            if (!neighbor.getVisited()) {
                topologicalSortStackHelper(neighbor, ordered, stack);
            } else if (stack.contains(neighbor)) {
                throw new CycleDetected();
            }
        }
        ordered.add(node);
        stack.remove(node);
    }


    // TODO: Implement topological sort with queue.
    /*
    Potential way to implement:
    1. Go through the edges and set the value of the node to the number of incoming edges and unvisited.
    2. Push nodes that have 0 incoming edges into the queue.
    3. Implement BFS
        -Everytime you process a node, decrease it's value.
     */
    public List<Node> topologicalSortQueue() throws CycleDetected {
        List<Node> ordered = new ArrayList<>();
        int[] edgeNew = new int[nodeCount()];

        for (int i = 0; i < nodeCount(); i++) {
            for (Node n : neighbors(i)) {
                edgeNew[n.getName()]++;
            }
        }

        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < nodeCount(); i++) {
            if (edgeNew[i] == 0) {
                q.offer(new Node(i));
            }
        }



        while (!q.isEmpty()) {
            Node n = q.poll();
            ordered.add(n);


            for (Node neighbor : neighbors(n.getName())) {
                int indexNeighbor = neighbor.getName();
                edgeNew[indexNeighbor]--;

                if (edgeNew[indexNeighbor] == 0) {
                    q.offer(new Node(indexNeighbor));
                }
            }
        }
        if (ordered.size() != nodeCount()){
            throw new CycleDetected();
        }
        return ordered;
    }

}

