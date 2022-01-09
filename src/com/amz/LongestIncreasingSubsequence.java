package com.amz;
/**
 * https://leetcode.com/problems/longest-increasing-subsequence/ *
 * */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {

        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        System.out.println(lis.calculate(new int[]{10,9,2,5,3,7,101,18}));
    }

    private int calculate(int[] nums) {
        if (nums.length ==0) {
            return 0;
        }
        int[] dp= new int[nums.length];
        dp[0] = 1; //base case LIS at first element has length as 1

        int maxans= 1; // global LIS length
        for (int i=1; i<nums.length; i++) {
            int maxval =0; // LIS length at index i of given numbers
            for (int j=0; j<i; j++) {// consider all values before i
                if (nums[i]> nums[j]) { // we only care if the current value is higher than this element
                    maxval= Math.max(maxval, dp[j]); //Check the LIS at previous value
                }
            }
            dp[i] = maxval +1; // we have the LIS at i, save it in db
            maxans= Math.max(maxans , dp[i]); // update the global LIS length.
        }
        return maxans;

    }
}
