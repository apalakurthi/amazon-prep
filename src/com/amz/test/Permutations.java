package com.amz.test;

import java.util.LinkedList;
import java.util.List;
/**
 * https://leetcode.com/problems/permutations/
 * */
class Permutations {
    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        if(nums.length == 0 || nums == null)    result.add(new LinkedList<>());
        perm(new LinkedList<>(),nums,visited);

        return result;
    }
    private void perm(List<Integer> permutation,int[] nums,boolean[] visited){
        if(nums.length == permutation.size()){
            result.add(new LinkedList(permutation));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(visited[i]) continue;
            visited[i]=true;
            permutation.add(nums[i]);
            perm(permutation,nums,visited);
            permutation.remove(permutation.size()-1);
            visited[i]=false;
        }
    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        List<List<Integer>> result = permutations.permute(new int[]{1,2,3});

        for (List<Integer> array: result) {
            for (Integer element: array) {
                System.out.print(element+" " );
            }
            System.out.println();
        }
    }
}