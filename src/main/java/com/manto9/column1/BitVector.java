package com.manto9.column1;

import com.manto9.exceptions.NumberFormatException;

import java.io.*;
import java.math.BigDecimal;
import java.util.BitSet;

/**
 * Created by manto9 on 11/02/16.
 *
 * bash-3.2$ time java -cp  target/lessons-1.0-SNAPSHOT.jar com.manto9.column1.BitVector

 real	0m2.579s
 user	0m2.752s
 sys	0m0.291s

 time java -cp  target/lessons-1.0-SNAPSHOT.jar com.manto9.column1.QuickSort

 real	0m3.115s
 user	0m3.387s
 sys	0m0.334s

 bash-3.2$ time sort -n shuf_num.txt > sorted_shuf_num.txt

 real	0m15.185s
 user	0m14.513s
 sys	0m0.552s


 NOTE:: File read&write time
 real	0m1.967s
 user	0m2.156s
 sys	0m0.308s
 */
public class BitVector {

    private static BitSet bitSet;
    private static int nBits;

    public void init(int nbits){
        nBits = nbits;
        bitSet = new BitSet(nbits);
    }

    public void insert(int num){
        bitSet.set(num,true);
    }

    public void sort(String filename){
        try {
            FileOutputStream fout = new FileOutputStream(filename);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fout));
            for(int i=0;i<nBits;i++){
                if(bitSet.get(i)) {
                    bw.write(String.valueOf(i));
                    bw.newLine();
                }
            }
            bw.flush();
            bw.close();
            fout.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public int isValidInteger(String s) throws NumberFormatException{
        int num;
        num = Integer.decode(s);
        if(num<0) throw new NumberFormatException("Invalid format");
        return num;
    }

    public void getFileSort(String filename) throws NumberFormatException{
        try {
            String content;
            int num;
            FileInputStream fin = new FileInputStream(filename);
            BufferedReader br = new BufferedReader(new InputStreamReader(fin));
            while((content = br.readLine())!= null){
                num = isValidInteger(content);
                insert(num);
            }
            fin.close();
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws NumberFormatException {
        BitVector bitVector = new BitVector();
        bitVector.init(10000000);
        bitVector.getFileSort("shuf_num.txt");
        bitVector.sort("java_shuf_num.txt.txt");
    }
}
