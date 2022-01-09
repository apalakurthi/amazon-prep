package com.amz.graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
* https://www.geeksforgeeks.org/connected-components-in-an-undirected-graph/
*
* */
public class NumberOfConnectedComponents {

    public static void main(String[] args) {

        int[][] edges = new int[][]{{0,1}, {1,2}, {2,0}, {3,4}};
        NumberOfConnectedComponents nc = new NumberOfConnectedComponents();
        System.out.println(nc.countComponents(5, edges));
    }

    int countComponents(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();

        //set up adjacency list with empty linked list
        for (int i = 0; i < n; i++) {
            adj.put(i, new LinkedList<>());
        }

        // populate adjacency list with all nodes neighbours
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        // create a visited array, where false= unvisited and true = visited.
        boolean[] visited = new boolean[n];

        //variable to count number of connected components
        int count =0;
        for (int i = 0; i < n; i++) {
            if(visited[i] == false) {
                count ++;
                dfs(adj, i, visited);
            }
        }
        return count;
    }

    private void dfs(HashMap<Integer, List<Integer>> adj, int index, boolean[] visited) {
        visited[index] = true;

        for (Integer j: adj.get(index)) {
            if(visited[j] == false) {
                dfs(adj, j, visited);
            }
        }

    }


}
