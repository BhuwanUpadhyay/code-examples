import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;

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
                {"aaabb", 3, 3},
                {"ababbc", 2, 5}
        });
    }


    public int longestSubstring(String s, int k) {

        /*
            ababbc

            i - n

         */


        return 0;
    }


    @ParameterizedTest
    @MethodSource("data")
    void testSolution(String s, int k, int expected) {
        int actual = longestSubstring(s, k);
        assertEquals(expected, actual);
    }


}
