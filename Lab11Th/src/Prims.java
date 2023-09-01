import org.w3c.dom.Node;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Prims {

    /** MST
     *
     * Implement Prim's Minimum Spanning Tree Algorithm
     *
     * Prim's algorithm is a greed algorithm that will
     * find the minimum edge of all edges connected to
     * the MST.
     *
     * This means that you will need to know which nodes
     * you have visited, which nodes are in the MST, and
     * which nodes you can reach from the edges in the
     * MST already.
     *
     * For a quick, more visual explanation see:
     *  https://www.youtube.com/watch?v=cplfcGZmX7I
     *
     *
     * One important note about the mst array.
     * It does not contain information on the weights,
     * only the nodes of the edges.
     *         i        = u
     *       mst[i]     = v
     * graph[i][mst[i]] = weight(u, v)
     *
     * @param graph
     * @return a Minimum Spanning Tree of the graph
     */
    public int[] mst(Graph graph){
        //TODO
        int[] p = new int[graph.getNumNodes()];
        int[] weights = new int[graph.getNumNodes()];
        Boolean[] mstSet = new Boolean[graph.getNumNodes()];

        for(int i = 0; i < graph.getNumNodes(); i++){
            weights[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }
            weights[0] = 0;
            p[0] = -1;


        for(int i = 0; i< graph.getNumNodes()-1; i++){
            int minI = minIndex(weights , mstSet, graph.getNumNodes());
            if(minI == -1){
                throw new DisconnectedGraphException();
            }
            mstSet[minI] = true;

            for(int j = 0; j< graph.getNumNodes(); j++){
                if(graph.getEdge(minI,j) != 0 && !mstSet[j] && graph.getEdge(minI,j)<weights[j]){
                    p[j] = minI;
                    weights[j] = graph.getEdge(minI,j);
                }
            }

        }
        //System.out.println(Arrays.toString(p));
        return p;
    }

    /** MININDEX
     *
     * When given a mst in progress, return the index of the weight
     * array of the minimum edge weight that is NOT in the MST.
     *
     * the mstSet array returns true if a node u is in the mst.
     *
     * @param weights array of weights
     * @param mstSet array of nodes in the MST
     * @param numNodes number of nodes in a MST
     * @return index of the smallest weight.
     */
    int minIndex(int weights[], Boolean mstSet[], int numNodes) {
        //TODO
        int minWeight = Integer.MAX_VALUE;
        int Indexmin = -1;
        for (int i = 0; i < numNodes; i++) {
            if (!mstSet[i] && weights[i] < minWeight) {
                minWeight = weights[i];
                Indexmin = i;
            }
        }

        return Indexmin;
    }
}
