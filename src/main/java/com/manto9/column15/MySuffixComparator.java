package com.manto9.column15;

import java.util.Comparator;

/**
 * Created by manto9 on 30/07/16.
 */
public class MySuffixComparator implements Comparator<Object> {
    int k;

    public MySuffixComparator(int  k) {
        this.k = k;
    }

    public int compare(Object o1, Object o2) {
        int i=0;
        String w1 = null,w2 = null;
        String a1 = (String)o1;
        String a2 = (String)o2;
        String[] s1 = a1.split("\\s+");
        String[] s2 = a2.split("\\s+");
        while((i<k)&&(i<s1.length)&&(i<s2.length)){
            w1 = s1[i].toLowerCase();
            w2 = s2[i].toLowerCase();
            if(w1.compareTo(w2)!=0)
                break;
            i++;
        }
        if(i==k)
            return 0;
        else if(i>s1.length) {
            return -1;
        }
        else if(i>s2.length){
            return 1;
        }
        return w1.compareTo(w2);

    }
}
