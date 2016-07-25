package com.manto9.column14;

/**
 * Created by manto9 on 28/06/16.
 */
public class Heap {

    private int[] heap;
    int heapSize, maxsize;

    public Heap(int m){
        maxsize = m;
        heapSize = 0;
        heap = new int[maxsize];
    }

    private int value(int i){
        return heap[i];
    }

    private int leftChild(int i){
        return 2*i+1;
    }

    private int rightChild(int i){
        return 2*i+2;
    }

    private int parent(int i){
        return (i-1)/2;
    }

    private boolean isNull(int i){
        return (i<0)||(i>=heapSize);
    }

    private void swap(int a, int b){
        int t = heap[a];
        heap[a] = heap[b];
        heap[b] = t;
    }

    public void siftUp(int n){
        int p;
        for(int i=n;i>0;){
            p=parent(i);
            if(heap[p]<heap[i]){
                swap(p,i);
            }
            i=p;
        }
    }

    public void siftDown(int n){
        int l,r,c;
        int i=0;
        while(i<n){
            l = leftChild(i);
            r = rightChild(i);
            c=l;
            if(l>=n)
                break;
            if(r < n){
                if(heap[l] < heap[r])
                    c=r;
            }
            if(heap[i] > heap[c])
                break;
            swap(i,c);
            i = c;
        }
    }

    public void siftDown(int l, int u){
        /*  Question : 2
            pre: heap(l+1,u)
            post: heap(l,u)
         */
        int i=l;
        int left, right, maxChild;
        while(i<=u){
            left = leftChild(i);
            right = rightChild(i);
            if(left > u)
                break;
            maxChild = left;
            if(right<=u){
                if(heap[left]<heap[right]){
                    maxChild = right;
                }
            }
            if(heap[i]>heap[maxChild])
                break;
            swap(i,maxChild);
            i = maxChild;
        }
    }

    public void print(int[] list){
        for(int i=0;i<heapSize;i++){
            System.out.print(heap[i] + " ");
        }
        System.out.print("\n");
    }

    public void insert(int t) throws HeapFullException {
        if(heapSize >=maxsize)
            throw new HeapFullException();
        heap[heapSize++] = t;
        siftUp(heapSize-1);
        System.out.println("Inserting " + t);
        print(heap);
        return;
    }

    public int extractMin() throws HeapEmptyException {
        if(heapSize<1)
            throw new HeapEmptyException();
        int t = heap[0];
        heap[0] = heap[heapSize-1];
        heapSize--;
        siftDown(heapSize);
        System.out.println("Extracting " + t);
        print(heap);
        return t;
    }

    public void sort(int[] list){
        int len = list.length;
        heapSize = len;
        for(int i=0;i<len;i++){
            heap[i] = list[i];
        }
        for(int i=1;i<len;i++){
            System.out.println("Moving up " + heap[i]);
            siftUp(i);
            print(heap);
        }
        for(int i=len-1;i>0;i--){
            System.out.println("Extracting " + heap[0]);
            System.out.println("swapping " + heap[0] + " and " + heap[i]);
            swap(0,i);
            print(heap);
            //siftDown(i);
            siftDown(0,i-1);
            print(heap);
        }
        print(heap);
    }
}
