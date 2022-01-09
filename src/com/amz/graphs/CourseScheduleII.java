package com.amz.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/*
* https://leetcode.com/problems/course-schedule/
*
* */
public class CourseScheduleII {

    public static void main(String[] args) {
        CourseScheduleII cs = new CourseScheduleII();
        int[] result = cs.canFinish(4, new int[][] {{1,0},{2,0},{3,1},{3,2}});
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }
    Stack<Integer> result = new Stack<>();
    int[] canFinish(int numCourses, int[][] prerequisites){
        if(prerequisites== null || numCourses==0|| prerequisites.length==0){
            return new int[]{};
        }

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        //directed graph so only one way.
        for (int[] req:prerequisites) {
            map.get(req[1]).add(req[0]);
        }
        int [] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            // false if a cycle is found
            if (!dfs(map, visited, i)) {
                return new int[]{};
            }
        }
        int[] response = new int[result.size()];
        int count = 0;
        while(!result.isEmpty()) {
            response[count++] = result.pop();
        }
        return response;
    }

    boolean dfs(HashMap<Integer, ArrayList<Integer>> map, int[] visited, int i){
        // if we run into a node that we saw earlier in this current dfs, its a cycle
        if (visited[i] == -1) return false;
        // if we run into a node that we saw in a separate or earlier dfs there is no problem.
        if(visited[i] == 1) return true;

        // mark the current node as -1 as we are currently visiting.
        visited[i] = -1;
        if (map.containsKey(i)) {
            //get all the neighbours of this node.
            for (int j  : map.get(i)) {
                //dfs into its neighbours and return false if cycle is found.
                if (!dfs(map, visited, j)){
                    return false;
                }
            }
        }
        //if all its neighbours are visited and there are no issues
        //we are done with this node and we mark it as 1 done visiting.
        visited[i] = 1;
        result.push(i);
        return true;
    }
}
