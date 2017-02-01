package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

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
    public static void main(String[] args) throws Exception {

        // read file name
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName =  reader.readLine();
        reader.close();

        if(args[0].equals("-c")){

            // all atreebutes
            String id = getId(fileName);
            String name = addSapce(args[1],30);
            String price = addSapce(args[2],8);
            String quantity = addSapce(args[3],4);

            // write file
            BufferedWriter fileOut = new BufferedWriter(new FileWriter(fileName,true));

            fileOut.write(id+name+price+quantity);
            fileOut.newLine();
            fileOut.close();

        }
    }

    // method generat new id
    private static String getId(String fileName) throws IOException {
        BufferedReader readerFile = new BufferedReader(new FileReader(fileName));
        int max = 0;

        while (readerFile.ready()) {
            String itrLine = readerFile.readLine();

            String itrIdstr = itrLine.substring(0, 8).replaceAll(" ","");
            int itrId = Integer.parseInt(itrIdstr);

            if (itrId > max) {
                max = itrId;
            }
        }

        readerFile.close();
        return String.valueOf(max+1);
    }


    // method to add space in args
    private static String addSapce(String strArg, int number) {

        char[] charArray = strArg.toCharArray();
        String resultString = strArg;

        if(charArray.length <= number) {
            for (int i = 0; i < (number - charArray.length); i++) {
                resultString += " ";
            }
        } else {
            for (int i = 0; i < number ; i++) {
                resultString += String.valueOf(charArray[i]);
            }
        }


        return resultString;
    }


}
