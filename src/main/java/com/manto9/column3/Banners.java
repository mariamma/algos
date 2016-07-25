package com.manto9.column3;

/**
 * Created by manto9 on 01/04/16.
 */
public class Banners {
    Row[] a = new Row[15];
    int N=15;
    int SHIFT = 12;
    int HALFSHIFT = 6;
    private static String SYMBOL = "(";

    class Row{
        int[] cols;

        Row(int []arr){
            cols = arr;
        }
    }

    public void initA(){
        Row a1 = new Row(new int[]{6,7,8});
        Row a2 = new Row(new int[]{5,6,8,9});
        Row a3 = new Row(new int[]{4,5,9,10});
        Row a4 = new Row(new int[]{3,4,10,11});
        Row a5 = new Row(new int[]{2,3,4,5,6,7,8,9,10,11,12});
        Row a6 = new Row(new int[]{1,2,12,13});
        Row a7 = new Row(new int[]{0,1,13,14});
       a[0] = null;
        a[1] = a1;
        a[2] = a2;
        a[3] = a3;
        a[4] = a4;a[5] = a5;a[6] = a6;
        a[7] = a7;
        a[8] = null;//a8;
        a[9] = null;//a9;
        a[10] = null;//a10;
        a[11] = null;
        a[12] = null;
        a[13] = null;
        a[14] = null;
    }

    public void printBanner(){
        int[] cols;
        int colInd = 0;
        for(int i=0;i<N+SHIFT;i++){
            if(a[i]!=null){
                colInd = 0;
                cols = a[i].cols;
                for(int j=0;j<N+SHIFT;j++){
                    if((colInd<cols.length)&&(j==cols[colInd]+HALFSHIFT)){
                        colInd++;
                        System.out.printf(" ");
                    }else if ((colInd<cols.length)&&(j!=cols[colInd]+HALFSHIFT)){
                        System.out.printf(SYMBOL);
                    }else{
                        System.out.printf(SYMBOL);
                    }
                }
            }else{
                for(int j=0;j<N+SHIFT;j++){
                    System.out.printf(SYMBOL);
                }
            }
            System.out.printf("\n");
        }

    }
    public static void main(String[] args) {
        Banners ban = new Banners();
        ban.initA();
        ban.printBanner();
    }
}
