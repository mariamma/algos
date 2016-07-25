package com.manto9.column14;

/**
 * Created by manto9 on 06/07/16.
 */
public abstract class GenericHeap<T> {

    protected T[] heap;
    protected int heapSize, maxSize;

    public GenericHeap(int m){
        maxSize = m;
        heapSize = 0;
    }

    protected int leftChild(int i){
        return 2*i+1;
    }

    protected int rightChild(int i){
        return 2*i+2;
    }

    protected int parent(int i){
        return (i-1)/2;
    }

    protected boolean isNull(int i){
        return (i<0)||(i>=heapSize);
    }

    protected boolean isEmpty(){
        return heapSize<=0;
    }

    protected void swap(int a, int b){
        //System.out.println("Swapping " + a + " " + b);
        T t = heap[a];
        heap[a] = heap[b];
        heap[b] = t;
    }

    public void insert(T t) throws HeapFullException {
        if(heapSize > maxSize)
            throw new HeapFullException();
        heap[heapSize] = t;
        heapSize++;
        siftUp(heapSize-1);
        return;
    }

    public T extractMin(){
        T min = heap[0];
        if(heapSize==1){
            heapSize--;
        }else {
            //System.out.println("Swapping with " + heapSize);
            swap(0, heapSize-1);
            heapSize--;
            siftDown(0, heapSize-1);
        }
        return min;
    }

    protected abstract void siftDown(int i, int i1);

    protected abstract void siftUp(int i);
}
