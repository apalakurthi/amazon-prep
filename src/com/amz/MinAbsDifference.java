package com.amz;

import java.util.Arrays;
/**
 * https://leetcode.com/problems/minimum-absolute-sum-difference/
 *
 * */
class MinAbsDifference {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        long total = 0;
        int n = nums1.length;
        int[] diffs = new int[n];
        for (int i = 0; i < n; i++) { // O(N)
            int diff = Math.abs(nums1[i] - nums2[i]);
            diffs[i] = diff;
            total += diff;
        }

        if (total == 0) return 0;
        long minTotal = total;
        Arrays.sort(nums1); // O(NlogN)
        for (int j = 0; j < n; j++) {
            int subInt = binarySearch(nums2[j], nums1); // O(logN)
            long tempTotal = total - diffs[j] + Math.abs(subInt - nums2[j]);
            if (tempTotal < minTotal) minTotal = tempTotal;
        }
        return (int) (minTotal % 1000000007);
    }

    // find the number that is closest to x
    private int binarySearch(int x, int[] nums1) { // O(logN)
        int len = nums1.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = (left+right) / 2;
            if (x - nums1[mid] > nums1[mid + 1] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums1[left];
    }



    public static void main(String[] args) {
        MinAbsDifference difference = new MinAbsDifference();
       System.out.println(difference.minAbsoluteSumDiff(new int[]{1,10,4,4,2,7}, new int[]{9,3,5,1,7,4}));
    }
}