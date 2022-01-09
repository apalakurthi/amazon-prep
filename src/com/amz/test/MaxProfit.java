package com.amz.test;

public class MaxProfit {
    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        System.out.println(maxProfit.profit(new int[] {2,1,2,1,0,1,2}));
    }

    public int profit(int[] prices) {
        int maxProfit =0;
        int i=0; int j=1;
        while(j< prices.length ) {
            maxProfit = Math.max(maxProfit, prices[j]- prices[i]);
            if (prices[i] > prices[j]) {
                i = j;
            }
            j++;
        }
        return maxProfit;
    }
}
