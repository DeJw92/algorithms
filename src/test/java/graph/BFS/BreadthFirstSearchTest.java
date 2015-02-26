package graph.BFS;

import graph.Graph;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by Dawid Pawlak.
 */


public class BreadthFirstSearchTest {

    private final int NUMBER_OF_VERTICES = 6;

    private Graph graph;

    @Before
    public void setUp() {
        graph = new Graph(NUMBER_OF_VERTICES);
    }

    @Test
    public void testIfDistancesCalculatedProperly() {
        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();

        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(2,3);
        graph.addEdge(3,4);
        graph.addEdge(4,5);

        int [] distances = breadthFirstSearch.bfs(graph, 0);

        assertThat(distances).isEqualTo(new int[] {0,1,1,2,3,4});
    }



}
