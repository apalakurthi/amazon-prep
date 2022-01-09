package com.amz.sorting;


public class SelectionSort {
    public static void main(String[] args) {
        SelectionSort ls = new SelectionSort();
        int[] arr = ls.sort(new int[]{65,25,12,22,11});
        for (int num:
             arr) {
            System.out.print(num +" ");
        }
    }

    public int[] sort(int[] arr){
        int n = arr.length;
        for (int i=0; i<n; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
}
