package com.company;

import java.io.*;
import java.util.Scanner;

public class zadanie2 {
<<<<<<< HEAD
    public static void main(String[] args) {
   /* int[] CRC_TABLE = int[256];

        for (int i = 0; i < 256; ++i) {
            int code = i;
            for (int j = 0; j < 8; ++j) {
                code = (code & 0x01 ? 0xEDB88320 ^ (code >>> 1) : (code >>> 1));
            }
            CRC_TABLE[i] = code;
        }

    public static int crc32(string text){
            int crc = -1;
            for (int i = 0; i < text.length; ++i) {
      	var code = text.charCodeAt(i);
                crc = CRC_TABLE[(code ^ crc) & 0xFF] ^ (crc >>> 8);
            }
            return (-1 ^ crc) >>> 0;

        } ;


// Usage example:

        System.out.println(crc32('This is example text ...'));  // 3473739588*/
    }
=======

        public static void main(String[] args) throws IOException {

            Scanner scanner = new Scanner(System.in);
            System.out.println("type data to save");
            String text = scanner.nextLine();
            File file = new File("C:\\Users\\papie\\Desktop");
            try (FileOutputStream fos = new FileOutputStream(file)) {


                byte[] mybytes = text.getBytes();

                fos.write(mybytes);
            }
        }

>>>>>>> 5ec5e7395f0fdd2025b2ae6000a3fa056d2d1ba5
}
/*
* const CRC_TABLE = Array(256);

for (let i = 0; i < 256; ++i) {
    let code = i;
    for (let j = 0; j < 8; ++j) {
      	code = (code & 0x01 ? 0xEDB88320 ^ (code >>> 1) : (code >>> 1));
    }
    CRC_TABLE[i] = code;
}

const crc32 = text => {
    let crc = -1;
    for (let i = 0; i < text.length; ++i) {
      	const code = text.charCodeAt(i);
        crc = CRC_TABLE[(code ^ crc) & 0xFF] ^ (crc >>> 8);
    }
    return (-1 ^ crc) >>> 0;
};


// Usage example:

console.log(crc32('This is example text ...'));  // 3473739588*/