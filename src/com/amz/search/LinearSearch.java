package com.amz.search;
/**
 * Time complexity is : O(n)
 * space complexity is : O(1)
 *
 * **/
public class LinearSearch {
    public static void main(String[] args) {
        LinearSearch ls = new LinearSearch();
        System.out.println(ls.search(new int[]{1,5,2,3,6}, 10));
    }

    public boolean search(int[] arr, int num){
        for(int i=0; i<arr.length; i++) {
            if (arr[i] == num) {
                return true;
            }
        }
        return false;
    }
}
