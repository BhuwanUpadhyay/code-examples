import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

// tag::code[]

/*
Given four lists A, B, C, D of integer values, compute
how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.

To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500.
All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.

Example:

Input:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]

Output:
2

Explanation:
The two tuples are:
1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0

 */
class Four_Sum_II_Test {

    static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}, 2},
                {new int[]{-1, -1}, new int[]{-1, 1}, new int[]{-1, 1}, new int[]{1, -1}, 6},
        });
    }

    /**
     * Complexity: O(n ^ 2)
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        /*
            Let, Q = A + B
            A[0] + B[0] = -1
            A[0] + B[1] = 0
            A[1] + B[0] = 0
            A[1] + B[1] = 1
         */

        Map<Integer, Integer> Q = new HashMap<>();

        for (int a : A) {
            for (int b : B) {

                int sum = a + b;

                Q.put(sum, Q.getOrDefault(sum, 0) + 1);
            }
        }

        /*
            Let, R = C + D
            C[0] + D[0] = -1
            C[0] + D[1] = 1
            C[1] + D[0] = 2
            C[1] + D[1] = 4
         */

        Map<Integer, Integer> R = new HashMap<>();

        for (int c : C) {
            for (int d : D) {

                int sum = c + d;

                R.put(sum, R.getOrDefault(sum, 0) + 1);
            }
        }

        /*
            Q -> map<tuple_sum, count> of A and B
            R -> map<tuple_sum, count> of C and D

            To identify tuples sum is zero we need to check,
            does the negative value of tuple sum in Q exists in R.
            If yes, then get its count  and multiply with count in Q
            then add with previous count.

         */
        int count = 0;

        for (Map.Entry<Integer, Integer> e : Q.entrySet()) {

            int nextSum = -e.getKey();

            if (R.containsKey(nextSum)) {
                count += e.getValue() * R.get(nextSum);
            }

        }

        return count;
    }

    public int optimizedFourSumCount(int[] A, int[] B, int[] C, int[] D) {

        Map<Integer, Integer> Q = new HashMap<>();

        for (int a : A) {
            for (int b : B) {

                int sum = a + b;

                Q.put(sum, Q.getOrDefault(sum, 0) + 1);
            }
        }

        int count = 0;

        for (int c : C) {
            for (int d : D) {

                int sum = c + d;

                count += Q.getOrDefault(-sum, 0);
            }
        }

        return count;
    }

    @ParameterizedTest
    @MethodSource("data")
    void testSolution(int[] A, int[] B, int[] C, int[] D, int expected) {
        int actual = fourSumCount(A, B, C, D);
        assertEquals(expected, actual);
    }


    @ParameterizedTest
    @MethodSource("data")
    void testOptimizedSolution(int[] A, int[] B, int[] C, int[] D, int expected) {
        int actual = optimizedFourSumCount(A, B, C, D);
        assertEquals(expected, actual);
    }

}
// end::code[]