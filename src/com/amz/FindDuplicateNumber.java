package com.amz;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-the-duplicate-number/
 * */
public class FindDuplicateNumber {

    public static void main(String[] args) {
        FindDuplicateNumber findDuplicateNumber = new FindDuplicateNumber();
      List<Integer> result =  findDuplicateNumber.find(new int[]{4,3,2,7,8,2,3,1});
      System.out.println(result.toString());

    }

    public List<Integer> find(int[] nums){
        List<Integer> result =new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            int index = Math.abs(nums[i]) -1;
            if (nums[index] <0) {
                result.add(Math.abs(nums[i]));
            }
            nums[index] = -nums[index];
        }
        return result;
    }

}
