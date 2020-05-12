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
    Button btnreg, buttonStation;
    EditText txtfname, txtsname, txtpass, txtemail;
    EditText loc, p, t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openHelper = new SQLiteHelper(this);


        btnreg = findViewById(R.id.btnreg);
        txtfname = findViewById(R.id.txtfName);
        txtsname = findViewById(R.id.txtsname);
        txtpass = findViewById(R.id.txtpass);
        txtemail = findViewById(R.id.editText4);


        buttonStation = findViewById(R.id.buttonStation);
        loc = findViewById(R.id.loc);
        p = findViewById(R.id.price);
        t = findViewById(R.id.type);

        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = openHelper.getWritableDatabase();
                String fname = txtfname.getText().toString();
                String sname = txtsname.getText().toString();
                String pass = txtpass.getText().toString();
                String email = txtemail.getText().toString();
                SQLiteHelper.insertUser(db, fname, sname, pass, email);
                Toast.makeText(getApplicationContext(), "yess", Toast.LENGTH_LONG).show();
            }
        });

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