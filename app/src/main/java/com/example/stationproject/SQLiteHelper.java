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
                "Price TEXT);";
    }


    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createUser());
        db.execSQL(createStation());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + "USER");
        db.execSQL("DROP TABLE IF EXISTS " + "STATION");
        onCreate(db);
    }

    public static void insertStation(SQLiteDatabase db, String loc, String price, String type) {
        ContentValues stationValues = new ContentValues();
        stationValues.put("Location", loc);
        stationValues.put("Price", price);
        stationValues.put("Type", type);

        long id = db.insert("STATION", null, stationValues);
    }

    public static void insertUser(SQLiteDatabase db, String fname, String sname, String pass, String email) {
        ContentValues userValues = new ContentValues();
        userValues.put("Name", fname);
        userValues.put("Surname", sname);
        userValues.put("Password", pass);
        userValues.put("Email", email);

        long id = db.insert("USER", null, userValues);
    }


}