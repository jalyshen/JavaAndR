package org.jaly.cauc.api.dto;

public class MeansRequest {
    public String firstGroupData;
    public String secondGroupData;

    public MeansRequest() {}
    public MeansRequest(String firstGroupData, String secondGroupData) {
        this.firstGroupData = firstGroupData;
        this.secondGroupData = secondGroupData;
    }
}
