package com.manto9.column11;

import com.manto9.exceptions.NumberFormatException;

import java.io.*;
import java.util.Random;

/**
 * Created by manto9 on 09/06/16.
 */
public class QuickSort {

    Random rand = new Random();
    private static int N = 8000;
    int cutOff = 40;

    public int isValidInteger(String s) throws NumberFormatException{
        int num;
        num = Integer.decode(s);
        if(num<0) throw new NumberFormatException("Invalid format");
        return num;
    }

    public void readFile(String filename,int []arr) throws NumberFormatException {
        try {
            String content;
            int num;
            int i=-1;
            FileInputStream fin = new FileInputStream(filename);
            BufferedReader br = new BufferedReader(new InputStreamReader(fin));
            while((content = br.readLine())!= null){
                num = isValidInteger(content);
                arr[++i] = num;
                if((i+1)==N){
                    break;
                }
            }
            fin.close();
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private int pivot1(int []a, int l, int u){
        int m = l;
        int p = a[l];
        for(int i=l;i<=u;i++){
            if(a[i]<p){
                swap(a,++m,i);
            }
    }
        swap(a,l,m);
        return m;
    }

    private void swap(int[] a, int l, int m) {
        int t = a[l];
        a[l] = a[m];
        a[m] = t;
    }

    private void qSort1(int []arr, int l, int u){
        if(l>=u)
            return;
        int m = pivot1(arr,l,u);
        //System.out.println("Pivot is at " + m);
        qSort1(arr,l,m-1);
        qSort1(arr,m+1,u);
    }

    private void qSort2(int []arr, int l, int u){
        if(l>=u)
            return;
        int m = pivot2(arr,l,u);
        qSort2(arr,l,m-1);
        qSort2(arr,m+1,u);
    }

    private int pivot2(int[] a, int l, int u) {
        int p = a[l];
        int i = l+1;
        int j = u;
        while(i<=j){
            while((i<=u)&&(a[i]<=p))
                i++;
            while((j>=l)&&(a[j]>p))
                j--;
            if(i<j)
                swap(a,i,j);
        }
        swap(a,j,l);
        return j;
    }

    private void qSort3(int[] arr, int l, int u) {
        if(l>=u)
            return;
        int m = pivot3(arr,l,u);
        //System.out.println("Pivot is at " + m);
        qSort3(arr,l,m-1);
        qSort3(arr,m+1,u);
    }

    private int pivot3(int[] a, int l, int u) {
        int r = rand.nextInt(u-l+1) + l;
        //System.out.println("Random num : " + r);
        swap(a,l,r);
        int p = a[l];
        int i = l+1;
        int j = u;
        while(i<=j){
            while((i<=u)&&(a[i]<=p))
                i++;
            while((j>=l)&&(a[j]>p))
                j--;
            if(i<j)
                swap(a,i,j);
        }
        swap(a,j,l);
        return j;
    }

    private void print(int []a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i] + " ");
        }
        System.out.println("\n");
    }

    private void insertionSort(int []a){
        int len = a.length;
        int t;
        int j;
        for(int i=0;i<len;i++){
            t = a[i];
            for( j=i;(j>0)&&(a[j]<t);j++){
                a[j] = a[j-1];
            }
            a[j] = t;
        }
    }

    private void qSort4(int[] arr, int l, int u){
        if(u-l < cutOff)
            return;
        int m = pivot3(arr,l,u);
        qSort4(arr,l,m-1);
        qSort4(arr,m+1,u);
    }

    public static void main(String[] args) throws NumberFormatException {
        long start, end;
        int []arr = new int[N];
        //int []arr = new int[]{55,41,59,26,53,58,97,93};
        //int []arr = new int[]{100,90,80,70,60,50,40,30};
        //int []arr = new int[]{200,200,200,200,200,200,200,200};
        //int []arr = new int[]{10,20,30,40,50,60,70,80,90,100};
        QuickSort qs = new QuickSort();
        qs.readFile("shuf_num.txt",arr);

        start = System.nanoTime();
        qs.qSort1(arr,0,arr.length-1);
        end = System.nanoTime();
        System.out.println("Quicksort1 : " + (end-start) + "\n");
        //qs.print(arr);

        start = System.nanoTime();
        qs.qSort2(arr,0,arr.length-1);
        end = System.nanoTime();
        System.out.println("Quicksort2 : " + (end-start) + "\n");
        //qs.print(arr);

        start = System.nanoTime();
        qs.qSort3(arr,0,arr.length-1);
        end = System.nanoTime();
        System.out.println("Quicksort3 : " + (end-start) + "\n");
        //qs.print(arr);

        start = System.nanoTime();
        qs.qSort4(arr,0,arr.length-1);
        qs.insertionSort(arr);
        end = System.nanoTime();
        System.out.println("Quicksort4 : " + (end-start) + "\n");
        //qs.print(arr);

        System.out.println("The End");
    }
}
