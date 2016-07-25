package com.manto9.column1;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * Created by manto9 on 16/02/16.
 */
public class GenerateNum {

    public void generate(int start,int end,int inc, String filename){
        try {
            FileOutputStream fout = new FileOutputStream(filename);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fout));
            for (int i = start; i < end; i = i + inc) {
                bw.write(String.valueOf(i));
                bw.newLine();
            }
            bw.close();
            fout.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        GenerateNum gen = new GenerateNum();
        gen.generate(0,2000000000,1,"src/main/resources/numbers.txt");
    }
}
