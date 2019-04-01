package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFile = "";
        String secondFile = "";
        try{
            firstFile = reader.readLine();
            secondFile  = reader.readLine();
            reader.close();
        }catch (IOException ie){
            System.out.println("Try again");
        }
        FileReader fr;
        BufferedReader buffer;
        FileWriter fw;
        BufferedWriter writer;
        ArrayList<String> fromFile =new ArrayList<>();
        try{
            fr = new FileReader(firstFile);
            buffer = new BufferedReader(fr);
            while (buffer.ready())
                fromFile.add(buffer.readLine());
            buffer.close();

            fr.close();
            fw = new FileWriter(secondFile, true);
            writer = new BufferedWriter(fw);
            for(String s : fromFile){
                s = s.replaceAll("\\.", "!");
                System.out.println(s);
                writer.write(s);
            }
            writer.close();
            fw.close();
        }catch (IOException ie){

        }
    }
}
