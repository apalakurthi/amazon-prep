package com.amz;

import java.io.*;
import java.util.*;

class MinRemovalsToMakeMountain {

    // Utility function to count array
    // elements required to be removed
    // to make array a mountain array
    public static int minRemovalsUtil(
            int[] arr)
    {
        int result = 0;
        if (arr.length < 3) {
            return -1;
        }

        // Stores length of increasing
        // subsequence from [0, i-1]
        int[] leftIncreasing
                = new int[arr.length];

        // Stores length of increasing
        // subsequence from [i + 1, n - 1]
        int[] rightIncreasing = new int[arr.length];

        // Iterate for each position up to
        // N - 1 to find the length of subsequence
        for (int i = 1; i < arr.length; i++) {

            for (int j = 0; j < i; j++) {

                // If j is less than i, then
                // i-th position has leftIncreasing[j]
                // + 1 lesser elements including itself
                if (arr[j] < arr[i]) {

                    // Check if it is the maximum
                    // obtained so far
                    leftIncreasing[i]
                            = Math.max(
                            leftIncreasing[i],
                            leftIncreasing[j] + 1);
                }
            }
        }

        // Search for increasing subsequence from right
        for (int i = arr.length - 2; i >= 0; i--) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[i]) {
                    rightIncreasing[i]
                            = Math.max(rightIncreasing[i],
                            rightIncreasing[j] + 1);
                }
            }
        }

        // Find the position following the peak
        // condition and have maximum leftIncreasing[i]
        // + rightIncreasing[i]
        for (int i = 0; i < arr.length; i++) {
            if (leftIncreasing[i] != 0
                    && rightIncreasing[i] != 0) {
                result = Math.max(
                        result, leftIncreasing[i]
                                + rightIncreasing[i]);
            }
        }

        return arr.length - (result + 1);
    }

    // Function to count elements to be
    // removed to make array a mountain array
    public static void minRemovals(int[] arr)
    {
        int ans = minRemovalsUtil(arr);

        // Print the answer
        System.out.println(ans);
    }

    // Driver Code
    public static void main(String[] args)
    {
        // Given array
        int[] arr = { 2, 1, 1, 5, 6, 2, 3, 1 };

        // Function Call
        minRemovals(arr);
    }
}
