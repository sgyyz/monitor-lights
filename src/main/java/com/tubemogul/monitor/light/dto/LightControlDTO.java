package com.tubemogul.monitor.light.dto;

import com.tubemogul.monitor.light.enums.Method;

public class LightControlDTO {
    private int lightId;

    // GRB values
    private String power = "on";
    private int rgbValue;
    private Method method = Method.SET_RGB;

    public int getLightId() {
        return lightId;
    }

    public void setLightId(int lightId) {
        this.lightId = lightId;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public int getRgbValue() {
        return rgbValue;
    }

    public void setRgbValue(int rgbValue) {
        this.rgbValue = rgbValue;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

}
