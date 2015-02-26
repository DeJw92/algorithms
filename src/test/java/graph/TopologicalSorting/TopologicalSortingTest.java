package graph.TopologicalSorting;

import com.google.common.collect.Lists;
import graph.DirectedGraph;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by Dawid Pawlak.
 */
public class TopologicalSortingTest {

    private TopologicalSorting topologicalSorting;

    @Before
    public void setUp() {
        topologicalSorting = new TopologicalSorting();

    }

    @Test
    public void shouldReturnCorrectTopologicalOrder() {
        DirectedGraph graph = new DirectedGraph(9);

        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(2,1);
        graph.addEdge(0,4);
        graph.addEdge(1,4);
        graph.addEdge(1,3);
        graph.addEdge(2,3);
        graph.addEdge(4,3);
        graph.addEdge(5,6);
        graph.addEdge(6,4);
        graph.addEdge(7,8);

        assertThat(topologicalSorting.sort(graph)).isEqualTo(Lists.newArrayList(0,5,7,2,6,8,1,4,3));
    }

    @Test
    public void shouldReturnEmptyListIfTopologicalOrderNotExist() {
        DirectedGraph graph = new DirectedGraph(4);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(3,1);

        assertThat(topologicalSorting.sort(graph)).isEmpty();
    }

}
