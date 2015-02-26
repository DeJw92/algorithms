package graph.DFS;

import graph.Graph;

/**
 * Created by Dawid Pawlak.
 */

/**
 * DFS
 *
 * Complexity : O(V+E) where V - number of vertices, E - number of edges
 */
public class DepthFirstSearch {

    public void dfs(Graph G, int vertex, boolean visited[]) {
        visited[vertex] = true;
        for(int neighbour : G.getNeighbours(vertex)) {
            if(!visited[neighbour]) {
                dfs(G,neighbour, visited);
            }
        }
    }

}
