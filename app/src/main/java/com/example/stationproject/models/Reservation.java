package com.example.stationproject.models;

public class Reservation {

    private int ReservationID;
    private String date;
    private String time;
    private boolean reservationStatus;

    public Reservation(int reservationID, String date, String time, boolean reservationStatus) {
        ReservationID = reservationID;
        this.date = date;
        this.time = time;
        this.reservationStatus = reservationStatus;
    }

    public Reservation() {

    }

    public int getReservationID() {
        return ReservationID;
    }

    public void setReservationID(int reservationID) {
        ReservationID = reservationID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(boolean reservationStatus) {
        this.reservationStatus = reservationStatus;
    }
}
