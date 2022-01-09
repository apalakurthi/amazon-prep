package com.amz.test;

import java.util.Arrays;
import java.util.Comparator;

class MergeIntervals {
    public static void main(String[] args) {
        MergeIntervals solution = new MergeIntervals();
        int[][] result = solution.merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
    }
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        int i = 0;
        for(int j = 1; j < intervals.length; j++) {
            if(intervals[j][0] <= intervals[i][1]) {
                intervals[i][1] = Math.max(intervals[i][1], intervals[j][1]);
            } else {
                intervals[i+1][0] = intervals[j][0];
                intervals[i+1][1] = intervals[j][1];
                i++;
            }
        }

        return Arrays.copyOfRange(intervals, 0, i + 1);
    }
}
