package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
        String b = reader.readLine();
        reader.close();

        FileInputStream fileAIn = new FileInputStream(a);
        FileInputStream fileBIn = new FileInputStream(b);

        byte[] bufferOne = new byte[fileAIn.available()];
        fileAIn.read(bufferOne);

        byte[] bufferTwo = new byte[fileBIn.available()];
        fileBIn.read(bufferTwo);

        FileOutputStream fileAOut = new FileOutputStream(a,false);
        fileAOut.write(bufferTwo);
        fileAOut = new FileOutputStream(a,true);
        fileAOut.write(bufferOne);

        fileAIn.close();
        fileBIn.close();
        fileAOut.close();


    }
}
