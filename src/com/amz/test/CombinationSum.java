package com.amz.test;

import java.util.ArrayList;
import java.util.List;
/**
 * https://leetcode.com/problems/combination-sum/
 * */
class CombinationSum {

    List<List<Integer>> results = new ArrayList<>();

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        List<List<Integer>> result = combinationSum.combinationSum(new int[] {2,3,6,7}, 7);
        for (List<Integer> array: result) {
            for (Integer element: array) {
                System.out.print(element+" " );
            }
            System.out.println();
        }
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates,target, 0, new ArrayList<>(), 0) ;
        return results;
    }

    private void dfs(int[] candidates, int target, int  index,List<Integer> combs, int sum) {

        for (int i = index; i < candidates.length; i++) {
            if (sum == target) {
                results.add(new ArrayList<>(combs));
                return;
            }
            if (sum > target) {
                return;
            }
            combs.add(candidates[i]);
            dfs(candidates, target, i, combs, sum+candidates[i]);
            combs.remove(combs.size() - 1);
        }
    }


    /*private void dfs(int[] candidates, int target, int offset, List<Integer> r, int sum) {
        for(int i = offset; i < candidates.length; i++) {
            if(sum == target) {
                results.add(new ArrayList<Integer>(r));
                return;
            }else if(sum > target) {
                return;
            }
            r.add(candidates[i]);
            dfs(candidates, target, i, r, sum+candidates[i]);
            r.remove(r.size() - 1);
        }
    }*/


}