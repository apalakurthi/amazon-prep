package com.amz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class Skyline {

    public static void main(String[] args) {
        //int[][] buildings = {{1,3,4}, {3,4,4}, {2,6,2}, {8,11,4}, {7,9,3}, {10,11,2}};
        int[][] buildings = {{0,2,3}, {0,3,4}};
        Skyline skyline = new Skyline();
        List<int[]> result = skyline.getSkyline(buildings);
        for (int[] item: result) {
            System.out.println(item[0] +":::" + item[1]);
        }
    }

    public List<int[]> getSkyline(int[][] buildings) {
        BuildingPoint[] buildingPoints = new BuildingPoint[buildings.length*2];
        int index =0;
        for (int building[]: buildings) {
            buildingPoints[index] = new BuildingPoint();
            buildingPoints[index].x = building[0];
            buildingPoints[index].isStart= true;
            buildingPoints[index].height= building[2];

            buildingPoints[index+1] = new BuildingPoint();
            buildingPoints[index+1].x = building[1];
            buildingPoints[index+1].isStart= false;
            buildingPoints[index+1].height= building[2];
            index += 2;
        }
        Arrays.sort(buildingPoints);

        TreeMap<Integer, Integer> queue = new TreeMap<>();
        queue.put(0,1);
        int prevMaxHeight =0;
        List<int[]> result = new ArrayList<>();
        for (BuildingPoint buildingPoint: buildingPoints) {
            Integer i = queue.get(buildingPoint.height);
            if(buildingPoint.isStart) {
                if(i != null) {
                    queue.put(buildingPoint.height, i++);
                } else {
                    queue.put(buildingPoint.height, 1);
                }
            } else {
                if(i != null) {
                    if (i > 1) {
                        queue.put(buildingPoint.height, i--);
                    } else {
                        queue.remove(buildingPoint.height);
                    }
                }
            }
            int currentMaxHeight = queue.lastKey();
            if (prevMaxHeight != currentMaxHeight) {
                result.add(new int[]{buildingPoint.x, currentMaxHeight});
                prevMaxHeight = currentMaxHeight;
            }
        }
        return result;
    }

    static class BuildingPoint implements Comparable<BuildingPoint>{
        int x;
        boolean isStart;
        int height;


        @Override
        public int compareTo(BuildingPoint o) {
            if (this.x != o.x) {
                return this.x-o.x;
            } else {
                return (this.isStart ? -this.height: this.height) - (o.isStart ? -o.height : o.height);
            }
        }
    }


}
