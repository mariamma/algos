package com.manto9.column15;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by manto9 on 28/07/16.
 */
public class TextGeneration {
    private String suffixArray[];
    int N=0;
    int k = 2;
    Random rand = new Random();

    public TextGeneration(int M){
        suffixArray = new String[M];
    }

    public String readFile(String filename){
        String line;
        StringBuilder sb = new StringBuilder();
        try {
            FileInputStream fin = new FileInputStream(filename);
            BufferedReader br = new BufferedReader(new InputStreamReader(fin));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return sb.toString();
    }

    public void generateSuffixArray(String filename){
        String line, prev;
        line = readFile(filename);
        boolean end=false;
        String word;
        int len = line.length();
        System.out.println("Length of string " + len);
        int i=0;
        while(i<len){
            //System.out.println("Substring[" + i + "]=" + line.substring(i,len));
            suffixArray[N++] = line.substring(i,len);
            int j=i;
            for(;j<len && line.charAt(j)!=' ';j++);
            for(;j<len && line.charAt(j)==' ';j++);
            i = j;
        }
    }

    public void printSuffixArray(){
        for(int i=0;i<N;i++)
            System.out.println("[" + (i+1) + "] =>" + suffixArray[i]);
    }

    public void sort(){
        Arrays.sort(suffixArray,0,N,new MySuffixComparator(k));
    }

    public String searchkWord(String key){
        int m = bSearch(key,N);
        System.out.println("Binary search index = " + m);
        int index = randomKey(key,m);
        System.out.println("Index = " + (index-1));
        String[] words = null;
        if((index>=0)&&(index<N)) {
            words = suffixArray[index-1].split("\\s");
        }
        System.out.println("First word of index " + index  + " = " + words[0]);
        System.out.println("Second word of index " + index  + " = " + words[1]);
        if(words.length<k)
            return ".";
        return words[k-1];
    }

    private int randomKey(String key, int m) {
        int i=m;
        while(getFirstWord(suffixArray[i]).compareTo(key) == 0){
            i++;
        }
        if(i>m){
            return rand.nextInt(i-m) + i;
        }
        return m;
    }

    public int bSearch(String k, int n){
        int l=-1;
        int u=n;
        int m = -1;
        String first;
        int res;
        while((l+1)!=u){
            m=(l+u)/2;
            first = getFirstWord(suffixArray[m]);
            res = first.compareTo(k);
            if(res<1)
                l=m;
            else
                u=m;
        }
        return m;
    }

    private String getFirstWord(String s) {
        String[] words = s.split("\\s+");
        //System.out.println("First word returned " + words[0]);
        return words[0];
    }

    public void printText(){
        int i=0;
        String prev = "a";
        String cur = "";
        while(i<20){
            //System.out.print(prev + " ");
            System.out.print(prev + " ");
            cur = searchkWord(prev);
            prev = cur;
            i++;
        }
    }

    public static void main(String[] args) {
        TextGeneration tg = new TextGeneration(10000);
        tg.generateSuffixArray("src/main/resources/suffixArray.txt");
        //tg.printSuffixArray();
        tg.sort();
        //tg.printSuffixArray();
        tg.printText();
    }
}
