package com.manto9.column11;

/**
 * Created by manto9 on 11/06/16.
 */
public class FatPivot {

    public static void main(String[] args) {
        int[] arr = new int[]{3,5,23,5,3,6,9,10};
        FatPivot fp = new FatPivot();
        fp.print(arr);
        fp.quickSort(arr, 0,arr.length-1);
        fp.print(arr);
    }

    private void print(int []a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i] + " ");
        }
        System.out.println("\n");
    }

    private void quickSort(int[] a, int l, int u) {
        if(l>=u)
            return;
        int t = a[l];
        int i = l+1;
        int j = u;
        int m = l;

        while(i<=j){
            while((i<=u)&&(a[i]<=t)){
                if(a[i] == t){
                    swap(a,++m,i);
                }
                i++;
            }
            while((j>l)&&(a[j]>t)){
                j--;
            }
            if(i<j){
                swap(a,i,j);
            }
        }
        int r = j;
        for(i=l;i<=m;i++){
            swap(a,i,j);
            r--;
        }

        quickSort(a,l,r);
        quickSort(a,j+1,u);
    }

    private void swap(int[] a, int l, int m) {
        int t = a[l];
        a[l] = a[m];
        a[m] = t;
    }
}
