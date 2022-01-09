package com.amz.oned;
/*
* https://leetcode.com/problems/word-search/
*
* */
public class WordSearch {
    private int m, n;
    private char[] arr;

    public static void main(String[] args) {
        /*char[][] grid = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };*/

        char[][] grid1 = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        WordSearch ns = new WordSearch();

        //System.out.println(ns.wordSearch(grid, "ABCCED"));
        System.out.println(ns.exist(grid1, "SEE"));
    }


    public boolean exist(char[][] board, String word) {
        arr = word.toCharArray();
        n = board.length;
        m = board[0].length;

        for (int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(dfs(i, j, board, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, char[][] board, int index) {
        if(i<0 || i>=n || j<0|| j>=m || board[i][j] == '+' ) {
            return false;
        }

        if (board[i][j] != arr[index]) {
            return false;
        } else if (index == arr.length - 1) {
            return true;
        }

        char temp = board[i][j];
        board[i][j] = '+';

        boolean result = dfs(i-1, j, board, index+1)
                || dfs(i+1, j, board, index+1)
                || dfs(i, j-1, board, index+1)
                ||dfs(i, j+1, board, index+1);
        board[i][j] = temp;
        return result;

    }
}
