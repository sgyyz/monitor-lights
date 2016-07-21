package com.tubemogul.monitor.light.entity;

public class ProductEntity {
    private final int id;
    private final String productName;
    private final int redLight;
    private final int yellowLight;
    private final int greenLight;
    private final int successRatio;

    public ProductEntity(int id, String productName, int redLight, int yellowLight, int greenLight, int successRatio) {
        this.id = id;
        this.productName = productName;
        this.redLight = redLight;
        this.yellowLight = yellowLight;
        this.greenLight = greenLight;
        this.successRatio = successRatio;
    }

    public int getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public int getRedLight() {
        return redLight;
    }

    public int getYellowLight() {
        return yellowLight;
    }

    public int getGreenLight() {
        return greenLight;
    }

    public int getSuccessRatio() {
        return successRatio;
    }

}
