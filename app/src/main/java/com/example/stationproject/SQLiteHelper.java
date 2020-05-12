package com.example.stationproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "StationProject.db";

    public String createUser() {
        return "CREATE TABLE USER (" +
                "userID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Name TEXT COLLATE NOCASE, " +
                "Surname TEXT COLLATE NOCASE, " +
                "Password TEXT, " +
                "Email TEXT);";
    }

    public String createStation() {
        return "CREATE TABLE STATION (" +
                "stationID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Location TEXT COLLATE NOCASE, " +
                "Type TEXT, " +
                "Price TEXT, " +
                "Availability NUMERIC, " +
                "CharginStatus NUMERIC, " +
                "Capacity INTEGER);";
    }

    public String createReservation() {
        return "CREATE TABLE RESERVATION (" +
                "reservationID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "reservationDate DATE, "+
                "reservationTime TIME, "+
                "reservationStatus NUMERIC, " +
                "userID INTEGER, " +
                "stationID INTEGER, " +
                "FOREIGN KEY(userID) REFERENCES USER(userID), " +
                "FOREIGN KEY(stationID) REFERENCES STATION(stationID));";
    }



    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createUser());
        db.execSQL(createStation());
        db.execSQL(createReservation());

        makeReservation(db, "2020-8-12","10:30", true, 5, 8);
        makeReservation(db, "2020-7-3", "12:00",true, 5, 8);
        makeReservation(db, "2020-9-7", "15:30",true, 5, 8);

        insertUser(db, "Betul", "Erkoç", "123", "betul@gmail.com");
        insertUser(db, "Ayse", "Aydın", "123", "ayse@gmail.com");
        insertUser(db, "Cansu", "Gunay", "123", "cansu@gmail.com");

        insertStation(db, "Kızılelma Caddesi", "5", "DC", true, false, 10);
        insertStation(db, "Dolmabahçe Caddesi", "5", "DC", false, true, 15);
        insertStation(db, "Vali Konağı Caddesi", "5", "DC", true, false, 5);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + "USER");
        db.execSQL("DROP TABLE IF EXISTS " + "STATION");
        db.execSQL("DROP TABLE IF EXISTS " + "RESERVATION");

        onCreate(db);
    }

    public static void insertUser(SQLiteDatabase db, String fname, String sname, String pass, String email) {
        ContentValues userValues = new ContentValues();
        userValues.put("Name", fname);
        userValues.put("Surname", sname);
        userValues.put("Password", pass);
        userValues.put("Email", email);

        db.insert("USER", null, userValues);
    }

    public static void insertStation(SQLiteDatabase db, String loc, String price, String type, boolean availability, boolean charging, int capacity) {
        ContentValues stationValues = new ContentValues();
        stationValues.put("Location", loc);
        stationValues.put("Price", price);
        stationValues.put("Type", type);
        stationValues.put("Availability", availability);
        stationValues.put("CharginStatus", charging);
        stationValues.put("Capacity", capacity);

        db.insert("STATION", null, stationValues);
    }

    public static void makeReservation (SQLiteDatabase db, String resDate,String resTime, boolean resStatus, int userID, int stationID) {
        ContentValues stationValues = new ContentValues();
        stationValues.put("reservationDate", resDate);
        stationValues.put("reservationTime", resTime);
        stationValues.put("reservationStatus", resStatus);
        stationValues.put("userID", userID);
        stationValues.put("stationID", stationID);

        db.insert("RESERVATION", null, stationValues);
    }
}