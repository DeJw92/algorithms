package graph.MaxFlow;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by Dawid Pawlak.
 */
public class MaxFlowTest {

    private MaxFlow maxFlow;

    private final int NUMBER_OF_VERTICES = 10;

    private final int NUMBER_OF_EDGES = 14;

    private List<Integer> graph[];

    private List<Edge> edges;

    @Before
    public void setUp() {
        edges = new ArrayList<>(2*NUMBER_OF_EDGES);
    }

    @Test
    public void shouldReturnCorrectMaxFlow() {
        inializeGraph();
        maxFlow = new MaxFlow(graph, edges);

        int source = 0;
        int sink = NUMBER_OF_VERTICES - 1;

        assertThat(maxFlow.dinic(source, sink)).isEqualTo(27);
    }

    private void inializeGraph() {
        graph = new List[NUMBER_OF_VERTICES];
        for (int i = 0; i < NUMBER_OF_VERTICES; i++) {
            graph[i] = new ArrayList<>();
        }
        add_edge(0,1,30);
        add_edge(0,2,10);
        add_edge(1,3,15);
        add_edge(1,4,5);
        add_edge(2,4,5);
        add_edge(2,5,5);
        add_edge(3,6,10);
        add_edge(3,7,10);
        add_edge(4,7,10);
        add_edge(4,8,5);
        add_edge(5,8,6);
        add_edge(6,9,15);
        add_edge(7,9,7);
        add_edge(8,9,10);
    }

    private void add_edge(int from, int to, int capacity) {
        Edge forwardEdge = new Edge(from, to, capacity, 0);
        Edge backwardEdge = new Edge(to, from, 0, 0);
        graph[from].add(edges.size());
        edges.add(forwardEdge);
        graph[to].add(edges.size());
        edges.add(backwardEdge);
    }

}
