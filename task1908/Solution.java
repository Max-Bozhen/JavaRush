package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFileName = "";
        String secondFileNae = "";
        try {
            firstFileName = reader.readLine();
            secondFileNae = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader buffer;
        BufferedWriter writer;
        FileReader fr;
        FileWriter fw;
        ArrayList<String> full = new ArrayList<>();
        ArrayList<String> numbers = new ArrayList<>();

        try {
            fr = new FileReader(firstFileName);
            buffer = new BufferedReader(fr);
            while (buffer.ready()) {
                full.add(buffer.readLine());
            }
            buffer.close();
            fr.close();
            for (String s : full) {
                String[] temp = s.split(" ");
                for (int i = 0; i < temp.length; i++) {
                    try {
                        int a = Integer.parseInt(temp[i]);
                        numbers.add(temp[i]);
                    } catch (NumberFormatException ne) {
                        continue;
                    }
                }
            }
            fw = new FileWriter(secondFileNae);
            writer = new BufferedWriter(fw);
            for (String s : numbers)
                writer.write(s+ " ");
            writer.close();
            fw.close();

        } catch (IOException ie) {

        }


    }
}
