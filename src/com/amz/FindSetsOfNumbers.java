package com.amz;

/*
* input array [2,4,6,10]
* find sets of numbers that add up to 16
*
* No duplicates
* No negative numbers or zeros
* array is sorted already
* what should be returned if add up to 0 -> it should return 1
*
* */


import java.util.Hashtable;

public class FindSetsOfNumbers {
    Hashtable<String, Integer> table = new Hashtable<>();
    public static void main(String[] args) {
        int[] a = new int[]{2,4,6,10, 20};

        FindSetsOfNumbers findSetsOfNumbers = new FindSetsOfNumbers();
        System.out.println(findSetsOfNumbers.count_sets_dp(a, 16));
    }


    public int count_sets_recursively(int[] a, int total) {
        return rec(a, total, a.length-1);
    }

    public  int rec(int[] a, int total, int index){
        if(total == 0) {
            return 1;
        } else if(total < 0){
            return 0;
        } else if (index < 0){
            return 0;
        } else if (total < a[index]) {
            return rec(a, total, index-1);
        } else {
            return rec(a, total, index-1) + rec(a, total-a[index], index-1);
        }
    }


    /**
     * time complexity is : o(n)
     * */
    public int count_sets_dp(int[] a, int total) {
        return dynamic_programming(a, total, a.length-1);
    }

    public int dynamic_programming(int[] a, int total, int index){
        String key = total +":"+ index;
        if (table.contains(key)) {
            return table.get(key);
        }
        int number_of_sets;
        if(total == 0) {
            return 1;
        } else if(total < 0){
            return 0;
        } else if (index < 0){
            return 0;
        } else if (total < a[index]) {
            number_of_sets=  dynamic_programming(a, total, index-1);
        } else {
            number_of_sets = dynamic_programming(a, total, index-1) +
                    dynamic_programming(a, total-a[index], index-1);
        }
        table.put(key, number_of_sets);
        return number_of_sets;
    }
}
