package com.amz.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/word-ladder-ii/
 * */


public class WordLadder2 {
    public static void main(String[] args) {
        WordLadder2 ladder2 = new WordLadder2();
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        List<List<String>> result = ladder2.findLadders("hit", "cog", wordList);

        for (List<String> array: result) {
            for (String s: array) {
                System.out.print(s+",");
            }
            System.out.println();
        }

    }


    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        //In the problem it is given that endword is there in wordlist
        // if it is not we can't solve the problem.
        if(!wordList.contains(endWord)) {
            return new ArrayList<>();
        }

        //you may continue without removing these two lists
        //your approach will slightly differ from mine
        wordList.remove(beginWord);
        wordList.remove(endWord);


        //we try to traverse level by level(BFS)
        //If we reach to endword then no need to explore lower levels
        //just find solutions that are available in this very level

        Queue<List<String>> q= new LinkedList<>();
        List<String> temp=new ArrayList<>();
        temp.add(beginWord);
        q.add(temp);

        //to keep track of word that should be removed at every level
        List<String> remove=new ArrayList<>();

        List<List<String>> list=new ArrayList<>();

        //this flag will let us know that we don't have to explore lower level
        boolean flag=true;

        while(flag && !q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                List<String> newList=q.remove();
                String newBegin=newList.get(newList.size()-1);

                //when we first time encounter path to endword there id no need to go to wordlist
                //just traverse through queue and check which element leads to endword at current level
                if(isDiffOne(newBegin,endWord)){
                    //if we do find those elements then we add them to list.
                    temp=new ArrayList<>(newList);
                    temp.add(endWord);
                    list.add(temp);
                    flag=false;//we mark flag so we don't further look into lower levels

                }else if(flag){
                    //looking another possible paths to endword
                    int j=0;
                    while(j<wordList.size()) {
                        String current=wordList.get(j);
                        if(isDiffOne(newBegin,current)){
                            //don't remove current from wordlist here
                            //because we may not find all possible paths if we do

                            temp=new ArrayList<>(newList);
                            temp.add(current);

                            q.add(temp);
                            remove.add(current);//to keep track of word that should be removed after we are done with this level
                        }

                        j++;
                    }
                }
            }

            for(String str:remove){
                wordList.remove(str);
            }
            remove.clear();
        }
        return list;
    }
    //simple method to find difference of letters between two words
    boolean isDiffOne(String current, String next){
        int diff=0;
        for(int i=0;i<current.length();i++){
            if(current.charAt(i)!=next.charAt(i)){
                diff++;
            }
            if(diff>=2){
                return false;
            }
        }
        return diff != 0;
    }
}
