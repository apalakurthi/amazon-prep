package com.amz.graphs;
/*
*
* https://leetcode.com/problems/number-of-islands/
* */
public class NumberOfIslands {
    private int m, n;

    public static void main(String[] args) {
        char[][] grid = {
                  {'1','1','1','1','0'},
                  {'1','1','0','1','0'},
                  {'1','1','0','0','0'},
                  {'0','0','0','0','0'}
        };

        char[][] grid1 = {
                  {'1','1','0','0','0'},
                  {'1','1','0','0','0'},
                  {'0','0','1','0','0'},
                  {'0','0','0','1','1'}
                };
        
        NumberOfIslands ns = new NumberOfIslands();

        System.out.println(ns.numIslands(grid));
        System.out.println(ns.numIslands(grid1));
    }

   /* public int numberOfIslands(char[][] grid) {
        int count =0;
        n= grid.length;
        m= grid[0].length;
        if(n ==0) {
            return 0;
        }

        for(int i=0; i< n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
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

    }*/


        public int numIslands(char[][] grid) {
            int count =0;
            int n= grid.length;
            int m = grid[0].length;
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++){
                    if(grid[i][j] == '1') {
                        dfs(i, j, grid);
                        count++;
                    }

                }
            }
            return count;
        }


        private void dfs(int i, int j, char[][] grid) {
            if(i < 0 || j<0 || i>= n || j>=m || grid[i][j] != '1'){
                return;
            }

            grid[i][j] = '0';
            dfs(i-1, j, grid);
            dfs(i+1, j, grid);
            dfs(i, j-1, grid);
            dfs(i, j+1, grid);
        }
}

