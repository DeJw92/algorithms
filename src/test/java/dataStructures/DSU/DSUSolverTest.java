package dataStructures.DSU;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by Dawid Pawlak.
 */
public class DSUSolverTest {

    private DSUSolver dsuSolver;

    private int NUMBER_OF_VERTICES = 3;

    @Before
    public void init() {
        dsuSolver = new DSUSolver(NUMBER_OF_VERTICES);
    }

    @Test
    public void test() {
        assertThat(dsuSolver.find(0) == dsuSolver.find(1)).isEqualTo(false);
        assertThat(dsuSolver.find(1) == dsuSolver.find(2)).isEqualTo(false);
        assertThat(dsuSolver.find(0) == dsuSolver.find(2)).isEqualTo(false);
        dsuSolver.union(0,1);
        assertThat(dsuSolver.find(0) == dsuSolver.find(1)).isEqualTo(true);
        assertThat(dsuSolver.find(1) == dsuSolver.find(2)).isEqualTo(false);
        assertThat(dsuSolver.find(0) == dsuSolver.find(2)).isEqualTo(false);
        dsuSolver.union(1,2);
        assertThat(dsuSolver.find(1) == dsuSolver.find(2)).isEqualTo(true);
        assertThat(dsuSolver.find(0) == dsuSolver.find(2)).isEqualTo(true);
    }

}
