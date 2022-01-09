package com.amz;
/**
 * https://leetcode.com/problems/unique-paths/
 * */
public class UniquePaths {
    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.unique(3,4));
    }

    int unique(int x, int y) {
        int[][] dp = new int[x][y];
        for (int i=0; i<x; i++) {
            for(int j=0; j<y; j++) {
                if (i==0|| j==0 && i!= j) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[x-1][y-1];
    }
}
