package com.javarush.test.level15.lesson12.bonus01;

/**
 * Created by ilafedoseev on 19/12/2016.
 */
public class Plane implements Flyable{

    private int humansInBoard;

    public Plane(int humansInBoard){
        this.humansInBoard = humansInBoard;
    }

    @Override
    public void fly()
    {

    }
}
