package com.amz;
/*
* https://leetcode.com/problems/surrounded-regions/
*
*
* */
public class SurroundedRegions {
    private int m, n;

    public static void main(String[] args) {
        char[][] grid = {
                {'x','x','x','x'},
                {'x','0','0','x'},
                {'x','x','0','x'},
                {'x','0','x','x'}
        };

        SurroundedRegions ns = new SurroundedRegions();
        ns.surroundedRegions(grid);

    }

    public void surroundedRegions(char[][] grid) {
        n= grid.length;
        m= grid[0].length;
        if(n ==0) {
            return;
        }

        for(int i=0; i< n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == '0' && (i != 0 && j!= 0 && i != n-1 && j != n-1)) {
                    dfs(grid, i, j);
                }
            }
        }

        for(int i=0; i< n; i++) {
            for(int j=0; j<m; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println("");
        }
    }

    public void dfs(char[][] grid, int i, int j) {
        if(i<0 || j<0 || i>=n ||j>=m || grid[i][j] != '0') {
            return;
        }

        grid[i][j] = 'x';
        dfs(grid, i-1,j);
        dfs(grid, i+1,j);
        dfs(grid, i,j-1);
        dfs(grid, i,j+1);

    }

}
