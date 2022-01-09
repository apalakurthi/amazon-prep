package com.amz;

public class Trie {
    TriNode root;

    public Trie() {
        root = new TriNode('0');
    }

    public void addNode(String word){
        TriNode current = root;
        for(int i=0; i< word.length(); i++) {
            char c = word.charAt(i);
            if(current.children[c-'a'] == null) {
                current.children[c-'a'] = new TriNode(c);
            }
            current = current.children[c-'a'];
        }
        current.isWord = true;
    }

    public boolean search(String word) {
        TriNode result =  getNode(word);
        return result != null && result.isWord;

    }

    public boolean startsWith(String word) {
        return getNode(word) != null;
    }

    public TriNode getNode(String word) {
        TriNode current = root;
        for(int i=0; i< word.length(); i++) {
            char c = word.charAt(i);
            if(current.children[c-'a'] == null) {
                return null;
            }
            current = current.children[c-'a'];
        }
        return current;
    }
}


class TriNode {
    public char c;
    public boolean isWord;
    public TriNode[] children;

    public TriNode(char c) {
        this.c = c;
        isWord = false;
        children = new TriNode[26];
    }

}