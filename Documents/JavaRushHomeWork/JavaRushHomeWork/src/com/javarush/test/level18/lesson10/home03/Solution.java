package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileOne = reader.readLine();
        String fileTwo = reader.readLine();
        String fileTree = reader.readLine();
        reader.close();

        FileOutputStream fileOneOut = new FileOutputStream(fileOne);
        FileInputStream fileTwoIn = new FileInputStream(fileTwo);
        FileInputStream fileTreeIn = new FileInputStream(fileTree);

        byte[] bufferTwo = new byte[fileTwoIn.available()];
        fileTwoIn.read(bufferTwo);

        byte[] bufferTree = new byte[fileTreeIn.available()];
        fileTreeIn.read(bufferTree);

        fileOneOut.write(bufferTwo);
        fileOneOut.write(bufferTree);

        fileTreeIn.close();
        fileTwoIn.close();
        fileOneOut.close();


    }
}
