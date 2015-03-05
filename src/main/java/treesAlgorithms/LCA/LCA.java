package treesAlgorithms.LCA;

import graph.Graph;

/**
 * Created by Dawid Pawlak.
 */

/**
 * Implementation of lowest common ancestor algorithm

 * Initialization : O(N log N ) time
 * Every query : O( log N ) time
 *
 * where N is a number of vertices
 */
public class LCA {

    private int LOGN;

    /**
     * ancestors[i][j] = 2^j ancestor of vertex i
     */
    private int ancestors[][];

    private int heights[];

    private Graph graph;

    public LCA(Graph graph) {
        LOGN = log2(graph.getGraphSize());
        ancestors = new int[graph.getGraphSize()][LOGN];
        heights = new int[graph.getGraphSize()];
        this.graph = graph;
        dfs(0,-1);
    }

    private int goUp(int vertex, int count) {
        for (int i = 0; i < LOGN; i++) {
            if (((count >> i) & 1) == 1) {
                vertex = ancestors[vertex][i];
            }
        }
        return vertex;
    }

     int lca(int a, int b) {
        if(heights[a] < heights[b]) return lca(b, a);

        a = goUp(a, heights[a] - heights[b]);
        if(a == b) return a;

        for(int i=LOGN-1;i>=0; i--) {
            if(ancestors[a][i] != ancestors[b][i]) {
                a = ancestors[a][i];
                b = ancestors[b][i];
            }
        }

        return ancestors[a][0];
    }

    private void dfs(int vertex, int parent) {
        ancestors[vertex][0] = parent;
        if(parent != -1) {
            heights[vertex] = heights[parent] + 1;
        }
        for(int i=1;i< LOGN; i++) {
            if(ancestors[vertex][i-1] != -1) {
                ancestors[vertex][i] = ancestors[ancestors[vertex][i-1]][i-1];
            }
        }
        for(int neighbour : graph.getNeighbours(vertex)) {
            if(neighbour != parent) {
                dfs(neighbour, vertex);
            }
        }
    }

    private int log2(int n) {
        int result = 0;
        while((n >>= 1) != 0) {
            result++;
        }
        return (result+1);
    }

}
