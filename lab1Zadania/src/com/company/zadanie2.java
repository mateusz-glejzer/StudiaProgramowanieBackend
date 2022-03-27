package com.company;

import java.io.*;
import java.util.Scanner;

public class zadanie2 {

        public static void main(String[] args) throws IOException {

            Scanner scanner = new Scanner(System.in);
            System.out.println("type data to save");
            String text = scanner.nextLine();
            File file = new File("C:\\Users\\papie\\Desktop");
            try (FileOutputStream fos = new FileOutputStream(file)) {


                byte[] mybytes = text.getBytes();

                fos.write(mybytes);
            }
        }}