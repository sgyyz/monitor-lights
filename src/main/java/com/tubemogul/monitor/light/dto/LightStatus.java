package com.tubemogul.monitor.light.dto;

public class LightStatus {
    private int rgbValue;
    private int startValue;
    private int endValue;
    
    public int getStartValue() {
        return startValue;
    }

    public void setStartValue(int startValue) {
        this.startValue = startValue;
    }

    public int getEndValue() {
        return endValue;
    }

    public void setEndValue(int endValue) {
        this.endValue = endValue;
    }

    public int getRgbValue() {
        return rgbValue;
    }

    public void setRgbValue(int rgbValue) {
        this.rgbValue = rgbValue;
    }

}