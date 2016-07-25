package com.manto9.column14;

/**
 * Created by manto9 on 29/06/16.
 */
public class Heapsort {

    Heap h = new Heap(20);

    public void fastHeapSort(){

    }

    public static void main(String[] args) {
        Heapsort hSort = new Heapsort();
        int[] list = new int[]{10,3,6,20,12,15,7,123,67};
        hSort.h.sort(list);
    }
}
