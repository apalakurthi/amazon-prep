package com.amz.oned;
/***
 *
 * https://leetcode.com/problems/climbing-stairs/
 * */
public class ClimbStairsWithTabulation {
    int[] result;
    public static void main(String[] args) {
        ClimbStairsWithTabulation cs = new ClimbStairsWithTabulation();
        System.out.println(cs.climbStairs(5));
    }

    private int climbStairs(int n) {
        result = new int[n+1];
        result[0] = 1;
        result[1] = 1;

        for (int i=2; i<=n; i++) {
            result[i] = result[i-1]+result[i-2];
        }
        return result[n];
    }
}
