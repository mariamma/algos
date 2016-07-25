package com.manto9.column8;

import java.util.Random;

/**
 * Created by manto9 on 14/05/16.
 *
 * n=10000
 1270412 59811724962
 1270412 62645867
 1270412 72855892
 1270412 2743000
 1270412 583952
 */
public class MaxSubSumArrayPoly1 {

    private int []array;// = new int[]{31,-41,59,26,-53,58,97,-93,-23,84};

    public  void maxNCubed(){
        int n = array.length;
        int sum = 0;
        int max = 0;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                sum=0;
                for(int k=i;k<j;k++){
                    sum +=array[k];
                }
                if(max<sum) max=sum;
            }
        }
        System.out.print(max);
    }

    public  void maxNSquared(){
        int sum, max;
        sum = max =0;
        int n=array.length;
        for(int i=0;i<n;i++){
            sum=0;
            for(int j=i;j<n;j++){
                sum += array[j];
                if(sum>max) {
                    max = sum;
                }
            }
        }
        System.out.print(max);
    }

    private  void maxNSpaceSquared() {
        int n = array.length;
        int sumarr[] = new int[n];
        int sum, max;
        sumarr[0] = array[0];
        for (int i=1;i<n;i++){
            sumarr[i] = sumarr[i-1] + array[i];
        }
        max = sum = sumarr[0];
        for(int i=1;i<n;i++){
            for(int j=i;j<n;j++){
                sum=sumarr[j]-sumarr[i-1];
                if(sum>max) max = sum;
            }
        }
        System.out.print(max);
    }

    private  void generateArray(int n){
        array = new int[n];
        Random random=new Random();
        int randomNumber;
        for (int i=0;i<n;i++) {
            randomNumber = (random.nextInt(65536) - 32768);
            array[i] = randomNumber;
        }
    }

    public static void main(String[] args) {
        MaxSubSumArrayPoly1 p = new MaxSubSumArrayPoly1();
        p.generateArray(10000);
        long start, end;
        start = System.nanoTime();
        p.maxNCubed();
        end = System.nanoTime();
        System.out.println(" " + (end-start));

        start = System.nanoTime();
        p.maxNSquared();
        end = System.nanoTime();
        System.out.println(" " + (end-start));

        start = System.nanoTime();
        p.maxNSpaceSquared();
        end = System.nanoTime();
        System.out.println(" " + (end-start));

        start = System.nanoTime();
        System.out.print(p.maxNDivideAndConquer(0,(p.array.length-1),0));
        end = System.nanoTime();
        System.out.println(" " + (end-start));

        start = System.nanoTime();
        p.maxNLinear();
        end = System.nanoTime();
        System.out.println(" " + (end-start));
    }

    private  void maxNLinear() {
        int max, cumArray;
        int n=array.length;
        max = cumArray = 0;
        for(int i=0;i<n;i++){
            cumArray +=array[i];
            cumArray = max(0,cumArray);
            max = max(cumArray,max);
        }
        System.out.print(max);
    }

    private static int max(int a, int b){
        if(a>b)
            return a;
        else
            return b;
    }

    private  int maxNDivideAndConquer(int l, int r, int sum) {
        int left, right, lsum, rsum, mid;
        int lmax, rmax;

        if(l>r)
            return 0;
        if(l==r)
            return (array[l]>0)?array[l]:0;
        mid = (l+r)/2;
        left = maxNDivideAndConquer(l,mid,sum);
        right = maxNDivideAndConquer(mid+1,r,sum);
        lsum = lmax = 0;
        for(int i=mid;i>=l;i--){
            lsum += array[i];
            lmax = max(lsum,lmax);
        }
        rsum = rmax = 0;
        for(int i=mid+1;i<=r;i++){
            rsum +=array[i];
            rmax = max(rsum,rmax);
        }
        sum = max(lmax+rmax, max(left,right));
        return sum;
    }


}
