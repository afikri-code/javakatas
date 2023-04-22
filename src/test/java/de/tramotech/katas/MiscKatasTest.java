package de.tramotech.katas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author: Ahmed Fikri
 */
class MiscKatasTest {

    MiscKatas app;
    @BeforeEach
    void setUp() {
        app = new MiscKatas();
    }


    @ParameterizedTest
    @MethodSource("maxSubarraySumDataProvider")
    void maxSubarraySum(int[] arr, int[] expected) {
        int[] actual = app.findSubarrayWithMaximumSum(arr);

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("longestSubstringDataProvider")
    void longestSubstring(String s, int k, int expected) {


        int actual = app.longestSubstring(s, k);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void calculateAverageGrade() {
        String actual = app.calculateAverageGrade("/Users/afikri/dev/tmp/grades.txt");

        assertThat(actual).isEqualTo("59,24");
    }

    @Test
    public void testPrintFizzBuzz() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        app.printFizzBuzz();
        StringBuilder expectedOutput = new StringBuilder();

         expectedOutput.append("1\n")
                 .append("2\n")
                 .append("Fizz\n")
                 .append("4\n")
                 .append("Buzz\n")
                 .append("Fizz\n")
                 .append("7\n")
                 .append("8\n")
                 .append("Fizz\n")
                 .append("Buzz\n")
                 .append("11\n")
                 .append("Fizz\n")
                 .append("13\n")
                 .append("14\n")
                 .append("FizzBuzz\n")
                 .append("16\n")
                 .append("17\n")
                 .append("Fizz\n")
                 .append("19\n")
                 .append("Buzz\n")
                 .append("Fizz\n")
                 .append("22\n")
                 .append("23\n")
                 .append("Fizz\n")
                 .append("Buzz\n")
                 .append("26\n")
                 .append("Fizz\n")
                 .append("28\n")
                 .append("29\n")
                 .append("FizzBuzz\n")
                 .append("31\n")
                 .append("32\n")
                 .append("Fizz\n")
                 .append("34\n")
                 .append("Buzz\n")
                 .append("Fizz\n")
                 .append("37\n")
                 .append("38\n")
                 .append("Fizz\n")
                 .append("Buzz\n")
                 .append("41\n")
                 .append("Fizz\n")
                 .append("43\n")
                 .append("44\n")
                 .append("FizzBuzz\n")
                 .append("46\n")
                 .append("47\n")
                 .append("Fizz\n")
                 .append("49\n")
                 .append("Buzz\n")
                 .append("Fizz\n")
                 .append("52\n")
                 .append("53\n")
                 .append("Fizz\n")
                 .append("Buzz\n")
                 .append("56\n")
                 .append("Fizz\n")
                 .append("58\n")
                 .append("59\n")
                 .append("FizzBuzz\n")
                 .append("61\n")
                 .append("62\n")
                 .append("Fizz\n")
                 .append("64\n")
                 .append("Buzz\n")
                 .append("Fizz\n")
                 .append("67\n")
                 .append("68\n")
                 .append("Fizz\n")
                 .append("Buzz\n")
                 .append("71\n")
                 .append("Fizz\n")
                 .append("73\n")
                 .append("74\n")
                 .append("FizzBuzz\n")
                 .append("76\n")
                 .append("77\n")
                 .append("Fizz\n")
                 .append("79\n")
                 .append("Buzz\n")
                 .append("Fizz\n")
                 .append("82\n")
                 .append("83\n")
                 .append("Fizz\n")
                 .append("Buzz\n")
                 .append("86\n")
                 .append("Fizz\n")
                 .append("88\n")
                 .append("89\n")
                 .append("FizzBuzz\n")
                 .append("91\n")
                 .append("92\n")
                 .append("Fizz\n")
                 .append("94\n")
                 .append("Buzz\n")
                 .append("Fizz\n")
                 .append("97\n")
                 .append("98\n")
                 .append("Fizz\n")
                 .append("Buzz\n");

        assertThat(expectedOutput.toString()).isEqualTo(outContent.toString());
    }

    static Collection<Object[]> longestSubstringDataProvider() {
        return List.of(new Object[][] {
                { "aabbcc", 2, 4},
                { "aabbcc", 1, 2 },
                { "aabbcc", 3, 6 },
                { "aaabbb", 3, 0 },
                { "aaabbbbcccc", 2, 8},
                { "abababba", 2, 8},
        });
    }

    static Collection<Object[]> maxSubarraySumDataProvider() {
        return List.of(new Object[][] {
                { new int[] {}, new int[] {} },
                { new int[] {1, 2, 3}, new int[] {1, 2, 3} },
                { new int[] {-1, -2, -3}, new int[] {} },
                { new int[] {-1 }, new int[] {} },
                { new int[] {1}, new int[] {1} },
                { new int[] {6, -7, 3}, new int[] {6} },
                { new int[] {6, -7, 8}, new int[] {8} },
                { new int[] {6, -7, 3, 5}, new int[] {3, 5} },
                { new int[] {6, -5, 3, 5}, new int[] {6, -5, 3, 5} },
                { new int[] {2, -4, 1, 9, -6, 7, -3}, new int[] {1, 9, -6, 7} },
                { new int[] {1, -100, 9, -6, 108, -3}, new int[] {9, -6, 108} },
                { new int[] {1, -100, 1, -6, 108, -3, 2}, new int[] {108} },
                { new int[] {1, -100, 1, -6, 108, -3, 4}, new int[] {108, -3, 4} },
                { new int[] {3, -4, 8, -2, 5}, new int[] {8, -2, 5} },
                { new int[] {9, -5, 6, 2, -1, 7, -8, 5}, new int[] {9, -5, 6, 2, -1, 7} },
                { new int[] {2, 6, -3, 1, 7, -2, 5, -8, 9, 4}, new int[] {2, 6, -3, 1, 7, -2, 5, -8, 9, 4} },
                { new int[] {1, -2, 3, 4, -5, 6, 7, -8, 9}, new int[] {3, 4, -5, 6, 7, -8, 9} },
                { new int[] {5, -2, -3, 4, -5, 6, -7, 8, 9}, new int[] {8, 9} },
        });
    }

}