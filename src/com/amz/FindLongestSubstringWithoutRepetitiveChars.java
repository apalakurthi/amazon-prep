package com.amz;

import java.util.HashSet;

public class FindLongestSubstringWithoutRepetitiveChars {

    public static void main(String[] args) {
        System.out.println (findShortLength("abcabcbb"));
    }
    public static int findShortLength(String s) {
        if (s == null || s.length()== 0) return 0;
        HashSet<Character> set = new HashSet<>();
        int head=0, tail, max=1;
        for(tail=0; tail<s.length(); tail++) {
            char c = s.charAt(tail);
            while(set.contains(c)) {
                set.remove(s.charAt(head++));
            }
            set.add(c);
            max = Math.max(tail-head+1, max);
        }


        return max;
    }
}
