package com.tubemogul.monitor.light.dto;

import java.util.List;

public class ProductDTO {
    private String id;
    private String productName;
    private List<LightStatus> statusList;
    private int lightId;

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

    public List<LightStatus> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<LightStatus> statusList) {
        this.statusList = statusList;
    }

    public int getLightId() {
        return lightId;
    }

    public void setLightId(int lightId) {
        this.lightId = lightId;
    }

}
