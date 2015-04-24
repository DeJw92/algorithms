package others.z_function;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by Dawid Pawlak.
 */
public class ZFunctionTest {

    private ZFunctionSolver zFunctionSolver;

    @Before
    public void setUp() {
        zFunctionSolver = new ZFunctionSolver();
    }

    @Test
    public void testIfReturnCorrectZValues() {
        int [] expectedZ = {0,1,0,0,3,1,0,0,2,2,1,0};
        assertThat(zFunctionSolver.calculateZFunction("aabcaabxaaaz".toCharArray())).isEqualTo(expectedZ);
    }


}
