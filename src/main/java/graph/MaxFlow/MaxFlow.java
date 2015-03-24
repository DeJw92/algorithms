package graph.MaxFlow;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/**
 * Created by Dawid Pawlak.
 */

/**
 * Implementation find max flow of given directed graph
 * using modified Dinic method
 *
 * Complexity O(n^2 * m) where n - number of vertices, m - number of edges
 */
public class MaxFlow {

    private List<Integer> graph[];

    private List<Edge> edges;

    private int level[];

    private int begin[];

    private int SIZE;

    private int INFINITY = Integer.MAX_VALUE;

    public MaxFlow(List<Integer> graph[], List<Edge> edges) {
        this.graph = graph;
        this.edges = edges;
        this.SIZE = graph.length;
        level = new int[SIZE];
        begin = new int[SIZE];
    }

    public int dinic(int source, int sink) {
        int maxFlow = 0;
        int pushed = 0;
        while(bfs(source, sink)) {
            for(int i=0;i<SIZE;i++) {
                begin[i] = 0;
            }
            while((pushed = dfs(source, sink, INFINITY)) > 0) {
                maxFlow += pushed;
            }
        }
        return maxFlow;
    }

    private int dfs(int vertex, int sink, int flow) {
        if(flow <= 0) return 0;
        if(vertex == sink) return flow;
        for(; begin[vertex] < graph[vertex].size(); begin[vertex]++) {
            int edgeID = graph[vertex].get(begin[vertex]);
            Edge edge = edges.get(edgeID);
            if(level[edge.to] != level[vertex] + 1) continue;
            int pushed = dfs(edge.to, sink, Math.min(flow, edge.capacity - edge.flow));
            if(pushed > 0) {
                edges.get(edgeID).flow += pushed;
                edges.get(edgeID^1).flow -= pushed;
                return pushed;
            }
        }
        return 0;
    }

    private boolean bfs(int source, int sink) {
        for (int i = 0; i < SIZE; i++) {
            level[i] = -1;
        }
        level[source] = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(source);
        int vertex;
        while(!queue.isEmpty()) {
            vertex = queue.remove();
            for (int edgeID : graph[vertex]) {
                Edge edge = edges.get(edgeID);
                if(level[edge.to] == -1 && edge.capacity > edge.flow ) {
                    level[edge.to] = level[vertex] + 1;
                    queue.add(edge.to);
                }
            }
        }
        return level[sink] != -1;
    }

}
