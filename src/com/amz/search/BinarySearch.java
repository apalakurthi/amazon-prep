package com.amz.search;
/**
 * Binary search is done only on sorted arrays.
 * time complexity is : O(log(n))
 * space complexity is : O(1)
 *
 * */
public class BinarySearch {
    public static void main(String[] args) {
        BinarySearch ls = new BinarySearch();
        System.out.println(ls.search(new int[]{1,2,3,5,6}, 7));
    }

    public boolean search(int[] arr, int num){
        if (arr[0] > num || arr[arr.length-1] < num) {
            return false;
        }

        for(int i=0, j= arr.length-1; i<arr.length && j>=i; i++, j--) {
            int mid = (i+j)/2;
            if (arr[mid] == num) {
                return true;
            }

            if (arr[mid] > num) {
                j= mid;
            } else {
                i= mid+1;
            }
        }
        return false;
    }
}
