package com.javarush.test.level15.lesson12.home05;

import java.math.BigDecimal;

/**
 * Created by ilafedoseev on 17/12/2016.
 */
public class SubSolution extends Solution{


    public SubSolution(Object pub1)
    {
        super(pub1);
    }

    public SubSolution(String pub2)
    {
        super(pub2);
    }

    public SubSolution(Integer pub3)
    {
        super(pub3);
    }

    private SubSolution(Character priv2){
        super(priv2);
    }

    private SubSolution(Double priv1){
        super(priv1);
    }

    private SubSolution(Exception priv3){
        super(priv3);
    }

    protected SubSolution(Number pro1)
    {
        super(pro1);
    }

    protected SubSolution(Boolean pro2)
    {
        super(pro2);
    }

    protected SubSolution(Float pro3)
    {
        super(pro3);
    }

    SubSolution(BigDecimal def1){
        super(def1);
    }
    SubSolution(Byte def2){
        super(def2);
    }
    SubSolution(Short def3){
        super(def3);
    }
}
