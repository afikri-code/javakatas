package de.tramotech.katas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

/**
 * Author: Ahmed Fikri
 *
 */
public class MiscKatas {

    /**
     * Finds the contiguous subarray within the given array with the maximum sum.
     * If there are multiple subarrays with the same maximum sum, returns the first one encountered.
     * If the input array is empty, returns an empty array.
     * @param arr The input array
     * @return An array of two integers representing the starting and ending indices of the subarray with the maximum sum
     */
    int[] findSubarrayWithMaximumSum(int[] arr) {
        int max = 0;
        int start = 0;
        int sum = 0;
        int resultIndexStart = 0;
        int resultIndexEnd = 0;

        if(arr == null || arr.length == 0) {
            return new int[] {};
        }

        for(int i = 0; i< arr.length; i++) {

            sum += arr[i];
            if(sum < 0) {
                // Abandon the current subarray and start a new one from the next index
                sum = 0;
                start = i+1;
            }
            // Update the indices of the subarray with the maximum sum if necessary
            if(sum > max ) {
                max = sum;
                resultIndexStart = start;
                resultIndexEnd = i + 1;
            }
        }


        // Return the starting and ending indices of the subarray with the maximum sum
        return Arrays.copyOfRange(arr, resultIndexStart, resultIndexEnd);
    }

    /**
     * Returns the length of the longest substring in the input string that contains at most k distinct characters.
     *
     * @param inputString the input string to be processed
     * @param k the maximum number of distinct characters allowed in a substring
     * @return the length of the longest substring with at most k distinct characters
     * @throws IllegalArgumentException if the length of inputString is greater than 10^4 or k is less than 1 or greater than 26
     */
    public int longestSubstring(String inputString, int k) throws IllegalArgumentException {
        if(inputString.length() > Math.pow(10, 4) || k < 1 || k > 26) {
            throw new IllegalArgumentException("Length of inputString must not exceed 10^4 and k must be between 1 and 26, inclusive.");
        }

        int maxLength = 0;
        for(int startIndex = 0; startIndex < inputString.length(); startIndex++) {
            Set<Character> charSet = new HashSet<>();
            charSet.add(inputString.charAt(startIndex));
            int currentLength = 1;
            for (int endIndex = startIndex + 1; endIndex < inputString.length(); endIndex++) {
                char currentChar = inputString.charAt(endIndex);
                if(charSet.size() == k && !charSet.contains(currentChar)) {
                    break;
                }
                charSet.add(currentChar);
                currentLength++;
            }
            if(charSet.size() == k) {
                maxLength = Math.max(maxLength, currentLength);
                if(maxLength >= inputString.length() - startIndex) {
                    break;
                }
            }
        }

        return maxLength;
    }

    /**
     * Reads the grades from the file and calculates the average.
     *
     * @return a formatted string containing the average grade, or "NaN" if the file doesn't contain any valid double value
     */
    public String calculateAverageGrade(String fileName) {
        DecimalFormat df = new DecimalFormat("#.##");
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            double average = br.lines()
                    .map(Optional::ofNullable)
                    .flatMap(Optional::stream)
                    .filter(s -> s!= null && !s.isBlank())
                    .map(this::parseDouble)
                    .filter(OptionalDouble::isPresent)
                    .mapToDouble(OptionalDouble::getAsDouble)
                    .average()
                    .orElseThrow(() -> new RuntimeException("the file doesn't contain any valid double value"));

            return df.format(average);
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
            return "NaN";
        }
    }

    /**
     * Parses the specified string to an OptionalDouble.
     * If the string can be parsed as a double, an OptionalDouble containing the double value is returned.
     * Otherwise, an empty OptionalDouble is returned.
     *
     * @param s the string to be parsed; must not be null
     * @return an OptionalDouble containing the double value, or an empty OptionalDouble if the string is not a valid double
     * @throws NullPointerException if s is null
     */
    private OptionalDouble parseDouble(String s) throws NullPointerException {
        Objects.requireNonNull(s, "s must not be null");
        try {
            return OptionalDouble.of((Double.valueOf(s)));
        } catch (NumberFormatException e) {
            return OptionalDouble.empty();
        }
    }




}
