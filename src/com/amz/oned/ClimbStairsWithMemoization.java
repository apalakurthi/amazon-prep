package com.amz.oned;
/***
 *
 * https://leetcode.com/problems/climbing-stairs/
 * */
public class ClimbStairsWithMemoization {
    int[] result;
    public static void main(String[] args) {
        ClimbStairsWithMemoization cs = new ClimbStairsWithMemoization();
        System.out.println(cs.climbStairs(5));
    }

    private int climbStairs(int n) {
        result = new int[n+1];
        result[0] = 1;
        result[1]= 1;

        return recursive(n);
    }

    private int recursive(int n) {
        if (result[n] >0) {
            return result[n];
        }
        result[n] = recursive(n-1) + recursive(n-2);
        return result[n];
    }
}
