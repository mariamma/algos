package com.manto9.column14;

/**
 * Created by manto9 on 06/07/16.
 */
public class NodeHeap extends GenericHeap<Node> {

    public NodeHeap(int m) {
        super(m);
        heap = new Node[maxSize];
    }

    public void print(){
        for(int i=0;i<heapSize;i++){
            System.out.print(heap[i].symbol + " ");
        }
        System.out.println("\n");
    }

    public void siftUp(int n){
        int p;
        for(int i=n;i>0;){
            p=parent(i);
            if(heap[p].compareTo(heap[i])>0){
                swap(p,i);
            }
            i=p;
        }
    }

    protected void siftDown(int l, int u){
        int i = l;
        int left, right,c;
        while (i<=u){
            left = leftChild(i);
            right = rightChild(i);
            if(left>u)
                break;
            c = left;
            if((right<=u)&&(heap[right].compareTo(heap[left])<0)){
                c = right;
            }
            if(heap[i].compareTo(heap[c])<=0)
                break;
            swap(c,i);
            i = c;
        }
    }


}
