package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {

        Map<Integer, Integer> hitsMap = new TreeMap<>();
        FileInputStream fileInput = new FileInputStream(args[0]);

        while (fileInput.available() > 0){
            int date = fileInput.read();

            if(hitsMap.containsKey(date)){
                int hits = hitsMap.get(date) + 1;
                hitsMap.put(date, hits);
            } else {
                hitsMap.put(date,1);
            }
        }

        for(Map.Entry<Integer, Integer> pair : hitsMap.entrySet()){
            int key = pair.getKey();
            char keyChar = (char) key;
            System.out.println(keyChar + " " + pair.getValue());
        }

        fileInput.close();
    }
}
