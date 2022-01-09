package com.amz;

import java.util.*;

public class LetterCombinations {

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits){
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length()== 0) {
            return result;
        }

        HashMap<Character, char[]> dict = new HashMap<>();
        dict.put('2',new char[]{'a','b','c'});
        dict.put('3',new char[]{'d','e','f'});
        dict.put('4',new char[]{'g','h','i'});
        dict.put('5',new char[]{'j','k','l'});
        dict.put('6',new char[]{'m','n','o'});
        dict.put('7',new char[]{'p','q','r','s'});
        dict.put('8',new char[]{'t','u','v'});
        dict.put('9',new char[]{'w','x','y','z'});

        char[] arr = new char[digits.length()];
        dfs(digits, arr, 0, dict, result);

        return result;
    }

    // time complexity is 0(vn) v: number of vertices and n number of edges
    public static void dfs(String digits, char[] arr, int index, HashMap<Character, char[]> dict, List<String> result) {
        if(index == digits.length()) {
            result.add(new String(arr));
            return;
        }

        char number = digits.charAt(index);
        char[] candidates = dict.get(number);
        for(int i =0; i<candidates.length; i++) {
            arr[index] = candidates[i];
            dfs(digits, arr, index+1, dict, result);
        }
    }
}
