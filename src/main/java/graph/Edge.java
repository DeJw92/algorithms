package graph;

/**
 * Created by Dawid Pawlak.
 */

public class Edge {
    public int from;
    public int to;
    public int cost;

    public Edge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}
