package org.example;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class InstallationsList {
    @SerializedName("Lista stanowisk pomiarowych dla podanej stacji")
    private List<Installation> installationsList;

    public List<Installation> getInstallationsList() {
        return installationsList;
    }
}
