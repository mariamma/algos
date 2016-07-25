package com.manto9.column2;

import java.io.*;

/**
 * Created by manto9 on 19/02/16.
 */
public class MissingNumber {
    int max,min,mid,min_cnt,max_cnt;
    String filename;
    private static int iter =1;

    public void init(){
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        min_cnt = 0;
        max_cnt = 0;
    }

    public void findMidNumber(String filename){
        String content;
        init();
        try {
            FileInputStream fin = new FileInputStream(filename);
            BufferedReader br = new BufferedReader(new InputStreamReader(fin));
            while((content = br.readLine())!= null){
                //System.out.println("Num :: " + Integer.parseInt(content) );
                max = setMax(max,content);
                min = setMin(min,content);
            }
            br.close();
            fin.close();
            System.out.println("Max :: " + max);
            System.out.println("Min :: " + min);
            mid = findMid(min,max);
            System.out.println("Mid :: " + mid);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void processFile(String file_name){
        try {
            System.out.println("Iter No :: " + iter);
            filename = file_name;
            String content;
            int num;
            findMidNumber(filename);
            FileInputStream fin = new FileInputStream(filename);
            BufferedReader br = new BufferedReader(new InputStreamReader(fin));
            FileOutputStream fmin = new FileOutputStream("Low_"+iter+".txt");
            BufferedWriter bmin = new BufferedWriter(new OutputStreamWriter(fmin));
            FileOutputStream fmax = new FileOutputStream("High_"+iter+".txt");
            BufferedWriter bmax = new BufferedWriter(new OutputStreamWriter(fmax));
            iter++;

            while((content = br.readLine())!= null){
                num = Integer.parseInt(content);
                if(num<mid){
                    bmin.write(String.valueOf(num));
                    bmin.newLine();
                    min_cnt++;
                }else{
                    bmax.write(String.valueOf(num));
                    bmax.newLine();
                    max_cnt++;
                }
            }
            br.close();
            fin.close();
            bmin.close();
            fmin.close();
            bmax.close();
            fmax.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Max_cnt :: " + max_cnt);
        System.out.println("Min_cnt :: " + min_cnt);
        if((max_cnt<3)||(min_cnt<3))
            return;
        if((max_cnt<min_cnt)){
            processFile("High_"+ (iter-1) +".txt");
        }else{
            processFile("Low_"+ (iter-1) +".txt");
        }

    }

    private int findMid(int min, int max) {
        int range = max - min;
        return min + (range/2);
    }

    private int setMin(int min, String content) {
        if(min > Integer.parseInt(content))
            return Integer.parseInt(content);
        else
            return min;
    }

    private int setMax(int max, String content) {
        if(max < Integer.parseInt(content))
            return Integer.parseInt(content);
        else
            return max;
    }

    public static void main(String[] args){
        MissingNumber missingNumber = new MissingNumber();
        missingNumber.processFile("src/main/resources/numbers.txt");
    }
}
