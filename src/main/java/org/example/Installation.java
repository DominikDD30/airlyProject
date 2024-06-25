package org.example;

import com.google.gson.annotations.SerializedName;

public class Installation {

    @SerializedName("Identyfikator stanowiska")
    private int installationId;
    @SerializedName("Wskaźnik - kod")
    private String marker;

    public int getInstallationId() {return installationId;}
    public String getMarker() {return marker;}
}
