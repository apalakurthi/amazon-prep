package com.amz;

public class WordDictionary {
    Trie trie;
    public WordDictionary() {
        trie = new Trie();
    }

    public void addWord(String word) {
       trie.addNode(word);
    }

    public boolean search(String word) {
        return trie.search(word);
    }
}
