package com.manto9.column8;

/**
 * Created by manto9 on 17/05/16.
 */
public class SumCloseToTen {

    private int []array = new int[]{31,-41,59,26,-53,58,97,-93,-23,84};
    private static int NUM = 10;

    private  int close(int a){
        return (Math.abs(a-NUM));
    }

    private int minSubVector(){
        int sum, cumArray;
        int n = array.length;
        cumArray = 0;
        sum = array[0];
        for(int i=0;i<n;i++){
            cumArray = cumArray + array[i];
            if(close(cumArray) > close(array[i]))
                cumArray = array[i];
            if(close(cumArray) < close(sum))
                sum = cumArray;
            System.out.println(i +" num : " + array[i] +  " sum : " + sum + " cumarray : " + cumArray);
        }
        return sum;
    }

    public static void main(String[] args) {
        SumCloseToTen s = new SumCloseToTen();
        int min = s.minSubVector();
        System.out.println(min);
    }
}
