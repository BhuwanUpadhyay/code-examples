import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

// tag::code[]

/*
Write a program that outputs the string representation of numbers from 1 to n.

But for multiples of three it should output “Fizz” instead of the number and
for the multiples of five output “Buzz”. For numbers which are multiples of both
three and five output “FizzBuzz”.

Example:

n = 15,

Return:
[
    "1",
    "2",
    "Fizz",
    "4",
    "Buzz",
    "Fizz",
    "7",
    "8",
    "Fizz",
    "Buzz",
    "11",
    "Fizz",
    "13",
    "14",
    "FizzBuzz"
]

 */
class Fizz_Buzz_Test {

    static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {
                        15,
                        new String[]{
                                "1",
                                "2",
                                "Fizz",
                                "4",
                                "Buzz",
                                "Fizz",
                                "7",
                                "8",
                                "Fizz",
                                "Buzz",
                                "11",
                                "Fizz",
                                "13",
                                "14",
                                "FizzBuzz"
                        }
                },
        });
    }

    /**
     * Complexity: O(n)
     */
    public List<String> fizzBuzz(int n) {

        List<String> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {

            int three = i % 3;

            int five = i % 5;

            if (three == 0 && five == 0) {
                result.add("FizzBuzz");
            } else if (three == 0) {
                result.add("Fizz");
            } else if (five == 0) {
                result.add("Buzz");
            } else {
                result.add(i + "");
            }
        }

        return result;
    }


    @ParameterizedTest
    @MethodSource("data")
    void testSolution(int n, String[] expected) {
        List<String> actual = fizzBuzz(n);
        assertLinesMatch(List.of(expected), actual);
    }


}
// end::code[]