package com.example.stationproject.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "STATIONAPP";

    public SQLiteHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //private void createDatabase(SQLiteDatabase db, int oldVersion)

    public String createUser() {
        return "CREATE TABLE USER (" +
                "userID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Name TEXT COLLATE NOCASE, " +
                "Surname TEXT COLLATE NOCASE, " +
                "Email TEXT, " +
                "Address TEXT);";
    }

    public String createStation() {
        return "CREATE TABLE STATION (" +
                "stationID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Location TEXT, " +
                "Type TEXT, " +
                "Price TEXT, " +
                "Availability NUMERIC, " +
                "ChargingStatus NUMERIC);";
    }

    public String createReservation() {
        return "CREATE TABLE RESERVATION (" +
                "reservationID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "reservationDate TIMESTAMP DATETIME DEFAULT (STRFTIME('%Y-%m-%d  %H:%M', 'NOW','localtime')), "+
                "reservationStatus NUMERIC, " +
                "ChargingStatus NUMERIC, " +
                "FOREIGN KEY(userID) REFERENCES USER(userID), " +
                "FOREIGN KEY(stationID) REFERENCES STATION(stationID));";

    }
}

