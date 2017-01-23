package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created by ilafedoseev on 28/12/2016.
 */
public class ImageReaderFactory{

    public static ImageReader getReader(ImageTypes image) {
        ImageReader readerImg;

        if(image == ImageTypes.JPG){
            readerImg = new JpgReader();
        } else if(image == ImageTypes.PNG){
            readerImg = new PngReader();
        } else if(image == ImageTypes.BMP){
            readerImg = new BmpReader();
        } else {
            throw  new  IllegalArgumentException("Неизвестный тип картинки");
        }
        return readerImg;
    }
}
