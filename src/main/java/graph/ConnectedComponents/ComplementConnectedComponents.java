package graph.ConnectedComponents;

/**
 * Created by Dawid Pawlak.
 */

import graph.Graph;

import java.util.*;

/**
 * Implementation which allows to find connected components of
 * graph having only it's complement
 */

public class ComplementConnectedComponents {

    private Graph graph;

    private Queue<Integer> queue;

    private List<Set<Integer>> result;

    public List<Set<Integer>> findConnectedComponents(Graph complementGraph) {
        this.graph = complementGraph;
        calculateNumberOfComponents(graph.getGraphSize());
        return result;
    }


    private void calculateNumberOfComponents(int n) {
        Set<Integer> contains = new HashSet<>();
        for (int i = 0; i < n; i++) {
            contains.add(i);
        }
        queue = new ArrayDeque<>();
        result = new ArrayList<>();
        Set<Integer> partialSum;
        for (int i = 0; i < n; i++) {
            if (contains.contains(i)) {
                queue.add(i);
                contains.remove(i);
                partialSum = calculatePartialSum(contains);
                result.add(partialSum);
            }
        }

    }

    private Set<Integer> calculatePartialSum(Set<Integer> contains) {
        Set<Integer> partialSum;
        partialSum = new HashSet<>();
        while(!queue.isEmpty()) {
            int vertex = queue.remove();
            partialSum.add(vertex);
            Set<Integer> newlyAdded = new HashSet<>();
            for(int neighbour : graph.getNeighbours(vertex)) {
                if (contains.contains(neighbour)) {
                    newlyAdded.add(neighbour);
                    contains.remove(neighbour);
                }
            }

            for (int x : contains) queue.add(x);
            contains.clear();
            contains.addAll(newlyAdded);
        }
        return partialSum;
    }
}
