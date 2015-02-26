package graph;

import com.google.common.collect.Sets;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by Dawid Pawlak.
 */

public class GraphTest {

    private Graph graph;

    private final int NUMBER_OF_VERTICES = 5;

    @Before
    public void setUp() {
        graph = new Graph(NUMBER_OF_VERTICES);
    }

    @Test
    public void testIfEdgesAddedProperly() {
        graph.addEdge(0,1);
        graph.addEdge(2,3);
        graph.addEdge(2,1);

        assertThat(graph.getNeighbours(0)).isEqualTo(Sets.newHashSet(1));
        assertThat(graph.getNeighbours(1)).isEqualTo(Sets.newHashSet(0,2));
        assertThat(graph.getNeighbours(2)).isEqualTo(Sets.newHashSet(1,3));
        assertThat(graph.getNeighbours(3)).isEqualTo(Sets.newHashSet(2));
        assertThat(graph.getNeighbours(4)).isEmpty();
    }

}
