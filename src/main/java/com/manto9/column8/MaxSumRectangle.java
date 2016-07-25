package com.manto9.column8;

/**
 * Created by manto9 on 19/05/16.
 */
public class MaxSumRectangle {

    private float [][]arr = new float[][]{{(float) 2.5,3,-1, (float) 1.5},
            {(float) 1.5,2,3,0},
            {-2, (float) 1.5,2,0},
            {3,-4, (float) 1.5,4}};
    private int n = 4;

    public static void main(String[] args) {
        MaxSumRectangle m = new MaxSumRectangle();
        float max = m.solve();
        System.out.println(max);
    }


    private float solve() {
        float [][]b = new float[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==0){
                    if(j>0){
                        b[i][j] = findLeft(b,i,j);
                    }else{
                        b[i][j] = arr[i][j];
                    }
                }else if(j==0){
                        b[i][j] = findTop(b,i,j);
                }else{
                        b[i][j] = findGen(b,i,j);
                }
            }
        }
        return getMaxSum(b);
    }

    private float getMaxSum(float[][] b) {
        float max = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(b[i][j] > max){
                    max = b[i][j];
                }
            }
        }
        return max;
    }

    private float findGen(float[][] b, int i, int j) {
        float left = b[i][j-1];
        float right = b[i-1][j];
        float dia = b[i-1][j-1];
        float sum = arr[i][j] + left + right - dia;
        return (sum > b[i][j])?sum:b[i][j];
    }

    private float findTop(float[][] b, int i, int j) {
        float sum = (arr[i][j] + b[i-1][j]);
        return (sum > b[i][j])?sum:b[i][j];
    }

    private float findLeft(float[][] b, int i, int j) {
        float sum = (arr[i][j] + b[i][j-1]);
        return (sum > b[i][j])?sum:b[i][j];
    }
}
