package de.tramotech.katas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

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