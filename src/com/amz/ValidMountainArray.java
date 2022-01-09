package com.amz;

public class ValidMountainArray {

    public boolean validMountainArray(int[] arr) {
        int i=0;
        int j= arr.length-1;
        int n= arr.length-1;

        while( i+1<n  && arr[i+1]> arr[i]) {
            i++;
        }

        while( j>0  && arr[j] < arr[j-1]) {
            j--;
        }

        return (i>0 && i==j && j<n);

    }

    public static void main(String[] args) {
        ValidMountainArray validMountainArray = new ValidMountainArray();
        System.out.println(validMountainArray.validMountainArray(new int[]{9,8,7,6,5,4,3,2,1,0}));
    }

}
