package com.manto9.column14;

/**
 * Created by manto9 on 07/07/16.
 */
public class BST {

    Node root = null;
    String string;
    public class Node{
        double val;
        Node left, right;

        public Node(double v){
            val = v;
            left = right = null;
        }
    }

    public Node insert(Node node, double v){
        //System.out.println("Processing " + v);
        if(node == null) {
            //System.out.println("Initializing root");
            node = new Node(v);
            return node;
        }

        Node t = node;
        while(t!=null) {
            if (t.left != null && t.right != null) {
                if (t.val <= v)
                    t = t.right;
                else
                    t = t.left;
            }
            else if (t.left == null && t.right == null) {
                if (t.val <= v)
                    t.right = new Node(v);
                else
                    t.left = new Node(v);
                return node;
            }
            else if (t.left == null && t.val > v) {
                t.left = new Node(v);
                return node;
            }
            else if (t.left == null && t.val <= v){
                t = t.right;
            }
            else if (t.right == null && t.val <= v) {
                t.right = new Node(v);
                return node;
            }
            else {
                t = t.left;
            }
        }
        return node;
    }

    public void inorderTraversal(Node t){
        if(t==null)
            return;
        inorderTraversal(t.left);
        System.out.print(t.val + " ");
        inorderTraversal(t.right);
    }

    public void delete(Node node,double v){
        Node t = node;
        Node parent = null;
        boolean left = true;
        if(node==null)
            return;
        while(t!=null){
            while(t.left!=null || t.right!=null) {
                if (t.val == v)
                    break;
                parent = t;
                if ((t.val < v)&&(t.right!=null))
                    t = t.right;
                else if((t.val > v)&&(t.left!=null))
                    t = t.left;
            }
            if(t.left==null && t.right==null && parent!=null){
                if(parent.left == t){
                    parent.left=null;
                    return;
                }else{
                    parent.right=null;
                    return;
                }
            }else{
                parent=t;
                Node suc;
                if(t.left!=null) {
                    suc = t.left;
                    while (suc.right != null) {
                        parent = suc;
                        suc = suc.right;
                    }
                }else{
                    suc = t.right;
                    while (suc.left != null) {
                        parent = suc;
                        suc = suc.left;
                    }
                }
                swapVals(t,suc);
                //deleteSuccessor(t,suc,left);
                //delete(suc,v);
                t=suc;
            }
        }
    }

    private void swapVals(Node t, Node suc) {
        double x = t.val;
        t.val = suc.val;
        suc.val = x;
        System.out.println("\nSwapping values " + t.val + " " + suc.val);
    }

    private Node findLeftSuccessor(Node n) {
        Node t =n.left;
        while(t!=null && t.right!=null){
            t = t.right;
        }
        return t;
    }

    private Node findRightSuccessor(Node n) {
        Node t =n.right;
        while(t!=null && t.left!=null){
            t = t.left;
        }
        return t;
    }

    public double lookup(Node root, double wt){
        Node t = root;
        Node parent = null;
        double s = -1;
        while(t!=null){
            if(t.val == wt)
                return wt;
            parent = t;
            if(t.val<wt)
                t = t.right;
            else {
                s = t.val;
                t = t.left;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        BST bst = new BST();
        double tempWt;
        double[] bins = new double[]{1,1,1,1};
        double[] wt = new double[]{0.2,0.5,0.1,0.8,0.6,0.3,0.1};
        for(int i=0;i<bins.length;i++) {
            bst.root = bst.insert(bst.root, bins[i]);
        }
        bst.inorderTraversal(bst.root);
        for(int i=0;i<wt.length;i++){
            tempWt = bst.lookup(bst.root,wt[i]);
            System.out.println("\nBefore deleting " + tempWt);
            bst.inorderTraversal(bst.root);
            bst.delete(bst.root,tempWt);
            System.out.println("After deleting " + tempWt);
            bst.inorderTraversal(bst.root);
            bst.insert(bst.root,tempWt-wt[i]);
            System.out.println("\nAdding weight " + (tempWt-wt[i]) + "\n");
            bst.inorderTraversal(bst.root);
        }
    }
}
