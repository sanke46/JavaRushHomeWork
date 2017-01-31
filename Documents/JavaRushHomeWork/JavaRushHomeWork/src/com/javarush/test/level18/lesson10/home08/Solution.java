package com.javarush.test.level18.lesson10.home08;

import jdk.nashorn.internal.ir.annotations.Ignore;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        for (String fileName = sc.nextLine(); !fileName.equals("exit"); fileName = sc.nextLine()) {
            Thread th = new ReadThread(fileName);
            th.start();
            try {
                th.join();
            }catch (Exception e) {}
        }

        sc.close();
    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;

        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            try {
                Map<Integer,Integer> hitsMap = new HashMap<Integer, Integer>();
                FileInputStream file = new FileInputStream(fileName);
                int max = 0;
                int charOfMax = 0;

                while (file.available() > 0){
                    int a = file.read();
                    if(hitsMap.containsKey(a)){
                        int hit = hitsMap.get(a) + 1;
                        hitsMap.put(a,hit);
                        if(hit > max){
                            max = hit;
                            charOfMax = a;
                        }
                    } else {
                        hitsMap.put(a,1);
                    }
                }

                resultMap.put(fileName,charOfMax);
                file.close();

            } catch (IOException ignore) {
                ignore.printStackTrace();
            }
        }
    }
}
