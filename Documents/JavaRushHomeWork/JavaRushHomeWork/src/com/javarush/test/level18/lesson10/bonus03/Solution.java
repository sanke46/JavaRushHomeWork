package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        if(args[0].equals("-c")){

            String id = getId(fileName);
            String name = setSpace(args[1],30);
            String price = setSpace(args[2],8);
            String quantity = setSpace(args[3],4);

            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName));
            fileWriter.write(id+name+price+quantity);
            fileWriter.newLine();
            fileWriter.close();

        } else if(args[0].equals("-d")){

            String findId = args[1];
            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

            while (fileReader.ready()){
                String itrLine = fileReader.readLine();
                if(itrLine.contains(findId)){

                    break;
                }
            }

        }

    }

    private static String getId(String fileName) throws IOException
    {
        BufferedReader fileRedaer = new BufferedReader(new FileReader(fileName));
        int max = 0;

        while (fileRedaer.ready()){
            String itrLine = fileRedaer.readLine();
            String itrstr = itrLine.substring(0,8).replaceAll(" ", "");

            int itr = Integer.parseInt(itrstr);
            if(itr > max){
                max = itr;
            }
        }

        fileRedaer.close();
        return String.valueOf(max);
    }

    private static String setSpace(String strArgs, int number){

        char[] charArray = strArgs.toCharArray();
        String resultString = strArgs;

        if(charArray.length <= number) {
            for (int i = 0; i < (number - charArray.length); i++) {
                resultString += " ";
            }
        } else {
            for (int i = 0; i < number; i++) {
                String fullStr = null;
                fullStr += String.valueOf(charArray[i]);
                resultString = fullStr;
            }
        }

        return resultString;
    }
}
