package graph.DFS;

import graph.Graph;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by Dawid Pawlak.
 */
public class DepthFirstSearchTest {

    private final int NUMBER_OF_VERTICES = 5;

    private Graph graph;

    @Before
    public void setUp() {
        graph = new Graph(NUMBER_OF_VERTICES);
    }

    @Test
    public void testIfVisited() {
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
        boolean visited[] = new boolean[NUMBER_OF_VERTICES];

        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,4);

        depthFirstSearch.dfs(graph,0,visited);

        assertThat(visited).isEqualTo(new boolean[] {true,true,true,false,true});
    }



}
