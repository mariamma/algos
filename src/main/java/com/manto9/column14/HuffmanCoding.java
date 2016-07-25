package com.manto9.column14;

/**
 * Created by manto9 on 06/07/16.
 */
public class HuffmanCoding {
    Node root;
    NodeHeap heap = new NodeHeap(26);

    String sb[] = new String[]{"A","B","C","D","E","F","G","H"};
    int wt[] = new int[]{8,3,1,1,1,1,1,1};

    public void buildTree() throws HeapFullException {
        Node min1, min2;
        Node t = null;
        for(int i=0;i<sb.length;i++){
            t = new Node(wt[i],sb[i]);
            heap.insert(t);
            System.out.println("Inserted symbol " + t.symbol);
        }
        heap.print();
        while(!heap.isEmpty()){
            min1 = heap.extractMin();
            System.out.println("Extracted min1 " + min1.symbol);
            heap.print();
            if(heap.isEmpty()){
                t = min1;
                break;
            }
            min2 = heap.extractMin();
            System.out.println("Extracted min2 " + min2.symbol);
            heap.print();
            t = new Node(min1.weight+min2.weight, min1.symbol+min2.symbol);
            t.left = min1;
            t.right = min2;
            min1.parent = min2.parent = t;
            System.out.println("Inserted " + t.symbol);
            if(t.left!=null)
                System.out.println("Left -> " + t.left.symbol);
            if(t.right!=null)
                System.out.println("Right -> " + t.right.symbol);
            heap.insert(t);
            heap.print();
        }
        root = t;
    }

    public void traversal(Node t, String val){
        if(t==null)
            return;
        //System.out.println(t.symbol);
        if(t.isLeafNode()) {
            System.out.println(t.symbol + " " + val);
            return;
        }else{
            traversal(t.left, val+"0");
            traversal(t.right, val+"1");
        }
    }

    public void decode(char[] bits){
        int i=0;
        Node t = root;
        while(i<bits.length){
            if(bits[i]=='0'){
                t = t.left;
            }
            else{
                t = t.right;
            }
            if(t.isLeafNode()){
                System.out.print(t.symbol);
                t = root;
            }
            i++;
        }
        if(!t.isLeafNode())
            System.out.println("\nNot complete input");
    }

    public static void main(String[] args) {
        String bits = "1101111100001";
        HuffmanCoding huffmanCoding = new HuffmanCoding();
        try {
            huffmanCoding.buildTree();
        } catch (HeapFullException e) {
            e.printStackTrace();
        }
        huffmanCoding.traversal(huffmanCoding.root,"");
        huffmanCoding.decode(bits.toCharArray());
    }
}
