package com.amz.test;
/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 */

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        MedianOfTwoSortedArrays median = new MedianOfTwoSortedArrays();
        System.out.println(median.findMedian(new int[]{1 ,2,3, 5}, new int[]{4, 6,7,8}));

    }

    public double findMedian(int[] num1, int[] num2) {
        if (num1.length > num2.length) {
            findMedian(num2, num1);
        }
        int x= num1.length, y= num2.length;
        int low =0, high=x;
        while (low<=high) {
            int partitionx = (low+high)/2;
            int partitiony = (x+y+1)/2 - partitionx;

            int maxLeftx = partitionx == 0 ? Integer.MIN_VALUE : num1[partitionx-1];
            int minRightx = partitionx == x ? Integer.MAX_VALUE : num1[partitionx];

            int maxLefty = partitiony == 0 ? Integer.MIN_VALUE : num2[partitiony-1];
            int minRighty = partitiony == y ? Integer.MAX_VALUE : num2[partitiony];

            if (maxLeftx <= minRighty && maxLefty <=  minRightx) {
                if ((x+y)% 2 ==0) {
                    return (Math.max(maxLeftx, maxLefty) + Math.min(minRightx, minRighty))/2;
                } else {
                    return Math.max(maxLeftx, maxLefty);
                }
            } else if (maxLeftx > minRighty) {
                high = partitionx-1;
            } else {
                low = partitionx+1;
            }
        }
        throw new IllegalArgumentException("No match founnd");

    }
}
