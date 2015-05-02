package dataStructures.FenwickTree;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by Dawid Pawlak.
 */
public class FenwickTreeTest {


    @Test
    public void shouldReturnCorrectSum() {
        FenwickTree fenwickTree = new FenwickTree(5);

        fenwickTree.add(1,3);
        assertThat(fenwickTree.sum(0,2)).isEqualTo(3);
        fenwickTree.add(0,6);
        fenwickTree.add(1,2);
        assertThat(fenwickTree.sum(0,1)).isEqualTo(11);
        assertThat(fenwickTree.sum(2,4)).isEqualTo(0);
    }

    @Test
    public void shouldReturnCorrectSumWithInitiallyInitializedArray() {
        int tab[] = {7,1,3,9,8,5};
        FenwickTree fenwickTree = new FenwickTree(tab);

        assertThat(fenwickTree.sum(0,3)).isEqualTo(20);
        assertThat(fenwickTree.sum(0,5)).isEqualTo(33);

        fenwickTree.add(1,10);
        fenwickTree.add(5,9);

        assertThat(fenwickTree.sum(0,5)).isEqualTo(52);

    }


}
