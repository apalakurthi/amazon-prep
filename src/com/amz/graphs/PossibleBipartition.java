package com.amz.graphs;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/possible-bipartition/
 * */
public class PossibleBipartition {
    public static void main(String[] args) {
        PossibleBipartition pb = new PossibleBipartition();
        System.out.println(pb.possibleBipartition(5, new int[][]{{1,2}, {1,3}, {2,4}}));
    }

    boolean possibleBipartition(int n, int[][] dislikes) {
        if (n == 0 || dislikes == null || dislikes.length == 0) {
            return false;
        }

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] dislikePair : dislikes) {
            map.get(dislikePair[0]-1).add(dislikePair[1]-1);
            map.get(dislikePair[1]-1).add(dislikePair[0]-1);
        }

        // create visited array where 0= unvisited, 1= group A, -1= group B
        int[] visited = new int[n];

        // if the dfs finds two neighbours with the same grouping, then return false
        //since we have not visited this connected component yet,
        // It does not matter whether we assign this first node to 1 to -1


        for (int i = 0; i < n; i++) {
            if (visited[i] == 0 && ! dfs(map, visited, i, 1)) {
                return false;
            }
        }
        return true;
    }

    boolean dfs(HashMap<Integer, ArrayList<Integer>> map, int[] visited, int person, int group) {
        // put this person in the indicated group.
        visited[person] = group;

        // check all the neighbours of this group
        for (int j: map.get(person)) {
            // if any of those neighbours belong to same group then party is over.
            if(visited[j] == group) {
                return false;
            }
            // if any neighbours have not been visited yet, DFS to it and assign it to the opposite group
            if(visited[j] == 0 && !dfs(map, visited, j, -group)) {
                return false;
            }
            // the third case is if a neighbour is already in the opposite group, no need to DFS there
        }
        // if everything works out and the DFS didnt run into any issues with neighbours return true.
        return true;
    }
}
