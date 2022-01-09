package com.amz.oned;


import java.util.*;

class WordBreakII {

    List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        WordBreakII wordBreakII = new WordBreakII();
        List<String> response =  wordBreakII.wordBreak("catsanddog", Arrays.asList("cat","cats","and","sand","dog"));
    }


    public List<String> wordBreak(String s, List<String> wordDict) {
        recurse(s, 0, new HashSet<>(wordDict), new StringBuilder());
        return result;
    }

    private void recurse(String s, int index, Set<String> dict, StringBuilder sb) {
        if (index == s.length()) {
            result.add(sb.toString().trim());
            return;
        }
        int L = index;
        StringBuilder temp = new StringBuilder();
        while (L < s.length()) {
            temp.append(s.charAt(L++));
            String found = temp.toString();
            if (dict.contains(found)) {
                String prev = sb.toString();
                sb.append(" ").append(found);
                recurse(s, L, dict, sb);
                sb = new StringBuilder(prev);
            }
        }
    }
}