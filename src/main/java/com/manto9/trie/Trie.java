package com.manto9.trie;

/**
 * Created by manto9 on 18/07/16.
 */
public class Trie {
    Node root;

    public Trie() {
        root = new Node(Character.MIN_VALUE);
    }

    public void addWord(String word) {
        Node t = root;
        char ch;
        int pos;
        for (int i = 0; i < word.length(); i++) {
            ch = word.charAt(i);
            pos = (int) (ch - 'a');
            if (t.edges[pos] != null) {
                t = t.edges[pos];
            } else {
                t.edges[pos] = new Node(ch);
                t = t.edges[pos];
            }
        }
        t.isWord = true;
        return;
    }

    public boolean lookUp(String word) {
        Node t = root;
        char ch;
        for (int i = 0; i < word.length(); i++) {
            ch = word.charAt(i);
            if (t.edges[ch - 'a'] == null)
                return false;
            else
                t = t.edges[ch - 'a'];
        }
        if (t.isWord == true)
            return true;
        return false;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.addWord("also");
        trie.addWord("assoc");
        trie.addWord("tree");
        trie.addWord("trie");
        if(trie.lookUp("alsoo"))
            System.out.println("Word available");
        else
            System.out.println("Word not available");
    }
}