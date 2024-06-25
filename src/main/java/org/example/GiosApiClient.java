package org.example;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class GiosApiClient {
    private final String apiUrl = "https://api.gios.gov.pl/pjp-api/v1/rest";
    private final OkHttpClient httpClient = new OkHttpClient();
    private final Gson gson = new Gson();

    public List<Installation> getInstallations(int id) throws IOException {
        Request request = new Request.Builder()
                .url(apiUrl + "/station/sensors/" + id)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            return Objects.nonNull(response.body()) ?
                    gson.fromJson(response.body().string(), InstallationsList.class).getInstallationsList()
                    : Collections.emptyList();
        }
    }

    public List<Station> findAllStations() throws IOException {
        Request request = new Request.Builder()
                .url(apiUrl + "/station/findAll")
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            return Objects.nonNull(response.body()) ?
                    gson.fromJson(response.body().string(), StationsList.class).getStationsList()
                    : Collections.emptyList();
        }
    }

}
