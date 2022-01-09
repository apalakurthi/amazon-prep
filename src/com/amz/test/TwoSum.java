package com.amz.test;

import java.util.Arrays;
import java.util.HashMap;

/*
* https://leetcode.com/problems/two-sum/
*
* */
class TwoSum {
    /**
     * time complexity is o(n2)
     * */
    public int[] bruteForce(int[] nums, int target) {

        for (int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }

        return new int[]{};
    }

    /**
     * time complexity is o(nlog(n))
     * */
    public int[] secondApproach(int[] nums, int target) {
        Arrays.sort(nums); //O(nlog(n))
        int i=0, j= nums.length-1;
        while(i< j) {
            if (nums[i]+nums[j] == target) {
                return new int[] {i, j};
            } else if (nums[i]+nums[j] > target) {
                j--;
            } else if (nums[i]+nums[j] < target) {
                i++;
            }
        }
        return new int[]{};
    }

    /**
     * time complexity is o(n)
     * */
    public int[] lineartime(int[] nums, int target) {
       HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target- nums[i];
            if (map.containsKey(complement)) {
                return new int[]{i, map.get(complement)};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] result = twoSum.bruteForce(new int[]{2,7,11,15}, 9);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+",");
        }
        System.out.println();
        result = twoSum.secondApproach(new int[]{2,7,11,15}, 9);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+",");
        }
    }
}
