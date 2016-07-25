package com.manto9.trie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manto9 on 18/07/16.
 */
public class Sentence {

    Trie trie;

    public Sentence(){
        trie = new Trie();
    }

    public void split(String sent){
        int st = 0;
        int i;
        for(i=0;i<sent.length();i++){
            //System.out.println("Char " + i + " = " + sent.charAt(i));
            //System.out.println("Checking for substring " + st + " " + i);
            if(true == trie.lookUp(sent.substring(st,i))){
                System.out.println(sent.substring(st,i));
                st = i;
            }
        }
        if(true == trie.lookUp(sent.substring(st,i))){
            System.out.println(sent.substring(st,i));
        }
    }

    public void add(List<String> words){
        for (String w:words) {
            trie.addWord(w);
        }
        return;
    }

    public static void main(String[] args) {
        Sentence sentence = new Sentence();
        List<String> str = new ArrayList<String>();
        str.add("trie");
        str.add("pea");
        str.add("nut");
        str.add("butter");
        str.add("tree");
        str.add("also");
        sentence.add(str);
        sentence.split("peanutbuttertreealso");
    }
}
