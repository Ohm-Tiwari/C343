import java.util.*;


public class Graph {
    private List<Node> nodes;

    public Graph() {
        nodes = new ArrayList<>();
    }

    public Graph(List<Node> nodes) {
        this.nodes = nodes;
    }

    // TODO: Initialize the nodes
    public void init(int n) {
        for (int i = 0; i < n; i++) {
            nodes.add(new Node(i));
        }
    }

    // TODO: not tested for credit technically but this method should reset your node's value
    public void reset() {
        for (Node n : nodes) {
            n.setValue(Integer.MAX_VALUE);
            n.setPrev(null);
        }
    }


    // TODO:
    public void addEdge(Node src, Node dest, int weight) {
        Edge e = new Edge(dest, weight);
        src.getEdges().add(e);

    }

    // TODO: remove the edge from the Node
    public void removeEdge(Node src, Node dest) {
        src.getEdges().removeIf(edge -> edge.getDestVertex().equals(dest));
    }

    // TODO: Return the shortest path from start to dest with the correct cost of the nodes; return null if no path possible
    public List<Node> shortestPath(int start, int dest) {
        reset();
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Node startNode = nodes.get(start);
        startNode.setValue(0);
        pq.offer(startNode);
        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            if(curNode.getName() == dest){
                List<Node> path = new ArrayList<>();
                Node node = curNode;
                while(node != null){
                    path.add(0, node);
                    node = node.getPrev();
                }
                return path;
            }
            for(Edge e : curNode.getEdges()){
                Node neighbor = e.getDestVertex();
                int cost = e.getWeight();
                int totalCost = curNode.getValue() + cost;
                if(totalCost < neighbor.getValue()){
                    neighbor.setValue(totalCost);
                    neighbor.setPrev(curNode);
                    pq.offer(neighbor);
                }
            }
        }
        return null;
    }
}

