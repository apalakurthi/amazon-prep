package com.amz.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {
    public static void main(String[] args) {
        ValidSudoku validSudoku = new ValidSudoku();
        System.out.println(validSudoku.valid(new char[][]   {{'5','3','.','.','7','.','.','.','.'}
                                        ,{'6','.','.','1','9','5','.','.','.'}
                                        ,{'.','9','8','.','.','.','.','6','.'}
                                        ,{'8','.','.','.','6','.','.','.','3'}
                                        ,{'4','.','.','8','.','3','.','.','1'}
                                        ,{'7','.','.','.','2','.','.','.','6'}
                                        ,{'.','6','.','.','.','.','2','8','.'}
                                        ,{'.','.','.','4','1','9','.','.','5'}
                                        ,{'.','.','.','.','8','.','.','7','9'}}));

    }

    public boolean valid(char[][] board) {
        Map<Integer, Set<Character>> rowSets = new HashMap<>();
        Map<Integer, Set<Character>> colSets = new HashMap<>();
        Map<Integer, Set<Character>> boxSets = new HashMap<>();

        for(int i = 0; i < 9; i++) {
            rowSets.put(i, new HashSet<>());
            colSets.put(i, new HashSet<>());
            boxSets.put(i, new HashSet<>());
        }

        for(int row = 0; row < 9; row++) {
            for(int col = 0; col < 9; col++) {
                char ch = board[row][col];

                if(ch != '.') {
                    int box = (row/3)*3+(col/3);

                    if(!rowSets.get(row).add(ch)) return false;
                    if(!colSets.get(col).add(ch)) return false;
                    if(!boxSets.get(box).add(ch)) return false;
                }
            }
        }
        return true;
    }


}
