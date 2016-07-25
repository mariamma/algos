package com.manto9.column4;

/**
 * Created by manto9 on 11/04/16.
 */
public class BinarySearch {

    public int bSearch(int[] arr, int s){
        int n=arr.length;
        int l,u,m;
        l=0;u=n-1;
        while(l<=u){
            m=(l+u)/2;
            if(arr[m]==s)
                return m;
            else if (arr[m]<s)
                l=m+1;
            else
                u=m-1;
            if(l>u){
                return -1;
            }
        }
        return -1;
    }

    public int bMultSearch(int[] arr, int s){
        int n=arr.length;
        int l,u,m;
        l=0;u=n-1;
        while(l<=u){
            m=(l+u)/2;
            if(arr[m]==s) {
                return m;
            }
            else if (arr[m]<s) {
                l = m + 1;
            }
            else {
                u = m - 1;
            }
            if(l>u){
                return -1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] arr = new int[] {1,3,5,7,9,10};
        int p = bs.bSearch(arr,0);
        System.out.println("Found at " + p);
    }
}
