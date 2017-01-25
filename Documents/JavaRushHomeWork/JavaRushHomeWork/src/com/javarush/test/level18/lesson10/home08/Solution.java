package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String fileName = reader.readLine();
            if(fileName.equals("exit")){
                break;
            }
            new ReadThread(fileName);
        }

    }

    public static class ReadThread extends Thread {
        String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }

        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run(){
            try {
                Map<Integer,Integer> hitsMap = new HashMap<Integer, Integer>();
                FileInputStream file = new FileInputStream(fileName);
                byte[] fileBytes = new byte[file.available()];
                int max = 0;
                int byteName = 0;

                while (file.available() > 0){
                    file.read(fileBytes);
                }

                for (int i = 0; i < fileBytes.length; i++) {
                    int byteNumber = fileBytes[i];
                    if(hitsMap.containsKey(fileBytes[i])){
                        int hit = hitsMap.get(i) + 1;
                        hitsMap.put(byteNumber, hit);
                    } else {
                        hitsMap.put(byteNumber, 1);
                    }
                }

                for(Map.Entry<Integer,Integer> pair : hitsMap.entrySet()){
                    if(pair.getValue() > max){
                        max = pair.getValue();
                        byteName = pair.getKey();
                    }
                }

                if(hitsMap.containsValue(max)){
                    resultMap.put(fileName, byteName);
                }


            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
