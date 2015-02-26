package graph.BFS;

import graph.Graph;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Dawid Pawlak.
 */

/**
 * BFS
 *
 * Complexity : O(V+E) where V - number of vertices, E - number of edges
 */
public class BreadthFirstSearch {

    public int[] bfs(Graph graph, int vertex) {
        Queue<Integer> queue = new ArrayDeque<>();

        int distances[] = new int[graph.getGraphSize()];
        boolean marked[] = new boolean[graph.getGraphSize()];

        queue.add(vertex);
        distances[vertex] = 0;
        marked[vertex] = true;

        while(!queue.isEmpty()) {
            int actualVertex = queue.remove();
            for(int neighbour : graph.getNeighbours(actualVertex)) {
                if(!marked[neighbour]) {
                    queue.add(neighbour);
                    distances[neighbour] = distances[actualVertex] + 1;
                    marked[neighbour] = true;
                }
            }
        }
        return distances;
    }

}
