package com.models;

public class Tap {
    private Long unixTimestamp;
    private Long customerId;
    private String station;

    public Tap() {
    }

    public Tap(Long unixTimestamp, Long custumerId, String station) {
        this.unixTimestamp = unixTimestamp;
        this.customerId = custumerId;
        this.station = station;
    }

    public Long getUnixTimestamp() {
        return unixTimestamp;
    }

    public void setUnixTimestamp(Long unixTimestamp) {
        this.unixTimestamp = unixTimestamp;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "unixTimestamp=" + unixTimestamp +
                ", customerId=" + customerId +
                ", station='" + station + '\'' +
                '}';
    }
}
