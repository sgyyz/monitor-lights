package com.troy.young.main;

import java.util.List;

/**
 * This DTO used to parsing xls.
 * 
 * @author yongzhi.yang
 *
 */
public class XLSSspOrderDTO {
    // ssp order basic information
    private String placementName;
    private String status;
    private String sspOrderId;

    // 13 weeks name
    private String weekName1;
    private String weekName2;
    private String weekName3;
    private String weekName4;
    private String weekName5;
    private String weekName6;
    private String weekName7;
    private String weekName8;
    private String weekName9;
    private String weekName10;
    private String weekName11;
    private String weekName12;
    private String weekName13;

    // rankers (row data)
    private List<XLSSspOrderRankerDTO> rankers;

    public String getPlacementName() {
        return placementName;
    }

    public void setPlacementName(String placementName) {
        this.placementName = placementName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSspOrderId() {
        return sspOrderId;
    }

    public void setSspOrderId(String sspOrderId) {
        this.sspOrderId = sspOrderId;
    }

    public String getWeekName1() {
        return weekName1;
    }

    public void setWeekName1(String weekName1) {
        this.weekName1 = weekName1;
    }

    public String getWeekName2() {
        return weekName2;
    }

    public void setWeekName2(String weekName2) {
        this.weekName2 = weekName2;
    }

    public String getWeekName3() {
        return weekName3;
    }

    public void setWeekName3(String weekName3) {
        this.weekName3 = weekName3;
    }

    public String getWeekName4() {
        return weekName4;
    }

    public void setWeekName4(String weekName4) {
        this.weekName4 = weekName4;
    }

    public String getWeekName5() {
        return weekName5;
    }

    public void setWeekName5(String weekName5) {
        this.weekName5 = weekName5;
    }

    public String getWeekName6() {
        return weekName6;
    }

    public void setWeekName6(String weekName6) {
        this.weekName6 = weekName6;
    }

    public String getWeekName7() {
        return weekName7;
    }

    public void setWeekName7(String weekName7) {
        this.weekName7 = weekName7;
    }

    public String getWeekName8() {
        return weekName8;
    }

    public void setWeekName8(String weekName8) {
        this.weekName8 = weekName8;
    }

    public String getWeekName9() {
        return weekName9;
    }

    public void setWeekName9(String weekName9) {
        this.weekName9 = weekName9;
    }

    public String getWeekName10() {
        return weekName10;
    }

    public void setWeekName10(String weekName10) {
        this.weekName10 = weekName10;
    }

    public String getWeekName11() {
        return weekName11;
    }

    public void setWeekName11(String weekName11) {
        this.weekName11 = weekName11;
    }

    public String getWeekName12() {
        return weekName12;
    }

    public void setWeekName12(String weekName12) {
        this.weekName12 = weekName12;
    }

    public String getWeekName13() {
        return weekName13;
    }

    public void setWeekName13(String weekName13) {
        this.weekName13 = weekName13;
    }

    public List<XLSSspOrderRankerDTO> getRankers() {
        return rankers;
    }

    public void setRankers(List<XLSSspOrderRankerDTO> rankers) {
        this.rankers = rankers;
    }

}
