package com.manto9.column15;

import java.util.Comparator;

/**
 * Created by manto9 on 26/07/16.
 */
public class SuffixComparator implements Comparator<Object> {

    public int compare(Object o1, Object o2) {
        String a1 = (String)o1;
        String a2 = (String)o2;
        //System.out.println(a1 + " " + a2);
        return a1.compareTo(a2);
    }
}
