package graph.dijkstra;

import graph.Edge;
import graph.WeightedGraph;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by Dawid Pawlak.
 */
public class DijkstraTest {

    private DijkstraSolver dijkstraSolver;

    @Before
    public void setUp() {
        dijkstraSolver = new DijkstraSolver();
    }

    @Test
    public void testGraph() {
        WeightedGraph weightedGraph = new WeightedGraph(10);
        weightedGraph.addEdge(new Edge(0,1,7));
        weightedGraph.addEdge(new Edge(0, 6, 17));
        weightedGraph.addEdge(new Edge(0,2,3));
        weightedGraph.addEdge(new Edge(0,4,4));
        weightedGraph.addEdge(new Edge(2,3,1));
        weightedGraph.addEdge(new Edge(3,1,2));
        weightedGraph.addEdge(new Edge(4,2,2));
        weightedGraph.addEdge(new Edge(4,5,8));
        weightedGraph.addEdge(new Edge(5,8,10));
        weightedGraph.addEdge(new Edge(3,8,90));
        weightedGraph.addEdge(new Edge(8,7,1));
        weightedGraph.addEdge(new Edge(6,7,2));
        weightedGraph.addEdge(new Edge(9,5,7));
        long distances[] = dijkstraSolver.dijkstra(weightedGraph, 0);

        assertThat(distances).isEqualTo(new long[] {0,6,3,4,4,12,17,19,22, Long.MAX_VALUE});
    }

}
