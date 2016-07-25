package com.manto9.column1;

import java.io.*;
import java.util.Arrays;

/**
 * Created by manto9 on 18/02/16.
 */
public class QuickSort {

    private int[] num = new int[10000000];

    public void readFile(String filename){
        try {
            String content;
            int i=0;
            FileInputStream fin = new FileInputStream(filename);
            BufferedReader br = new BufferedReader(new InputStreamReader(fin));
            while((content = br.readLine())!= null){
                num[i++] = Integer.parseInt(content);
            }
            fin.close();
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sort(){
        Arrays.sort(num);
    }

    public static void main(String[] args){
        QuickSort qs = new QuickSort();
        qs.readFile("shuf_num.txt");
       // qs.sort();
        qs.writeToFile("Qs_sort.txt");
    }

    private void writeToFile(String filename) {
        try {
            FileOutputStream fout = new FileOutputStream(filename);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fout));
            for(int i=0;i<num.length;i++){
                bw.write(String.valueOf(i));
                bw.newLine();
            }
            bw.flush();
            bw.close();
            fout.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
