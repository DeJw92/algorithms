package dataStructures.FenwickTree;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by Dawid Pawlak.
 */
public class FenwickTree2DTest {

    @Test
    public void shouldReturnCorrectSum() {
        FenwickTree2D fenwickTree = new FenwickTree2D(4,7);

        fenwickTree.add(1,2,5);
        fenwickTree.add(2,4,7);
        fenwickTree.add(1,5,1);
        fenwickTree.add(3,1,10);
        fenwickTree.add(0,4,7);

        assertThat(fenwickTree.sum(1,2,2,5)).isEqualTo(13);
        assertThat(fenwickTree.sum(1,1,3,2)).isEqualTo(15);
        assertThat(fenwickTree.sum(0,2,2,5)).isEqualTo(20);


        fenwickTree.add(3,3,10);

        assertThat(fenwickTree.sum(0,0,3,5)).isEqualTo(40);
        assertThat(fenwickTree.sum(0,0,0,3)).isEqualTo(0);

    }

}
