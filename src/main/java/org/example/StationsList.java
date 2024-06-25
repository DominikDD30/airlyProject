package org.example;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StationsList {

    @SerializedName("Lista stacji pomiarowych")
    private List<Station> stationsList;

    public List<Station> getStationsList() {
        return stationsList;
    }
}
