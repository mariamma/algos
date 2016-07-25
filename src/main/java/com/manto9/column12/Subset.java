package com.manto9.column12;

/**
 * Created by manto9 on 17/06/16.
 */
public class Subset {

    private static int M, N;

    private void print(int[] a){
        //System.out.println("\n");
        for(int i=0;i<M;i++){
            System.out.print(a[i] + " ");
        }
        System.out.print("||");
    }

    private void solve(int m, int n, int[] a){
        //System.out.println("Iteration with m=" + m + " n=" + n);
        if(m == M){
            //System.out.println("n=" + n + " m=" + m);
            print(a);
            return;
        }
        if((m<M)&&(n<N)) {
            a[m] = n;
            solve(m + 1, n + 1, a);
            solve(m, n + 1, a);
        }
        return;
    }

    public static void main(String[] args) {
        Subset s = new Subset();
        s.M = 3;
        s.N = 5;
        int[] a = new int[M];
        s.solve(0,0,a);
    }
}
