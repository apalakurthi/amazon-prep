package com.amz;

import java.util.ArrayList;


public class FindAnagramsInGivenStringAndPrintTheirStartingIndexes {

    public static void main(String[] args) {
        System.out.println (findShortLength("bacdecba", "abc"));
    }
    public static ArrayList<Integer> findShortLength(String s, String p) {
       ArrayList<Integer> result = new ArrayList<>();
       if(s.length()== 0 || p.length() == 0 || s.length() < p.length()) {
           return result;
       }

       int[] chars = new int[26];
       for(Character c : p.toCharArray()) {
           chars[c-'a']++;
       }

       int start =0, end=0, len= p.length();
       int diff = p.length(); // tracks how many characters off
       char temp;
       for(end =0; end<s.length(); end++) {

           // If the windows length is longer than the anagram, we should move the start pointer too.
           if(end-start >= len) {
                temp = s.charAt(start);
                chars[temp-'a']++;
               //If its positive this means the character was part of anagram
               //we are one step farther from forming the anagram so increment diff
                if(chars[temp-'a'] > 0) {
                   diff++;
               }
                start++;

           }
           temp = s.charAt(end);
           //Decrement the count for this char, because it is now part of sliding window
           chars[temp-'a']--;
           // if its positive then decrement the difference
            if(chars[temp-'a'] >= 0) {
                diff--;
            }
        // if difference is zero then we got oour anagram add start index to the result.
           if(diff ==0) {
               result.add(start);
           }
       }
        return result;
    }
}
