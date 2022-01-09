package com.amz;

import java.util.HashSet;
import java.util.Set;

public class FindNumbersThatAddUptoTarget {
    public static void main(String[] args) {
        FindNumbersThatAddUptoTarget findNumbersThatAddUptoTarget = new FindNumbersThatAddUptoTarget();
        System.out.println(
        findNumbersThatAddUptoTarget.dp(new int[]{2,7,11,15}, 9).toString());
    }

    /*int[] find(int[] arr, int target){
        int n= arr.length;
        Arrays.sort(arr);

        for( int i=0,j=n-1; i<n && j>0;) {

            if(arr[i] +arr[j] == target && i != j) {
                return new int[]{arr[i], arr[j]};
            } else if(arr[i] +arr[j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return new int[]{-1};
    }*/

    int[] dp(int[] arr, int target){
        Set<Integer> visitedSet = new HashSet();

        for(int num : arr) {
            if (visitedSet.contains(Math.abs(target-num))) {
                return new int[]{num, Math.abs(target-num)};
            } else {
                visitedSet.add(num);
            }
        }
        return new int[]{-1};
    }
}
