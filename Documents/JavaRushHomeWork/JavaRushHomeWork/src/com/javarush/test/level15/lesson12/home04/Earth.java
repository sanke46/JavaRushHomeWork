package com.javarush.test.level15.lesson12.home04;

/**
 * Created by ilafedoseev on 17/12/2016.
 */
public final class Earth implements Planet{

    private static Earth earth = null;

    private Earth(){

    }

    static synchronized Earth getInstance(){
        if (earth == null){
            earth = new Earth();
        }
        return earth;
    }
}
