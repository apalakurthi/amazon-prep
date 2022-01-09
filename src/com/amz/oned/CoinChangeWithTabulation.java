package com.amz.oned;
/*
* https://leetcode.com/problems/coin-change/
* */
public class CoinChangeWithTabulation {

    public static void main(String[] args) {

        CoinChangeWithTabulation coinChangeWithTabulation = new CoinChangeWithTabulation();
        System.out.println(coinChangeWithTabulation.coinChange(new int[]{1,2,5}, 11));
        //System.out.println(coinChangeWithTabulation.calculate(new int[]{2}, 3));
    }

    private int calculate(int[] coins, int amount) {
        if (amount <=0) {
            return 0;
        }
        int[] result = new int[amount+1];
        result[0] = 0;

        for (int i=1; i< result.length ; i++) {
            result[i]= result[i-1]+coins[0];
            for (int j=1; j< coins.length; j++) {

                if (i-coins[j] >= 0) {
                    result[i] = Math.min(result[i], result[i-coins[j]]+1);
                }
            }

        }
        return result[amount];
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];//dp[i] represents the min coins needed to change for amount i
        //base case
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i-coin >= 0 && dp[i-coin] != -1) {
                    min = Math.min(dp[i-coin] + 1, min);
                }
            }
            dp[i] = (min == Integer.MAX_VALUE ? -1 : min);
        }
        return dp[amount];
    }

}
