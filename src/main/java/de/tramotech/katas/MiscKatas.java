package de.tramotech.katas;

import java.util.Arrays;

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

}
