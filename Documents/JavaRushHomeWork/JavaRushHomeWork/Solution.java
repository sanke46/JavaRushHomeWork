package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();

        HashMap<Integer, Integer> hitsMap = new HashMap<Integer, Integer>();
        ArrayList<Integer> arr = new ArrayList<Integer>();

        FileInputStream file = new FileInputStream(name);
        int min = 1;

        while (file.available() > 0){
            int tmp = file.read();
            if (tmp < min){
                min = tmp;
            }
            if(hitsMap.containsKey(tmp)){
                int value = hitsMap.get(tmp) + 1;
                hitsMap.put(tmp, value);
            } else {
                hitsMap.put(tmp,1);
            }
        }

        for (HashMap.Entry<Integer,Integer> pair : hitsMap.entrySet()){
            if(pair.getValue().equals(min)){
                if(!arr.contains(pair.getValue())){
                    arr.add(pair.getKey());
                }
            }
        }

        System.out.print(arr.get(0));

        for (int i = 1; i < arr.size(); i++) {
            System.out.print(" " + arr.get(i));
        }

    }
}
