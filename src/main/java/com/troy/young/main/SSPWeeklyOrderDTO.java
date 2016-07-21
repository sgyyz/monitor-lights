package com.troy.young.main;

import java.util.List;
import java.util.Map;

public class SSPWeeklyOrderDTO {
    private Campaign campaign;
    private SSPOrder ssp;
    private Map<String, Integer> dayparts;
    private List<NetworkSummary> networks;
    private List<String> weeklyDates;
    private List<Rankers> rankers;
    
    private String week1Name;
    private String week2Name;
    private String week3Name;

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public SSPOrder getSsp() {
        return ssp;
    }

    public void setSsp(SSPOrder ssp) {
        this.ssp = ssp;
    }

    public Map<String, Integer> getDayparts() {
        return dayparts;
    }

    public void setDayparts(Map<String, Integer> dayparts) {
        this.dayparts = dayparts;
    }

    public List<NetworkSummary> getNetworks() {
        return networks;
    }

    public void setNetworks(List<NetworkSummary> networks) {
        this.networks = networks;
    }

    public List<String> getWeeklyDates() {
        return weeklyDates;
    }

    public void setWeeklyDates(List<String> weeklyDates) {
        this.weeklyDates = weeklyDates;
    }

    public List<Rankers> getRankers() {
        return rankers;
    }

    public void setRankers(List<Rankers> rankers) {
        this.rankers = rankers;
    }

    public String getWeek1Name() {
        return week1Name;
    }

    public void setWeek1Name(String week1Name) {
        this.week1Name = week1Name;
    }

    public String getWeek2Name() {
        return week2Name;
    }

    public void setWeek2Name(String week2Name) {
        this.week2Name = week2Name;
    }

    public String getWeek3Name() {
        return week3Name;
    }

    public void setWeek3Name(String week3Name) {
        this.week3Name = week3Name;
    }

    
}
