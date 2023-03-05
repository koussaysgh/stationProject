package com.models;

import java.util.List;

public class ConsumerSummary {
    private Long customerId;
    private int totalCostInCents;
    private List<Trip> trips;

    public ConsumerSummary() {
    }

    public ConsumerSummary(Long customerId, int totalCostInCents, List<Trip> trips) {
        this.customerId = customerId;
        this.totalCostInCents = totalCostInCents;
        this.trips = trips;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public int getTotalCostInCents() {
        return totalCostInCents;
    }

    public void setTotalCostInCents(int totalCostInCents) {
        this.totalCostInCents = totalCostInCents;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    @Override
    public String toString() {
        return "ConsumerSummary{" +
                "customerId=" + customerId +
                ", totalCostInCents=" + totalCostInCents +
                ", trips=" + trips +
                '}';
    }
}
