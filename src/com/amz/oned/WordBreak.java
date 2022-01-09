package com.amz.oned;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/word-break/
 * */
public class WordBreak {
    public static void main(String[] args) {
        WordBreak cs = new WordBreak();
        List<String> dict = new ArrayList<>();
        dict.add("leet");
        dict.add("code");
        System.out.println(cs.wordBreak("leetcode", dict));

        /*dict = new HashSet<>();
        dict.add("apple");
        dict.add("pen");
        System.out.println(cs.wordBreak("applepenapple", dict));

        dict = new HashSet<>();*/
        /*dict.add("cats");
        dict.add("dog");
        dict.add("sand");
        dict.add("and");
        dict.add("cat");

        System.out.println(cs.wordBreak("catsandog", dict));*/
    }

    private boolean wordBreak(String s, List<String> dict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0]= true;

        for(int i=1; i<= s.length(); i++) {

            for(int j=0; j< i; j++) {
                String substring = s.substring(j,i);
                boolean exist = dict.contains(substring);

                if (dp[j] && exist){
                    dp[i] = true;
                    break;
                }
            }

        }
        return dp[s.length()];
    }
}
