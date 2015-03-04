package treesAlgorithms.LCA;

import graph.Graph;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by Dawid Pawlak.
 */
public class LCATest {

    private LCA LCA;

    private Graph graph;

    private int NUMBER_OF_VERTICES = 20;

    @Before
    public void setUp() {
        graph = initializeGraph();
        LCA = new LCA(graph);
    }


    @Test
    public void shouldCalculateCorrectLCA() {
        assertThat(LCA.lca(6,7)).isEqualTo(5);
        assertThat(LCA.lca(10,11)).isEqualTo(9);
        assertThat(LCA.lca(10,8)).isEqualTo(8);
        assertThat(LCA.lca(7,11)).isEqualTo(4);
        assertThat(LCA.lca(10,5)).isEqualTo(4);
        assertThat(LCA.lca(14,15)).isEqualTo(13);
        assertThat(LCA.lca(6,15)).isEqualTo(1);
        assertThat(LCA.lca(13,9)).isEqualTo(1);
        assertThat(LCA.lca(6,6)).isEqualTo(6);
        assertThat(LCA.lca(18,11)).isEqualTo(0);
        assertThat(LCA.lca(3,18)).isEqualTo(3);
    }



    private Graph initializeGraph() {
        graph = new Graph(NUMBER_OF_VERTICES);
        graph.addEdge(0,1);
        graph.addEdge(1,4);
        graph.addEdge(4,5);
        graph.addEdge(5,6);
        graph.addEdge(5,7);
        graph.addEdge(4,8);
        graph.addEdge(8,9);
        graph.addEdge(9,10);
        graph.addEdge(9,11);
        graph.addEdge(1,12);
        graph.addEdge(12,13);
        graph.addEdge(13,14);
        graph.addEdge(13,15);
        graph.addEdge(0,3);
        graph.addEdge(3,16);
        graph.addEdge(16,17);
        graph.addEdge(17,18);

        return graph;
    }

}
