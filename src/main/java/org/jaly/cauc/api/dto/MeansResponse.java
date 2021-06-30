package org.jaly.cauc.api.dto;

import java.util.List;

public class MeansResponse {
    public int errCode = 200;
    public String errMsg = "OK";
    public List<Double> meansReuslt;
    public List<Double> highTemp;
    public List<Double> lowTemp;
}
