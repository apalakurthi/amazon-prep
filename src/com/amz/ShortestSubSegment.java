package com.amz;

import java.util.HashMap;
import java.util.Map;

public class ShortestSubSegment {

    public static void main(String[] args) {
        String input = "This is a test. This is a programming test. This is a programming test in any language.";

        String[] arr = { "a", "test", "programming", "this"};
        System.out.println(shortestSubSegment(input, arr));
    }

    public static String shortestSubSegment(String input, String[] arr){
        input = input.toLowerCase();
        input = input.replaceAll("\\.", "");
        Map<String, Integer> inputMap = new HashMap<>();
        Map<String, Integer> currentMap = new HashMap<>();

        //add occurrences of each string into the map
        for(String str:arr){
            if(!inputMap.containsKey(str)){
                inputMap.put(str, 1);
            } else{
                inputMap.put(str, inputMap.get(str)+1);
            }
        }

        String[] inputArr = input.split(" ");

        int len = arr.length;
        int count = 0;
        int start =0;
        int minStart =0, minEnd =inputArr.length;

        for(int i=0; i < inputArr.length; i++){

            if(!inputMap.containsKey(inputArr[i])){
                continue;
            }

            if(currentMap.getOrDefault(inputArr[i], 0) < inputMap.get(inputArr[i])){
                currentMap.put(inputArr[i], currentMap.getOrDefault(inputArr[i], 0)+1);
                count++;
            } else{
                currentMap.put(inputArr[i], currentMap.get(inputArr[i])+1);
            }

            // window
            if(count == len){

                while(!inputMap.containsKey(inputArr[start]) ||
                        inputMap.get(inputArr[start]) < currentMap.getOrDefault(inputArr[start], 0)){
                    if(currentMap.containsKey(inputArr[start])){
                        currentMap.put(inputArr[start], currentMap.get(inputArr[start])-1);
                    }

                    start++;
                }

                if((minEnd - minStart) > (i-start)){
                    minStart = start;
                    minEnd = i;
                }

            }

        }


        if(len != count) {
            return "NO SUBSEGMENT FOUND";
        }

        String out ="";

        for(int i= minStart; i<= minEnd; i++){
            out+= inputArr[i]+" ";
        }
        return out;
    }
}
