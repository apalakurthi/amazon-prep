package com.amz.sorting;

public class MergeSort {
    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        int[] input = new int[]{10, 2, 4, 7, 16, 1};
        sort.mergeSort(input);
        for (int i: input) {
            System.out.println(i);
        }
    }

    void mergeSort(int[] nums) {
        if(nums.length < 2) {
            return;
        }

        int i=0; int j= nums.length;
        // Get middle element
        int mid = (i+j)/2;
        // split array into two halves
        int[] leftArray = new int[mid];
        int[] rightArray = new int[j-mid];
        // populate arrays with values
        for(int k=0; k<mid; k++) {
            leftArray[k] = nums[k];
        }
        for(int k=mid; k<nums.length; k++) {
            rightArray[k-mid] = nums[k];
        }
        // run mergesort
        mergeSort(leftArray);
        mergeSort(rightArray);
        // merge the elements
        merge(nums, leftArray, rightArray);
    }

    private void merge(int[] nums, int[] left, int[] right){
        int i=0, j=0, k=0;

        // sort and store the elements in nums array
        while(i < left.length && j< right.length) {
            if (left[i] <= right[j]) {
                nums[k] = left[i];
                k++;
                i++;
            } else {
                nums[k] = right[j];
                k++;
                j++;
            }
        }
        // add left over elements from left array into the nums array
        while(i< left.length) {
            nums[k] = left[i];
            k++;
            i++;
        }
        // add left over elements from right array into the nums array
        while(j< right.length) {
            nums[k] = right[j];
            k++;
            j++;
        }
    }

}
