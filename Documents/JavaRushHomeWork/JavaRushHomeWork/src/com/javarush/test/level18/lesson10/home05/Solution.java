package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine(); //"/Users/ilafedoseev/name.txt";
        String b = reader.readLine(); //"/Users/ilafedoseev/name2.txt";;
        reader.close();

        FileInputStream fileAIn = new FileInputStream(a);
        FileOutputStream fileBOut  = new FileOutputStream(b);

        if(fileAIn.available() > 0){
            byte[] aByte = new byte[fileAIn.available()];
            fileAIn.read(aByte);

            String[] strArray = new String(aByte).split(" ");
            StringBuilder strBuilder = new StringBuilder(aByte.length);

            for (String x : strArray) {
                int finalNumber = (int) Math.round(Double.valueOf(x));
                strBuilder.append(finalNumber);
                strBuilder.append(" ");
            }

            fileBOut.write(strBuilder.toString().getBytes());
        }

        fileAIn.close();
        fileBOut.close();
    }
}
