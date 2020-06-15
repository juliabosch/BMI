package com.smarherd.bmilab1;

import androidx.lifecycle.ViewModel;

public class BMIViewModel extends ViewModel {
    public double bmi;
    public double range;
    public int mode;

    public BMIViewModel() {}

    public BMIViewModel(double bmi, double range) {
        this.bmi = bmi;
        this.range = range;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public void setRange(double range) {
        this.range = range;
    }

    public double getBmi() {
        return bmi;
    }

    public double getRange() {
        return range;
    }
}
