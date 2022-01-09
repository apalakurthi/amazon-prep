package com.amz;

import java.util.ArrayList;
import java.util.List;
/**
 * https://leetcode.com/problems/zigzag-conversion/
 * **/
public class ZigZag {
    public static void main(String[] args) {
        ZigZag zigZag = new ZigZag();
       System.out.println(zigZag.convert("PAYPALISHIRING", 4));

    }

    public String convert(String s, int numRows) {
        List<char []> arr = new ArrayList<>();
        make2DMatrix(s,numRows,arr);
        /////////Now traverse the 2d Matrix row wise and get your string/////////////

        int cols = arr.size();
        int rows = numRows;
        StringBuilder str = new StringBuilder();

        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){ //every col is a different vertical list
                char [] vertical = arr.get(j); //get that vertical list
                if((vertical[i] >= 'A' && vertical[i] <='Z') ||
                        (vertical[i] >= 'a' && vertical[i] <= 'z') ||
                        (vertical[i] =='.') || (vertical[i] == ',')){
                    str.append(vertical[i]);
                }
            }
        }

        return str.toString();
    }

    private void make2DMatrix(String s,int numRows,List<char []> arr){
        int idx = 0 ; //for string idx
        int end = 0;
        int listidx = 0;
        while(idx < s.length()){
            arr.add(new char[numRows]);

            if(end == 0){ //then only whole vertical list will be filled
                for(int i = 0;i<numRows && idx < s.length();i++){
                    arr.get(listidx)[i] = s.charAt(idx++);
                    end = i;
                }
            }else{ //only one char will be filled that too at end - 1 idx
                arr.get(listidx)[end] = s.charAt(idx++);
            }

            end--; //for next iteration
            if(end < 0) end = 0;
            listidx++; //for next iteration
        }    //end of while loop
    }

}