import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*


 */
class Template {


    static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}, 0},
        });
    }


    int fourSumCount(int[] a, int[] b, int[] c, int[] d) {
        return 0;
    }

    @ParameterizedTest
    @MethodSource("data")
    void testSolution(int[] A, int[] B, int[] C, int[] D, int expected) {
        int actual = fourSumCount(A, B, C, D);
        assertEquals(expected, actual);
    }


}
