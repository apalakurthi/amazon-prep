package com.amz.oned;

import java.io.*;
        import java.util.*;

class MinimumCostToReachToopFloor
{
    // function to find
// the minimum cost
// to reach N-th floor
    static int minimumCost(int cost[],
                           int n)
    {
        // declare an array
        int dp[] = new int[n];

        // base case
        if (n == 1)
            return cost[0];

        // initially to
        // climb till 0-th
        // or 1th stair
        dp[0] = cost[0];
        dp[1] = cost[1];

        // iterate for finding the cost
        for (int i = 2; i < n; i++)
        {
            dp[i] = Math.min(dp[i - 1],
                    dp[i - 2]) + cost[i];
        }

        // return the minimum
        return Math.min(dp[n - 2],
                dp[n - 1]);
    }

    // Driver Code
    public static void main(String args[])
    {
        int a[] = { 10,15,20 };
        int n = a.length;
        System.out.print(minimumCost(a, n));
    }
}