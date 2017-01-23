package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created by ilafedoseev on 19/12/2016.
 */
public class LatteMaker extends DrinkMaker{

    @Override
    void getRightCup()
    {
        System.out.println("Берем чашку для латте");
        super.getRightCup();
    }

    @Override
    void putIngredient()
    {
        System.out.println("Делаем кофе");
        super.putIngredient();
    }

    @Override
    void pour()
    {
        System.out.println("Заливаем молоком с пенкой");
        super.pour();
    }
}
