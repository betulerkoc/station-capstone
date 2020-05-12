package com.example.stationproject;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Button buttonStation;
    EditText loc, p, t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openHelper = new SQLiteHelper(this);

        buttonStation = findViewById(R.id.buttonStation);
        loc = findViewById(R.id.loc);
        p = findViewById(R.id.price);
        t = findViewById(R.id.type);

        buttonStation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = openHelper.getWritableDatabase();
                String location = loc.getText().toString();
                String price = p.getText().toString();
                String type = t.getText().toString();
                SQLiteHelper.insertStation(db, location, price, type);
                Toast.makeText(getApplicationContext(), "station", Toast.LENGTH_LONG).show();
            }
        });

    }
}