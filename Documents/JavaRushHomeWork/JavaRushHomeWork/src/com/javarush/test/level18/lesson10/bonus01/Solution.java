package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        String textOne = args[0];
        String fileName = args[1];
        String fileWrite = args[2];

        // number to encrypt and to decrypt
        int number = 5;

        if(textOne.equals("-e")){
            FileInputStream fileIn = new FileInputStream(fileName);
            FileOutputStream fileOut = new FileOutputStream(fileWrite);

            //read all bytes in file
            byte[] allBytes = new byte[fileIn.available()];
            fileIn.read(allBytes);

            // use method encrypt() for bytes in file
            fileOut.write(enrypt(allBytes, number));

            // close to read and write in files
            fileIn.close();
            fileOut.close();

        } else if (textOne.equals("-d")) {
            FileInputStream fileIn = new FileInputStream(fileName);
            FileOutputStream fileOut = new FileOutputStream(fileWrite);

            //read all bytes in file
            byte[] allBytes = new byte[fileIn.available()];
            fileIn.read(allBytes);

            // use method encrypt() for bytes in file
            fileOut.write(decrypt(allBytes,number));

            // close to read and write files
            fileIn.close();
            fileOut.close();
        }

    }

    public static byte[] enrypt(byte[] arr,int number){
        byte[] result = new byte[arr.length];

        for (int i = 0; i < arr.length; i++){
            result[i] = (byte) (arr[i]^number);
        }
        return result;
    }

    public static byte[] decrypt(byte[] arr,int number){
        byte[] result = new byte[arr.length];

        for (int i = 0; i < arr.length ; i++) {
            result[i] = (byte)(arr[i]^number);
        }

        return result;
    }
}
