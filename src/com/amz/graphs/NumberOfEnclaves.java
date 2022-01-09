package com.amz.graphs;
/*
* https://leetcode.com/problems/number-of-enclaves/
*
* */
public class NumberOfEnclaves {
    private int m, n;

    public static void main(String[] args) {
        char[][] grid = {
                {'0','0','0','0'},
                {'1','0','1','0'},
                {'0','1','1','0'},
                {'0','0','0','0'}
        };

        char[][] grid1 = {
                {'0','1','1','0'},
                {'0','0','1','0'},
                {'0','0','1','0'},
                {'0','0','0','0'}
        };

        NumberOfEnclaves ns = new NumberOfEnclaves();

        System.out.println(ns.numberOfEnclaves(grid));
        System.out.println(ns.numberOfEnclaves(grid1));
    }

    public int numberOfEnclaves(char[][] grid) {
        int count =0;
        n= grid.length;
        m= grid[0].length;

        if(n ==0) {
            return 0;
        }

        for(int i=0; i< n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == '1' && (i ==0 || j==0 || i==n-1 || j==m-1)) {
                    dfs(grid, i, j);
                }
            }
        }
        for(int i=0; i< n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == '1') {
                    count++;
                }
            }
        }

        return count;
    }

    public void dfs(char[][] grid, int i, int j) {
        if(i<0 || j<0 || i>=n ||j>=m || grid[i][j] != '1') {
            return;
        }

        grid[i][j] = '0';
        dfs(grid, i-1,j);
        dfs(grid, i+1,j);
        dfs(grid, i,j-1);
        dfs(grid, i,j+1);

    }
}
