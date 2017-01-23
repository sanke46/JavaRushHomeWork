package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) throws IOException{
        FileInputStream file = new FileInputStream("/Users/ilafedoseev/name.txt");
        int counterLetters = 0;
        int counterSpace = 0;

        while (file.available() > 0){
            counterLetters++;
            if(file.read() == ' ') {
                counterSpace++;
            }
        }

        float result = (float) ((float)counterSpace/counterLetters*100.0);
        System.out.printf("%.2f", result);
        file.close();
    }
}
