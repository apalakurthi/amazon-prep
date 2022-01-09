package com.amz.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/partition-labels/
 * */
public class PartitionLabels {
    public static void main(String[] args) {
        PartitionLabels partitionLabels = new PartitionLabels();
        partitionLabels.partition("ababcbacadefegdehijhklij");
    }

    List<Integer> partition(String s) {
        List<Integer> wordLengths = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        int l=0, r=0;
        for (int i = 0; i < s.length(); i++) {
            r = Math.max(r, map.get(s.charAt(i)));
            if (r== i) {
                wordLengths.add(r-l+1);
                l = r+1;
            }
        }
        return wordLengths;
    }
}
