package dataStructures.MaxQueue;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by Dawid Pawlak.
 */

public class MaxQueueTest {

    private MaxQueue maxQueue;

    @Before
    public void setUp() {
        maxQueue = new MaxQueue();
    }


    @Test
    public void testIfBehavesCorrectly() {
        assertThat(maxQueue.getMax()).isEqualTo(Integer.MIN_VALUE);

        maxQueue.pushBack(7);
        maxQueue.pushBack(4);

        assertThat(maxQueue.getMax()).isEqualTo(7);

        maxQueue.removeFront();

        assertThat(maxQueue.getMax()).isEqualTo(4);

        maxQueue.pushBack(9);

        assertThat(maxQueue.getMax()).isEqualTo(9);

    }

}
