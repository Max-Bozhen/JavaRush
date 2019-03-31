package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String s = fileScanner.nextLine();
            String[] from = s.split(" ");
            String lastName = from[0];
            String firstName = from[1];
            String middleName = from[2];
            String date = "";
            for(int i = 3; i<from.length; i++)
                date += from[i]+" ";
            DateFormat format = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
            Date birthDate = null;
            try {
                birthDate = format.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Person person = new Person(firstName, middleName, lastName, birthDate);
            return person;
        }

        @Override
        public void close() throws IOException {
            this.fileScanner.close();
        }
    }
}
