package graph;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dawid Pawlak.
 */
public class DirectedGraph {

    private Set<Integer> neighbours[];

    private int inDegree[];

    @SuppressWarnings("unchecked")
    public DirectedGraph(int numberOfVertices) {
        neighbours = new Set[numberOfVertices];
        inDegree = new int[numberOfVertices];
        for(int i=0;i<numberOfVertices;i++) {
            neighbours[i] = new HashSet<>();
        }
    }

    public void addEdge(int from, int to) {
        neighbours[from].add(to);
        inDegree[to]++;
    }

    public Set<Integer> getNeighbours(int vertex) {
        return neighbours[vertex];
    }

    public int getGraphSize() {
        return neighbours.length;
    }

    public int getInDegree(int vertex) {
        return inDegree[vertex];
    }

    public int getOutDegree(int vertex) {
        return neighbours[vertex].size();
    }
}
