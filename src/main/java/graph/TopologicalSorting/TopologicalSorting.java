package graph.TopologicalSorting;

/**
 * Created by Dawid Pawlak.
 */

import graph.DirectedGraph;
import graph.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Topological sorting of directed Graph
 */

public class TopologicalSorting {


    public List<Integer> sort(DirectedGraph graph) {
        int graphSize = graph.getGraphSize();
        int inDegree[] = new int[graphSize];

        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();

        for(int i=0;i<graphSize;i++) {
            inDegree[i] = graph.getInDegree(i);
            if(inDegree[i] == 0) queue.add(i);
        }

        while(!queue.isEmpty()) {
            int vertex = queue.remove();
            result.add(vertex);
            for(int neighbour : graph.getNeighbours(vertex)) {
                inDegree[neighbour]--;
                if(inDegree[neighbour] == 0) queue.add(neighbour);
            }
        }

        if(result.size() == graphSize) return result;

        return new ArrayList<>();
    }


}
