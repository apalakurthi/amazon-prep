package com.amz.sorting;

public class QuickSort {
    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        int[] input = new int[]{10, 2, 4, 7, 16, 1};
        sort.quickSort(input, 0, input.length-1);
        for (int i: input) {
            System.out.println(i);
        }
    }

    public void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int sortedElementIndex = partition(arr, start, end);
            quickSort(arr, start, sortedElementIndex-1);
            quickSort(arr, sortedElementIndex+1, end);
        }
    }

    private int partition(int[] arr, int start, int end){
        int i= start, j= end;
        int pivot = arr[start];

        while(i < j) {
            while(arr[i] < pivot) {
                i++;
            }

            while(arr[j] < pivot) {
                j--;
            }
            swap(arr, i, j);
        }
        swap(arr, start, j);
        return j;
    }
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i]= arr[j];
        arr[j] = temp;
    }
}
