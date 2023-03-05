package com.serviceImp;

import com.models.*;
import com.service.PricingService;

import java.util.*;
import java.util.stream.Collectors;

public class PricingServiceImp implements PricingService {
    @Override
    public OutputFile generateFile(InputFile input) {
        if (input == null)
            return null;
        OutputFile outputFile = new OutputFile();
        List<ConsumerSummary> consumerSummaryList = new ArrayList<>();
        List<Tap> taps = input.getTaps();
        Set<Long> setOfCustomerId = new HashSet<>();
        List<Tap> tapsByCustomerId = new ArrayList<>();
        for (Tap tap : taps) {
            if (!setOfCustomerId.contains(tap.getCustomerId())) {
                tapsByCustomerId = taps.stream()
                        .filter(t -> t.getCustomerId() == tap.getCustomerId())
                        .sorted((t1, t2) -> (int) (t1.getUnixTimestamp() - t2.getUnixTimestamp()))
                        .collect(Collectors.toList());
                setOfCustomerId.add(tap.getCustomerId());
                consumerSummaryList.add(getConsumerSummary(tap.getCustomerId(), tapsByCustomerId));
            }
        }
        outputFile.setCustomerSummaries(consumerSummaryList);
        return outputFile;
    }

    private ConsumerSummary getConsumerSummary(Long customerId, List<Tap> tapsByCustomerId) {
        ConsumerSummary consumerSummary = new ConsumerSummary();
        List<Trip> trips = getTrips(tapsByCustomerId);
        consumerSummary.setCustomerId(customerId);
        consumerSummary.setTrips(trips);
        consumerSummary.setTotalCostInCents(getTotalCostInCents(trips));
        return consumerSummary;
    }

    private int getTotalCostInCents(List<Trip> trips) {
        return trips.stream().mapToInt(e -> e.getCostInCents()).sum();
    }

    private List<Trip> getTrips(List<Tap> tapList) {
        List<Trip> trips = new ArrayList<>();
        for (int i = 0; i < tapList.size() - 1; i += 2) {
            String startedStation = tapList.get(i).getStation();
            String endStation = tapList.get(i + 1).getStation();
            Trip trip = new Trip();
            trip.setStationStart(startedStation);
            trip.setStationEnd(endStation);
            trip.setZoneFrom(getZone(startedStation));
            trip.setZoneTo(getZone(endStation));
            trip.setCostInCents(calculatePricing(startedStation, endStation));
            trip.setStartedJourneyAt(tapList.get(i).getUnixTimestamp());
            trips.add(trip);
        }
        return trips;
    }


    private int calculatePricing(String stationStart, String stationEnd) {
        int zoneFrom = getZone(stationStart);
        int zoneTo = getZone(stationEnd);


        if (zoneFrom <= 2 && zoneTo <= 2) {
            return 240;
        } else if (zoneFrom >= 3 && zoneTo >= 3) {
            return 200;
        } else if (zoneFrom == 3 && (zoneTo == 1 || zoneTo == 2)) {
            return 280;
        } else if (zoneFrom == 4 && (zoneTo == 1 || zoneTo == 2)) {
            return 300;
        } else if ((zoneFrom == 1 || zoneFrom == 2) && zoneTo == 3) {
            return 280;
        } else {
            return 300;
        }
    }

    private int getZone(String station) {
        if (station.equals("A") || station.equals("B")) {
            return 1;
        } else if (station.equals("C") || station.equals("D")) {
            return 2;
        } else if (station.equals("F") || station.equals("E")) {
            return 3;
        } else if (station.equals("G") || station.equals("H") || station.equals("I")) {
            return 4;

        } else return 5;
    }
}
