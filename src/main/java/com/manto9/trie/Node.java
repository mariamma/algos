package com.manto9.trie;

/**
 * Created by manto9 on 18/07/16.
 */
public class Node {
    char letter;
    Node[] edges;
    boolean isWord;

    public Node(char l){
        letter = l;
        edges = new Node[26];
        for(int i=0;i<26;i++)
            edges[i] = null;
        isWord = false;
    }
}
