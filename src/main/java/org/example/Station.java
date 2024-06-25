package org.example;

import com.google.gson.annotations.SerializedName;

public class Station {

    @SerializedName("Identyfikator stacji")
    private int stationId;

    @SerializedName("Nazwa stacji")
    private String stationName;

    public int getStationId() {return stationId;}
    public String getStationName() {return stationName;}
}


