import java.util.*;

public class Graph {

    private List<Node> nodes; // List of all nodes
    private HashMap<Node, List<Node>> neighbors; // Adjacency list where the key is the node and the value is the neighbors of that node
    public Node start;
    public Graph(List<Node> nodes, HashMap<Node, List<Node>> neighbors){
        this.nodes = nodes;
        this.neighbors = neighbors;
        start = nodes.get(0);
    }

    /** UNWEIGHTED
     *
     * This method is an implementation of the unweighted shortest paths algorithm.
     * You must implement the algorithm that you learned in class and from the book
     * where you are given a starting node s and must calculate the shortest path to
     * every node and lengths of those paths.
     *
     * To make it easier, you may store the length of the path in the distance
     * variable of the ending node. Paths must be store recursively, meaning every
     * node has a reference to the previous node in the path.
     *
     *      This means for a graph:
     *               A - B - D
     *                  /     \
     *                 C - F - E
     *      The shortest path from A to F is: A, B, C, F and F.getDistance() returns 3
     *
     * For the starting node, the path variable must be set to that node.
     *
     * If you cannot find a path to any specific node, you must set that node's
     * distance variable to Integer.MAX_VALUE, and it's path is simple the
     * disconnected node. If you do not, you will fail autograder tests.
     *
     *
     * @param s Starting node
     */
    void unweighted(Node s) {
        for (Node n : nodes) {
            n.setDistance(Integer.MAX_VALUE);
        }
        s.setDistance(0);
        Queue<Node> queue = new LinkedList<>();
        queue.add(s);

        while (!queue.isEmpty()) {
            Node curr = queue.remove();
            List<Node> currNeighbors = neighbors.get(curr);
            for (Node neighbor : currNeighbors) {
                if (neighbor.getDistance() == Integer.MAX_VALUE) {
                    neighbor.setDistance(curr.getDistance() + 1);
                    neighbor.setPath(curr);
                    queue.add(neighbor);
                }
            }
        }
    }



    /** PATHANDISTANCE
     *
     * Great method, not the best name.
     *
     * This method returns the path found from the unweighted() method earlier.
     * You will find it helpful to also print the distance of each path for
     * testing.
     *
     * Each node has a path variable that tracks the previous node in the path
     * back to the starting node. This method recursively adds those nodes
     * to an arraylist and returns that list.
     *
     * The depth variable is helpful but not required for debugging. When making
     * this you may want to print the distance of each path as well and to do that,
     * only print the distance on your first recursive call. (depth == 0)
     *
     * @param node Node you want to find the shortest path for
     * @param depth Level of depth in recursion (you may ignore this one if you want)
     * @return An arraylist containing the path from the node specified in the most
     *          recent unweighted() call to the node parameter
     */
    ArrayList<Node> pathAndDistance(Node node, int depth){
        //TODO
        return null;
    }
}
