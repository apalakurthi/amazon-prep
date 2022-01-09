package com.amz;

public class FindShortestSubSegmentWithSumN {

    public static void main(String[] args) {
        int[] s = new int[]{2,3,1,2,4};
        int sum = 7;
        System.out.println (findShortLength(s, sum));
    }
    public static int findShortLength(int[] arr, int s){

        if (arr == null || arr.length== 0){
            return 0;
        }
        int left =0; int right; int sum =0; int ans = Integer.MAX_VALUE;

        for(right =0; right< arr.length; right++){
            sum += arr[right];
            while(sum >=s) {
                ans = Math.min(ans, right-left+1);
                sum -= arr[left++];
            }
        }
        return (ans != Integer.MAX_VALUE) ? ans: 0;
    }
}
