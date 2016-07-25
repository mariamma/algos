package com.manto9.column2;

import java.io.*;
import java.util.*;

/**
 * Created by manto9 on 17/03/16.
 */
public class Anagram {

    int N=10;
    List<Group> groups = new LinkedList<Group>();

    class Group{
        private String word;
        private String signature;

        Group(String w, String s){
            word = w;
            signature = s;
        }

        public String getWord() {
            return word;
        }

        public String getSignature() {
            return signature;
        }
    }

    public void init(){
        String content;
        String filename = "src/main/resources/dict.txt";
        FileInputStream fin = null;
        try {
            fin = new FileInputStream(filename);
            BufferedReader br = new BufferedReader(new InputStreamReader(fin));
            while((content = br.readLine())!= null){
                groups.add(new Group(content,sortWord(content)));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public String sortWord(String word){
        char[] charArray = word.toCharArray();
        Arrays.sort(charArray);
        return String.valueOf(charArray);
    }

    public void findAnagram(){
        Collections.sort(groups,new AnagramComparator());
        String oldsig = "";
        String cursig;
        for (Group g:groups) {
            cursig = g.getSignature();
            if(cursig!=null && !oldsig.equals(cursig)){
                System.out.print("\n");
                System.out.print(g.getWord() + " ");
                oldsig = cursig;
            }else{
                System.out.print(g.getWord() + " ");
            }
        }

    }

    public void print(){
        for (Group g:groups) {
            System.out.println(g.getSignature() + " " + g.getWord());
        }
    }

    public static void main(String[] args) {
        Anagram anagram = new Anagram();
        anagram.init();
        anagram.findAnagram();
        //anagram.print();
    }
}

class AnagramComparator implements Comparator<Anagram.Group>{

    public int compare(Anagram.Group o1, Anagram.Group o2) {
        return o1.getSignature().compareTo(o2.getSignature());
    }
}
