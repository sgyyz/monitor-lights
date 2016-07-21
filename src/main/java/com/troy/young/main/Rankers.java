package com.troy.young.main;

import java.util.List;

public class Rankers {
    private String network;
    private Integer unit;
    private List<Integer> weeklySpend;
    private String week1;
    private String week2;

    public Rankers() {

    }

    public Rankers(String network, Integer unit, List<Integer> weeklySpend) {
        this.network = network;
        this.unit = unit;
        this.weeklySpend = weeklySpend;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public List<Integer> getWeeklySpend() {
        return weeklySpend;
    }

    public void setWeeklySpend(List<Integer> weeklySpend) {
        this.weeklySpend = weeklySpend;
    }

    public String getWeek1() {
        return week1;
    }

    public void setWeek1(String week1) {
        this.week1 = week1;
    }

    public String getWeek2() {
        return week2;
    }

    public void setWeek2(String week2) {
        this.week2 = week2;
    }

}
