package graph;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dawid Pawlak.
 */

/**
 * Implementation of undirected graph
 */

public class Graph {

    private Set<Integer> neighbours[];

    @SuppressWarnings("unchecked")
    public Graph(int numberOfVertices) {
        neighbours = new Set[numberOfVertices];
        for(int i=0;i<numberOfVertices;i++) {
            neighbours[i] = new HashSet<>();
        }
    }

    public void addEdge(int from, int to) {
        neighbours[from].add(to);
        neighbours[to].add(from);
    }

    public Set<Integer> getNeighbours(int vertex) {
        return neighbours[vertex];
    }

    public int getGraphSize() {
        return neighbours.length;
    }

}
