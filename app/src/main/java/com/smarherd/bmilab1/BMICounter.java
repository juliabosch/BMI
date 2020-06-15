package com.smarherd.bmilab1;

public class BMICounter {

    private double height;
    private double mass;
    private double bmi;
    // range = 0 -> uw // r = 1 -> n // r = 2 -> ow // r = 3 -> ob
    private int range;

    public BMICounter() {}

    public BMICounter(double height, double mass) {
        this.height = height;
        this.mass = mass;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public double getHeight() {
        return height;
    }

    public double getMass() {
        return mass;
    }

    public double getBmi() {
        return bmi;
    }

    public int getRange() {
        return range;
    }

    public double getMetricBMI() {
        height /= 100;
        bmi = mass/(height * height);
        range = getClassification(bmi);
        return bmi;
    }

    public double getImperialBMI() {
        bmi = mass*703/(height * height);
        range = getClassification(bmi);
        return bmi;
    }

    public int getClassification(double bmi) {

        int result;
        //underweight
        if (bmi < 18.5)
            result = 0;
        //normal range
        else if (bmi < 25)
            result = 1;
        //overweight
        else if (bmi < 30)
            result = 2;
        else
            result = 3;

        return result;
    }

}
