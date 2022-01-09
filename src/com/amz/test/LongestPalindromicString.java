package com.amz.test;
/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * */
public class LongestPalindromicString {
    public static void main(String[] args) {
        LongestPalindromicString ls = new LongestPalindromicString();
        System.out.println(ls.longestPalindrome("abcba"));
    }

    public String longestPalindrome(String s) {
        if (s== null || s.length()== 0) return "";
        int start =0, end=0;
        for (int i=0; i<s.length(); i++) {
            int len1 = expandFromMiddle(s, i, i);
            int len2 = expandFromMiddle(s, i, i+1);
            int max = Math.max(len1, len2);
            if (max > end-start) {
                start = i-(max-1)/2;
                end = i+max/2;
            }
        }
        return s.substring(start, end+1);


    }

    private int expandFromMiddle(String s, int left, int right){
        if (s== null || left> right)  return 0;
        while(left >= 0 && right <s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right-left-1;
    }

    //Brute force approach

    public String bruteForce(String s) {
        if (s== null || s.length()== 0) return "";
        int start =0; int max=1;
        for (int i=0; i<s.length(); i++) {
            for(int j=i; j<s.length(); j++) {
              int flag = 1;

              for(int k=0; k<(j-i+1)/2; k++) {
                  if (s.charAt(i+k) != s.charAt(j-k)) {
                      flag =0;
                  }
              }

              if(flag !=0 && (j-i+1)>max) {
                  start =i;
                  max = j-i+1;
              }
            }
        }
        return s.substring(start, max);
    }
}
