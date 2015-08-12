package graph.dijkstra;

import graph.Edge;
import graph.WeightedGraph;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by Dawid Pawlak.
 */
public class DijkstraSolver {

    public long[] dijkstra(WeightedGraph graph, int source) {
        final long distances[] = new long[graph.getNumberOfVertices()];
        for(int i=0;i<distances.length;i++) {
            distances[i] = Long.MAX_VALUE;
        }
        distances[source] = 0;
        TreeSet<Integer> set = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int res = Long.compare(distances[o1], distances[o2]);
                if(res == 0) {
                    res = Integer.compare(o1, o2);
                }
                return res;
            }
        });
        set.add(source);
        while(!set.isEmpty()) {
            int vertex = set.pollFirst();
            for(int edgeID : graph.getEdgesIds(vertex)) {
                Edge edge = graph.getEdge(edgeID);
                if(distances[edge.to] > distances[edge.from] + edge.cost) {
                    set.remove(edge.to);
                    distances[edge.to] = distances[edge.from] + edge.cost;
                    set.add(edge.to);
                }

            }
        }
        return distances;
    }


}
