package com.troy.young.main;

public class NetworkSummary {
    private String name;
    private Integer spend;

    public NetworkSummary(String name, Integer spend) {
        this.name = name;
        this.spend = spend;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSpend() {
        return spend;
    }

    public void setSpend(Integer spend) {
        this.spend = spend;
    }

}
