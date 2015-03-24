package graph.MaxFlow;

/**
 * Created by Dawid Pawlak.
 */
public class Edge {
    int from;
    int to;
    int capacity;
    int flow;

    public Edge(int from, int to, int capacity, int flow) {
        this.from = from;
        this.to = to;
        this.capacity = capacity;
        this.flow = flow;
    }
}
