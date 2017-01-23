package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        int coutnter = 0;
        int word;

        while (fileInputStream.available() > 0){
            word = fileInputStream.read();
            if(LetterIsTrue(word) == true){
                coutnter++;
            }
        }

        System.out.println(coutnter);
        fileInputStream.close();
    }

    public static boolean LetterIsTrue(int word){
        if(((word > 64) && (word < 91)) || ((word > 96) && (word < 123))){
            return true;
        } else {
            return false;
        }
    }
}
