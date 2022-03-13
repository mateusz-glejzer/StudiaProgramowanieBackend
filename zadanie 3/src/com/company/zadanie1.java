package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;



public class zadanie1 {
    public static void main(String[] args) throws IOException {
        InputStream input = new FileInputStream("C:\\Users\\mateu\\Desktop\\ProgramowanieBackend\\tekst.txt");
        int data = input.read();
        while (data != -1) {
            System.out.println(data);
            data = input.read();
        }


        input.close();


    }
}