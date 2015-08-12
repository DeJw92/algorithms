package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dawid Pawlak.
 */
public class WeightedGraph {

    private List<Integer> neighbours[];

    private List<Edge> edges;

    @SuppressWarnings("unchecked")
    public WeightedGraph(int numberOfVertices) {
        neighbours = new List[numberOfVertices];
        for(int i=0;i<numberOfVertices;i++) {
            neighbours[i] = new ArrayList<>();
        }
        edges = new ArrayList<>();
    }

    public void addEdge(Edge edge) {
        neighbours[edge.from].add(edges.size());
        edges.add(edge);
    }

    public int getNumberOfVertices() {
        return neighbours.length;
    }

    public List<Integer> getEdgesIds(int vertex) {
        return neighbours[vertex];
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public Edge getEdge(int id) {
        return edges.get(id);
    }
}
