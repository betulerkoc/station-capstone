package com.example.stationproject.models;

public class Station {

    private int StationID;
    private String location;
    private String type;
    private String price;
    private boolean availability;
    private boolean chargingStatus;

    public Station(int stationID, String location, String type, String price, boolean availability, boolean chargingStatus) {
        StationID = stationID;
        this.location = location;
        this.type = type;
        this.price = price;
        this.availability = availability;
        this.chargingStatus = chargingStatus;
    }

    public Station() {
    }

    public int getStationID() {
        return StationID;
    }

    public void setStationID(int stationID) {
        StationID = stationID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public boolean isChargingStatus() {
        return chargingStatus;
    }

    public void setChargingStatus(boolean chargingStatus) {
        this.chargingStatus = chargingStatus;
    }
}
