package com.manto9.column2;

/**
 * Created by manto9 on 25/02/16.
 */
public class ArrayShift {

    public static void main(String[] args){
        String str = "abcdefghijkl";
        int n = 4;
        char[] charArray = new char[str.length()];
        charArray = str.toCharArray();
        ArrayShift arrayShift = new ArrayShift();
        char[] revStr =  arrayShift.reverseShift(charArray,n);
        System.out.println("Final::");
        arrayShift.printCharArray(revStr);
    }

    private char[] newjuggleShift(char[] charArray, int d) {
        int len = charArray.length;
        int gcd = gcd(len,d);
        System.out.println("Gcd of " + d + " & " + len + " : " + gcd);

        int times = len/gcd;
        int start,cur,next = 0;
        char e1,e2;
        for(int k=0;k<gcd;k++){
            System.out.println("**Iter ::" + k + " **");
            cur = k;
            next = (k+len-d)%len;
            start = k;
            e1 = charArray[cur];
            e2 = charArray[next];
            while(start != next){
                charArray[next] = e1;
                cur = next;
                next = (cur+len-d)%len;
                e1 = e2;
                e2 = charArray[next];
                System.out.println(next + "  <- " + cur);
                printCharArray(charArray);
            }
            charArray[start] = e1;
            printCharArray(charArray);
        }
        return charArray;
    }


    private void swap(char[] charArray, int prev, int cur) {
        char t = charArray[prev];
        charArray[prev] = charArray[cur];
        charArray[cur] = t;
    }

    private int gcd(int p, int q) {
        int range;
        int g = 1;
        if(p>q) {
            range = (p/2 > q)?q:p/2;
        }else{
            range = (q/2 > p)?p:q/2;
        }
        for(int i=range;i>0;i--){
            if((p%i==0)&&(q%i==0)) {
                g = g * i;
                p = p / i;
                q = q / i;
            }
        }
        return g;
    }

    private  void printCharArray(char[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]);
        }
        System.out.println("");
    }

    public char[] reverseShift(char[] a, int d){
        int n=a.length;
        reverse(a,0,d-1);
        reverse(a,d,n-1);
        reverse(a,0,n-1);
        return a;
    }

    public void reverse(char[] arr, int p, int q){
        char t;
        int i,j;
        i=p; j=q;
        while(i<= (p+q)/2){
            t=arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            i++;
            j--;
        }
    }

}
