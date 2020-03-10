import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*

Find the length of the longest substring T of a given string (consists of lowercase letters only)
such that every character in T appears no less than k times.

Example 1:

Input:
s = "aaabb", k = 3

Output:
3

The longest substring is "aaa", as 'a' is repeated 3 times.
Example 2:

Input:
s = "ababbc", k = 2

Output:
5

The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.

 */
class Longest_Substring_with_At_Least_K_Repeating_Characters {


    static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}, 2},
                {new int[]{-1, -1}, new int[]{-1, 1}, new int[]{-1, 1}, new int[]{1, -1}, 6},
        });
    }


    @ParameterizedTest
    @MethodSource("data")
    void testSolution(int[] A, int[] B, int[] C, int[] D, int expected) {
        int actual = fourSumCount(A, B, C, D);
        assertEquals(expected, actual);
    }


}
