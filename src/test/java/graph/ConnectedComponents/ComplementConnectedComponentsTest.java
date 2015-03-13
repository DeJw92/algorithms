package graph.ConnectedComponents;

import com.google.common.collect.Sets;
import graph.Graph;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by Dawid Pawlak.
 */
public class ComplementConnectedComponentsTest {

    private ComplementConnectedComponents complementConnectedComponents;

    @Before
    public void setUp() {
        complementConnectedComponents = new ComplementConnectedComponents();
    }

    @Test
    public void shouldReturnTwoConnectedComponents() {

        Graph graph = new Graph(6);

        graph.addEdge(0,2);
        graph.addEdge(0,3);
        graph.addEdge(0,4);
        graph.addEdge(0,5);
        graph.addEdge(1,4);
        graph.addEdge(1,5);
        graph.addEdge(2,4);
        graph.addEdge(2,5);
        graph.addEdge(3,4);
        graph.addEdge(3,5);

        List<Set<Integer>> result = complementConnectedComponents.findConnectedComponents(graph);

        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0)).isEqualTo(Sets.newHashSet(0,1,2,3));
        assertThat(result.get(1)).isEqualTo(Sets.newHashSet(4,5));

    }

    @Test
    public void shouldReturnOneConnectedComponent() {
        Graph graph = new Graph(10);

        graph.addEdge(4,8);

        List<Set<Integer>> result = complementConnectedComponents.findConnectedComponents(graph);

        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0)).isEqualTo(Sets.newHashSet(0,1,2,3,4,5,6,7,8,9));
    }


}
