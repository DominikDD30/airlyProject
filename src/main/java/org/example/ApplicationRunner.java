package org.example;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ApplicationRunner {
    private static final  GiosApiClient giosApiClient = new GiosApiClient();

    
    public static void main(String[] args) {
        System.out.println("""
                ##################
                #  Data scraper  #
                ##################
                """);
        
        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("type 1 for fetch data");
            System.out.println("type 2 to exit");

            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                if(input == 2){return;}
                if (input == 1) {
                    doApiCall();
                    continue;
                }
            }
            System.err.println("wrong format \n");
        }
    }

    private static void doApiCall() {
        System.out.println("fetching data");
        List<Station> allStations;

        try {
            allStations = giosApiClient.findAllStations();
        } catch (IOException e) {
            System.out.println("exception while fetching stations: " + e.getMessage());
            return;
        }

        allStations.forEach(station -> {
            try {
                List<Installation> installations = giosApiClient.getInstallations(station.getStationId());
                printDataForStation(station, installations);
            } catch (IOException e) {
                System.out.println("exception while fetching installations: " + e.getMessage());
            }
        });
    }

    private static void printDataForStation(Station station, List<Installation> installations) {
        System.out.printf("Station #%d %s:  \n", station.getStationId(), station.getStationName());
        installations.forEach(installation ->
                System.out.printf("installation #%d:'%s' \n",
                        installation.getInstallationId(), installation.getMarker()));
        System.out.println();
    }

}