package com.manto9.column14;

/**
 * Created by manto9 on 29/06/16.
 */
public class PriorityQueue {

    Heap pq;
    public PriorityQueue(){
    }

    public void pqSort(int[] list, int n) throws HeapFullException, HeapEmptyException {
        pq = new Heap(n);
        int len = list.length;
        for(int i=0;i<len;i++){
            pq.insert(list[i]);
        }
        for (int i=0;i<len;i++){
            list[i] = pq.extractMin();
        }
    }

    public static void main(String[] args) {
        int[] list = new int[]{10,3,6,20,12,15,7,123,67};
        PriorityQueue priorityQueue = new PriorityQueue();
        try {
            priorityQueue.pqSort(list, 30);
        } catch (HeapFullException e) {
            e.printStackTrace();
        } catch (HeapEmptyException e) {
            e.printStackTrace();
        }
        for(int i=0;i<list.length;i++){
            System.out.print(list[i] + " ");
        }
    }
}
