package com.amz;

public class Febonacci {

    public static void main(String[] args) {
        //method 1: recursion --
        // time complexity - order of 2 power n
        System.out.println(recursion(5));

        //method 2: momoize time
        // time complexity - order of n
        //memory complexity - order of n
        Integer[] a = new Integer[6];
        for(int i=0; i< a.length; i++){
        a[i] = null;
        }
        System.out.println(memoize(5, a));

        // method 3: bottom up approach
        // time complexity - order of n
        //memory complexity - order of n
        System.out.println(bottomup(5));
    }

    public static int recursion(int n) {
        if(n==1 || n==2) {
            return 1;
        } else  {
            int result = recursion(n-1)+recursion(n-2);
            return result;
        }
    }

    public static int memoize(int n, Integer[] a) {
        int result;

        if (a[n] != null) {
            return a[n];
        }
        if (n== 1 || n==2){
            result =1;
        } else {
            result = memoize(n-1, a)+ memoize(n-2 , a);
        }
        a[n]= result;
        return result;
    }

    public static int bottomup(int n){
        if(n== 1 || n==2) {
            return 1;
        }
        int[] a = new int[n+1];
        a[1]= 1;
        a[2]= 1;
        for(int i = 3; i<= n; i++){
            int result = a[i-1]+ a[i-2];
            a[i]= result;
        }
        return a[n];
    }
}
