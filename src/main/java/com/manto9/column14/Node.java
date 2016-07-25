package com.manto9.column14;

/**
 * Created by manto9 on 06/07/16.
 */
public class Node implements Comparable{
    int weight;
    String symbol;
    Node left, right, parent;

    public Node(int w, String s){
        weight = w;
        symbol = s;
        parent = left = right = null;
    }

    public int compareTo(Object o) {
        Node n = (Node)o;
        if (this.weight > n.weight) return 1;
        else if (this.weight < n.weight) return -1;
        else return 0;
    }

    public boolean isLeafNode(){
        return ((left==null)&&(right==null));
    }
}
