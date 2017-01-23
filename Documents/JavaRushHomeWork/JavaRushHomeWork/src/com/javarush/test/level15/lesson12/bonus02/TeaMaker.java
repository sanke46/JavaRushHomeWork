package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created by ilafedoseev on 19/12/2016.
 */
public class TeaMaker extends DrinkMaker{

    @Override
    void getRightCup()
    {
        System.out.println("Берем чашку для чая");
        super.getRightCup();
    }

    @Override
    void putIngredient()
    {
        System.out.println("Насыпаем чай");
        super.putIngredient();
    }

    @Override
    void pour()
    {
        System.out.println("Заливаем водой");
        super.pour();
    }
}
