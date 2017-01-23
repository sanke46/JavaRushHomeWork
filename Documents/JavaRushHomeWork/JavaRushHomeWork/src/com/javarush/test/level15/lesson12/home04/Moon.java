package com.javarush.test.level15.lesson12.home04;

/**
 * Created by ilafedoseev on 17/12/2016.
 */
public final class Moon implements Planet{

    private static  Moon moon = null;

    private Moon(){

    }

    static synchronized Moon getInstance(){
        if (moon == null){
            moon = new Moon();
        }
        return moon;
    }
}
