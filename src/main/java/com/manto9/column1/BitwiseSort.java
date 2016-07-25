package com.manto9.column1;

/**
 * Created by manto9 on 18/07/16.
 */
public class BitwiseSort {
    private static int DUPLICATE_CNT = 10;
    private static int LONG = 64;
    int MAX = 1000;
    private int N;
    private int DUP;
    private long[] a;

    private int init_DUP(){
        int i=0;
        while(Math.pow(2,i)<DUPLICATE_CNT)
            i++;
        return i;
    }

    public BitwiseSort(){
        DUP = init_DUP();
        N = MAX/16;
        //System.out.println("Value of N " + N);
        a = new long[N];
        for(int i=0;i<N;i++)
            a[i] = 0;
    }

    public void set(int num){
        int index = num/16;
        int pos = ((num%16)*4);
        long v, cnt = 0,loc;
        long word, map = 0;
        long hex = (long) (Math.pow(2,63) - 1);
        for (int i=0;i<4;i++)
            map = hex & ~(1<<(pos+i));
        System.out.println("Map val " + map);
        word = a[index];
        v = (map) & word;
        v = v>>pos;
        cnt = v;

//        for(int i=0;i<4;i++){
//            word = a[index];
//            //System.out.println("Index " + index);
//            //System.out.println("Pos " + (pos+i) + " Shift val " + (1<<(pos+i)) + " for num " + num);
//           // System.out.println(a[index] & (1<<(pos+i)));
//            v = (int) (word >>(pos+i));
//            System.out.println("v = " + v);
//            cnt |= v<<i;
//        }
        System.out.println("Count " + cnt + " pos " + pos);
        cnt++;
        System.out.println("Count after inc " + cnt);
        //cnt = cnt<<pos;
        //System.out.println("Count after shift " + cnt);
        System.out.println("hex " + map + " cnt " + cnt + " pos " + pos );
        //cnt|=map;
        //System.out.println("Count after map " + cnt);
        for(int i=0;i<4;i++) {
            if((cnt&(1<<i)) !=0 ){
                System.out.println("Setting 1 at " + (pos+i));
                a[index] |= 1<<(pos+i);
            }else {
                System.out.println("Setting 0 at " + (pos+i));
                a[index] &= ~(1 << (pos + i));
            }
        }
        //System.out.println("Setting " + cnt + " at " + pos);
        System.out.println("New array = " + a[index]);
        return;
    }

    public void print(){
        long num, cnt=0;
        long word;
        long v =0;
        int MULT = 16;
        for (int i=0;i<N;i++){
            word = a[i];
            for(int j=0;j<LONG;){
                v=0;
                for(int k=0;k<4;k++){
                    if((word & (1<<j))!=0){
                        v|=(i<<k);
                    }
                    //v = v>>j;
                    j++;
                }
                cnt = v;
                if(cnt>0) {
                    System.out.println("i = " + i + " v = " + v);
                    num = i*MULT + (j-1);
                    System.out.println("Count " + cnt + " num " + num);
                }
            }
        }
    }

    public static void main(String[] args) {
        BitwiseSort bs = new BitwiseSort();
        int[] arr = new int[]{4,4,4,4,4,4};
        for(int i=0;i<arr.length;i++){
            bs.set(arr[i]);
            System.out.println("******************");
        }
        bs.print();
    }
}