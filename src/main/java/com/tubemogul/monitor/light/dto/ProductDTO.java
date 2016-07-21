package com.tubemogul.monitor.light.dto;

public class ProductDTO {
    private String id;
    private String productName;
    private int redLight;
    private int yellowLight;
    private int greenLight;
    private int successRatio;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getRedLight() {
        return redLight;
    }

    public void setRedLight(int redLight) {
        this.redLight = redLight;
    }

    public int getYellowLight() {
        return yellowLight;
    }

    public void setYellowLight(int yellowLight) {
        this.yellowLight = yellowLight;
    }

    public int getGreenLight() {
        return greenLight;
    }

    public void setGreenLight(int greenLight) {
        this.greenLight = greenLight;
    }

    public int getSuccessRatio() {
        return successRatio;
    }

    public void setSuccessRatio(int successRatio) {
        this.successRatio = successRatio;
    }

}
