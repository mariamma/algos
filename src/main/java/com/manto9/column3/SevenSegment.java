package com.manto9.column3;

/**
 * Created by manto9 on 05/04/16.
 */
public class SevenSegment {

    public static void main(String[] args) {
        SevenSegment seg = new SevenSegment();
        displaynum(123);
    }

    private static void displaynum(int num) {
        int n,r;
        while(num>0){
            r=num%10;
            System.out.println(getCode(r));
            num = num/10;
        }
    }

    private static  String getCode(int num){
        switch (num){
            case 0: return "00000000";
            case 1: return "000010100";
            case 2: return "011101100";
            case 3: return "011101010";
            case 4: return "0011011010";
            case 5: return "011110010";
            default: return "00000000";
        }
    }

}
