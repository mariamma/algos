package com.manto9.column15;

import java.util.Arrays;
/**
 * Created by manto9 on 25/07/16.
 */
public class SuffixArray {

    private String[] suffixArray = new String[1000];
    int N;

    private void initSuffixArray(String s){
        int l = s.length();
        int i;
        N=0;
        for(i=0;i<l;i++){
            if(Character.isLetter(s.charAt(i))) {
                suffixArray[N] = s.substring(i, l);
                N++;
            }
        }
    }

    public void sortSuffixArray(){
        Arrays.sort(suffixArray,0,N,new SuffixComparator());
    }

    public void print(){
        for(int i=0;i<N;i++){
            System.out.println(suffixArray[i]);
        }
    }

    public int findMaxCommon(){
        int max=0, len;
        String maxStr = null;
        for(int i=0;i<N-1;i++){
            len = comp(suffixArray[i],suffixArray[i+1]);
            if(len>max) {
                max = len;
                maxStr = suffixArray[i];
            }
        }
        System.out.println(maxStr.substring(0,max));
        return max;
    }

    private int comp(String s, String s1) {
        int i=0,j=0,u=0;
        while((i < s.length())&&(j<s1.length())){
            if ((s.charAt(i) == s1.charAt(j))) {
                i++;
                j++;
                u++;
            }
            else if(!Character.isLetter(s.charAt(i)))
                i++;
            else if(!Character.isLetter(s1.charAt(j)))
                j++;
            else
                break;
        }
        i--;
        while ((i>=0)&&(!Character.isLetter(s.charAt(i))))
                i--;
        return (i+1);
    }

    public static void main(String[] args) {
        SuffixArray s = new SuffixArray();
        s.initSuffixArray("Ask not what the country can do for you, but what you can do for your country");
        //s.print();
        s.sortSuffixArray();
        //s.print();
        System.out.println(s.findMaxCommon());
    }

}
