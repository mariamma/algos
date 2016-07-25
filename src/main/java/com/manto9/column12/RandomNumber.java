package com.manto9.column12;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by manto9 on 14/06/16.
 */
public class RandomNumber {

    Random r = new Random();

    private void genKnuth(int n, int m){
        int select = m;
        int rem = n;
        for(int i=0;(i<n)&&(select>0);i++){
            if(r.nextInt()%rem < select) {
                System.out.println(i);
                select--;
            }
            rem--;
        }
    }


    private void setImpl(int n, int m){
        Set<Integer> s = new TreeSet<Integer>();

    }


    public static void main(String[] args) {
        RandomNumber rNum = new RandomNumber();
        rNum.genKnuth(100,20);
    }
}
